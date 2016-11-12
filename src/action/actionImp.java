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
	
	
	
	
	
    //����Ա��¼
	public Manager login(String username) {
		Manager m = new Manager();
		dao = new Dao();
		m = dao.querymanager(username);
		boolean flag = false;
//		if(m!=null){
//			  if(username.equals(m.getMname())&&userpassword.equals(m.getMpassword())){
//			    flag = true;	
//			  }else{
//					 JOptionPane.showMessageDialog(frame,"�û������������");
//				}
//			  
//		}else{
//			 JOptionPane.showMessageDialog(frame,"�û������������");
//			}
	      
		return m;
	}
	
	//Ա����¼
	public Emp login1(String ename) {
		boolean flag = false;
		 emp = new Emp();
		 dao = new Dao();
		emp =  dao.queryemp(ename);
		
	       return emp;
	}
	//Ա������������޸�
	public boolean updateemppass(int empno, String newpass) {
		dao = new Dao();
		boolean flag = dao.updateemppass(empno,newpass);
		return flag;
	}
	//����Ա���������޸�
	public boolean updatemanagerpass(String name,String newpass){
		dao = new Dao();
		boolean flag = dao.updatemanagerpass(name,newpass);
		return flag;	
	}
	
	
	
	//ע�����Ա
	  public boolean addmanager(String name,String password){
		  dao = new Dao(); 
		  boolean flag = false;
		   flag = dao.addmanager(name,password);
		   return flag;
	   }
	  //�޸Ĺ���Ա����
	  public boolean managerpassword(String name,String oldpass,String newpass){
		  dao = new Dao();
		  boolean flag = false;
		  flag = dao.managerpassword(name,oldpass,newpass);
//		  if (flag) {
//			  JOptionPane.showMessageDialog(frame,"�޸ĳɹ�");
//		}else {
//			JOptionPane.showMessageDialog(frame,"����ԭʼ��������");
//		}
		  return flag;
	  }

	public List<Emp> queryallemp() {
		List<Emp> list = new ArrayList<Emp>();
		dao = new Dao();
		list = dao.queryallemp();
		return list;
	}
	//��ѯԱ��
	public Emp queryemp(String ename) {
		dao = new Dao();
		Emp emp = new Emp();
		emp = dao.queryemp(ename);
		return emp;
	}
	
    //��ѯԱ��
	public List<Emp> queryallemp(String name) {
		dao = new Dao();
//		Emp e = new Emp();
		List<Emp> list = new ArrayList<Emp>();
		list = dao.queryallemp(name);
		return list;
	}
	//ͨ��Ա����Ų�ѯԱ��
	public List<Emp> queryempempno(int empno) {
		dao = new Dao();
		List<Emp> list = new ArrayList<Emp>();
		list = dao.queryempempno(empno);
		return list;
	}
	
	//ɾ��Ա��
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
    //����Ա�޸ķ�����Ϣ

	public boolean updateroom(int rmno, String type, double price, double vprice) {
		boolean flag = false;
		biz = new Biz();
		flag = biz.updateroom(rmno,type,price,vprice);
		return flag;
	}
    //����Աɾ������
	public boolean deleteroom(int rmno) {
		boolean flag = false;
		biz = new Biz();
		flag = biz.deleteroom(rmno);
		return flag;
	}
    //���ӷ���
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
	  
//	//��ѯ����vip
	public Vip querybyid(int no,String name) {
		biz = new Biz();
		Vip v = new Vip();
		v = biz.querybyic(no,name);
		
		return v;
	}

	//�����Ͳ�ѯ����
	public List<Room> queryroombytype(String type) {
		 List<Room> list = new ArrayList<Room>();
		 biz = new Biz();
		 list = biz.queryroombytype(type);
		return list;
	}

//   ��ѯ���з���
	public List<Room> queryroom() {
		List<Room> list = new ArrayList<Room>();
		biz = new Biz();
		list = biz.queryroom();
		return list;
	}
	//��ѯ�������������
	public Room queryroomtype(int rmno){
		Room r = new Room();
		daoemp  = new Daoemp();
		r = daoemp.queryroomtype(rmno);
		return r;		
	}
	
	
	//��շ���
	public List<Room> queryroombuff() {
		List<Room> list = new ArrayList<Room>();
		biz = new Biz();
		list = biz.queryroombuff();
		return list;
	}


	//��ԱԤ������
	public boolean vipyuding(int vno, String vname, int rmno) {
		biz = new Biz();
		boolean flag = false;
		flag = biz.vipyuding(vno,vname,rmno);
		return flag;
	}

	//���·���״̬
	public boolean updateroom(int no,String date) {
		boolean flag = false;
		daoemp = new Daoemp();
		flag = daoemp.updatebuff(no,date);
		return flag;
	}
	//��ѯvip
	public Vip queryvip(int vno,String vname) {
		Vip v = new Vip();
		daoemp = new Daoemp();
		v = daoemp.queryvipid(vno, vname);
		return v;
	}
