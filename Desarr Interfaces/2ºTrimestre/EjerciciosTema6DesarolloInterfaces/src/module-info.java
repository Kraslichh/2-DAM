module EjerciciosTema6DesarolloInterfaces {
	requires javafx.controls;
	requires javafx.fxml;
    requires java.sql;
	requires java.desktop;
	requires java.xml;
	requires jdk.compiler;
	requires jdk.javadoc;
    
	opens Ejercicios to javafx.graphics, javafx.fxml;
	
}
