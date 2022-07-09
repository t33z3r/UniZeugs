package _1abstractClass;

import java.util.Calendar;

public class Manager extends Mitarbeiter {
	
	private double fixgehalt = 0;
	private double provision1 = 0;
	private double provision2 = 0;
	private double umsatz1 = 0;
	private double umsatz2 = 0;

	/**
	 * @return the fixgehalt
	 */
	public double getFixgehalt() {
		return fixgehalt;
	}

	/**
	 * @param fixgehalt the fixgehalt to set
	 */
	public void setFixgehalt(double fixgehalt) {
		this.fixgehalt = fixgehalt;
	}

	/**
	 * @return the provision1
	 */
	public double getProvision1() {
		return provision1;
	}

	/**
	 * @param provision1 the provision1 to set
	 */
	public void setProvision1(double provision1) {
		this.provision1 = provision1;
	}

	/**
	 * @return the provision2
	 */
	public double getProvision2() {
		return provision2;
	}

	/**
	 * @param provision2 the provision2 to set
	 */
	public void setProvision2(double provision2) {
		this.provision2 = provision2;
	}

	/**
	 * @return the umsatz1
	 */
	public double getUmsatz1() {
		return umsatz1;
	}

	/**
	 * @param umsatz1 the umsatz1 to set
	 */
	public void setUmsatz1(double umsatz1) {
		this.umsatz1 = umsatz1;
	}

	/**
	 * @return the umsatz2
	 */
	public double getUmsatz2() {
		return umsatz2;
	}

	/**
	 * @param umsatz2 the umsatz2 to set
	 */
	public void setUmsatz2(double umsatz2) {
		this.umsatz2 = umsatz2;
	}

	@Override
	public double monatsBrutto() {
		// TODO Auto-generated method stub
		return (fixgehalt + umsatz1 * provision1 + umsatz2 * provision2);
	}

	@Override
	public int hatDienstjubilaeum() {
		// TODO Auto-generated method stub
		Calendar cal1 = getEintritt();
		Calendar cal2 = Calendar.getInstance();
		int dienstjahre = (cal2.get(Calendar.YEAR))-(cal1.get(Calendar.YEAR));
		return (dienstjahre * 100);
	}

}
