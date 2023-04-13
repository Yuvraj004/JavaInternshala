package com.example.connect4game;


import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.net.URL;
import java.util.*;
import java.util.stream.IntStream;

public class HelloController implements Initializable {

	private static final int columnsG = 7;
	private static final int rowsG = 6;
	private static final double circleDiameter = 80.0;
	private static final String discColor1 = "#FF00FF";
	private static final String discColor2 = "#00FFFF";


	private static  String Player_one = "Player One";
	private static  String Player_two = "Player Two";
	public TextField playerOneTextField;
	public TextField playerTwoTextField;
	public Button setNamesButton;

	private boolean isPlayerOneTurn = true;

	private final Disc[][]  insertedDiscArray = new Disc[rowsG][columnsG];


	private boolean isAllowedToInsert = true; //flag to help


	@FXML
	public GridPane rootGridPane;

	@FXML
	public Pane insertedDiscsPane;

	@FXML
	public Label playerNameLabel;


	public void createPlayground() {
		Shape rectWithHoles = createGameStructure();
		rootGridPane.add(rectWithHoles, 0, 1);

		List<Rectangle> rectangleList = createClickableColumns();
		for (Rectangle rectangle : rectangleList) {
			rootGridPane.add(rectangle, 0, 1);
		}

		setNamesButton.setOnAction(actionEvent -> {

			Player_one= playerOneTextField.getText();
			Player_two=playerTwoTextField.getText();
			System.out.println("Names updated");
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("Connect4");
			alert.setHeaderText("Names");
			alert.setContentText("Names entered Updated");

			alert.showAndWait();
		});

	}

	private Shape createGameStructure() {
		Shape rectWithHoles = new Rectangle((columnsG + 1) * circleDiameter, (rowsG + 1) * circleDiameter);
		for (int row = 0; row < rowsG; row++) {
			for (int col = 0; col < columnsG; col++) {

				Circle circle = new Circle();
				circle.setRadius(circleDiameter / 2);
				circle.setCenterX(circleDiameter / 2);
				circle.setCenterY(circleDiameter / 2);
				circle.setSmooth(true);
				circle.setTranslateX(col * (circleDiameter + 5) + circleDiameter / 4);
				circle.setTranslateY(row * (circleDiameter + 5) + circleDiameter / 4);

				rectWithHoles = Shape.subtract(rectWithHoles, circle);
			}
		}


		rectWithHoles.setFill(Color.WHITE);
		return rectWithHoles;
	}

	private List<Rectangle> createClickableColumns() {
		List<Rectangle> rectangleList = new ArrayList<>();
		for (int col = 0; col < columnsG; col++) {
			Rectangle rectangle = new Rectangle(circleDiameter, (rowsG + 1) * circleDiameter);
			rectangle.setFill(Color.TRANSPARENT);
			rectangle.setTranslateX(col * (circleDiameter + 5) + circleDiameter / 4);

			rectangle.setOnMouseEntered(event -> rectangle.setFill(Color.valueOf("#eeeeee26")));
			rectangle.setOnMouseExited(event -> rectangle.setFill(Color.TRANSPARENT));

			int finalCol = col;
			rectangle.setOnMouseClicked(event -> {
				if(isAllowedToInsert) {
					isAllowedToInsert=false;
					insertDisc(new Disc(isPlayerOneTurn), finalCol);
				}
			});
			rectangleList.add(rectangle);
		}

		return rectangleList;
	}

