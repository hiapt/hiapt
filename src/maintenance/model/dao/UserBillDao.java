package maintenance.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import maintenance.model.vo.UserBill;

public class UserBillDao {
	public UserBillDao() {}
	
	// 고지서 전체 번호
	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;

		String query = "select count(*) from bill";

		try {

			stmt = conn.createStatement();
			// 쿼리문 별도 내용 없으므로 바로 실행하면 됨
			rset = stmt.executeQuery(query);

			if (rset.next()) {
				listCount = rset.getInt(1); // int로 받아오면 컬럼명을 쓸 수 없으므로 순번을 적으면 됨, 오라클은 1번부터, 오라클에서 애칭을 사용해도 됨
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return listCount;
		
	}// end getListCount

	
	public ArrayList<UserBill> selectList(Connection conn, int startRow, int endRow) {
		ArrayList<UserBill> list = new ArrayList<UserBill>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT * FROM " + 
				"(SELECT ROWNUM RNUM, c.* " + 
				"FROM(SELECT * FROM BILL ORDER BY BILL_YEAR_MONTH DESC, USERID ASC)C) " + 
				"where rnum >= ? and rnum <=?";

		try { 
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				UserBill b = new UserBill();

				b.setMerchantUid(rset.getLong("merchant_uid"));// 1. 고유고지서번호
				b.setUserId(rset.getString("userid"));// 2. 동/호수
				b.setUserName(rset.getString("username"));// 3. 이름
				b.setBillYearMonth(rset.getDate("bill_year_month"));// 4. 고지서부과월
				b.setCalculateStartDay(rset.getDate("calculate_start_day"));// 5. 산출기간 시작일
				b.setCalculateEndDay(rset.getDate("calculate_end_day"));// 6. 산출기간 마감일
				b.setImposeEndDay(rset.getDate("impose_end_date"));// 7. 부과마감일
				b.setAcceptDate(rset.getDate("accept_date"));// 8. 출력의뢰일시
				b.setCutoffDate(rset.getDate("cutoff_date"));// 9. 납부마감일
				
				b.setImposeStatus(rset.getString("impose_status"));// 10. 부과진행
				b.setImposeCount(rset.getInt("impose_count"));// 11. 부과마감횟수
				b.setImposeFinish(rset.getString("impose_finish"));// 12. 부과완료
				
				b.setGeneralCost(rset.getInt("general_cost"));// 13. 일반관리비
				b.setGuardCost(rset.getInt("guard_cost"));// 14. 경비비
				b.setCleanCost(rset.getInt("clean_cost"));// 15. 청소비
				b.setDisinfectCost(rset.getInt("disinfect_cost"));// 16. 소독비
				b.setElevatorCost(rset.getInt("elevator_cost"));// 17. 승강기유지비
				b.setRepairCost(rset.getInt("repair_cost"));// 18. 수선유지비
				b.setCommission(rset.getInt("commission"));// 19. 위탁관리수수료
				b.setFireInsuranceCost(rset.getInt("fireinsurance_cost"));// 20. 화재보험료
				b.setElectricCost(rset.getInt("electric_cost"));// 21. 세대전기료
				b.setTvCost(rset.getInt("tv_cost"));// 22. TV 수신료
				b.setWaterCost(rset.getInt("water_cost"));// 23. 세대수도료
				b.setHeatingCost(rset.getInt("heating_cost"));// 24. 난방사용료
				b.setHwaterCost(rset.getInt("hwater_cost"));// 25. 온수사용료
				b.setAllElectricCost(rset.getInt("allelectric_cost"));// 26. 공동전기료
				b.setAllWaterCost(rset.getInt("allwater_cost"));// 27. 공동수도료
				b.setElectricUsage(rset.getInt("electric_usage"));// 28. 전기사용량
				b.setWaterUsage(rset.getInt("water_usage"));// 29. 수도사용량
				b.setHeatingUsage(rset.getDouble("heating_usage"));// 30. 난방사용량
				b.setHwaterUsage(rset.getDouble("hwater_usage"));// 31. 온수사용량 
				
				b.setArrears(rset.getInt("arrears"));// 32. 미납액
				b.setEtc(rset.getString("etc"));// 33. 비고
				b.setVbankNum(rset.getString("vbank_num"));// 34. 계좌번호
				b.setAmount(rset.getInt("amount")); // 35. 부과금액
				b.setBeforeAmount(rset.getDouble("before_amount")); // 36. 납기내 금액
				b.setArrearsFine(rset.getDouble("arrears_fine")); // 37. 미납후 금액
				b.setAfterAmount(rset.getDouble("after_amount"));// 38. 납기후 금액
				
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("list dao : " + list);
		System.out.println("size : " + list.size());
		return list;
	}// end selectList
	
	// 검색용 페이지
	public int getListCount(Connection conn, String months) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT COUNT(*) " +
				" FROM Bill " +
				" WHERE TO_CHAR(BILL_YEAR_MONTH, 'yyyy/mm') Like ?";

		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + months + "%");
			
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				listCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return listCount;
	}
	// 검색용
	public ArrayList<UserBill> selectMonthSearch(Connection conn, String months, int startRow, int endRow) {
		ArrayList<UserBill> list = new ArrayList<UserBill>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		/*String query = "SELECT * FROM BASE_VIEW "
				+ " where TO_CHAR(BILL_YEAR_MONTH, 'yyyy-mm') like ?";*/
		
		String query  = "SELECT * FROM (SELECT ROWNUM RNUM, r.* " + 
				"				FROM (SELECT * FROM BILL " + 
				"				WHERE TO_CHAR(BILL_YEAR_MONTH, 'yyyy-mm') LIKE ? " + 
				"				ORDER BY BILL_YEAR_MONTH DESC, CUTOFF_DATE DESC) r) " + 
				"				where rnum >=? and rnum <=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+ months + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				UserBill b = new UserBill();

				b.setMerchantUid(rset.getLong("merchant_uid"));// 1. 고유고지서번호
				b.setUserId(rset.getString("userid"));// 2. 동/호수
				b.setUserName(rset.getString("username"));// 3. 이름
				b.setBillYearMonth(rset.getDate("bill_year_month"));// 4. 고지서부과월
				b.setCalculateStartDay(rset.getDate("calculate_start_day"));// 5. 산출기간 시작일
				b.setCalculateEndDay(rset.getDate("calculate_end_day"));// 6. 산출기간 마감일
				b.setImposeEndDay(rset.getDate("impose_end_date"));// 7. 부과마감일
				b.setAcceptDate(rset.getDate("accept_date"));// 8. 출력의뢰일시
				b.setCutoffDate(rset.getDate("cutoff_date"));// 9. 납부마감일
				
				b.setImposeStatus(rset.getString("impose_status"));// 10. 부과진행
				b.setImposeCount(rset.getInt("impose_count"));// 11. 부과마감횟수
				b.setImposeFinish(rset.getString("impose_finish"));// 12. 부과완료
				
				b.setGeneralCost(rset.getInt("general_cost"));// 13. 일반관리비
				b.setGuardCost(rset.getInt("guard_cost"));// 14. 경비비
				b.setCleanCost(rset.getInt("clean_cost"));// 15. 청소비
				b.setDisinfectCost(rset.getInt("disinfect_cost"));// 16. 소독비
				b.setElevatorCost(rset.getInt("elevator_cost"));// 17. 승강기유지비
				b.setRepairCost(rset.getInt("repair_cost"));// 18. 수선유지비
				b.setCommission(rset.getInt("commission"));// 19. 위탁관리수수료
				b.setFireInsuranceCost(rset.getInt("fireinsurance_cost"));// 20. 화재보험료
				b.setElectricCost(rset.getInt("electric_cost"));// 21. 세대전기료
				b.setTvCost(rset.getInt("tv_cost"));// 22. TV 수신료
				b.setWaterCost(rset.getInt("water_cost"));// 23. 세대수도료
				b.setHeatingCost(rset.getInt("heating_cost"));// 24. 난방사용료
				b.setHwaterCost(rset.getInt("hwater_cost"));// 25. 온수사용료
				b.setAllElectricCost(rset.getInt("allelectric_cost"));// 26. 공동전기료
				b.setAllWaterCost(rset.getInt("allwater_cost"));// 27. 공동수도료
				b.setElectricUsage(rset.getInt("electric_usage"));// 28. 전기사용량
				b.setWaterUsage(rset.getInt("water_usage"));// 29. 수도사용량
				b.setHeatingUsage(rset.getDouble("heating_usage"));// 30. 난방사용량
				b.setHwaterUsage(rset.getDouble("hwater_usage"));// 31. 온수사용량 
				
				b.setArrears(rset.getInt("arrears"));// 32. 미납액
				b.setEtc(rset.getString("etc"));// 33. 비고
				b.setVbankNum(rset.getString("vbank_num"));// 34. 계좌번호
				b.setAmount(rset.getInt("amount")); // 35. 부과금액
				b.setBeforeAmount(rset.getDouble("before_amount")); // 36. 납기내 금액
				b.setArrearsFine(rset.getDouble("arrears_fine")); // 37. 미납후 금액
				b.setAfterAmount(rset.getDouble("after_amount"));// 38. 납기후 금액
				
				list.add(b);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("dao months: " + list);
		return list;
	}
	
