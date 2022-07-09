package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI extends Application{
	
	private Button btn1 = new Button("Button");
	
	private Label lbl1 = new Label("Label");
	
	private TextField txt1 = new TextField();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();

	}
	
	public void start(Stage primaryStage) {
		
		//Programmtitel
		primaryStage.setTitle("Titel");
		
		//Kein größer/kleiner-Ziehen des Programms möglich
		primaryStage.setResizable(false);
		
		//Vertikales Layout
		VBox root1 = new VBox(); 
		
		//Horizontales Layout
		//HBox root2 = new HBox();
		
		btn1.setStyle("-fx-font: 20 arial; -fx-base: #777777;");
		
		btn1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		
		btn1.setOnAction(e -> {
			String tmp = txt1.getText();
			lbl1.setText(tmp);
			//...
		});
		
		root1.getChildren().addAll(lbl1,txt1,btn1);
		
		primaryStage.setScene(new Scene (root1));
		
		primaryStage.show();
		
	}

}
