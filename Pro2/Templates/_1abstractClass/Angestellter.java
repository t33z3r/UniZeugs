package _1abstractClass;

import java.util.Calendar;

public class Angestellter extends Mitarbeiter{
	
	private double grundgehalt = 0;
	private double ortszuschlag = 0;
	private double zulage = 0;

	@Override
	public double monatsBrutto() {
		// TODO Auto-generated method stub
		return (grundgehalt+ortszuschlag+zulage);
	}

	@Override
	public int hatDienstjubilaeum() {
		// TODO Auto-generated method stub
		Calendar cal1 = getEintritt();
		Calendar cal2 = Calendar.getInstance();
		int dienstjahre = (cal2.get(Calendar.YEAR))-(cal1.get(Calendar.YEAR));
		return (dienstjahre * 50);
	}

	/**
	 * @return the grundgehalt
	 */
	public double getGrundgehalt() {
		return grundgehalt;
	}

	/**
	 * @param grundgehalt the grundgehalt to set
	 */
	public void setGrundgehalt(double grundgehalt) {
		this.grundgehalt = grundgehalt;
	}

	/**
	 * @return the ortszuschlag
	 */
	public double getOrtszuschlag() {
		return ortszuschlag;
	}

	/**
	 * @param ortszuschlag the ortszuschlag to set
	 */
	public void setOrtszuschlag(double ortszuschlag) {
		this.ortszuschlag = ortszuschlag;
	}

	/**
	 * @return the zulage
	 */
	public double getZulage() {
		return zulage;
	}

	/**
	 * @param zulage the zulage to set
	 */
	public void setZulage(double zulage) {
		this.zulage = zulage;
	}	

}
