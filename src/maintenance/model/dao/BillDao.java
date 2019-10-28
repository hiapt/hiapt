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
				b.setArrearsFine(rset.getDouble("arrears_fine")); //미납후 금액
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

}
