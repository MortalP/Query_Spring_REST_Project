package fi.bfk.kysely.bean;

public class Kysymys {
	
	private int id;
	private String kysymys;
	
	public Kysymys(int id, String kysymys) {
		super();
		this.id = id;
		this.kysymys = kysymys;
	}
	public Kysymys() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKysymys() {
		return kysymys;
	}
	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}
	@Override
	public String toString() {
		return "Kysymys [id=" + id + ", kysymys=" + kysymys + "]";
	}
}
