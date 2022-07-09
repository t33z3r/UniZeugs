package _1abstractClass;

import java.util.Calendar;

public abstract class Mitarbeiter {
	
	// Variablendeklaration
	private int persnr = 0;
	private String name = "";
	private Calendar eintritt;
	
	/**
	 * @return the persnr
	 */
	public int getPersnr() {
		return persnr;
	}

	/**
	 * @param persnr the persnr to set
	 */
	public void setPersnr(int persnr) {
		this.persnr = persnr;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the eintritt
	 */
	public Calendar getEintritt() {
		return eintritt;
	}

	/**
	 * @param eintritt the eintritt to set
	 */
	public void setEintritt(Calendar eintritt) {
		this.eintritt = eintritt;
	}
	
	public Mitarbeiter() {
		
	}
	
	public abstract double monatsBrutto();
	
	public abstract int hatDienstjubilaeum();
	
	
}
