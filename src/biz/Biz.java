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
  	   
   //��ѯԱ��
     public Emp queryempbyempno(int empno){
    	 dao = new Dao();
    	Emp emp = dao.queryempbyempno(empno);

			return emp;
		
    	 
     }
   //����Ա��
   public boolean plusemp(String name, int age,double sal,String sex) {
	   boolean flag = dao.plusemp(name,age,sal,sex); 
	   return flag;
}
   //�޸�Ա����Ϣ
   public boolean updateemp(int empno, String name, int age, double sal,String sex) {
	   dao = new Dao();
	   boolean flag = dao.updateemp(empno, name, age, sal,sex);
	   return flag;
   }
//   //ɾ��Ա��
//   public boolean deleteemp(int empno, String name) {
//	 emp = dao.queryemp(name);
//	 if(emp.getEname()!=null){
//       boolean flag = dao.deleteemp(empno,name);
//     return flag;
//     }else{
//	 System.out.println("��Ա��ƥ��");
//	 return false;
//  }
//}
   
   //��ѯ���з���
	public List<Room> queryroom() {
		List<Room> list = dao.queryroom();
		return list;
	}
	//���ݷ�����������
	public List<Room> queryroombytype(String name) {
	    dao = new Dao();
	    List<Room>  list = dao.queryroombytype(name);
		return list;
	}
	//��ѯ�շ���
	public List<Room> queryroombuff() {
		dao = new Dao();
	    List<Room>  list = dao.queryroombuff();
		return list;
	}
   
	//����Ա�޸ķ�����Ϣ
	public boolean updateroom(int rmno, String type, double price, double vprice) {
		dao = new Dao();
		boolean flag = false;
		flag = dao.updateroom(rmno, type, price, vprice);
		return flag;
	}
	//��ѯ��������
	public Room queryrmno(int no) {
		dao = new Dao();
		 r = new Room();
		r = dao.queryrmno(no);
		return r;
	}
   //���ӷ���
	public boolean addroom(String rmtype, double rmprice, double vprice) {
		boolean flag = dao.addroom(rmtype,rmprice,vprice);
		return flag;
		
	}
	//vipԤ������
	public boolean vipyuding(int vno, String vname, int rmno) {
		boolean flag = false;
		daoemp = new Daoemp();
		flag = daoemp.vipyuding(vno,vname,rmno);
		return flag;
	}
	//��ѯ����vip
	public Vip querybyic(int no,String vname) {
		daoemp = new Daoemp();
		Vip v = new Vip();
		v = daoemp.queryvipid(no,vname);
		return v;
	}
    //�����в�
    public List<Menus> querymenus() {
    	daoemp = new Daoemp();
	  List<Menus> list = daoemp.querymenus();
	return list;
}
     //�鵥����
	public List<Menus> menusname(String name) {
	   daoemp = new Daoemp();
	   List<Menus> list = daoemp.menusname(name);
	   return list;
	   
	}
	
	//�鵥���˵Ķ���
	public Menus querymenus1(String name) {
	     daoemp = new Daoemp();
	     Menus m = new Menus();
	     m = daoemp.querymenus(name);
		return m;
	}
	//���²˵�
     public boolean updatemenus(String mname, double price, double vprice, int id) {
		daoemp = new Daoemp();
		boolean flag = daoemp.updatemenus(mname, price, vprice, id);
		return flag;
	}
    
    //ɾ���˵�
    public boolean deletemenus(String mname) {
    	boolean flag = dao.deletemenus(mname);
    	return flag;
    }
 
	//������
	public boolean insertmenus(String mname, double mfee, double mvfee) {
		boolean flag = dao.insertmenus(mname,mfee,mvfee);
		return flag;
	}
	
	
	//ɾ������
	public boolean deleteroom(int rmno) {
		boolean flag = false;
	    flag = dao.deleteroom(rmno);
        return flag;
	}

	//��ѯvip��
	public List<Vip> queryvip() {
		List<Vip> list = dao.queryvip();
		return list;
	}
	//ɾ����Ա
	public boolean deletevip(int no) {
		boolean flag = dao.deletevip(no);
		return flag;
	}
    //���ӻ�Ա
	public boolean insertvip(int no, String name, long tel, String card) {
		boolean flag = false;
		flag = dao.insertvip(no,name,tel,card);
		return flag;
	}
	public void xiugaivip(int no, int newno) {
	    boolean flag = false;
	    flag = dao.xiugaivno(no,newno);
		if (flag) {
			System.out.println("�޸ĳɹ�");
		}else {
			System.out.println("�޸�ʧ��");
		}
	}
	public void xiugaivip(int no, String newname) {
		boolean flag = false;
		flag = dao.xiugaivname(no,newname);
		if (flag) {
			System.out.println("�޸ĳɹ�");
		}else {
			System.out.println("�޸�ʧ��");
		}
		
	}
	
	public void xiugaivip(int no, long newtel) {
		boolean flag = dao.xiugaivtel(no,newtel);
		if (flag) {
			System.out.println("�޸ĳɹ�");
		}else {
			System.out.println("�޸�ʧ��");
		}
	}
	public void xiugaivcard(int no, String newcard) {
		boolean flag = false;
		flag = dao.xiugaivcard(no,newcard);
		if (flag) {
			System.out.println("�޸ĳɹ�");
		}else {
			System.out.println("�޸�ʧ��");
		}
		
	}
	//�޸�Ա������
	public boolean emppass(String username, String oldpass, String newpass) {
		boolean flag = false;
		daoemp = new Daoemp();
		flag = daoemp.emppass(username,oldpass,newpass);
		return flag;
	}
	//vip��ס��ѯ
	public YuDingxinxi vipruzhuchaxun(String card) {
		YuDingxinxi y = new YuDingxinxi();
		daoemp = new Daoemp();
		y = daoemp.vipruzhuchaxun(card);
		return y;
	}
	//��ͨ�û���ס��ѯ
	public YuDingxinxi putongruzhuchaxun(String card) {
		YuDingxinxi y = new YuDingxinxi();
		daoemp = new Daoemp();
		y = daoemp.putongruzhuchaxun(card);
		return y;
	}
	//vipȷ����ס
	public boolean vipruzhu(String vcard,String newtime) {
		daoemp = new Daoemp();
		boolean flag = daoemp.vipruzhu(vcard,newtime);
		return flag;
	}
	//�޸���ס������Ϣ
	public boolean updateruzhuroom(int rmno) {
		daoemp = new Daoemp();
		boolean flag = daoemp.updateruzhuroom(rmno);
		return flag;
	}
	//��ͨ�û���Ԥ������ס
	public boolean clientruzhu(String ccard) {
		daoemp = new Daoemp();
		boolean flag = daoemp.clientruzhu(ccard);
		return flag;
	}
	//vip�˶�����
	public boolean viptuiding(String card) {
		daoemp = new Daoemp();
		boolean flag = daoemp.viptuiding(card);
		return flag;
	}
	//�˶�����
	public boolean tuidingroom(int rmno) {
		daoemp = new Daoemp();
		boolean flag = daoemp.tuidingroom(rmno);
		return flag;
	}
	//��ͨ�û��˶�����
	public boolean clienttuiding(String card) {
		daoemp = new Daoemp();
		boolean flag = daoemp.clienttuiding(card);
		return flag;
	}
	//vip��ס
	public boolean vipRuZhu(int vno, String vname, int rmno) {
		daoemp = new Daoemp();
		boolean flag = daoemp.vipRuZhu(vno,vname,rmno);
		return flag;
	}
	//��ͨ��ס
	public boolean putongRuZhu(String putongname, String card, long tel,
			double ding, int rmno) {
		daoemp = new Daoemp();
		boolean flag = daoemp.putongRuZhu(putongname,card,tel,ding,rmno);
		return flag;
	}
	//����ʱ��ͨ�ͻ���ѯ(ͨ�������)
	public Client queryclient(int rmno) {
		daoemp = new Daoemp();
		Client c = new Client();
		c = daoemp.queryclient(rmno);
		return c;
	}
	//����ʱvip�ͻ���ѯ
	public Vip queryvip(int rmno) {
		daoemp = new Daoemp();
		 Vip v = new Vip();
		v = daoemp.queryvip(rmno);
		return v;
	}
	//��ѯ����۸�
	public Room roomprice(int rmno) {
		daoemp = new Daoemp();
		 Room r = new Room();
		r = daoemp.roomprice(rmno);
		return r;
	}
	//���˺���Ӽ�¼
	public boolean addhistoryjiezhang(String cnamne, String ccard, long rtel,int rmno,String type
			,String cdate, String newtime, int allfee, String shijian) {
		daoemp = new Daoemp();
		boolean flag =  daoemp.addhistoryjiezhang(cnamne,ccard,rtel,rmno,type,cdate,newtime,allfee,shijian);
		return flag;
	}
	//���˺�ɾ���ͻ�
	public boolean deleteclient(String ccard, int rmno) {
		daoemp = new Daoemp();
		boolean flag = daoemp.deleteclient(ccard,rmno);
		return flag;
	}
	//�˷����޸ķ���״̬
	public boolean updatetuifangroom(int rmno) {
		daoemp = new Daoemp();
		boolean flag = daoemp.updatetuifangroom(rmno);
		return flag;
	}
	//�˷������vip�û�
	public boolean updatevip(String vcard,int rmno) {
		daoemp = new Daoemp();
		boolean flag = daoemp.updatevip(vcard,rmno);
		return flag;
	}
	//���ݷ���Ų�ѯ�����¼
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
	//���ݷ������Ͳ�ѯ�����¼
	public List<History> queryjilubytype(String type) {
		List<History> list = new ArrayList<History>();
		daoemp = new Daoemp();
		list = daoemp.queryjilubytype(type);
		return list;
	}
	//vip�ͻ����֮����±�
	public boolean updatevipvfee(int rmno, double vprice) {
		daoemp = new Daoemp();
		boolean flag = daoemp.updatevipvfee(rmno,vprice);
		return flag;
	}
	//��ͨ�û���ͺ���±�
	public boolean updateclientcfee(int rmno, double price) {
		daoemp = new Daoemp();
		boolean flag = daoemp.updateclientcfee(rmno,price);
		return flag;
	}
	//����Ԥ����ķ����¼
	public boolean addYuDinghistory(String vname, String vcard, long tel, int rmno, String rmtype, String newtime,
			String shijian) {
		daoemp = new Daoemp();
		boolean flag = daoemp.addYuDinghistory(vname,vcard,tel,rmno,rmtype,newtime,shijian);
		return flag;
	}
	//�ͻ��˶��������˷���¼
	public boolean addTuiDinghistory(String name, String card, long tel, int rmno, String type, String newtime,
			String shijian) {
		daoemp = new Daoemp();
		boolean flag = daoemp.addTuiDinghistory(name,card,tel,rmno,type,newtime,shijian);
		return flag;
	}
	//�ͻ���ס��ļ�¼
	public boolean addRuZhuhistory(String name, String card, long tel, int rmno, String type, String newtime,
			String shijian) {
		daoemp = new Daoemp();
		boolean flag = daoemp.addRuZhuhistory(name,card,tel,rmno,type,newtime,shijian);
		return flag;
	}
	
	
}

