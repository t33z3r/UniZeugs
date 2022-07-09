package _9baeume;


import java.awt.Graphics;
import java.util.Scanner;

import javax.swing.JFrame;

public class BinBaumGrafik extends JFrame {
	private  int breite = 400;
	private  int hoehe = 200;
	private  int h = 20; // Abstand der Ebenen
	private Node wurzel;

	public BinBaumGrafik(String name) {
		super(name);
		setDefaultCloseOperation(3);
		setSize(breite, hoehe);
		setVisible(true);
		start();
	}

	public static void main(String args[]) {
		new BinBaumGrafik("BinaerBaum");
	}

	public void drawBaum(Graphics t, Node root, int xpos, int ypos, int weite) {
		if (root == null) {
			t.drawString("Baum ist leer", 20, 40);
		} else {
			t.drawString("" + root.getKey(), xpos, ypos);
			if (root.getLchild() != null) {
				t.drawLine(xpos, ypos, xpos - weite, ypos + h);
				drawBaum(t, root.getLchild(), xpos - weite, ypos + h, weite / 2);
			}
			if (root.getRchild() != null) {
				t.drawLine(xpos, ypos, xpos + weite, ypos + h);
				drawBaum(t, root.getRchild(), xpos + weite, ypos + h, weite / 2);
			}
		}
	}

	public void paint(Graphics g) {
		drawBaum(g, wurzel, breite / 2 - 4, 75, breite / 4 - 4);
	}

	public void start() {
		SuchBaum sb = new SuchBaum();
		wurzel = sb.getRoot();
		System.out.println("Suchbaum-Operationen ");
		System.out.println("***************************************");

		//
		String a;

		Scanner scanner = new Scanner(System.in);

		do {
			System.out.println("Waehlen Sie: [i]nsert, [d]elete, Baum [l]öschen, [e]xit ... ");
			a = scanner.next();
			switch (a.charAt(0)) {
			case 'i': {
				System.out.println("Einfuegen: ");
				int key = scanner.nextInt();
				
				sb.insert(key);
				wurzel = sb.getRoot();
				repaint();
				break;
			}
			case 'd': {
				System.out.println("Entfernen: ");
				int key = scanner.nextInt();
				if (sb.member(key)) {
					sb.delete(key);
					wurzel = sb.getRoot();
					repaint();
				} else {
					System.out.println(key + " ist nicht vorhanden.");
				}
				break;
			}
			case 'l': {
				wurzel = null;
				sb.setRoot(null); 
				repaint();
				break;
			}
			case 'e': {
				scanner.close();
				System.exit(0);
				break;
			}
			default: break;
			
			}
		} while ((a.charAt(0) == 'i') || (a.charAt(0) == 'd') || (a.charAt(0) == 'l'));
	}
}
