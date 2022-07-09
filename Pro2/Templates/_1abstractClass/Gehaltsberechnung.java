package _1abstractClass;

import java.util.GregorianCalendar;

public class Gehaltsberechnung {

	private final int anz_ma = 10;
	private Mitarbeiter ma[]= new Mitarbeiter[anz_ma];
	
	public Gehaltsberechnung() {
	Manager manager1 = new Manager();
	manager1.setName("Hans Wurst");
	manager1.setProvision1(20.0);
	manager1.setProvision2(40.0);
	manager1.setUmsatz1(5);
	manager1.setUmsatz2(2);
	
	manager1.setEintritt(new GregorianCalendar(2000, GregorianCalendar.DECEMBER, 4));
	manager1.setPersnr(1);
	
	ma[0] = manager1;
	
	Arbeiter arbeiter1 = new Arbeiter();
	arbeiter1.setName("Hans Peter");
	arbeiter1.setStundenlohn(9.0);
	arbeiter1.setAnzahlueberstunden(10.0);
	arbeiter1.setUeberstundenzuschlag(0.25);
	arbeiter1.setSchichtzulage(120);
	arbeiter1.setAnzahlstunden(160);
	
	arbeiter1.setEintritt(new GregorianCalendar(1998, 10, 23));
	arbeiter1.setPersnr(2);
	
	ma[1] = arbeiter1;
	
	Arbeiter arbeiter2 = new Arbeiter();
	arbeiter2.setName("Klaus Wurst");
	arbeiter2.setStundenlohn(9.0);
	arbeiter2.setAnzahlueberstunden(20.0);
	arbeiter2.setUeberstundenzuschlag(0.25);
	arbeiter2.setSchichtzulage(220);
	arbeiter2.setAnzahlstunden(260);
	
	arbeiter2.setEintritt(new GregorianCalendar(1978, 2, 13));
	arbeiter2.setPersnr(3);
	
	ma[2] = arbeiter2;
	
	}
	
	public static void berechneGehaltsliste() {
		Gehaltsberechnung ghb = new Gehaltsberechnung();
		for (int i=0; i <= 2; i++) {
			System.out.println(ghb.ma[i].hatDienstjubilaeum());
			System.out.println(ghb.ma[i].monatsBrutto());
		}
	}
	
	public static void main(String[] args) {
		berechneGehaltsliste();
	}
}
