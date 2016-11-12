package entity;

public class Client {
	 private int cid; 
	 private String  cname;
	 private String ccard; 
	 private long rtel; 
	 private int rmno ;
	 private double cding;
	 private double cfee;
	 private String  cdate;
	 
	 
	 public Client() {
		// TODO Auto-generated constructor stub
	}
	 public Client(int cid,String cname,String ccard,long rtel,int rmno,double cding,double cfee
			 ,String cdate){
		 super();
		 this.ccard = ccard;
		 this.cdate = cdate;
		 this.cding = cding;
		 this.cfee = cfee;
		 this.cid = cid;
		 this.cname = cname;
		 this.rmno = rmno;
		 this.rtel = rtel;
		 
	 }

	public String toString() {
		return "姓名是:"+cname+"房间号:"+rmno;
	}
	 
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCnamne() {
		return cname;
	}
	public void setCnamne(String cname) {
		this.cname = cname;
	}
	public String getCcard() {
		return ccard;
	}
	public void setCcard(String ccard) {
		this.ccard = ccard;
	}
	public long getRtel() {
		return rtel;
	}
	public void setRtel(long rtel) {
		this.rtel = rtel;
	}
	public int getRmno() {
		return rmno;
	}
	public void setRmno(int rmno) {
		this.rmno = rmno;
	}
	public double getCding() {
		return cding;
	}
	public void setCding(double cding) {
		this.cding = cding;
	}
	public double getCfee() {
		return cfee;
	}
	public void setCfee(double cfee) {
		this.cfee = cfee;
	}

	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	 
	 
	 
}
