package entity;

public class Menus {
	private String mname;
    private double mfee;
    private double mvfee;
    private int mno;
    
    public String toString() {
    	return mname+"\t"+mfee+"\t"+mvfee;
    }
    public Menus() {
	}
    public Menus(String mname,double mfee,double mvfee,int mno) {
    	
	   super();
	   this.mno = mno;
	   this.mname = mname;
	   this.mfee = mfee;
	   this.mvfee = mvfee;
    }
    public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}

    
    
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public double getMfee() {
		return mfee;
	}
	public void setMfee(double mfee) {
		this.mfee = mfee;
	}
	public double getMvfee() {
		return mvfee;
	}
	public void setMvfee(double mvfee) {
		this.mvfee = mvfee;
	}
    
    
    
}
