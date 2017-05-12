package fi.bfk.kysely.bean;

public class Kysymys {
	
	private int id;
	private String kysymys;
	 private int kysely_id;
	 
	 
	public Kysymys() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Kysymys(int id, String kysymys, int kysely_id) {
		super();
		this.id = id;
		this.kysymys = kysymys;
		this.kysely_id = kysely_id;
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
	public int getKysely_id() {
		return kysely_id;
	}
	public void setKysely_id(int kysely_id) {
		this.kysely_id = kysely_id;
	}
	@Override
	public String toString() {
		return "Kysymys [id=" + id + ", kysymys=" + kysymys + ", kysely_id=" + kysely_id + "]";
	}
	 
}