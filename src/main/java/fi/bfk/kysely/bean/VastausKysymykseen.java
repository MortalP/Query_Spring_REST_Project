package fi.bfk.kysely.bean;

public class VastausKysymykseen {
	
	private int id;
	private String vastaus;
	private int kysymys_id;
	private String kysymys;
	
	public VastausKysymykseen() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public VastausKysymykseen(int id, String vastaus, int kysymys_id, String kysymys) {
		super();
		this.id = id;
		this.vastaus = vastaus;
		this.kysymys_id = kysymys_id;
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

	@Override
	public String toString() {
		return "VastausKysymykseen [id=" + id + ", vastaus=" + vastaus + ", kysymys_id=" + kysymys_id + ", kysymys="
				+ kysymys + "]";
	}

}
