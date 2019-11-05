package maintenance.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import maintenance.model.vo.Bill;

public class BillDao {
	// 기본생성자
	public BillDao() {
	}

	// 고지서 전체 조회용 리스트
	public ArrayList<Bill> selectList(Connection conn) {
		ArrayList<Bill> list = new ArrayList<Bill>();
		Statement stmt = null;
		ResultSet rset = null;

		String query = "select * from bill";

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				Bill b = new Bill();

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
				b.setAmount(rset.getInt("amount")); // 부과금액
				b.setBeforeAmount(rset.getDouble("before_amount")); // 납기내 금액
				b.setArrearsFine(rset.getDouble("arrears_fine")); // 미납후 금액
				b.setAfterAmount(rset.getDouble("after_amount"));// 납기후 금액

				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		System.out.println("list : " + list);
		return list;
	}

	// 페이징 처리용 Count();
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
	}

	// 페이징 시작번호, 끝 번호
	public ArrayList<Bill> selectList(Connection conn, int startRow, int endRow) {
		ArrayList<Bill> list = new ArrayList<Bill>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT * FROM " + "(SELECT ROWNUM RNUM, c.* "
				+ "FROM(SELECT * FROM BILL ORDER BY BILL_YEAR_MONTH DESC, USERID ASC)C) "
				+ "where rnum >= ? and rnum <=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Bill b = new Bill();

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
	}

	// insert
	public int insertBill(Connection conn, Bill bill) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "INSERT INTO bill VALUES( " + "BILL_SEQ.NEXTVAL,?, ?, ?, " + "  ?, ?, ?, ?, ?, "
				+ "  ?, ?, default, " + "  ?, ?, ?, ?, ?, ?, ?, ?, " + "  ?, ?, ?, ?, ?, ?, ?, "
				+ "  ?, ?, ?, ?, default, NULL, null, " + " default, default, ?, default )";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bill.getUserId());
			pstmt.setString(2, bill.getUserName());
			pstmt.setDate(3, bill.getBillYearMonth());

			pstmt.setDate(4, bill.getCalculateStartDay());
			pstmt.setDate(5, bill.getCalculateEndDay());
			pstmt.setDate(6, bill.getImposeEndDay());
			pstmt.setDate(7, bill.getAcceptDate());
			pstmt.setDate(8, bill.getCutoffDate());

			pstmt.setString(9, bill.getImposeStatus());
			pstmt.setInt(10, bill.getImposeCount()); // 마감횟수

			pstmt.setInt(11, bill.getGeneralCost());
			pstmt.setInt(12, bill.getCleanCost());
			pstmt.setInt(13, bill.getDisinfectCost());
			pstmt.setInt(14, bill.getElevatorCost());
			pstmt.setInt(15, bill.getRepairCost());
			pstmt.setInt(16, bill.getGuardCost());
			pstmt.setInt(17, bill.getFireInsuranceCost());
			pstmt.setInt(18, bill.getCommission());

			pstmt.setInt(19, bill.getElectricCost());
			pstmt.setInt(20, bill.getAllElectricCost());
			pstmt.setInt(21, bill.getTvCost());
			pstmt.setInt(22, bill.getHeatingCost());
			pstmt.setInt(23, bill.getHwaterCost());
			pstmt.setInt(24, bill.getWaterCost());

			pstmt.setInt(25, bill.getAllWaterCost());

			pstmt.setInt(26, bill.getElectricUsage());
			pstmt.setDouble(27, bill.getHeatingUsage());
			pstmt.setDouble(28, bill.getHwaterUsage());
			pstmt.setInt(29, bill.getWaterUsage());

			pstmt.setInt(30, bill.getAmount());

			result = pstmt.executeUpdate();
			System.out.println("처리된 행의 갯수 :" + result);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}// end insert

	// 직원용
	public Bill selectOne(Connection conn, long merchantUid) {
		Bill b = null;

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from bill where MERCHANT_UID = ?";
		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setLong(1, merchantUid);

			rset = pstmt.executeQuery();

			if (rset.next()) {// 값이 있다면
				b = new Bill();

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

	public int updateBill(Connection conn, Bill bill) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = " UPDATE BILL SET " + "USERID = ? , 	USERNAME = ?,	BILL_YEAR_MONTH	= ?,"
				+ "CALCULATE_START_DAY = ?, CALCULATE_END_DAY	= ?,"
				+ "IMPOSE_END_DATE =?, ACCEPT_DATE =?,  CUTOFF_DATE =?,"
				+ "IMPOSE_STATUS =?,	IMPOSE_COUNT = ?, IMPOSE_FINISH	= DEFAULT,"
				+ "GENERAL_COST = ?, GUARD_COST = ?, CLEAN_COST = ?,	DISINFECT_COST = ?,"
				+ "	ELEVATOR_COST =?, REPAIR_COST =?, COMMISSION =?,"
				+ "	FIREINSURANCE_COST	=?, ELECTRIC_COST =?, TV_COST	=?,"
				+ "  WATER_COST =?,HEATING_COST =?,HWATER_COST =? ,"
				+ "  ALLELECTRIC_COST =?,ALLWATER_COST =?,ELECTRIC_USAGE =?," + "	WATER_USAGE	=?,"
				+ "  HEATING_USAGE	=?," + "	HWATER_USAGE =?," + "	ARREARS	= default," + "	ETC	= '',"
				+ "	VBANK_NUM =	'110-23-0310818'," + "  AMOUNT	= ?," + "  BEFORE_AMOUNT	= DEFAULT,"
				+ "	ARREARS_FINE	 = DEFAULT," + "	AFTER_AMOUNT	= DEFAULT " + "  where merchant_uid = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bill.getUserId());
			pstmt.setString(2, bill.getUserName());
			pstmt.setDate(3, bill.getBillYearMonth());

			pstmt.setDate(4, bill.getCalculateStartDay());
			pstmt.setDate(5, bill.getCalculateEndDay());
			pstmt.setDate(6, bill.getImposeEndDay());
			pstmt.setDate(7, bill.getAcceptDate());
			pstmt.setDate(8, bill.getCutoffDate());

			pstmt.setString(9, bill.getImposeStatus());
			pstmt.setInt(10, bill.getImposeCount()); // 마감횟수

			pstmt.setInt(11, bill.getGeneralCost());
			pstmt.setInt(12, bill.getCleanCost());
			pstmt.setInt(13, bill.getDisinfectCost());
			pstmt.setInt(14, bill.getElevatorCost());
			pstmt.setInt(15, bill.getRepairCost());
			pstmt.setInt(16, bill.getGuardCost());
			pstmt.setInt(17, bill.getFireInsuranceCost());
			pstmt.setInt(18, bill.getCommission());

			pstmt.setInt(19, bill.getElectricCost());
			pstmt.setInt(20, bill.getAllElectricCost());
			pstmt.setInt(21, bill.getTvCost());
			pstmt.setInt(22, bill.getHeatingCost());
			pstmt.setInt(23, bill.getHwaterCost());
			pstmt.setInt(24, bill.getWaterCost());

			pstmt.setInt(25, bill.getAllWaterCost());

			pstmt.setInt(26, bill.getElectricUsage());
			pstmt.setDouble(27, bill.getHeatingUsage());
			pstmt.setDouble(28, bill.getHwaterUsage());
			pstmt.setInt(29, bill.getWaterUsage());

			pstmt.setInt(30, bill.getAmount());
			pstmt.setLong(31, bill.getMerchantUid());

			result = pstmt.executeUpdate();
			System.out.println("처리된 행의 갯수 :" + result);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;

	}// end update

	// 상세보기하면 카운트 증가
	public int updateImposeCount(Connection conn, long merchantUid) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "UPDATE BILL SET IMPOSE_COUNT = IMPOSE_COUNT + 1 " + 
				"where merchant_uid = ?";
		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setLong(1, merchantUid);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

}
