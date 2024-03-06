package model;

public class session {
    private int id ;
    private int yearS ;
    private int yearE ;
	public session(int id, int yearS, int yearE) {
		super();
		this.id = id;
		this.yearS = yearS;
		this.yearE = yearE;
	}
	public session() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYearS() {
		return yearS;
	}
	public void setYearS(int yearS) {
		this.yearS = yearS;
	}
	public int getYearE() {
		return yearE;
	}
	public void setYearE(int yearE) {
		this.yearE = yearE;
	}
	
	public session(int yearS, int yearE) {
		super();
		this.yearS = yearS;
		this.yearE = yearE;
	}
	
	@Override
	public String toString() {
		return "session [id=" + id + ", yearS=" + yearS + ", yearE=" + yearE + "]";
	}
    
    
}
