package entity;

public class Vip {
	private int id;
	private int vno;
	private String vname;
	private String vcard;
	private int rmno;
	private long tel;
	private double vfee;
	private String vdate;
	
	public Vip() {
		// TODO Auto-generated constructor stub
	}
	public Vip(int id,int vno,String vname,String vcard,int rmno,long tel,double vfee,String vdate){
		 super();
		 this.id = id;
		 this.vno = vno;
		 this.vname = vname;
		 this.vfee = vfee;
		 this.vcard = vcard;
		 this.rmno = rmno;
		 this.tel = tel;
		 this.vdate = vdate;
	}
	
	public String toString() {
	
		return "姓名是"+vname+"会员编号是"+vno+"身份证是"+vcard+"电话是"+tel;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVno() {
		return vno;
	}
	public void setVno(int vno) {
		this.vno = vno;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getVcard() {
		return vcard;
	}
	public void setVcard(String vcard) {
		this.vcard = vcard;
	}
	public int getRmno() {
		return rmno;
	}
	public void setRmno(int rmno) {
		this.rmno = rmno;
	}
	public long getTel() {
		return tel;
	}
	public void setTel(long tel) {
		this.tel = tel;
	}
	public double getVfee() {
		return vfee;
	}
	public void setVfee(double vfee) {
		this.vfee = vfee;
	}
	public String getVdate() {
		return vdate;
	}
	public void setVdate(String vdate) {
		this.vdate = vdate;
	}
	
	
}
