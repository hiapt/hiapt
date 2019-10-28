package maintenance.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import maintenance.model.vo.ImposeView;

public class ImposeViewDao {
	public ImposeViewDao() {}
	
	// 관리비금액 입력 단
	public int insertImposeView(Connection conn, ImposeView impose) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "INSERT INTO IMPOSE_VIEW VALUES( " + 
				"BILL_SEQ.NEXTVAL,?, ?, ?, " + 
				"  ?, ?, ?, ?, ?, ?, ?, ?, " +
				"  ?, ?, ?, ?, ?, ?, ?, " + 
				"  ?, ?, ?, ?, ? )";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, impose.getUserId());
			pstmt.setString(2, impose.getUserName());
			pstmt.setDate(3, impose.getBillYearMonth());
			pstmt.setInt(4, impose.getGeneralCost());
			pstmt.setInt(5, impose.getGuardCost());
			pstmt.setInt(6, impose.getCleanCost());
			pstmt.setInt(7, impose.getDisinfectCost());
			pstmt.setInt(8, impose.getElevatorCost());
			pstmt.setInt(9, impose.getRepairCost());
			pstmt.setInt(10, impose.getCommission());
			pstmt.setInt(11, impose.getFireInsuranceCost());
			pstmt.setInt(12, impose.getElectricCost());
			pstmt.setInt(13, impose.getTvCost());
			pstmt.setInt(14, impose.getWaterCost());
			pstmt.setInt(15, impose.getHeatingCost());
			pstmt.setInt(16, impose.getHwaterCost());
			pstmt.setInt(17, impose.getAllElectricCost());
			pstmt.setInt(18, impose.getAllWaterCost());
			pstmt.setInt(19, impose.getElectricUsage());
			pstmt.setInt(20, impose.getWaterUsage());
			pstmt.setDouble(21, impose.getHeatingUsage());
			pstmt.setDouble(22, impose.getHwaterUsage());
			pstmt.setInt(23, impose.getAmount());
			
			result = pstmt.executeUpdate();
			System.out.println("처리된 행의 갯수 :" + result);			
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}// end insertImposeView
}
