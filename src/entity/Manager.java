package entity;


import java.io.Serializable;

	public class Manager implements Serializable {
		private static final long serialVersionUID = 1666257854331861643L;
		private int mid ;
		private String mname;
		private String mpassword;
		public Manager() {
			// TODO Auto-generated constructor stub
		}
		public Manager(int mid,String mname,String mpassword){
			super();
			this.mid = mid;
			this.mname=mname;
			this.mpassword=mpassword;
		}
		
		public int getMid() {
			return mid;
		}
		public void setMid(int mid) {
			this.mid = mid;
		}
		public String getMname() {
			return mname;
		}
		public void setMname(String mname) {
			this.mname = mname;
		}
		public String getMpassword() {
			return mpassword;
		}
		public void setMpassword(String mpassword) {
			this.mpassword = mpassword;
		}	
		
	}

