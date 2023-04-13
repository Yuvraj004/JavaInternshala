package com.example.javaanimation;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.net.URL;
import javafx.util.Duration;
import java.util.ResourceBundle;

public class HelloController implements Initializable {


	@FXML
	private Pane MyPane;

	@FXML
	public Button myButton;

	@Override
	public void initialize(URL location, ResourceBundle resources){
		Circle circle = new Circle();
		circle.setRadius(20);
		circle.setFill(Color.RED);
		circle.setTranslateX(50);
		circle.setTranslateY(50);
		MyPane.getChildren().add(circle);

		myButton.setOnAction(actionEvent -> {
			startAnimation(circle);
		});
	}

	private void startAnimation(Circle circle) {
		TranslateTransition transition = new TranslateTransition(Duration.seconds(1),circle);
//		transition.setDuration(Duration.seconds(1));
//		transition.setNode(circle);
		transition.setToY(200);
		transition.play();
	}

}