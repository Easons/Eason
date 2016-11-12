package biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

public class Biz {
   //private static final String String = null;
   Menus m = null;
   Room r = null;
   static Dao dao = new Dao();
   Daoemp daoemp ;
   private Manager manager;
    Emp emp;
    static Scanner sc = new Scanner(System.in);
  	   
   //查询员工
     public Emp queryempbyempno(int empno){
    	 dao = new Dao();
    	Emp emp = dao.queryempbyempno(empno);

			return emp;
		
    	 
     }
   //增加员工
   public boolean plusemp(String name, int age,double sal,String sex) {
	   boolean flag = dao.plusemp(name,age,sal,sex); 
	   return flag;
}
   //修改员工信息
   public boolean updateemp(int empno, String name, int age, double sal,String sex) {
	   dao = new Dao();
	   boolean flag = dao.updateemp(empno, name, age, sal,sex);
	   return flag;
   }
//   //删除员工
//   public boolean deleteemp(int empno, String name) {
//	 emp = dao.queryemp(name);
//	 if(emp.getEname()!=null){
//       boolean flag = dao.deleteemp(empno,name);
//     return flag;
//     }else{
//	 System.out.println("无员工匹配");
//	 return false;
//  }
//}
   
   //查询所有房间
	public List<Room> queryroom() {
		List<Room> list = dao.queryroom();
		return list;
	}
	//根据房间类型来查
	public List<Room> queryroombytype(String name) {
	    dao = new Dao();
	    List<Room>  list = dao.queryroombytype(name);
		return list;
	}
	//查询空房间
	public List<Room> queryroombuff() {
		dao = new Dao();
	    List<Room>  list = dao.queryroombuff();
		return list;
	}
   
	//管理员修改房间信息
	public boolean updateroom(int rmno, String type, double price, double vprice) {
		dao = new Dao();
		boolean flag = false;
		flag = dao.updateroom(rmno, type, price, vprice);
		return flag;
	}
	//查询单个房间
	public Room queryrmno(int no) {
		dao = new Dao();
		 r = new Room();
		r = dao.queryrmno(no);
		return r;
	}
   //增加房间
	public boolean addroom(String rmtype, double rmprice, double vprice) {
		boolean flag = dao.addroom(rmtype,rmprice,vprice);
		return flag;
		
	}
	//vip预定房间
	public boolean vipyuding(int vno, String vname, int rmno) {
		boolean flag = false;
		daoemp = new Daoemp();
		flag = daoemp.vipyuding(vno,vname,rmno);
		return flag;
	}
	//查询单个vip
	public Vip querybyic(int no,String vname) {
		daoemp = new Daoemp();
		Vip v = new Vip();
		v = daoemp.queryvipid(no,vname);
		return v;
	}
    //查所有菜
    public List<Menus> querymenus() {
    	daoemp = new Daoemp();
	  List<Menus> list = daoemp.querymenus();
	return list;
}
     //查单个菜
	public List<Menus> menusname(String name) {
	   daoemp = new Daoemp();
	   List<Menus> list = daoemp.menusname(name);
	   return list;
	   
	}
	
	//查单个菜的对象
	public Menus querymenus1(String name) {
	     daoemp = new Daoemp();
	     Menus m = new Menus();
	     m = daoemp.querymenus(name);
		return m;
	}
	//更新菜单
     public boolean updatemenus(String mname, double price, double vprice, int id) {
		daoemp = new Daoemp();
		boolean flag = daoemp.updatemenus(mname, price, vprice, id);
		return flag;
	}
    
    //删除菜单
    public boolean deletemenus(String mname) {
    	boolean flag = dao.deletemenus(mname);
    	return flag;
    }
 
	//新增菜
	public boolean insertmenus(String mname, double mfee, double mvfee) {
		boolean flag = dao.insertmenus(mname,mfee,mvfee);
		return flag;
	}
	
	
	//删除房间
	public boolean deleteroom(int rmno) {
		boolean flag = false;
	    flag = dao.deleteroom(rmno);
        return flag;
	}

