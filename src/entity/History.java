package entity;

public class History {
	private int id;
	private String hname;
	private String hcard;
	private long htel;
	private int hrmno;
	private String htype;
	private String hydate;
	private String hyedate;
	private String hdate;
	private String hedate;
	private double hallfee;
	private String hshijian;
	
	
	public History(){}
	
	public History(String htype,int hrmno,int id,String hname,String hcard,long htel,String hydate,String hdate,String hedate,double hallfee,
			String hshijian) {
		super();
		this.htype = htype;
		this.hrmno = hrmno;
		this.id = id;
		this.hname = hname;
		this.hcard = hcard;
		this.htel = htel;
		this.hydate = hydate;
		this.hyedate = hyedate;
		this.hdate = hdate;
		this.hedate = hedate;
		this.hallfee = hallfee;
		this.hshijian = hshijian;
	}

	
	public String getHtype() {
		return htype;
	}

	public void setHtype(String htype) {
		this.htype = htype;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public String getHcard() {
		return hcard;
	}

	public void setHcard(String hcard) {
		this.hcard = hcard;
	}

	public long getHtel() {
		return htel;
	}

	public void setHtel(long htel) {
		this.htel = htel;
	}

	public int getHrmno() {
		return hrmno;
	}

	public void setHrmno(int hrmno) {
		this.hrmno = hrmno;
	}

	public String getHydate() {
		return hydate;
	}

	public void setHydate(String hydate) {
		this.hydate = hydate;
	}

	public String getHyedate() {
		return hyedate;
	}

	public void setHyedate(String hyedate) {
		this.hyedate = hyedate;
	}

	public String getHdate() {
		return hdate;
	}

	public void setHdate(String hdate) {
		this.hdate = hdate;
	}

	public String getHedate() {
		return hedate;
	}

	public void setHedate(String hedate) {
		this.hedate = hedate;
	}

	public double getHallfee() {
		return hallfee;
	}

	public void setHallfee(double hallfee) {
		this.hallfee = hallfee;
	}

	public String getHshijian() {
		return hshijian;
	}

	public void setHshijian(String hshijian) {
		this.hshijian = hshijian;
	}


	
}
