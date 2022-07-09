package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class radio extends Application{

	public static void main(String[] args) {

		launch();
	}

	
	public void start(Stage primaryStage){
		
		BorderPane root = new BorderPane();
		primaryStage.setTitle("RadionButton");
		root.setMinSize(400, 400);
		
		
		RadioButton rb1 = new RadioButton("Rot");
		
		RadioButton rb2 = new RadioButton("Gruen");
		
		RadioButton rb3 = new RadioButton("Blau");
		//root.setAlignment(rb1, Pos.TOP_CENTER);
		root.setTop(rb1);
		root.setLeft(rb2);
		root.setBottom(rb3);

		root.setMargin(rb1, new Insets(20,0,0,10));
		root.setMargin(rb2, new Insets(40,0,0,10));
		root.setMargin(rb3, new Insets(0,0,240,10));
		
		
		
		Rectangle r = new Rectangle(100,100);
		root.setRight(r);
		root.setMargin(r, new Insets(0,100,0,0));
		rb1.setOnAction(e -> {
			r.setFill(Color.RED);
			rb2.setSelected(false);
			rb3.setSelected(false);
		});
		
		rb2.setOnAction(e -> {
			r.setFill(Color.GREEN);
			rb1.setSelected(false);
			rb3.setSelected(false);
		});
		
		rb3.setOnAction(e -> {
			r.setFill(Color.BLUE);
			rb1.setSelected(false);
			rb2.setSelected(false);
		});
		
		
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
		
	}


	
	

}
