package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.Dao;
import dao.Daoemp;

import entity.Client;
import entity.Emp;
import entity.History;
import entity.Manager;
import entity.Menus;
import entity.Room;
import entity.Vip;
import entity.YuDingxinxi;
import UI.EmpLogin;
import UI.Empframe;
import UI.ManagerLogin;
import UI.SystemUI;
import biz.Biz;

public class actionImp{
	private ManagerLogin frame;
	Scanner sc = new Scanner(System.in);
	public Daoemp daoemp ;
	public Dao dao;
	public Emp emp;
	static Biz biz;
//	public actionImp() {
//		this.frame = frame;
//	}
	
	
	
	
	
    //管理员登录
	public Manager login(String username) {
		Manager m = new Manager();
		dao = new Dao();
		m = dao.querymanager(username);
		boolean flag = false;
//		if(m!=null){
//			  if(username.equals(m.getMname())&&userpassword.equals(m.getMpassword())){
//			    flag = true;	
//			  }else{
//					 JOptionPane.showMessageDialog(frame,"用户名或密码错误");
//				}
//			  
//		}else{
//			 JOptionPane.showMessageDialog(frame,"用户名或密码错误");
//			}
	      
		return m;
	}
	
	//员工登录
	public Emp login1(String ename) {
		boolean flag = false;
		 emp = new Emp();
		 dao = new Dao();
		emp =  dao.queryemp(ename);
		
	       return emp;
	}
	//员工忘记密码的修改
	public boolean updateemppass(int empno, String newpass) {
		dao = new Dao();
		boolean flag = dao.updateemppass(empno,newpass);
		return flag;
	}
	//管理员忘记密码修改
	public boolean updatemanagerpass(String name,String newpass){
		dao = new Dao();
		boolean flag = dao.updatemanagerpass(name,newpass);
		return flag;	
	}
	
	
	
	//注册管理员
	  public boolean addmanager(String name,String password){
		  dao = new Dao(); 
		  boolean flag = false;
		   flag = dao.addmanager(name,password);
		   return flag;
	   }
	  //修改管理员密码
	  public boolean managerpassword(String name,String oldpass,String newpass){
		  dao = new Dao();
		  boolean flag = false;
		  flag = dao.managerpassword(name,oldpass,newpass);
//		  if (flag) {
//			  JOptionPane.showMessageDialog(frame,"修改成功");
//		}else {
//			JOptionPane.showMessageDialog(frame,"您的原始密码有误");
//		}
		  return flag;
	  }

	public List<Emp> queryallemp() {
		List<Emp> list = new ArrayList<Emp>();
		dao = new Dao();
		list = dao.queryallemp();
		return list;
	}
	//查询员工
	public Emp queryemp(String ename) {
		dao = new Dao();
		Emp emp = new Emp();
		emp = dao.queryemp(ename);
		return emp;
	}
	
    //查询员工
	public List<Emp> queryallemp(String name) {
		dao = new Dao();
//		Emp e = new Emp();
		List<Emp> list = new ArrayList<Emp>();
		list = dao.queryallemp(name);
		return list;
	}
	//通过员工编号查询员工
	public List<Emp> queryempempno(int empno) {
		dao = new Dao();
		List<Emp> list = new ArrayList<Emp>();
		list = dao.queryempempno(empno);
		return list;
	}
	
	//删除员工
	public boolean deleteemp(int empno, String name) {
		boolean flag = false;
		dao = new Dao();
		 flag = dao.deleteemp(empno, name);
		return flag;
	}

   public Emp queryempbyempno(int empno) {
		Emp e = new Emp();
		biz = new Biz();
		e = biz.queryempbyempno(empno);
		return e;
	}


	public boolean updateemp(int empno, String name, int age, double sal,String sex) {
		boolean flag = false;
		biz = new Biz();
		flag = biz.updateemp(empno,name,age,sal,sex);
		return flag;
	}

       public boolean plusemp( String name, int age,double sal,String sex) {
    	   biz = new Biz();
    	   boolean flag = biz.plusemp(name,age,sal,sex);
    	   return flag;
    }
    //管理员修改房间信息

