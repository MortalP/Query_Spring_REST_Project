package fi.bfk.kysely.bean;

public class PerusKysely {
	private int id;
	private String nimi;
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
	public PerusKysely(int id, String nimi) {
		super();
		this.id = id;
		this.nimi = nimi;
	}
	public PerusKysely() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PerusKysely [id=" + id + ", nimi=" + nimi + "]";
	}
	
}