//	//��Ա��ס
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

	//��ѯ����ɢ��
	public Client queryclient(String putongname, long tel) {
		daoemp = new Daoemp();
		Client client = new Client();
		client = daoemp.queryclient(putongname,tel);
		return client;
	}
 
	//��ѯ���в˵�
	public List<Menus> querymenus() {
		biz = new Biz();
		List<Menus> list = biz.querymenus();
		return list;
	}
	//��ѯ������
	public List<Menus> querymenus(String mname) {
		List<Menus> list = biz.menusname(mname);
		return list;
	}
	
	//ɾ���˵�
	public boolean deletemenus(String mname) {
		boolean flag = false;
		flag =  biz.deletemenus(mname);
		return flag;
	}
	
	//���Ӳ˵�
	public boolean addmenus(String mname, double mfee, double mvfee) {
	     boolean flag = biz.insertmenus(mname,mfee,mvfee);
		return flag;
	}

	//��ѯ�����˵�����
	public Menus menusname(String name) {
		biz = new Biz();
		Menus m = biz.querymenus1(name);
		return m;
	}

	//���²˵�
	public boolean updatemenus(String mname, double price, double vprice, int id) {
		biz = new Biz();
		boolean flag = biz.updatemenus(mname,price,vprice,id);
		return flag;
	}
    //vip����ס��ѯ
	public YuDingxinxi vipruzhuchaxun(String card) {
		biz = new Biz();
		YuDingxinxi y = new YuDingxinxi();
		y = biz.vipruzhuchaxun(card);
		return y;
	}

	//��ͨ�û���ס��ѯ
	public YuDingxinxi putongruzhuchaxun(String card) {
		biz = new Biz();
		YuDingxinxi y = new YuDingxinxi();
		y = biz.putongruzhuchaxun(card);
		return y;
	}

	//��ס�޸ķ���״̬
	public boolean updateruzhuroom(int rmno) {
		biz = new Biz();
		boolean flag = biz.updateruzhuroom(rmno);
		return flag;
	}

	//��ͨ�û���ס
	public boolean clientruzhu(String ccard) {
		biz = new Biz();
		boolean flag = false;
		flag = biz.clientruzhu(ccard);
		return flag;
	}

	//vip�˶�����
	public boolean viptuiding(String card) {
		biz = new Biz();
		boolean flag = false;
		flag = biz.viptuiding(card);
		return flag;
	}

	//�˶�(�ı䷿��״̬)
	public boolean tuidingroom(int rmno) {
		biz = new Biz();
		boolean flag = false;
		flag = biz.tuidingroom(rmno);
		return flag;
	}
	//�ͻ��˶�������ʷ��¼
	public boolean addTuiDinghistory(String name, String card, long tel, int rmno, String type, String newtime,
			String shijian) {
		biz = new Biz();
	    boolean flag = false;
		flag = biz.addTuiDinghistory(name,card,tel,rmno,type,newtime,shijian);
		return flag ;
		
	}

	//��ͨ�û��˶�����
	public boolean clienttuiding(String card) {
		biz = new Biz();
		boolean flag = false;
		flag = biz.clienttuiding(card);
		return flag;
	}

	//vipֱ����ס
	public boolean vipRuZhu(int vno, String vname, int rmno) {
		biz = new Biz();
		boolean flag = false;
		flag = biz.vipRuZhu(vno,vname,rmno);
		return flag;
	}

	//������ס������Ϣ
	public boolean updateroomruzhu(int rmno) {
		daoemp = new Daoemp();
		boolean flag = daoemp.updateroomruzhu(rmno);
	    return flag;
	}
	//��ͨ�û�ֱ����ס
	public boolean putongRuZhu(String putongname, String card, long tel,double ding, int rmno) {
		biz = new Biz();
		boolean flag = false;
		flag = biz.putongRuZhu(putongname,card,tel,ding,rmno);
		return flag;
	}

	//����ʱͨ������Ų�ѯɢ��
	public Client queryclient(int rmno) {
		biz = new Biz();
		Client c = new Client();
		c = biz.queryclient(rmno);
		return c ;
	}
	//����ʱͨ������Ų�ѯvip
	public Vip queryvip(int rmno) {
		biz = new Biz();
	     Vip v = new Vip();
		v = biz.queryvip(rmno);
		return v ;
	}

	//��ѯ����ļ۸�
	public Room roomprice(int rmno) {
		biz = new Biz();
	    Room r = new Room();
		r = biz.roomprice(rmno);
		return r ;
	}

	//������ʷ��¼
	public boolean addhistory(String cnamne, String ccard, long rtel,
			int rmno,String type, String cdate, String newtime, int allfee, String shijian) {
		biz = new Biz();
	    boolean flag = false;
		flag = biz.addhistoryjiezhang(cnamne,ccard,rtel,rmno,type,cdate,newtime,allfee,shijian);
		return flag ;
	}
	//����Ԥ������ʷ��¼
	public boolean addYuDinghistory(String vname, String vcard, long tel, int rmno, String rmtype, String newtime,
			String shijian) {
		biz = new Biz();
	    boolean flag = false;
		flag = biz.addYuDinghistory(vname,vcard,tel,rmno,rmtype,newtime,shijian);
		return flag ;
	}

	//������ס����ʷ��¼
	public boolean addRuZhuhistory(String name, String card, long tel, int rmno, String type, String newtime,
			String shijian) {
		biz = new Biz();
	    boolean flag = false;
		return flag = biz.addRuZhuhistory(name,card,tel,rmno,type,newtime,shijian);
	}
	
	

	//�˷���ɾ����ͨ�û�
	public boolean deleteclient(String ccard, int rmno) {
		biz = new Biz();
		boolean flag = false;
		flag = biz.deleteclient(ccard,rmno);
		return flag;
	}

	//�˷����޸ķ����״̬
	public boolean updatetuifangroom(int rmno) {
		biz = new Biz();
		boolean flag = false;
		flag = biz.updatetuifangroom(rmno);
		return flag;
	}

	//�˷������vip�û�
	public boolean updatevip(String vcard, int rmno) {
		biz = new Biz();
		boolean flag = false;
		flag = biz.updatevip(vcard,rmno);
		return flag;
	}

	//���ݷ���Ų��Ҽ�¼
	public List<History> queryjilu(int rmno) {
		List<History> list = new ArrayList<History>();
		biz = new Biz();
		list = biz.queryjilu(rmno);
		return list;
	}

	//��ѯ���еķ����¼
	public List<History> queryalljilu() {
		List<History> list = new ArrayList<History>();
		biz = new Biz();
		list = biz.queryalljilu();
		return list;
	}

	//��ѯ���еķ����¼ͨ����������
	public List<History> queryjilubytype(String type) {
		List<History> list = new ArrayList<History>();
		biz = new Biz();
		list = biz.queryjilubytype(type);
		return list;
	}

	//vip���֮�����vip��
	public boolean updatevipvfee(int rmno, double vprice) {
		biz = new Biz();
		boolean flag = false;
		flag = biz.updatevipvfee(rmno,vprice);
		return flag;
	}

	//��ͨ�ͻ����֮����±�
	public boolean updateclientcfee(int rmno, double price) {
		biz = new Biz();
		boolean flag = false;
		flag = biz.updateclientcfee(rmno,price);
		return flag;
	}

	//���𵥸���Ա
	public Vip queryvip(String sfz) {
		daoemp = new Daoemp();
		Vip v = new Vip();
		v = daoemp.queryvip(sfz);
		return v;
	}

	//����vip��Ϣ
	public boolean updateVip(int vno, String newname, String vcard, Long tel, String name) {
		daoemp = new Daoemp();
		boolean flag = false;
		flag = daoemp.queryVip(vno,newname,vcard,tel,name);
		return flag;
	}

	//ɾ����Ա
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

	

	


	


	//��ѯԱ��ͨ������
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
//			System.out.println("�����������������");
//			return null;
//		}
//    }
	