	public boolean updateroom(int rmno, String type, double price, double vprice) {
		boolean flag = false;
		biz = new Biz();
		flag = biz.updateroom(rmno,type,price,vprice);
		return flag;
	}
    //管理员删除房间
	public boolean deleteroom(int rmno) {
		boolean flag = false;
		biz = new Biz();
		flag = biz.deleteroom(rmno);
		return flag;
	}
    //增加房间
	public boolean addroom(String type, double price, double vprice) {
		boolean flag = false;
		Room r = new Room();
		biz = new Biz();
		
		flag = biz.addroom(type, price, vprice);
		return flag;
	}

	public boolean emppass(String username, String oldpass, String newpass) {
		biz = new Biz();
		boolean flag = false;
		flag = biz.emppass(username,oldpass,newpass);
		return flag;
	}
	  
//	//查询单个vip
	public Vip querybyid(int no,String name) {
		biz = new Biz();
		Vip v = new Vip();
		v = biz.querybyic(no,name);
		
		return v;
	}

	//按类型查询房间
	public List<Room> queryroombytype(String type) {
		 List<Room> list = new ArrayList<Room>();
		 biz = new Biz();
		 list = biz.queryroombytype(type);
		return list;
	}

//   查询所有房间
	public List<Room> queryroom() {
		List<Room> list = new ArrayList<Room>();
		biz = new Biz();
		list = biz.queryroom();
		return list;
	}
	//查询单个房间的类型
	public Room queryroomtype(int rmno){
		Room r = new Room();
		daoemp  = new Daoemp();
		r = daoemp.queryroomtype(rmno);
		return r;		
	}
	
	
	//查空房间
	public List<Room> queryroombuff() {
		List<Room> list = new ArrayList<Room>();
		biz = new Biz();
		list = biz.queryroombuff();
		return list;
	}


	//会员预定房间
	public boolean vipyuding(int vno, String vname, int rmno) {
		biz = new Biz();
		boolean flag = false;
		flag = biz.vipyuding(vno,vname,rmno);
		return flag;
	}

	//更新房间状态
	public boolean updateroom(int no,String date) {
		boolean flag = false;
		daoemp = new Daoemp();
		flag = daoemp.updatebuff(no,date);
		return flag;
	}
	//查询vip
	public Vip queryvip(int vno,String vname) {
		Vip v = new Vip();
		daoemp = new Daoemp();
		v = daoemp.queryvipid(vno, vname);
		return v;
	}
//	//会员入住
	public boolean vipruzhu(String vcard,String newtime) {
		biz = new Biz();
		Vip vip = new Vip();
		boolean flag = false;
		flag = biz.vipruzhu(vcard,newtime);
		return flag;
	}

	public boolean putongyuding(int rmno,String putongname, long tel, String card,
			double ding) {
		boolean flag = false;
		daoemp = new Daoemp();
		flag = daoemp.putongyuding(rmno,putongname,tel,card,ding);
		return flag;
	}

	//查询单个散客
	public Client queryclient(String putongname, long tel) {
		daoemp = new Daoemp();
		Client client = new Client();
		client = daoemp.queryclient(putongname,tel);
		return client;
	}
 
	//查询所有菜单
	public List<Menus> querymenus() {
		biz = new Biz();
		List<Menus> list = biz.querymenus();
		return list;
	}
	//查询单个菜
	public List<Menus> querymenus(String mname) {
		List<Menus> list = biz.menusname(mname);
		return list;
	}
	
	//删除菜单
	public boolean deletemenus(String mname) {
		boolean flag = false;
		flag =  biz.deletemenus(mname);
		return flag;
	}
	
	//增加菜单
	public boolean addmenus(String mname, double mfee, double mvfee) {
	     boolean flag = biz.insertmenus(mname,mfee,mvfee);
		return flag;
	}

	//查询单个菜单对象
	public Menus menusname(String name) {
		biz = new Biz();
		Menus m = biz.querymenus1(name);
		return m;
	}

	//更新菜单
	public boolean updatemenus(String mname, double price, double vprice, int id) {
		biz = new Biz();
		boolean flag = biz.updatemenus(mname,price,vprice,id);
		return flag;
	}
    //vip的入住查询
	public YuDingxinxi vipruzhuchaxun(String card) {
		biz = new Biz();
		YuDingxinxi y = new YuDingxinxi();
		y = biz.vipruzhuchaxun(card);
		return y;
	}

