package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import entity.Client;
import entity.Emp;
import entity.History;
import entity.Menus;
import entity.Room;
import entity.Vip;
import entity.YuDingxinxi;

import Util.util;

public class Daoemp {
	
    //修改员工密码
	
	public boolean emppass(String username, String oldpass, String newpass) {
		boolean flag = false;
		try{
		Connection conn = util.getConnection();
		String sql = "update emp set epassword=?  where ename=? and epassword=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,newpass);
		ps.setString(2,username);
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

	  //vip预定房间
	  public boolean vipyuding(int vno, String vname, int rmno) {
		  boolean flag = false;
			try{
			Connection conn = util.getConnection();
			String sql = "update vip set rmno=?  where vname=? and vno=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,rmno);
			ps.setString(2,vname);
			ps.setInt(3,vno);
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
	
	  //查询单个vip
		public Vip queryvipid(int no,String name) {
			Vip v = new Vip();
			try {
				Connection conn = util.getConnection();
				String sql = "select * from vip where vno = ?  and vname=? ";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1,no);
				ps.setString(2,name);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					v.setId(rs.getInt("id"));
					v.setRmno(rs.getInt("rmno"));
					v.setTel(rs.getLong("tel"));
					v.setVcard(rs.getString("vcard"));
					v.setVdate(rs.getString("vdate"));
					v.setVfee(rs.getDouble("vfee"));
					v.setVname(rs.getString("vname"));
					v.setVno(rs.getInt("vno"));
				}
				//关闭连接
				util.closeConnection(ps, conn, rs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return v;
		}
	
	//通过房间类型查询房间
	public List<Room> queryallroom(String type) {
		List<Room> list = new ArrayList<Room>();
		try {
			Connection conn = util.getConnection();
			String sql = "select * from room where rmtype=? and rmbuff='无人' and rmbook='无人预订' order by rmno asc ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, type);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Room r = new Room();
				r.setRmbook(rs.getString("rmbook"));
				r.setRmbuff(rs.getString("rmbuff"));
				r.setRmno(rs.getInt("rmno"));
				r.setRmprice(rs.getDouble("rmprice"));
				r.setRmtype(type);
				r.setRydate(rs.getString("rydate"));
				r.setVprice(rs.getDouble("vprice"));
				list.add(r);
			}
			util.closeConnection(ps,conn, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	//查询单个房间的种类
		public Room queryroomtype(int rmno) {
			Room r = new  Room();
			try {
				Connection conn = util.getConnection();
				String sql = "select * from room where rmno=? ";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, rmno);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					r.setRmbook(rs.getString("rmbook"));
					r.setRmbuff(rs.getString("rmbuff"));
					r.setRmno(rs.getInt("rmno"));
					r.setRmprice(rs.getDouble("rmprice"));
					r.setRmtype(rs.getString("rmtype"));
					r.setRydate(rs.getString("rydate"));
					r.setVprice(rs.getDouble("vprice"));
				}
				util.closeConnection(ps,conn, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return r;
		}
	
	
    //会员入住
	public boolean vipruzhu(int no,int rmno) {
		boolean flag = false;
		try{
		Connection conn = util.getConnection();
		String sql = "update vip set rmno=?,vedate = to_char(sysdate,'yyyy-mm-dd HH24:MM:ss') where vno=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,rmno);
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
	
    //更新房间状态
	public boolean updatebuff(int no,String date) {
		boolean flag = false;
		try{
		Connection conn = util.getConnection();
		String sql = "update room set rmbook='已预订',rydate = ?  where rmno=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,date);
		ps.setInt(2,no);
		int n=ps.executeUpdate();
		if(n>=1){
			flag = true;
		}
		util.closeConnection(ps, conn, null);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return flag;
	}
	//普通用户预定
	public boolean putongyuding(int rmno,String putongname, long tel, String card,
			double ding) {
		boolean flag = false;
		try {
			Connection conn = util.getConnection();
			String sql =" insert into client values(client_seq.nextval,?,?,?,?,?,0,'空')";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,putongname);
			ps.setString(2,card);
			ps.setLong(3,tel);
			ps.setInt(4,rmno);
			ps.setDouble(5,ding);
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
	//普通客户的单个查询
	public Client queryclient(String putongname, long tel) {
		Client client = new Client();
		try {
			Connection conn = util.getConnection();
			String sql = "select * from client where cname=? and rtel=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,putongname);
			ps.setLong(2,tel);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				client.setCnamne(rs.getString("cname"));
				client.setCcard(rs.getString("ccard"));
				client.setCdate(rs.getString("cdate"));
				client.setCding(rs.getDouble("cding"));
				client.setCid(rs.getInt("cid"));
				client.setRtel(rs.getLong("rtel"));
				client.setRmno(rs.getInt("rmno"));
				client.setCfee(rs.getDouble("cfee"));	
			}
			//关闭连接
			util.closeConnection(ps, conn, rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client;
	}
	 //查询所有菜单
	public List<Menus> querymenus() {
		List<Menus> list = new ArrayList<Menus>();
		try {
			Connection conn = util.getConnection();
			String sql = "select * from menus order by mno asc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Menus m = new Menus();
				m.setMno(rs.getInt("mno"));
				m.setMname(rs.getString("mname"));
				m.setMfee(rs.getDouble("mfee"));
				m.setMvfee(rs.getDouble("mvfee"));
				list.add(m);
			}
			//关闭连接
			util.closeConnection(ps, conn, rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}
	
	
	//查询单个菜
	public List<Menus> menusname(String name) {
		List<Menus> list = new ArrayList<Menus>();
		try {
				Connection conn = util.getConnection();
				String sql = "select * from menus where mname=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, name);
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					Menus m = new Menus();
					m.setMno(rs.getInt("mno"));
					m.setMname(rs.getString("mname"));
					m.setMfee(rs.getDouble("mfee"));
					m.setMvfee(rs.getDouble("mvfee"));
					list.add(m);
				}
				util.closeConnection(ps,conn, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;	
	}

	//查询单个菜单的对象
	public Menus querymenus(String name) {
		 Menus m = new Menus();
		
		try {
			Connection conn = util.getConnection();
			String sql = "select * from menus where mname=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				m.setMname(rs.getString("mname"));
				m.setMfee(rs.getDouble("mfee"));
				m.setMvfee(rs.getDouble("mvfee"));
			}
			util.closeConnection(ps,conn, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;	
	}
	//修改菜单
	public boolean updatemenus(String mname, double price, double vprice, int mno){
		boolean flag = false;
		try{
		Connection conn = util.getConnection();
		String sql = "update menus set mname=?,mfee=?,mvfee=?  where mno=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, mname);
		ps.setDouble(2, price);
		ps.setDouble(3, vprice);
		ps.setInt(4, mno);
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
	
	//vip入住查询
	public YuDingxinxi vipruzhuchaxun(String card) {
		YuDingxinxi y = new YuDingxinxi();
		Vip v = new Vip();
		Room r = new Room();
		try {
			Connection conn = util.getConnection();
			String sql = "select v.vname,v.vcard,r.rmno,r.rmtype,r.rydate  from vip v,room r where r.rmno=v.rmno and vcard=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,card);
//			ps.setInt(2,rmno);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
			      y.setName(rs.getString("vname"));
				  y.setCard(rs.getString("vcard"));
				  y.setRmno(rs.getInt("rmno"));
				  y.setType(rs.getString("rmtype"));
				  y.setTime(rs.getString("rydate"));
			}
			util.closeConnection(ps,conn, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return y;
	}
	 	//普通用户入住查询
	public YuDingxinxi putongruzhuchaxun(String card) {
		YuDingxinxi y = new YuDingxinxi();
		try {
			Connection conn = util.getConnection();
			String sql = "select c.cname,c.ccard,r.rmno,r.rmtype,r.rydate  from client c,room r where c.rmno=r.rmno and c.ccard=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, card);
			//ps.setInt(2,rmno);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
			      y.setName(rs.getString("cname"));
				  y.setCard(rs.getString("ccard"));
				  y.setRmno(rs.getInt("rmno"));
				  y.setType(rs.getString("rmtype"));
				  y.setTime(rs.getString("rydate"));
				  
			}
			util.closeConnection(ps,conn, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return y;
	}
	//vip确认入住
	public boolean vipruzhu(String vcard,String newtime) {
		boolean flag = false;
		try{
		Connection conn = util.getConnection();
		String sql = "update vip set vdate=?  where vcard=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, newtime);
		ps.setString(2, vcard);
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
	//普通用户预订入住
	public boolean clientruzhu(String ccard) {
		boolean flag = false;
		try{
		Connection conn = util.getConnection();
		String sql = "update client set cdate=to_char(sysdate,'yyyy-MM-dd HH24:mm:ss')  where ccard=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, ccard);
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
		//修改入住房间状态
	public boolean updateruzhuroom(int rmno) {
		boolean flag = false;
		try{
		Connection conn = util.getConnection();
		String sql = "update room set rmbuff='有人',rmbook='无人预订',rydate=null  where rmno=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,rmno);
		int n=ps.executeUpdate();
		if(n>=1){
			flag = true;
		}
		util.closeConnection(ps, conn, null);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return flag;
	
	}
	

   	//vip退订房间
	public boolean viptuiding(String card) {
		boolean flag = false;
		try{
		Connection conn = util.getConnection();
		String sql = "update vip set rmno=null  where vcard=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, card);
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

	//退订房间(改变房间状态)
	public boolean tuidingroom(int rmno) {
		boolean flag = false;
		try{
		Connection conn = util.getConnection();
		String sql = "update room set rmbook='无人预订',rydate=null  where rmno=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,rmno);
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

	//普通用户退订房间
	public boolean clienttuiding(String card) {
		boolean flag = false;
		try{
		Connection conn = util.getConnection();
		String sql = "delete from client where ccard=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, card);
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

	//vip直接入住
	public boolean vipRuZhu(int vno, String vname, int rmno) {
		boolean flag = false;
		try{
		Connection conn = util.getConnection();
		String sql = "update vip set vdate=to_char(sysdate,'yyyy-MM-dd HH24:mm:ss'),rmno=?  where vno=? and vname=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, rmno);
		ps.setInt(2,vno);
		ps.setString(3,vname);
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
	
    //更新入住房间信息
	public boolean updateroomruzhu(int rmno) {
		boolean flag = false;
		try{
		Connection conn = util.getConnection();
		String sql = "update room set rmbuff='有人'  where rmno=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,rmno);
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

	//普通用户直接入住
	public boolean putongRuZhu(String name, String card, long tel,
			double yajing, int rmno) {
		boolean flag = false;
		try {
			Connection conn = util.getConnection();
			String sql =" insert into client(cid,cname,ccard,rtel,rmno,cding,cdate) values(client_seq.nextval,?,?,?,?,?,to_char(sysdate,'yyyy-MM-dd HH24:mm:ss'))";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2,card);
			ps.setLong(3,tel);
			ps.setInt(4,rmno);
			ps.setDouble(5,yajing);
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

	//结账时查询普通客户
	public Client queryclient(int rmno) {
		Client c = new Client();
		try {
			Connection conn = util.getConnection();
			String sql = "select * from client where rmno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, rmno);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
			   c.setCcard(rs.getString("ccard"));
			   c.setCdate(rs.getString("cdate"));
			   c.setCding(rs.getDouble("cding"));
			   c.setCfee(rs.getDouble("cfee"));
			   c.setCid(rs.getInt("cid"));
			   c.setCnamne(rs.getString("cname"));
			   c.setRmno(rmno);
			   c.setRtel(rs.getLong("rtel"));	  
			}
			util.closeConnection(ps,conn, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	public Vip queryvip(int rmno) {
		Vip v = new Vip();
		try {
			Connection conn = util.getConnection();
			String sql = "select * from vip where rmno=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,rmno);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				v.setId(rs.getInt("id"));
				v.setRmno(rs.getInt("rmno"));
				v.setTel(rs.getLong("tel"));
				v.setVcard(rs.getString("vcard"));
				v.setVdate(rs.getString("vdate"));
				v.setVfee(rs.getDouble("vfee"));
				v.setVname(rs.getString("vname"));
				v.setVno(rs.getInt("vno"));
			}
			//关闭连接
			util.closeConnection(ps, conn, rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return v;
	}

	//查询房间价格
	public Room roomprice(int rmno) {
		Room r = new Room();
		try {
			Connection conn = util.getConnection();
			String sql = "select rmprice,vprice,rmtype from room where rmno=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,rmno);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				r.setRmprice(rs.getDouble("rmprice"));
				r.setVprice(rs.getDouble("vprice"));
				r.setRmtype(rs.getString("rmtype"));
			}
			//关闭连接
			util.closeConnection(ps, conn, rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

	//客户结账后添加记录
	public boolean addhistoryjiezhang(String cnamne, String ccard, long rtel,int rmno,String type,String cdate, String newtime, int allfee, String shijian) {
		boolean flag = false;
		try {
			Connection conn = util.getConnection();
			String sql =" insert into history  values(his_seq.nextval,?,?,?,?,?,'无','无',?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,cnamne);
			ps.setString(2,ccard);
			ps.setLong(3,rtel);
			ps.setInt(4,rmno);
			ps.setString(5,type);
			ps.setString(6,cdate);
			ps.setString(7,newtime);
			ps.setInt(8,allfee);
			ps.setString(9,shijian);
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
	
	//客户预定后添加记录
	public boolean addYuDinghistory(String vname, String vcard, long tel, int rmno, String rmtype, String newtime,
			String shijian) {
		boolean flag = false;
		try {
			Connection conn = util.getConnection();
			String sql =" insert into history  values(his_seq.nextval,?,?,?,?,?,?,'无','无','无',0,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,vname);
			ps.setString(2,vcard);
			ps.setLong(3,tel);
			ps.setInt(4,rmno);
			ps.setString(5,rmtype);
			ps.setString(6,newtime);
			ps.setString(7,shijian);
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

	//客户退订后增加记录
	public boolean addTuiDinghistory(String name, String card, long tel, int rmno, String type, String newtime,
			String shijian) {
		boolean flag = false;
		try {
			Connection conn = util.getConnection();
			String sql =" insert into history  values(his_seq.nextval,?,?,?,?,?,'空',?,'无','无',0,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2,card);
			ps.setLong(3,tel);
			ps.setInt(4,rmno);
			ps.setString(5,type);
			ps.setString(6,newtime);
			ps.setString(7,shijian);
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
	
	//客户入住添加记录
		public boolean addRuZhuhistory(String name, String card, long tel, int rmno, String type, String newtime,
				String shijian) {
			boolean flag = false;
			try {
				Connection conn = util.getConnection();
				String sql =" insert into history  values(his_seq.nextval,?,?,?,?,?,'空','空',?,'无',0,?)";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1,name);
				ps.setString(2,card);
				ps.setLong(3,tel);
				ps.setInt(4,rmno);
				ps.setString(5,type);
				ps.setString(6,newtime);
				ps.setString(7,shijian);
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
	
	//退房后删除普通客户
	public boolean deleteclient(String ccard, int rmno) {
		boolean flag = false;
		try{
		Connection conn = util.getConnection();
		String sql = "delete from client where ccard=? and rmno=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,ccard);
		ps.setInt(2,rmno);
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
  
	//退房后修改房间状态
	public boolean updatetuifangroom(int rmno) {
		boolean flag = false;
		try{
		Connection conn = util.getConnection();
		String sql = "update room set rmbuff='无人',rmbook='无人预订'  where rmno=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,rmno);
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
	
	
	//vip用户退房后更新信息
	public boolean updatevip(String vcard, int rmno) {
		boolean flag = false;
		try{
		Connection conn = util.getConnection();
		String sql = "update vip set rmno=null,vdate='空',vfee=0  where rmno=? and vcard=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,rmno);
		ps.setString(2,vcard);
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
	
	
	//通过房间号查询房间记录
	public List<History> queryjilu(int rmno) {
		List<History> list = new ArrayList<History>();
		try {
			Connection conn = util.getConnection();
			String sql = "select * from history where hrmno = ? order by id asc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, rmno);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				History h = new History();
				h.setId(rs.getInt("id"));
				h.setHyedate(rs.getString("hyedate"));
				h.setHydate(rs.getString("hydate"));
				h.setHtel(rs.getLong("htel"));
				h.setHshijian(rs.getString("hshijian"));
				h.setHrmno(rs.getInt("hrmno"));
				h.setHtype(rs.getString("htype"));
				h.setHname(rs.getString("hname"));
				h.setHedate(rs.getString("hedate"));
				h.setHdate(rs.getString("hdate"));
				h.setHcard(rs.getString("hcard"));
				h.setHallfee(rs.getDouble("hallfee"));
				list.add(h);
			}
			util.closeConnection(ps,conn, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//查询所有的房间信息
	public List<History> queryalljilu() {
		List<History> list = new ArrayList<History>();
		try {
			Connection conn = util.getConnection();
			String sql = "select * from history order by id asc ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				History h = new History();
				h.setId(rs.getInt("id"));
				h.setHyedate(rs.getString("hyedate"));
				h.setHydate(rs.getString("hydate"));
				h.setHtel(rs.getLong("htel"));
				h.setHshijian(rs.getString("hshijian"));
				h.setHrmno(rs.getInt("hrmno"));
				h.setHtype(rs.getString("htype"));
				h.setHname(rs.getString("hname"));
				h.setHedate(rs.getString("hedate"));
				h.setHdate(rs.getString("hdate"));
				h.setHcard(rs.getString("hcard"));
				h.setHallfee(rs.getDouble("hallfee"));
				list.add(h);
			}
			util.closeConnection(ps,conn, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//通过房间类型查询记录
	public List<History> queryjilubytype(String type) {
		List<History> list = new ArrayList<History>();
		try {
			Connection conn = util.getConnection();
			String sql = "select * from history where htype=? order by id asc ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,type);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				History h = new History();
				h.setId(rs.getInt("id"));
				h.setHyedate(rs.getString("hyedate"));
				h.setHydate(rs.getString("hydate"));
				h.setHtel(rs.getLong("htel"));
				h.setHshijian(rs.getString("hshijian"));
				h.setHrmno(rs.getInt("hrmno"));
				h.setHtype(rs.getString("htype"));
				h.setHname(rs.getString("hname"));
				h.setHedate(rs.getString("hedate"));
				h.setHdate(rs.getString("hdate"));
				h.setHcard(rs.getString("hcard"));
				h.setHallfee(rs.getDouble("hallfee"));
				list.add(h);
			}
			util.closeConnection(ps,conn, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//vip点餐后更新vip表
	public boolean updatevipvfee(int rmno, double vprice) {
		boolean flag = false;
		try{
		Connection conn = util.getConnection();
		String sql = "update vip set vfee = vfee+?  where rmno=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setDouble(1,vprice);
		ps.setInt(2,rmno);
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

	//普通用户点餐后更新表
	public boolean updateclientcfee(int rmno, double price) {
		boolean flag = false;
		try{
		Connection conn = util.getConnection();
		String sql = "update client set cfee = cfee+?  where rmno=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setDouble(1,price);
		ps.setInt(2,rmno);
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
	
	
	
	
	
   

   	//查询单个会员通过身份证
	public Vip queryvip(String sfz) {
		Vip v = new Vip();
		try {
			Connection conn = util.getConnection();
			String sql = "select * from vip where vcard = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, sfz);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				v.setId(rs.getInt("id"));
				v.setVno(rs.getInt("vno"));
				v.setVname(rs.getString("vname"));
				v.setVcard(rs.getString("vcard"));
				v.setTel(rs.getLong("tel"));
				v.setVfee(rs.getLong("vfee"));
				v.setVdate(rs.getString("vdate"));
				
			}
			//关闭连接
			util.closeConnection(ps, conn, rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return v;
	}

	//更新vip的信息
	public boolean queryVip(int vno, String newname, String vcard, Long tel, String name) {
		boolean flag = false;
		try{
			Connection conn = util.getConnection();
			String sql = "update vip set vno=?,vname=?,vcard=?,tel=? where vname = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, vno);
			ps.setString(2, newname);
			ps.setString(3, vcard);
			ps.setLong(4, tel);
			ps.setString(5,name);
			int n = ps.executeUpdate();
			if (n>=1) {
				flag=true;
			}
		util.closeConnection(ps, conn, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	//删除会员
	public boolean deletevip(String name, int vno) {
			   boolean flag = false;
				try{
				Connection conn = util.getConnection();
				String sql = "delete from vip where vno=? and vname=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1,vno);
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
	

	public boolean addvip(String vname, int vno, long tel, String card) {
		 boolean flag = false;
			try{
			Connection conn = util.getConnection();
			String sql = "insert into vip values(vip_seq.nextval,?,?,?,null,?,0,'空')";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,vno);
			ps.setString(2,vname);
			ps.setString(3,card);
			ps.setLong(4, tel);
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

	
	public static void main(String[] args) {
		Daoemp d = new Daoemp();
		List<History> list = new ArrayList<History>();
       list = d.queryjilu(308);
        System.out.println(list.get(0).getHcard());
   	
   	}

	





}

	


