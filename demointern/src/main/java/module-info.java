module com.example.demointern {
	requires javafx.controls;
	requires javafx.fxml;

	requires org.kordamp.bootstrapfx.core;
	requires com.almasb.fxgl.all;

	opens com.example.demointern to javafx.fxml;
	exports com.example.demointern;
}