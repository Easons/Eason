package entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Room {
	private int rmno;
	private String rmtype;
	private double rmprice;
	private String rmbuff;
	private String rmbook;
	private double vprice;
	private String rydate ;
	
	public Room() {
		// TODO Auto-generated constructor stub
	}
	public Room(int rmid,int rmno,String rmtype,double rmprice
			,String rmbuff,String rmbook,double vprice,String rydate){
		//super();
		this.rydate = rydate;
		this.rmno = rmno;
		this.rmtype = rmtype;
		this.rmprice = rmprice;
		this.rmbuff = rmbuff;
		this.rmbook = rmbook;
		this.vprice = vprice;
	}
	public String toString() {
		return rmno+"\t\t"+rmtype+"\t\t"+rmprice+"\t\t"+vprice+"\t\t"+rmbuff+"\t\t"+rmbook;
	}

	public String getRydate() {
		return rydate;
	}
	public void setRydate(String rydate) {
		this.rydate = rydate;
	}

	public int getRmno() {
		return rmno;
	}

	public void setRmno(int rmno) {
		this.rmno = rmno;
	}

	public String getRmtype() {
		return rmtype;
	}

	public void setRmtype(String rmtype) {
		this.rmtype = rmtype;
	}

	public double getRmprice() {
		return rmprice;
	}

	public void setRmprice(double rmprice) {
		this.rmprice = rmprice;
	}

	public String getRmbuff() {
		return rmbuff;
	}

	public void setRmbuff(String rmbuff) {
		this.rmbuff = rmbuff;
	}

	public String getRmbook() {
		return rmbook;
	}

	public void setRmbook(String rmbook) {
		this.rmbook = rmbook;
	}

	public double getVprice() {
		return vprice;
	}

	public void setVprice(double vprice) {
		this.vprice = vprice;
	}	
//	public static void main(String[] args) {
////		System.out.println(new SimpleDateFormat("yyyy'Äê'-MM'ÔÂ'-dd'ºÅ' hh£ºmm£ºss").format(new Date()));
////		System.out.println(new SimpleDateFormat("yyyy-MM-dd hh£ºmm£ºss").format(new Date()));
////	    System.out.println(to_char(,"YYYY-MM-DD HH24:MI:SS"));
//	
//	}
}
