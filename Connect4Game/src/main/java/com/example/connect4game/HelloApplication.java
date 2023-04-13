package com.example.connect4game;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class HelloApplication extends Application {
	private HelloController controller;

	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
		GridPane rootGridPane = fxmlLoader.load();
		HelloController controller = fxmlLoader.getController();


		Scene scene = new Scene(rootGridPane);
		MenuBar menuB = createMenu();
		menuB.prefWidthProperty().bind(stage.widthProperty());
		Pane menuPane = (Pane) rootGridPane.getChildren().get(0);

		menuPane.getChildren().add(menuB);
		stage.setTitle("Connect Four");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}

	private MenuBar createMenu(){
		//file menu
		Menu fileMenu = new Menu("File");
		MenuItem newGame = new MenuItem("New game");
		//action
		newGame.setOnAction(actionEvent -> {
			controller.resetGame();
		});
		MenuItem resetGame = new MenuItem("Reset game");
		resetGame.setOnAction(actionEvent -> {
			controller.resetGame();
		});
		SeparatorMenuItem sept = new SeparatorMenuItem();


		//to trigger events on click in running app
		newGame.setOnAction(actionEvent -> System.out.println("New Menu Item Clicked"));

		MenuItem exitGame = new MenuItem("Exit game");
		exitGame.setOnAction(actionEvent -> {
			Platform.exit();
			System.exit(0);
		});

		fileMenu.getItems().addAll(newGame,resetGame,sept,exitGame);

		//Help Menu
		Menu helpMenu = new Menu("Help");
		MenuItem aboutGame = new MenuItem("About Connect4");
		aboutGame.setOnAction(actionEvent -> aboutConnect4());
		SeparatorMenuItem sept2 = new SeparatorMenuItem();
		MenuItem aboutMe = new MenuItem("About Me");
		aboutMe.setOnAction(actionEvent -> aboutMe());
		helpMenu.getItems().addAll(aboutGame,sept2,aboutMe);
		//actions


		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(
				fileMenu,helpMenu
		);
		return menuBar;
	}

	private void aboutMe() {
		Alert alertD = new Alert(Alert.AlertType.INFORMATION);//Information and other types define the image across header text
		alertD.setTitle("About Me");
		alertD.setHeaderText("Yuvraj Chaturvedi");
		alertD.setContentText("Player hmm hmm");
		alertD.show();
	}

	private void aboutConnect4() {
		Alert alertD = new Alert(Alert.AlertType.INFORMATION);//Information and other types define the image across header text
		alertD.setTitle("About Connect4");
		alertD.setHeaderText("How To Play?");
		alertD.setContentText("Connect Four is a two-player connection game in which the " +
						"players first choose a color and then take turns dropping colored discs " +
						"from the into a seven-column, six-row vertically suspended grid. "+
						"The pieces fall straight down, occupying the next available space within the column."+
				"The objective of the game is to be the first to form a horizontal, vertical, " +
						"or diagonal line of four of one's own discs. Connect Four is a solved game." +
				"The first player can always win by playing the right moves."
		);
		alertD.show();
	}
}