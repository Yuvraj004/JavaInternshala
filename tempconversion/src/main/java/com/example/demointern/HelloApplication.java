package com.example.demointern;

import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class HelloApplication extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() throws Exception {
		System.out.println("Init");
		super.init();
		//initialize the application
		//optional to override
	}

	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
		VBox rootNode = fxmlLoader.load();

		MenuBar menuB = createMenu();
		rootNode.getChildren().add(0,menuB);

		Scene scene = new Scene(rootNode);
		stage.setTitle("Temperature Convertor Tool");
		stage.setScene(scene);
		//stage.setResizable(false); -> to stop the dialog box having the option of expanding and contracting
		//Start an application
		//must be overwritten
		//Use show() to make application visible
		stage.show();
	}

	private MenuBar createMenu(){
		//file menu
		Menu fileMenu = new Menu("File");
		MenuItem newM = new MenuItem("New");

		//to trigger events on click in running app
		newM.setOnAction(actionEvent -> System.out.println("New Menu Item Clicked"));

		SeparatorMenuItem sept = new SeparatorMenuItem();

		MenuItem quitM = new MenuItem("Quit");
		quitM.setOnAction(actionEvent -> {
			Platform.exit();
			System.exit(0);
		});

		fileMenu.getItems().addAll(newM,sept,quitM);

		//Help Menu
		Menu helpMenu = new Menu("Help");
		MenuItem aboutM = new MenuItem("About");

		aboutM.setOnAction(actionEvent -> aboutApp());

		helpMenu.getItems().addAll(aboutM);

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(
				fileMenu,helpMenu
		);
		return menuBar;
	}

	private void aboutApp() {
		Alert alertD = new Alert(Alert.AlertType.INFORMATION);//Information and other types define the image across header text
		alertD.setTitle("My first Desk App");
		alertD.setHeaderText("Learning JavaFx");
		alertD.setContentText("I am just a beginner but soon i will");

		ButtonType yesBtn = new ButtonType("YES");
		ButtonType noBtn = new ButtonType("no");
		alertD.getButtonTypes().setAll(yesBtn,noBtn);

		Optional<ButtonType> clickedB=alertD.showAndWait();//optional is a container that contains other objects


		if(clickedB.isPresent() && clickedB.get() == yesBtn){
			System.out.println("YES BTN");
		}
		else if(  clickedB.isPresent() &&  clickedB.get() == noBtn){
			System.out.println("NO BTN");
		}
	}

	//To check the sequence of execution
	@Override
	public void stop() throws Exception {
		System.out.println("Stop");
		super.stop();
		//optional to override
	}
}

//Which JavaFX application lifecycle method is used to just create the application instance?
//init()
//Identify the method which is not counted as JavaFX application's lifecycle method.
// main()
//The top level container of JavaFX application that hosts the Scene is ______  Stage
//We may raise a question that why do we need to override start() method in Java thread?
// Answer is simple, we might want to initialize something
// e.g. our own library or may want  to call some methods for some initial task before starting a new thread.
// In this situation, we have to override start() method.
