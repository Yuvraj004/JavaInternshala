module com.example.connect4game {
	requires javafx.controls;
	requires javafx.fxml;

	requires org.controlsfx.controls;
	requires com.dlsc.formsfx;
	requires org.kordamp.bootstrapfx.core;
	requires com.almasb.fxgl.all;

	opens com.example.connect4game to javafx.fxml;
	exports com.example.connect4game;
}