	//查询vip表
	public List<Vip> queryvip() {
		List<Vip> list = dao.queryvip();
		return list;
	}
	//删除会员
	public boolean deletevip(int no) {
		boolean flag = dao.deletevip(no);
		return flag;
	}
    //增加会员
	public boolean insertvip(int no, String name, long tel, String card) {
		boolean flag = false;
		flag = dao.insertvip(no,name,tel,card);
		return flag;
	}
	public void xiugaivip(int no, int newno) {
	    boolean flag = false;
	    flag = dao.xiugaivno(no,newno);
		if (flag) {
			System.out.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
	}
	public void xiugaivip(int no, String newname) {
		boolean flag = false;
		flag = dao.xiugaivname(no,newname);
		if (flag) {
			System.out.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
		
	}
	
	public void xiugaivip(int no, long newtel) {
		boolean flag = dao.xiugaivtel(no,newtel);
		if (flag) {
			System.out.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
	}
	public void xiugaivcard(int no, String newcard) {
		boolean flag = false;
		flag = dao.xiugaivcard(no,newcard);
		if (flag) {
			System.out.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
		
	}
	//修改员工密码
	public boolean emppass(String username, String oldpass, String newpass) {
		boolean flag = false;
		daoemp = new Daoemp();
		flag = daoemp.emppass(username,oldpass,newpass);
		return flag;
	}
	//vip入住查询
	public YuDingxinxi vipruzhuchaxun(String card) {
		YuDingxinxi y = new YuDingxinxi();
		daoemp = new Daoemp();
		y = daoemp.vipruzhuchaxun(card);
		return y;
	}
	//普通用户入住查询
	public YuDingxinxi putongruzhuchaxun(String card) {
		YuDingxinxi y = new YuDingxinxi();
		daoemp = new Daoemp();
		y = daoemp.putongruzhuchaxun(card);
		return y;
	}
	//vip确认入住
	public boolean vipruzhu(String vcard,String newtime) {
		daoemp = new Daoemp();
		boolean flag = daoemp.vipruzhu(vcard,newtime);
		return flag;
	}
	//修改入住房间信息
	public boolean updateruzhuroom(int rmno) {
		daoemp = new Daoemp();
		boolean flag = daoemp.updateruzhuroom(rmno);
		return flag;
	}
	//普通用户（预订）入住
	public boolean clientruzhu(String ccard) {
		daoemp = new Daoemp();
		boolean flag = daoemp.clientruzhu(ccard);
		return flag;
	}
	//vip退订房间
	public boolean viptuiding(String card) {
		daoemp = new Daoemp();
		boolean flag = daoemp.viptuiding(card);
		return flag;
	}
	//退订房间
	public boolean tuidingroom(int rmno) {
		daoemp = new Daoemp();
		boolean flag = daoemp.tuidingroom(rmno);
		return flag;
	}
	//普通用户退订房间
	public boolean clienttuiding(String card) {
		daoemp = new Daoemp();
		boolean flag = daoemp.clienttuiding(card);
		return flag;
	}
	//vip入住
	public boolean vipRuZhu(int vno, String vname, int rmno) {
		daoemp = new Daoemp();
		boolean flag = daoemp.vipRuZhu(vno,vname,rmno);
		return flag;
	}
	//普通入住
	public boolean putongRuZhu(String putongname, String card, long tel,
			double ding, int rmno) {
		daoemp = new Daoemp();
		boolean flag = daoemp.putongRuZhu(putongname,card,tel,ding,rmno);
		return flag;
	}
	//结账时普通客户查询(通过房间号)
	public Client queryclient(int rmno) {
		daoemp = new Daoemp();
		Client c = new Client();
		c = daoemp.queryclient(rmno);
		return c;
	}
	//结账时vip客户查询
	public Vip queryvip(int rmno) {
		daoemp = new Daoemp();
		 Vip v = new Vip();
		v = daoemp.queryvip(rmno);
		return v;
	}
	//查询房间价格
	public Room roomprice(int rmno) {
		daoemp = new Daoemp();
		 Room r = new Room();
		r = daoemp.roomprice(rmno);
		return r;
	}
	//结账后添加记录
	public boolean addhistoryjiezhang(String cnamne, String ccard, long rtel,int rmno,String type
			,String cdate, String newtime, int allfee, String shijian) {
		daoemp = new Daoemp();
		boolean flag =  daoemp.addhistoryjiezhang(cnamne,ccard,rtel,rmno,type,cdate,newtime,allfee,shijian);
		return flag;
	}
	//结账后删除客户
	public boolean deleteclient(String ccard, int rmno) {
		daoemp = new Daoemp();
		boolean flag = daoemp.deleteclient(ccard,rmno);
		return flag;
	}
	//退房后修改房间状态
	public boolean updatetuifangroom(int rmno) {
		daoemp = new Daoemp();
		boolean flag = daoemp.updatetuifangroom(rmno);
		return flag;
	}
	//退房后更新vip用户
	public boolean updatevip(String vcard,int rmno) {
		daoemp = new Daoemp();
		boolean flag = daoemp.updatevip(vcard,rmno);
		return flag;
	}
	//根据房间号查询房间记录
	public List<History> queryjilu(int rmno) {
		List<History> list = new ArrayList<History>();
		daoemp = new Daoemp();
		list = daoemp.queryjilu(rmno);
		return list;
		
	}
	public List<History> queryalljilu() {
		List<History> list = new ArrayList<History>();
		daoemp = new Daoemp();
		list = daoemp.queryalljilu();
		return list;
	}
	//根据房间类型查询房间记录
	public List<History> queryjilubytype(String type) {
		List<History> list = new ArrayList<History>();
		daoemp = new Daoemp();
		list = daoemp.queryjilubytype(type);
		return list;
	}
	//vip客户点餐之后更新表
	public boolean updatevipvfee(int rmno, double vprice) {
		daoemp = new Daoemp();
		boolean flag = daoemp.updatevipvfee(rmno,vprice);
		return flag;
	}
	//普通用户点餐后更新表
	public boolean updateclientcfee(int rmno, double price) {
		daoemp = new Daoemp();
		boolean flag = daoemp.updateclientcfee(rmno,price);
		return flag;
	}
	//增加预定后的房间记录
	public boolean addYuDinghistory(String vname, String vcard, long tel, int rmno, String rmtype, String newtime,
			String shijian) {
		daoemp = new Daoemp();
		boolean flag = daoemp.addYuDinghistory(vname,vcard,tel,rmno,rmtype,newtime,shijian);
		return flag;
	}
	//客户退订后增加退房记录
	public boolean addTuiDinghistory(String name, String card, long tel, int rmno, String type, String newtime,
			String shijian) {
		daoemp = new Daoemp();
		boolean flag = daoemp.addTuiDinghistory(name,card,tel,rmno,type,newtime,shijian);
		return flag;
	}
	//客户入住后的记录
	public boolean addRuZhuhistory(String name, String card, long tel, int rmno, String type, String newtime,
			String shijian) {
		daoemp = new Daoemp();
		boolean flag = daoemp.addRuZhuhistory(name,card,tel,rmno,type,newtime,shijian);
		return flag;
	}
	
	
}

