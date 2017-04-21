package fi.bfk.kysely.bean;

public class Vastaus {
private int id;
private String vastaus;
private int kysymys_id;
public Vastaus(int id, String vastaus, int kysymys_id){
	super();
	this.id=id;
	this.vastaus=vastaus;
	this.kysymys_id=kysymys_id;
	
	
}
public Vastaus() {
	super();
	// TODO Auto-generated constructor stub
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

}