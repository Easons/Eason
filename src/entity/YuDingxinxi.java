package entity;

public class YuDingxinxi {
	private String name;
	private String card;
	private int rmno;
	private String type;
	private String time;

	
	public YuDingxinxi() {
		
	}


	public YuDingxinxi(String name,String card,int rmno,String type,String time){
		super();
		this.name = name;
		this.card = card;
		this.rmno = rmno;
		this.type = type;
		this.time = time;
		
	}
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCard() {
		return card;
	}


	public void setCard(String card) {
		this.card = card;
	}


	public int getRmno() {
		return rmno;
	}


	public void setRmno(int rmno) {
		this.rmno = rmno;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}
	
	
}