	private void insertDisc(Disc disc, int col) {

		int row = rowsG - 1;
		while (row >= 0) {
			if (insertedDiscArray[row][col] == null) break;
			row--;
		}
		if (row < 0) return;
		insertedDiscArray[row][col] = disc; //for structural changes : for developers
		insertedDiscsPane.getChildren().add(disc);

		disc.setTranslateX(col * (circleDiameter + 5) + circleDiameter / 4);

		TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.5), disc);
		translateTransition.setToY(row * (circleDiameter + 5) + circleDiameter / 4);
		int finalRow = row;
		translateTransition.setOnFinished(actionEvent -> {

			isAllowedToInsert = true;
			if (gameEnded(finalRow, col)) {
				gameOver();
				return;

			}
			isPlayerOneTurn = !isPlayerOneTurn;
			playerNameLabel.setText(isPlayerOneTurn ? Player_one : Player_two);
		});
		translateTransition.play();
	}

	private void gameOver() {
		String winner = isPlayerOneTurn ? Player_one : Player_two;
		System.out.println("Winner is:" + winner);

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Connect four");
		alert.setTitle("Connect Four");
		alert.setHeaderText ("The Winner is " + winner);
		alert.setContentText ("Want to play again? ");

		ButtonType yesBtn = new ButtonType("Yes");
		ButtonType noBtn = new ButtonType("No,Exit");
		alert.getButtonTypes().setAll(yesBtn,noBtn);

		Platform.runLater ( () -> {
			Optional<ButtonType> btnClicked = alert.showAndWait();
			if (btnClicked.isPresent() && btnClicked.get() == yesBtn) {
				// ... user chose YES so RESET the game
				resetGame();
			} else {
				Platform.exit();
				System.exit(0);
			}
		});
	}

	public void resetGame() {
		 insertedDiscsPane.getChildren().clear();
		for (Disc[] discs : insertedDiscArray) {
			Arrays.fill(discs, null);
		}

		isPlayerOneTurn = true;
		playerNameLabel.setText(Player_one);

		createPlayground();
	}

	private boolean gameEnded(int finalRow, int col) {

		// Vertical Points. A small example: Player has inserted his last disc at row = 2, column = 3
		// range of row values = 0,1,2,3,4,5
		// index of each element present in column [row][column]: 0,3 1,3 2,3 3,3 4,3 5,3

		List<Point2D> verticalPoints = IntStream.rangeClosed(finalRow - 3, finalRow + 3)
				.mapToObj(r -> new Point2D(r, col))
				.toList();

		List<Point2D> horizontalPoints = IntStream.rangeClosed(col - 3, col + 3)
				.mapToObj(column -> new Point2D(finalRow, column))
				.toList();

		Point2D startPoint1 = new Point2D(finalRow - 3, col + 3);
		List<Point2D> diagonalPoints = IntStream.rangeClosed(0, 6)
				.mapToObj(i -> startPoint1.add(i, -i))
				.toList();

		Point2D startPoint2 = new Point2D(finalRow - 3, col - 3);
		List<Point2D> diagonal2Points = IntStream.rangeClosed(0, 6)
				.mapToObj(i -> startPoint2.add(i, i))
				.toList();

		return checkCombinations(verticalPoints) || checkCombinations(horizontalPoints) || checkCombinations(diagonalPoints) || checkCombinations(diagonal2Points);
	}

	private boolean checkCombinations(List<Point2D> points) {
		int chain = 0;
		for (Point2D point : points) {
			int rowIndexForArray = (int) point.getX();
			int columnIndexForArray = (int) point.getY();
			Disc disc = getDiscIfPresent(rowIndexForArray, columnIndexForArray);
			if (disc != null && disc.isPlayerOneMove == isPlayerOneTurn) {
				chain++;
				if (chain == 4) {
					System.out.println("chain4");
					return true;
				}
			} else {
				chain = 0;
			}
		}
		return false;
	}

	private Disc getDiscIfPresent(int row, int column) { // To prevent ArrayIndexOutOfBoundException
		if (row >= rowsG || row < 0 || column >= columnsG || column < 0) // If row or column index is invalid
			return null;
		return insertedDiscArray[row][column];
	}


	private static class Disc extends Circle {
		private final boolean isPlayerOneMove ;

		public Disc(boolean isPlayerOneMove) {
			this.isPlayerOneMove = isPlayerOneMove;
			setRadius(circleDiameter / 2);
			setFill(isPlayerOneMove ? Color.valueOf(discColor1) : Color.valueOf(discColor2));
			setCenterX(circleDiameter / 2);
			setCenterY(circleDiameter / 2);
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		createPlayground();
	}
}

