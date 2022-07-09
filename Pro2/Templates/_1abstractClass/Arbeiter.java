package _1abstractClass;

import java.util.Calendar;

public class Arbeiter extends Mitarbeiter{

	private double stundenlohn = 0;
	private double anzahlstunden = 0;
	private double ueberstundenzuschlag = 0;
	private double anzahlueberstunden = 0;
	private double schichtzulage = 0;
	
	/**
	 * @return the stundenlohn
	 */
	public double getStundenlohn() {
		return stundenlohn;
	}

	/**
	 * @param stundenlohn the stundenlohn to set
	 */
	public void setStundenlohn(double stundenlohn) {
		this.stundenlohn = stundenlohn;
	}

	/**
	 * @return the anzahlstunden
	 */
	public double getAnzahlstunden() {
		return anzahlstunden;
	}

	/**
	 * @param anzahlstunden the anzahlstunden to set
	 */
	public void setAnzahlstunden(double anzahlstunden) {
		this.anzahlstunden = anzahlstunden;
	}

	/**
	 * @return the ueberstundenzuschlag
	 */
	public double getUeberstundenzuschlag() {
		return ueberstundenzuschlag;
	}

	/**
	 * @param ueberstundenzuschlag the ueberstundenzuschlag to set
	 */
	public void setUeberstundenzuschlag(double ueberstundenzuschlag) {
		this.ueberstundenzuschlag = ueberstundenzuschlag;
	}

	/**
	 * @return the anzahlueberstunden
	 */
	public double getAnzahlueberstunden() {
		return anzahlueberstunden;
	}

	/**
	 * @param anzahlueberstunden the anzahlueberstunden to set
	 */
	public void setAnzahlueberstunden(double anzahlueberstunden) {
		this.anzahlueberstunden = anzahlueberstunden;
	}

	/**
	 * @return the schichtzulage
	 */
	public double getSchichtzulage() {
		return schichtzulage;
	}

	/**
	 * @param schichtzulage the schichtzulage to set
	 */
	public void setSchichtzulage(double schichtzulage) {
		this.schichtzulage = schichtzulage;
	}

	@Override
	public double monatsBrutto() {
		// TODO Auto-generated method stub
		return (stundenlohn*anzahlstunden+anzahlueberstunden*ueberstundenzuschlag+schichtzulage);
	}

	@Override
	public int hatDienstjubilaeum() {
		// TODO Auto-generated method stub
		Calendar cal1 = getEintritt();
		Calendar cal2 = Calendar.getInstance();
		int dienstjahre = (cal2.get(Calendar.YEAR))-(cal1.get(Calendar.YEAR));
		return (dienstjahre * 10);
	}

}
