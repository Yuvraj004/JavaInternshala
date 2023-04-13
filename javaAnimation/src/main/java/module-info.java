module com.example.javaanimation {
	requires javafx.controls;
	requires javafx.fxml;

	requires org.controlsfx.controls;
	requires org.kordamp.bootstrapfx.core;
	requires com.almasb.fxgl.all;

	opens com.example.javaanimation to javafx.fxml;
	exports com.example.javaanimation;
}