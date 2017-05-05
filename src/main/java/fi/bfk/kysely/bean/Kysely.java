package fi.bfk.kysely.bean;

public class Kysely {
	
	private int id;
	private String nimi;
	private int kysymys_id;
	private String kysymys;
	private int vastaus_id;
	private String vastaus;
	
	
	
	public Kysely() {
		super();
		
	}



	public Kysely(int id, String nimi, int kysymys_id, String kysymys, int vastaus_id, String vastaus) {
		super();
		this.id = id;
		this.nimi = nimi;
		this.kysymys_id = kysymys_id;
		this.kysymys = kysymys;
		this.vastaus_id = vastaus_id;
		this.vastaus = vastaus;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNimi() {
		return nimi;
	}



	public void setNimi(String nimi) {
		this.nimi = nimi;
	}



	public int getKysymys_id() {
		return kysymys_id;
	}



	public void setKysymys_id(int kysymys_id) {
		this.kysymys_id = kysymys_id;
	}



	public String getKysymys() {
		return kysymys;
	}



	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}



	public int getVastaus_id() {
		return vastaus_id;
	}



	public void setVastaus_id(int vastaus_id) {
		this.vastaus_id = vastaus_id;
	}



	public String getVastaus() {
		return vastaus;
	}



	public void setVastaus(String vastaus) {
		this.vastaus = vastaus;
	}



	@Override
	public String toString() {
		return "Kysely [id=" + id + ", nimi=" + nimi + ", kysymys_id=" + kysymys_id + ", kysymys=" + kysymys
				+ ", vastaus_id=" + vastaus_id + ", vastaus=" + vastaus + "]";
	}
	
	
	
	

}
