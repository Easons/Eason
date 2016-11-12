package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.sql.DATE;

import entity.Emp;
import entity.Manager;
import entity.Menus;
import entity.Room;
import entity.Vip;

import Util.util;

public class Dao{
		//查询管理员
	    Manager manager;
	    Emp emp;
	    
		public Manager querymanager(String username ){
			try {
				Connection conn = util.getConnection();
				String sql = "select * from manager where mname=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, username);
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					manager = new Manager();
					manager.setMid(rs.getInt("mid"));
					manager.setMname(rs.getString("mname"));
					manager.setMpassword(rs.getString("mpassword"));
				}
				util.closeConnection(ps,conn, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return manager;	
		}
		//增加管理员
		
		
        //查询所有管理员		
		public List<Emp> queryallemp() {
			List<Emp> list = new ArrayList<Emp>();
			try {
				Connection conn = util.getConnection();
				String sql = "select * from emp order by empno asc";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					Emp e = new Emp();
					e.setAge(rs.getInt("age"));
					e.setEmpno(rs.getInt("empno"));
					e.setEname(rs.getString("ename"));
					e.setEpassword(rs.getString("epassword"));
					e.setSal(rs.getDouble("sal"));
					e.setEsex(rs.getString("esex"));
					list.add(e);
				}
				//关闭连接
				util.closeConnection(ps, conn, rs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}		//查询员工
		public List<Emp> queryallemp(String ename){
			List<Emp> list = new ArrayList<Emp>();
			try {
				Connection conn = util.getConnection();
				String sql = "select * from emp where ename = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1,ename);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					Emp e = new Emp();
					e.setAge(rs.getInt("age"));
					e.setEmpno(rs.getInt("empno"));
					e.setEname(rs.getString("ename"));
					e.setEsex(rs.getString("esex"));
					e.setEpassword(rs.getString("epassword"));
					e.setSal(rs.getDouble("sal"));
					list.add(e);
				}
				//关闭连接
				util.closeConnection(ps, conn, rs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}
		
		//查询员工通过员工的编号
		public List<Emp> queryempempno(int empno) {
			List<Emp> list = new ArrayList<Emp>();
			try {
				Connection conn = util.getConnection();
				String sql = "select * from emp where empno = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1,empno);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					Emp e = new Emp();
					e.setAge(rs.getInt("age"));
					e.setEmpno(rs.getInt("empno"));
					e.setEname(rs.getString("ename"));
					e.setEsex(rs.getString("esex"));
					e.setEpassword(rs.getString("epassword"));
					e.setSal(rs.getDouble("sal"));
					list.add(e);
				}
				//关闭连接
				util.closeConnection(ps, conn, rs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}
		
		public Emp queryempbyempno(int empno) {
			Emp e = new Emp();
			try {
				Connection conn = util.getConnection();
				String sql = "select * from emp where empno=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1,empno);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					e.setAge(rs.getInt("age"));
					e.setEmpno(rs.getInt("empno"));
					e.setEname(rs.getString("ename"));
					e.setEsex(rs.getString("esex"));
					e.setEpassword(rs.getString("epassword"));
					e.setSal(rs.getDouble("sal"));
				}
				//关闭连接
				util.closeConnection(ps, conn, rs);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return e;
		}
		
		
		public Emp queryemp(String ename) {
			Emp e = new Emp();
			try {
				Connection conn = util.getConnection();
				String sql = "select * from emp where ename = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1,ename);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()){
					e.setAge(rs.getInt("age"));
					e.setEmpno(rs.getInt("empno"));
					e.setEname(rs.getString("ename"));
					e.setEpassword(rs.getString("epassword"));
					e.setSal(rs.getDouble("sal"));
				}
				//关闭连接
				util.closeConnection(ps, conn, rs);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return e;
		}
		
		
		//增加员工
		public boolean plusemp(String name,int age,double sal,String sex) {
				try {
					Connection conn = util.getConnection();
					String sql = "insert into emp values(emp_seq.nextval,666666,?,?,?,?)";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1,name);
					ps.setString(2,sex);
					ps.setInt(3, age);
					ps.setDouble(4, sal);
					int i = ps.executeUpdate();
					if(i==1){
					   return true;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
				return false;
				
		}
		//删除员工
		public boolean deleteemp(int empno,String name) {
			try {
				Connection conn = util.getConnection();
				String sql = "delete from emp where empno=? and ename=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1,empno);
				ps.setString(2,name);
				int i = ps.executeUpdate();
				if(i==1){
				   conn.setAutoCommit(true);
				   return true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			return false;
		}
		
		//修改员工信息
		public boolean updateemp(int empno,String name,int age,double sal,String sex) {
			boolean flag = false;
			try{
			Connection conn = util.getConnection();
			String sql = "update emp set sal=?,ename=?,age=?,esex=? where empno=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, sal);
			ps.setString(2, name);
			ps.setInt(3,age);
			ps.setString(4,sex);
			ps.setInt(5,empno);
			int n=ps.executeUpdate();
			if(n>=1){
				 flag=true;
			}
			util.closeConnection(ps, conn, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
		}
//	    //查询所有菜单
//		public List<Menus> querymenus() {
//			List<Menus> list = new ArrayList<Menus>();
//			try {
//				Connection conn = util.getConnection();
//				String sql = "select * from menus";
//				PreparedStatement ps = conn.prepareStatement(sql);
//				ResultSet rs = ps.executeQuery();
//				while(rs.next()){
//					Menus m = new Menus();
//					m.setMid(rs.getInt("mid"));
//					m.setMname(rs.getString("mname"));
//					m.setMfee(rs.getDouble("mfee"));
//					m.setMvfee(rs.getDouble("mvfee"));
//					list.add(m);
//				}
//				//关闭连接
//				util.closeConnection(ps, conn, rs);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return list;
//
//		}		
		//删除菜单
		public boolean deletemenus(String mname) {
			try {
				Connection conn = util.getConnection();
				String sql = "delete from menus where mname=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1,mname);
				int i = ps.executeUpdate();
				if(i==1){
					return true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		//增加菜单
		public boolean insertmenus(String mname, double mfee, double mvfee) {
			try {
				Connection conn = util.getConnection();
				String sql = "insert into menus values(menus_seq.nextval,?,?,?)";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1,mname);
				ps.setDouble(2,mfee);
				ps.setDouble(3,mvfee);
				int i = ps.executeUpdate();
				if(i>=1){
				   return true;
				}
				util.closeConnection(ps,conn, null);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			return false;
		}
		//修改菜名
		public boolean xiucainame(String oldname,String newname) {
			boolean flag = false;
			try{
			Connection conn = util.getConnection();
			String sql = "update menus set mname=? where mname=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newname);
			ps.setString(2, oldname);
			int n=ps.executeUpdate();
			if(n>=1){
				 flag=true;
			}
			util.closeConnection(ps, conn, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
			
		}
		//修改菜价
		public boolean xiucaifee(String oldname, double fee) {
			boolean flag = false;
			try{
			Connection conn = util.getConnection();
			String sql = "update menus set mfee=? where mname=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, fee);
			ps.setString(2, oldname);
			int n=ps.executeUpdate();
			if(n>=1){
				 flag=true;
			}
			util.closeConnection(ps, conn, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
		}
		public boolean xiucaivfee(String oldname, double vfee) {
			boolean flag = false;
			try{
			Connection conn = util.getConnection();
			String sql = "update menus set mvfee=? where mname=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, vfee);
			ps.setString(2, oldname);
			int n=ps.executeUpdate();
			if(n>=1){
				 flag=true;
			}
			util.closeConnection(ps, conn, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
		}
		//查找所有房间
		public List<Room> queryroom() {
			List<Room> list = new ArrayList<Room>();
			try {
				Connection conn = util.getConnection();
				String sql = "select * from Room order by rmno asc";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					Room r = new Room();
					r.setRmno(rs.getInt("rmno"));
					r.setRmprice(rs.getDouble("rmprice"));
					r.setRmtype(rs.getString("rmtype"));
					r.setVprice(rs.getDouble("vprice"));
					r.setRmbuff(rs.getString("rmbuff"));
					r.setRmbook(rs.getString("rmbook"));
					r.setRydate(rs.getString("rydate"));
					list.add(r);
				}
				//关闭连接
				util.closeConnection(ps, conn, rs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}
		//查询所有空房间
		public List<Room> queryroombuff() {
			List<Room> list = new ArrayList<Room>();
			try {
				Connection conn = util.getConnection();
				String sql = "select * from Room where rmbuff='无人' and rmbook='无人预订' order by rmno asc";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					Room r = new Room();
					r.setRmno(rs.getInt("rmno"));
					r.setRmprice(rs.getDouble("rmprice"));
					r.setRmtype(rs.getString("rmtype"));
					r.setVprice(rs.getDouble("vprice"));
					r.setRmbuff(rs.getString("rmbuff"));
					r.setRmbook(rs.getString("rmbook"));
					r.setRydate(rs.getString("rydate"));
					list.add(r);
				}
				//关闭连接
				util.closeConnection(ps, conn, rs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}
		//查询单个房间
		public Room queryrmno(int no) {
			Room room = null;	
			try {
					Connection conn = util.getConnection();
					String sql = "select * from room where rmno=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setInt(1, no);
					ResultSet rs = ps.executeQuery();
					if(rs.next()){
						room = new Room();
						room.setRmno(no);
						room.setRmprice(rs.getDouble("rmprice"));
					    room.setRmtype(rs.getString("rmtype"));
					    room.setRydate(rs.getString("rydate"));
					    room.setVprice(rs.getDouble("vprice"));
					    room.setRmbook(rs.getString("rmbook"));
					    room.setRmbuff(rs.getString("rmbuff"));
					}
					util.closeConnection(ps,conn, rs);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return room;	
		}
		//根据房间类型查房间
      public List<Room> queryroombytype(String name) {
    	  List<Room> list = new ArrayList<Room>();
			try {
				Connection conn = util.getConnection();
				String sql = "select * from Room where rmtype=? and rmbuff='无人' and rmbook='无人预订'  order by rmno asc";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1,name);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					Room r = new Room();
					r.setRmno(rs.getInt("rmno"));
					r.setRmprice(rs.getDouble("rmprice"));
					r.setRmtype(rs.getString("rmtype"));
					r.setVprice(rs.getDouble("vprice"));
					r.setRmbuff(rs.getString("rmbuff"));
					r.setRmbook(rs.getString("rmbook"));
					r.setRydate(rs.getString("rydate"));
					list.add(r);
				}
				//关闭连接
				util.closeConnection(ps, conn, rs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
 }
		//删除房间
		public boolean deleteroom(int rmno) {
			try {
				Connection conn = util.getConnection();
				String sql = "delete from room where rmno=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1,rmno);
				int i = ps.executeUpdate();
				if(i==1){
				   return true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			return false;
		}
		//增加房间
		public boolean addroom(String rmtype, double rmprice,
				double vprice) {
			boolean flag = false;
			try {
				Connection conn = util.getConnection();
				String sql =" insert into room values(room_seq.nextval,?,?,?,'无人','无人预订','空')";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1,rmtype);
				ps.setDouble(2,rmprice);
				ps.setDouble(3,vprice);
	
				int i = ps.executeUpdate();
				if(i>=1){
				   flag =  true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			return flag;
		}
		
		//修改房间信息
		public boolean updateroom(int rmno,String type,double price,double vprice) {
			boolean flag = false;
			try{
			Connection conn = util.getConnection();
			String sql = "update room set rmtype=?,rmprice=?,vprice=? where rmno=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,type);
			ps.setDouble(2,price);
			ps.setDouble(3,vprice);
			ps.setInt(4,rmno);
			
			int n=ps.executeUpdate();
			
			if(n>=1){
				 flag=true;
			}
			util.closeConnection(ps, conn, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//查询vip表
		public List<Vip> queryvip() {
			List<Vip> list = new ArrayList<Vip>();
			try {
				Connection conn = util.getConnection();
				String sql = "select * from vip order by vno asc";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					Vip v = new Vip();
					v.setId(rs.getInt("id"));
					v.setRmno(rs.getInt("rmno"));
					v.setTel(rs.getLong("tel"));
					v.setVcard(rs.getString("vcard"));
					v.setVdate(rs.getString("vdate"));
					v.setVfee(rs.getDouble("vfee"));
					v.setVname(rs.getString("vname"));
					v.setVno(rs.getInt("vno"));
					list.add(v);
				}
				//关闭连接
				util.closeConnection(ps, conn, rs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}

		public boolean deletevip(int no) {
			try {
				Connection conn = util.getConnection();
				String sql = "delete from vip where vno=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1,no);
				int i = ps.executeUpdate();
				if(i==1){
				   //conn.setAutoCommit(true);
				   return true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			return false;
		}
		public boolean insertvip(int no, String name, long tel, String card) {
			boolean flag = false;
			try {
				Connection conn = util.getConnection();
				String sql =" insert into vip(id,vno,vname,vcard,rmno,tel) values(vip_seq.nextval,?,?,?,null,?)";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1,no);
				ps.setString(2,name);
				ps.setString(3,card);
				ps.setLong(4,tel);
	            int i = ps.executeUpdate();
				if(i>=1){
				   flag =  true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			return flag;
		}
		public boolean xiugaivno(int no, int newno) {
			boolean flag = false;
			try{
			Connection conn = util.getConnection();
			String sql = "update vip set vno=? where vno=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,newno);
			ps.setInt(2,no);
			int n=ps.executeUpdate();
			if(n>=1){
				 flag=true;
			}
			util.closeConnection(ps, conn, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
		}
		public boolean xiugaivname(int no, String newname) {
			boolean flag = false;
			try{
			Connection conn = util.getConnection();
			String sql = "update vip set vname=? where vno=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,newname);
			ps.setInt(2,no);
			int n=ps.executeUpdate();
			if(n>=1){
				 flag=true;
			}
			util.closeConnection(ps, conn, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
		}
		public boolean xiugaivtel(int no, long newtel) {
			boolean flag = false;
			try{
			Connection conn = util.getConnection();
			String sql = "update vip set tel=? where vno=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1,newtel);
			ps.setInt(2,no);
			int n=ps.executeUpdate();
			if(n>=1){
				 flag=true;
			}
			util.closeConnection(ps, conn, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
		}
		public boolean xiugaivcard(int no, String newcard) {
			boolean flag = false;
			try{
			Connection conn = util.getConnection();
			String sql = "update vip set vcard=? where vno=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,newcard);
			ps.setInt(2,no);
			int n=ps.executeUpdate();
			if(n>=1){
				 flag=true;
			}
			util.closeConnection(ps, conn, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
		}



		public boolean addmanager(String name, String password) {
			boolean flag = false;
			try {
				Connection conn = util.getConnection();
				String sql =" insert into manager values(manager_seq.nextval,?,?)";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1,name);
				ps.setString(2,password);
	            int i = ps.executeUpdate();
				if(i>=1){
				   flag =  true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			return flag;
		}
        //修改管理员密码
		public boolean managerpassword(String name, String oldpass,
				String newpass) {
			boolean flag = false;
			try{
			Connection conn = util.getConnection();
			String sql = "update manager set mpassword=? where mname=? and mpassword=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,newpass);
			ps.setString(2,name);
			ps.setString(3,oldpass);
			int n=ps.executeUpdate();
			if(n>=1){
				 flag=true;
			}
			util.closeConnection(ps, conn, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
		}


		//员工忘密码的找回
		public boolean updateemppass(int empno, String newpass) {
			boolean flag = false;
			try{
			Connection conn = util.getConnection();
			String sql = "update emp set epassword=? where empno=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,newpass);
			ps.setInt(2,empno);
			int n=ps.executeUpdate();
			if(n>=1){
				 flag=true;
			}
			util.closeConnection(ps, conn, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
		}


		//管理员密码找回
		public boolean updatemanagerpass(String name, String newpass) {
			boolean flag = false;
			try{
			Connection conn = util.getConnection();
			String sql = "update manager set mpassword=? where mname=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,newpass);
			ps.setString(2,name);
			int n=ps.executeUpdate();
			if(n>=1){
				 flag=true;
			}
			util.closeConnection(ps, conn, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
		}


		
		




		


		


		





		
		
//		public static void main(String[] args) {
//			Dao dao = new Dao();
////			int no = 104;
////			String name = "eason";
////			long tel = 13100216873l;
////			String card = "431202131346794613";
////			boolean flag =  dao.insertvip(no,name,tel, card);
////			System.out.println(flag);
//		    List<Emp> list = new ArrayList<Emp>();
//			list = dao.queryallemp();	
//		    System.out.println(list.size());
//		}
		
		
	}		
    
		