//	
//	//ɾ����Ա
//	public void deletevip(int no) {
//		boolean flag = false;
//		flag = biz.deletevip(no);
//		if (flag) {
//			System.out.println("ɾ���ɹ�");
//		}
//	}
//	public void insertvip(int no, String name, long tel, String card) {
//		Vip v = new Vip();
//		boolean flag = false;
//		    flag = biz.insertvip(no,name,tel,card);
//			if (flag) {
//				System.out.println("���ӳɹ�");
//			}else{
//				System.out.println("����ʧ��");
//			}
//		}
//	
//	//��ͨ�ͻ���ס
//	public boolean cnruzhu() {
//		dao = new Daoemp();
//		boolean flag = false;
//		System.out.println("������ͻ�������");
//		String name = sc.next();
//		System.out.println("������ͻ������֤��");
//        String card = sc.next();
//        System.out.println("������ͻ�����ϵ�绰");
//		long tel = sc.nextLong();
//		System.out.println("������ͻ�Ҫ��ס�ķ���");
//		int no = sc.nextInt();
//		System.out.println("����Ԥ��100ԪѺ��");
//		double yajing = sc.nextDouble();
//	     flag = dao.cnruzhu(name,card,tel,no,yajing);
//		if (flag) {
//			updateroom(no);
//		}
//		return flag;
//	}
//	

//		System.out.println("������Ҫ��ѯ��vip����");
//		String name = sc.next();
//		System.out.println("������Ҫ��ѯ��vip���");
//		int vno = sc.nextInt();

