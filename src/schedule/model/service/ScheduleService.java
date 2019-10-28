package schedule.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import schedule.model.dao.ScheduleDao;
import schedule.model.vo.Schedule;

import static common.JDBCTemplate.*;

public class ScheduleService {
	public ScheduleService() {}
	private ScheduleDao schDao = new ScheduleDao();

	public ArrayList<Schedule> selectAll(String ym, String writer) {
		Connection conn = getConnection();
		ArrayList<Schedule> list = schDao.selectAll(conn, ym, writer);
		close(conn);
		return list;
		
	}

	public int insertSchedule(Schedule sch) {
		Connection conn = getConnection();
		int result = schDao.insertCalendar(conn, sch);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public Schedule selectOne(String snum) {
		Connection conn = getConnection();
		Schedule sch = schDao.selectOne(conn, snum);
		close(conn);
		return sch;
	}

	public int deleteSchedule(String schNo) {
		Connection conn = getConnection();
		int result = schDao.deleteSchedule(conn, schNo);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int updateSchedule(Schedule sch) {
		Connection conn = getConnection();
		int result = schDao.updateSchedule(conn, sch);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

}
