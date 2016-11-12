package entity;

public class Emp {
	private int empno;
	private String ename;
	private String epassword;
    private int age;
    private double sal;
    private String esex;
    
    public String getEsex() {
		return esex;
	}
	public void setEsex(String esex) {
		this.esex = esex;
	}

	public Emp() {
		// TODO Auto-generated constructor stub
	}
    public Emp(int empno,String ename,String epassword,int age
    		,double sal,String esex){
    	super();
    	this.empno = empno;
    	this.esex = esex;
    	this.ename = ename;
    	this.epassword = epassword;
    	this.age = age;
    	this.sal = sal;
    	
    	
    }


	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEpassword() {
		return epassword;
	}

	public void setEpassword(String epassword) {
		this.epassword = epassword;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}



}