	//普通用户入住查询
	public YuDingxinxi putongruzhuchaxun(String card) {
		biz = new Biz();
		YuDingxinxi y = new YuDingxinxi();
		y = biz.putongruzhuchaxun(card);
		return y;
	}

	//入住修改房间状态
	public boolean updateruzhuroom(int rmno) {
		biz = new Biz();
		boolean flag = biz.updateruzhuroom(rmno);
		return flag;
	}

	//普通用户入住
	public boolean clientruzhu(String ccard) {
		biz = new Biz();
		boolean flag = false;
		flag = biz.clientruzhu(ccard);
		return flag;
	}

	//vip退订房间
	public boolean viptuiding(String card) {
		biz = new Biz();
		boolean flag = false;
		flag = biz.viptuiding(card);
		return flag;
	}

	//退订(改变房间状态)
	public boolean tuidingroom(int rmno) {
		biz = new Biz();
		boolean flag = false;
		flag = biz.tuidingroom(rmno);
		return flag;
	}
	//客户退订增加历史记录
	public boolean addTuiDinghistory(String name, String card, long tel, int rmno, String type, String newtime,
			String shijian) {
		biz = new Biz();
	    boolean flag = false;
		flag = biz.addTuiDinghistory(name,card,tel,rmno,type,newtime,shijian);
		return flag ;
		
	}

	//普通用户退订房间
	public boolean clienttuiding(String card) {
		biz = new Biz();
		boolean flag = false;
		flag = biz.clienttuiding(card);
		return flag;
	}

	//vip直接入住
	public boolean vipRuZhu(int vno, String vname, int rmno) {
		biz = new Biz();
		boolean flag = false;
		flag = biz.vipRuZhu(vno,vname,rmno);
		return flag;
	}

	//更新入住房间信息
	public boolean updateroomruzhu(int rmno) {
		daoemp = new Daoemp();
		boolean flag = daoemp.updateroomruzhu(rmno);
	    return flag;
	}
	//普通用户直接入住
	public boolean putongRuZhu(String putongname, String card, long tel,double ding, int rmno) {
		biz = new Biz();
		boolean flag = false;
		flag = biz.putongRuZhu(putongname,card,tel,ding,rmno);
		return flag;
	}

	//结账时通过房间号查询散客
	public Client queryclient(int rmno) {
		biz = new Biz();
		Client c = new Client();
		c = biz.queryclient(rmno);
		return c ;
	}
	//结账时通过房间号查询vip
	public Vip queryvip(int rmno) {
		biz = new Biz();
	     Vip v = new Vip();
		v = biz.queryvip(rmno);
		return v ;
	}

	//查询房间的价格
	public Room roomprice(int rmno) {
		biz = new Biz();
	    Room r = new Room();
		r = biz.roomprice(rmno);
		return r ;
	}

	//增加历史记录
	public boolean addhistory(String cnamne, String ccard, long rtel,
			int rmno,String type, String cdate, String newtime, int allfee, String shijian) {
		biz = new Biz();
	    boolean flag = false;
		flag = biz.addhistoryjiezhang(cnamne,ccard,rtel,rmno,type,cdate,newtime,allfee,shijian);
		return flag ;
	}
	//增加预定的历史记录
	public boolean addYuDinghistory(String vname, String vcard, long tel, int rmno, String rmtype, String newtime,
			String shijian) {
		biz = new Biz();
	    boolean flag = false;
		flag = biz.addYuDinghistory(vname,vcard,tel,rmno,rmtype,newtime,shijian);
		return flag ;
	}

	//增加入住的历史记录
	public boolean addRuZhuhistory(String name, String card, long tel, int rmno, String type, String newtime,
			String shijian) {
		biz = new Biz();
	    boolean flag = false;
		return flag = biz.addRuZhuhistory(name,card,tel,rmno,type,newtime,shijian);
	}
	
	

	//退房后删除普通用户
	public boolean deleteclient(String ccard, int rmno) {
		biz = new Biz();
		boolean flag = false;
		flag = biz.deleteclient(ccard,rmno);
		return flag;
	}

