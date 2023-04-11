package com.example.demointern;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
	public ChoiceBox<String> choice;
	public TextField temp;
	public Button convertBtn;
	public Label ansW;
	@FXML
	private Label welcomeText;
	private static final String ctoF ="Celsius to Fahrenheit";
	private static final String ftoC="Fahrenheit to Celsius" ;
	private  Float F= (float) 0;
	private  Float C= (float) 0;
	private boolean cF = true;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		choice.getItems().add(ctoF);
		choice.getItems().add(ftoC);
		choice.setValue(ctoF);

		choice.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {
			System.out.println(t1);
			if(Objects.equals(t1, ctoF)){
				System.out.println("TO F");


			} else if (Objects.equals(t1,ftoC)) {

				System.out.println("TO C");
				cF=false;
			}
		});

		convertBtn.setOnAction(actionEvent -> {
			System.out.println("Lol");
			if(!cF){
				C=convertToC();
				ansW.setText(String.valueOf(C));
			}
			else{
				F = convertToF();
				ansW.setText(String.valueOf(F));
			}


		});
	}

	private float convertToC() {
		String inp =  temp.getText();
		float tempF = Float.parseFloat(inp);
		return ((tempF-32)*((float) 5 /9));
	}

	private float convertToF() {
		String inp2 =  temp.getText();
		float tempC = Float.parseFloat(inp2);
		return (   tempC*((float) 5 /9) +32 );
	}
}