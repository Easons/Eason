//package dao;
//
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.text.SimpleDateFormat;
//import java.util.Scanner;
//
//import entity.Room;
//
//import Util.util;
//
//public class Test {
//	static Scanner sc = new Scanner(System.in);
//	public Room queryrmno(int no) {
//		Room room = null;	
////		try {
//				Connection conn = util.getConnection();
//				String sql = "select * from room where rmno=?";
//				PreparedStatement ps = conn.prepareStatement(sql);
//				ps.setInt(1, no);
//				ResultSet rs = ps.executeQuery();
//				if(rs.next()){
//					room = new Room();
//					room.setRmid(rs.getInt("rmid"));
//					room.setRmno(no);
//					room.setRmprice(rs.getDouble("rmprice"));
//				    room.setRmtype(rs.getString("rmtype"));
//				    room.setRydate(rs.getString("rydate"));
//				    room.setVprice(rs.getDouble("vprice"));
//				    room.setRmbook(rs.getString("rmbook"));
//				    room.setRmbuff(rs.getString("rmbuff"));
//				}
//				util.closeConnection(ps,conn, rs);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return room;	
//	}
//	public static void main(String[] args) {
//		Test t = new Test();
//		int no = sc.nextInt();
//		Room r = t.queryrmno(no);
//		String date = r.getRydate();
//		System.out.println(date);
//		System.out.println(date.length());
//		System.out.println(date.substring(6,7));
//		System.out.println(date.substring(11,13));
//	}
//}
