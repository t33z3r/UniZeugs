package application;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animation extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();
	}
	
	public void start(Stage primaryStage) {
		//Container
		AnchorPane root = new AnchorPane();
		
		//graf. Elemente
		Rectangle quadrat = new Rectangle(10,10,30,30);//(x,y,breite,hoehe)
		//Timelineanimation
		KeyValue kv1X = new KeyValue(quadrat.translateXProperty(),100);
		//KeyValue - spez. Objekt, welches die Eigenschaften um einen
		//angegebenen Wert aendert ( x-Start: 10 --> +100)
		KeyValue kv1Y = new KeyValue(quadrat.translateYProperty(),0);
		
		KeyFrame f1 = new KeyFrame(Duration.seconds(1),kv1X,kv1Y);
		//Wechsel von f0 (Ausgangsbild) auf f1 in 1 Sekunde mit den
		//Aenderungen kv1X,kv1Y
		
		KeyValue kv2X = new KeyValue(quadrat.translateXProperty(),400);
		KeyValue kv2Y = new KeyValue(quadrat.translateYProperty(),400);
		KeyFrame f2 = new KeyFrame(Duration.seconds(2),kv2X,kv2Y);
		Timeline zeitlinie = new Timeline();
		zeitlinie.getKeyFrames().addAll(f1,f2);//oder 2x .add(..)
		zeitlinie.setCycleCount(4);
		//4x wiederholen(Hinweg,Rueckweg,Hinweg,Rueckweg)
		zeitlinie.setAutoReverse(true);//Rueckweg einschalten
		zeitlinie.play();
		
		root.getChildren().add(quadrat);
		
		Circle kreis = new Circle(100,100,30);//(x,y,radius)
		kreis.setFill(Color.GREEN);//Farbe des Kreises
		//PathTransistion - vordefinierte Animation
		Path weg = new Path();
		weg.getElements().add(new MoveTo(100,150));//gehe zu 100,150
		weg.getElements().add(new CubicCurveTo(100,200,250,200,200,110));
		//Start-Vorgabe, Anker1(x,y), Anker2(x,y),Ende(x,y)
		
		PathTransition wegAnimation = new PathTransition();
		wegAnimation.setDuration(Duration.seconds(5));
		wegAnimation.setPath(weg);//Welcher Weg soll genommen werden
		wegAnimation.setNode(kreis);//Auf welches Element soll die
		//PathTransition angewendet werden
		wegAnimation.setCycleCount(PathTransition.INDEFINITE);//-1
		//unedlich oft wiederholen
		wegAnimation.setAutoReverse(true);
		wegAnimation.play();
		root.getChildren().add(kreis);
		
		
		//Scene
		Scene s = new Scene(root,500,500);// root + Groesse 500x500px
		primaryStage.setScene(s);
		primaryStage.show();
	}

}
