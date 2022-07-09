package application;

import java.time.Duration;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Party extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();
	}
	public void start(Stage primaryStage) {
		int anzahlDerKreise = 500;
		Circle[] kreise = new Circle[anzahlDerKreise];
		long[] zeiten = new long[anzahlDerKreise];//enthaelt die Startzeiten
		double[] winkel = new double[anzahlDerKreise];//enthalt die 
		//verschiedenen Richtungen
		long dauer = Duration.ofSeconds(5).toNanos();// 5s in ns
		Random rnd = new Random();
		
		for(int m = 0; m < anzahlDerKreise; m++) {
			Color farbe = Color.rgb(rnd.nextInt(256), 
					rnd.nextInt(256), rnd.nextInt(256));
			//zufaellige Farbe erzeugen
			kreise[m] = new Circle(5,farbe);//(radius,farbe)
			zeiten[m] = (long)(rnd.nextDouble()*dauer);
			//Startwert zwischen 0 - 4,9999 Sekunden
			winkel[m] = 2 * Math.PI * rnd.nextDouble();
			//0 <= winkel < 2 * PI ( 0 - 359,99999 Grad)
		}
		AnchorPane root = new AnchorPane();
		root.getChildren().addAll(kreise);
		Scene s = new Scene(root,500,500);
		primaryStage.setScene(s);
		primaryStage.show();
		
		AnimationTimer timer = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				// die Methode handle wird im Millisekundenbreich
				//aufgerufen ( 1000 / Hertz)
				double radius = 250;
				for(int m = 0 ; m < anzahlDerKreise; m++) {
					long t = (now -zeiten[m]) % dauer;
					double distanz = t * radius / dauer;
					//Abstand im Zusammenhang mit der Zeit
					double w = winkel[m];
					Circle k = kreise[m];
					k.setTranslateX(Math.cos(w)*distanz 
							+ primaryStage.getWidth()/2);
					k.setTranslateY(Math.sin(w)*distanz 
							+primaryStage.getHeight()/2);
				}
				
			}
		};
		timer.start();
	}

}