	// 고지서 top1
	public ArrayList<UserBill> selectTop1(Connection conn) {
		ArrayList<UserBill> ulist = new ArrayList<UserBill>();
		Statement stmt = null;
		ResultSet rset = null;
		
		// 상위 1개만 고르는 걸로
		String query ="SELECT * FROM (SELECT ROWNUM RNUM, R.* " + 
				"				FROM (SELECT * FROM BILL " + 
				"        WHERE BILL_YEAR_MONTH IS NOT NULL " + 
				"        and CUTOFF_DATE is not null " + 
				"        AND USERID IS NOT NULL" + 
				"        and USERNAME is not null " + 
				"        AND AMOUNT IS NOT NULL " + 
				"        AND BEFORE_AMOUNT IS NOT NULL " + 
				"        AND AFTER_AMOUNT IS NOT NULL " + 
				"				ORDER BY merchant_uid DESC, BILL_YEAR_MONTH DESC) R)" + 
				"				where rnum =1 and IMPOSE_FINISH = 'N'";
		
		try {
			
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				UserBill b = new UserBill();

				b.setMerchantUid(rset.getLong("merchant_uid"));// 1. 고유고지서번호
				b.setUserId(rset.getString("userid"));// 2. 동/호수
				b.setUserName(rset.getString("username"));// 3. 이름
				b.setBillYearMonth(rset.getDate("bill_year_month"));// 4. 고지서부과월			
				b.setCutoffDate(rset.getDate("CUTOFF_DATE"));// 납부마감일
				b.setArrears(rset.getInt("arrears"));// 32. 미납액
				b.setAmount(rset.getInt("amount")); // 35. 부과금액
				b.setBeforeAmount(rset.getDouble("before_amount")); // 36. 납기내 금액
				b.setArrearsFine(rset.getDouble("arrears_fine")); // 37. 미납후 금액
				b.setAfterAmount(rset.getDouble("after_amount"));// 38. 납기후 금액
				
				ulist.add(b);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}	
		System.out.println("dao : " + ulist);
		return ulist;
	}
	// 상세보기용
	public UserBill selectOne(Connection conn, long merchantUid) {
		UserBill b = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from bill where MERCHANT_UID = ?";
		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setLong(1, merchantUid);

			rset = pstmt.executeQuery();

			if (rset.next()) {// 값이 있다면
				b = new UserBill();

				b.setMerchantUid(rset.getLong("merchant_uid"));// 1. 고유고지서번호
				b.setUserId(rset.getString("userid"));// 2. 동/호수
				b.setUserName(rset.getString("username"));// 3. 이름
				b.setBillYearMonth(rset.getDate("bill_year_month"));// 4. 고지서부과월
				b.setCalculateStartDay(rset.getDate("calculate_start_day"));// 5. 산출기간 시작일
				b.setCalculateEndDay(rset.getDate("calculate_end_day"));// 6. 산출기간 마감일
				b.setImposeEndDay(rset.getDate("impose_end_date"));// 7. 부과마감일
				b.setAcceptDate(rset.getDate("accept_date"));// 8. 출력의뢰일시
				b.setCutoffDate(rset.getDate("cutoff_date"));// 9. 납부마감일
				
				b.setImposeStatus(rset.getString("impose_status"));// 10. 부과진행
				b.setImposeCount(rset.getInt("impose_count"));// 11. 부과마감횟수
				b.setImposeFinish(rset.getString("impose_finish"));// 12. 부과완료
				
				b.setGeneralCost(rset.getInt("general_cost"));// 13. 일반관리비
				b.setGuardCost(rset.getInt("guard_cost"));// 14. 경비비
				b.setCleanCost(rset.getInt("clean_cost"));// 15. 청소비
				b.setDisinfectCost(rset.getInt("disinfect_cost"));// 16. 소독비
				b.setElevatorCost(rset.getInt("elevator_cost"));// 17. 승강기유지비
				b.setRepairCost(rset.getInt("repair_cost"));// 18. 수선유지비
				b.setCommission(rset.getInt("commission"));// 19. 위탁관리수수료
				b.setFireInsuranceCost(rset.getInt("fireinsurance_cost"));// 20. 화재보험료
				b.setElectricCost(rset.getInt("electric_cost"));// 21. 세대전기료
				b.setTvCost(rset.getInt("tv_cost"));// 22. TV 수신료
				b.setWaterCost(rset.getInt("water_cost"));// 23. 세대수도료
				b.setHeatingCost(rset.getInt("heating_cost"));// 24. 난방사용료
				b.setHwaterCost(rset.getInt("hwater_cost"));// 25. 온수사용료
				b.setAllElectricCost(rset.getInt("allelectric_cost"));// 26. 공동전기료
				b.setAllWaterCost(rset.getInt("allwater_cost"));// 27. 공동수도료
				b.setElectricUsage(rset.getInt("electric_usage"));// 28. 전기사용량
				b.setWaterUsage(rset.getInt("water_usage"));// 29. 수도사용량
				b.setHeatingUsage(rset.getDouble("heating_usage"));// 30. 난방사용량
				b.setHwaterUsage(rset.getDouble("hwater_usage"));// 31. 온수사용량 
				
				b.setArrears(rset.getInt("arrears"));// 32. 미납액
				b.setEtc(rset.getString("etc"));// 33. 비고
				b.setVbankNum(rset.getString("vbank_num"));// 34. 계좌번호
				b.setAmount(rset.getInt("amount")); // 35. 부과금액
				b.setBeforeAmount(rset.getDouble("before_amount")); // 36. 납기내 금액
				b.setArrearsFine(rset.getDouble("arrears_fine")); // 37. 미납후 금액
				b.setAfterAmount(rset.getDouble("after_amount"));// 38. 납기후 금액
								
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return b;
	}
	
	// 결제용 하나
	public UserBill selectMerchant(Connection conn, Long merchantUid) {
		UserBill bill = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		// 상위 1개만 고르는 걸로
		String query ="SELECT * FROM BILL " + 
				"where merchant_uid = ?";
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setLong(1, merchantUid);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				bill = new UserBill();

				bill.setMerchantUid(rset.getLong("merchant_uid"));// 1. 고유고지서번호
				bill.setAmount(rset.getInt("amount")); // 35. 부과금액
				bill.setBeforeAmount(rset.getDouble("before_amount")); // 36. 납기내 금액				
				bill.setAfterAmount(rset.getDouble("after_amount"));// 38. 납기후 금액
				
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}	
		System.out.println("dao : " + bill);
		return bill;
	}


	
	
	
}// end class
