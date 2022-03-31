package data;

public class Ehdokkaat {

	private int ehdokasId;
	private String sukunimi;
	private String etunimi;
	private String puolue;
	private String kotiPaikkakunta;
	private int ika;
	private String miksiEduskuntaan;
	private String mitaAsioitaHaluatEdistaa;
	private String ammatti;
	
	public int getEhdokasId() {
		return ehdokasId;
	}
	public void setEhdokasId(int ehdokasId) {
		this.ehdokasId = ehdokasId;
	}
	
	public String getSukunimi() {
		return sukunimi;
	}
	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}
	
	public String getEtunimi() {
		return etunimi;
	}
	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}
	
	public String getPuolue() {
		return puolue;
	}
	public void setPuolue(String puolue) {
		this.puolue = puolue;
	}
	
	public String getKotiPaikkakunta() {
		return kotiPaikkakunta;
	}
	public void setKotiPaikkakunta(String kotiPaikkakunta) {
		this.kotiPaikkakunta = kotiPaikkakunta;
	}
	
	public int getIka() {
		return ika;
	}
	public void setIka(int ika) {
		this.ika = ika;
	}
	
	public String getMiksiEduskuntaan() {
		return miksiEduskuntaan;
	}
	public void setMiksiEduskuntaan(String miksiEduskuntaan) {
		this.miksiEduskuntaan = miksiEduskuntaan;
	}
	
	public String getMitaAsioitaHaluatEdistaa() {
		return mitaAsioitaHaluatEdistaa;
	}
	public void setMitaAsioitaHaluatEdistaa(String mitaAsioitaHaluatEdistaa) {
		this.mitaAsioitaHaluatEdistaa = mitaAsioitaHaluatEdistaa;
	}
	
	public String getAmmatti() {
		return ammatti;
	}
	public void setAmmatti(String ammatti) {
		this.ammatti = ammatti;
	}
	
	public String toString() {
		return ehdokasId + " " + sukunimi + " " + etunimi + " " + puolue + " " + kotiPaikkakunta + " " + ika + " " + miksiEduskuntaan + " " + mitaAsioitaHaluatEdistaa + " " + ammatti;
	} 
	
	
}
