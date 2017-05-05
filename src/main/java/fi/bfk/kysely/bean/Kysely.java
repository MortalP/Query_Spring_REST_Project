package fi.bfk.kysely.bean;

public class Kysely {
	
	private int kysely_id;
	private String nimi;
	private int kysymys_id;
	private String kysymys;
	private int id;
	private String vastaus;
	
	public Kysely(int kysely_id, String nimi, int kysymys_id, String kysymys, int id, String vastaus) {
		super();
		this.kysely_id = kysely_id;
		this.nimi = nimi;
		this.kysymys_id = kysymys_id;
		this.kysymys = kysymys;
		this.id = id;
		this.vastaus = vastaus;
	}
	
	public Kysely() {
		super();
	}
	
	public int getKysely_id() {
		return kysely_id;
	}
	public void setKysely_id(int kysely_id) {
		this.kysely_id = kysely_id;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVastaus() {
		return vastaus;
	}
	public void setVastaus(String vastaus) {
		this.vastaus = vastaus;
	}
	
	@Override
	public String toString() {
		return "Kysely [kysely_id=" + kysely_id + ", nimi=" + nimi + ", kysymys_id=" + kysymys_id + ", kysymys="
				+ kysymys + ", id=" + id + ", vastaus=" + vastaus + "]";
	}
	
}
