package maintenance.model.service;

import maintenance.model.dao.UserBillDao;
import maintenance.model.vo.UserBill;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

public class UserBillService {
	
	// 의존성 주입
		private UserBillDao ubdao = new UserBillDao();
		
		public UserBillService() {}
		
		// 기본 페이지 List
		public int getListCount() {
			Connection conn = getConnection();
			int listCount = ubdao.getListCount(conn);
			close(conn);
			
			return listCount;
		}// end getListCount
		
		// 기본 시작 페이지번호, 끝 번호
		public ArrayList<UserBill> selectList(int startRow, int endRow) {
			Connection conn = getConnection();
			ArrayList<UserBill> list = ubdao.selectList(conn, startRow, endRow);
			close(conn);
			System.out.println("list service : " + list);
			return list;
		} // end ArrayList
		
		// 검색용 페이지
		public int getListCount(String months) {
			Connection conn = getConnection();
			int listCount = ubdao.getListCount(conn, months);
			close(conn);
			
			return listCount;
		}
		
		// 검색용
		public ArrayList<UserBill> selectList(String months, int startRow, int endRow) {
			Connection conn = getConnection();
			ArrayList<UserBill> list = ubdao.selectMonthSearch(conn, months, startRow, endRow);
			close(conn);
			
			System.out.println("service monts:  " + list);
			return list;
		}
		
		// top1
		public ArrayList<UserBill> selectTop1() {
			Connection conn = getConnection();
			ArrayList<UserBill> ulist = ubdao.selectTop1(conn);
			close(conn);
			return ulist;
		}
		
		// 상세보기용
		public UserBill selectOne(long merchantUid) {
			Connection conn = getConnection();
			UserBill ubill = ubdao.selectOne(conn, merchantUid);
			close(conn);
			
			return ubill;
		}
		
		
		// 결제용
		public UserBill selectMerchant(Long merchantUid) {
			Connection conn = getConnection();
			UserBill bill = ubdao.selectMerchant(conn, merchantUid);
			close(conn);
			
			return bill;	
		}
		
} // end class