	//退房后修改房间的状态
	public boolean updatetuifangroom(int rmno) {
		biz = new Biz();
		boolean flag = false;
		flag = biz.updatetuifangroom(rmno);
		return flag;
	}

	//退房后更新vip用户
	public boolean updatevip(String vcard, int rmno) {
		biz = new Biz();
		boolean flag = false;
		flag = biz.updatevip(vcard,rmno);
		return flag;
	}

	//根据房间号查找记录
	public List<History> queryjilu(int rmno) {
		List<History> list = new ArrayList<History>();
		biz = new Biz();
		list = biz.queryjilu(rmno);
		return list;
	}

	//查询所有的房间记录
	public List<History> queryalljilu() {
		List<History> list = new ArrayList<History>();
		biz = new Biz();
		list = biz.queryalljilu();
		return list;
	}

	//查询所有的房间记录通过房间类型
	public List<History> queryjilubytype(String type) {
		List<History> list = new ArrayList<History>();
		biz = new Biz();
		list = biz.queryjilubytype(type);
		return list;
	}

	//vip点餐之后更新vip表
	public boolean updatevipvfee(int rmno, double vprice) {
		biz = new Biz();
		boolean flag = false;
		flag = biz.updatevipvfee(rmno,vprice);
		return flag;
	}

	//普通客户点餐之后更新表
	public boolean updateclientcfee(int rmno, double price) {
		biz = new Biz();
		boolean flag = false;
		flag = biz.updateclientcfee(rmno,price);
		return flag;
	}

	//插叙单个会员
	public Vip queryvip(String sfz) {
		daoemp = new Daoemp();
		Vip v = new Vip();
		v = daoemp.queryvip(sfz);
		return v;
	}

	//更新vip信息
	public boolean updateVip(int vno, String newname, String vcard, Long tel, String name) {
		daoemp = new Daoemp();
		boolean flag = false;
		flag = daoemp.queryVip(vno,newname,vcard,tel,name);
		return flag;
	}

	//删除会员
	public boolean deletevip(String name, int vno) {
		daoemp = new Daoemp();
		boolean flag = false;
		flag = daoemp.deletevip(name,vno);
		return flag;
	}

	public boolean addvip(String vname, int vno, long tel, String card) {
		daoemp = new Daoemp();
		boolean flag = false;
		flag = daoemp.addvip(vname,vno,tel,card);
		return flag;
	}

	

	


	


	//查询员工通过姓名
//	public Emp queryempbyname(String namevalue) {
//		daoemp = new Daoemp();
//		Emp emp = new Emp();
//		emp = daoemp.queryempbyname(namevalue);
//		return emp;
//	}

	
}	
	
	
	
	
//    public Emp queryemp(String name){
//    	Emp emp = biz.queryemp(name);
//    	if(emp!=null){
//    		return emp;
//    	}else {
//			System.out.println("您输入的姓名不存在");
//			return null;
//		}
//    }
	
//	
//	//删除会员
//	public void deletevip(int no) {
//		boolean flag = false;
//		flag = biz.deletevip(no);
//		if (flag) {
//			System.out.println("删除成功");
//		}
//	}
//	public void insertvip(int no, String name, long tel, String card) {
//		Vip v = new Vip();
//		boolean flag = false;
//		    flag = biz.insertvip(no,name,tel,card);
//			if (flag) {
//				System.out.println("增加成功");
//			}else{
//				System.out.println("增加失败");
//			}
//		}
//	
//	//普通客户入住
//	public boolean cnruzhu() {
//		dao = new Daoemp();
//		boolean flag = false;
//		System.out.println("请输入客户的名字");
//		String name = sc.next();
//		System.out.println("请输入客户的身份证号");
//        String card = sc.next();
//        System.out.println("请输入客户的联系电话");
//		long tel = sc.nextLong();
//		System.out.println("请输入客户要入住的房间");
//		int no = sc.nextInt();
//		System.out.println("请您预付100元押金");
//		double yajing = sc.nextDouble();
//	     flag = dao.cnruzhu(name,card,tel,no,yajing);
//		if (flag) {
//			updateroom(no);
//		}
//		return flag;
//	}
//	

//		System.out.println("请输入要查询的vip姓名");
//		String name = sc.next();
//		System.out.println("请输入要查询的vip编号");
//		int vno = sc.nextInt();

