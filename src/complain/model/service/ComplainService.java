package complain.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import board.model.vo.Board;
import board.model.vo.BoardFiles;
import complain.model.dao.ComplainDao;
import complain.model.vo.Complain;
import complain.model.vo.ComplainImgs;
import vote.model.vo.Vote;

public class ComplainService {
	private ComplainDao cdao = new ComplainDao();
	
	//전체목록갯수 
	public int getListCount() {
		Connection conn = getConnection();
		int listCount = cdao.getListCount(conn);
		close(conn);
		return listCount;
	}
	
	// 전체목록조회
		public ArrayList<Complain> selectList(int startlist, int endlist) {
			Connection conn = getConnection();
			ArrayList<Complain> clist = cdao.selectList(conn, startlist, endlist);
			close(conn);
			return clist;
		}
		//민원 내용등록
		public int insertComplain(Complain comp) {
			Connection conn = getConnection();
			int result =cdao.insertComplain(conn, comp);
			if(result > 0)
				commit(conn);
			else
				rollback(conn);
			close(conn);
			return result;
		}
		//민원 마지막번호조회
		public int selectLastCno() {
			Connection conn = getConnection();
			int result = cdao.selectLastCno(conn);
			close(conn);
			return result;
		}
		
		//이미지 등록
		public void insertComplainImg(int cno, ComplainImgs cImg) {
			Connection conn = getConnection();
			int result =cdao.insertComplainImg(conn, cno, cImg);
			if(result > 0)
				commit(conn);
			else
				rollback(conn);
			close(conn);
		}
		//상세조회
		public Complain selectView(int cNo) {
			Connection conn = getConnection();
			Complain comp= cdao.selectView(conn, cNo);
			close(conn);
			return comp;
		}
		//이미지조회
		public ArrayList<ComplainImgs> selectImgs(int cNo) {
			Connection conn = getConnection();
			ArrayList<ComplainImgs> imglist = cdao.selectImgs(conn, cNo);
			close(conn);
			return imglist;
		}
		//민원 삭제
		public int deleteComplain(int cNo) {
			Connection conn = getConnection();
			int result =cdao.deleteComplain(conn, cNo);
			if(result > 0)
				commit(conn);
			else
				rollback(conn);
			close(conn);
			return result;
		}
		//민원 수정
		public int updateComplain(Complain comp) {
			Connection conn = getConnection();
			int result =cdao.updateComplain(conn, comp);
			if(result > 0)
				commit(conn);
			else
				rollback(conn);
			close(conn);
			return result;
		}
		//db파일삭제
		public void deleteFile(String renameFileName) {
			Connection conn = getConnection();
			int result =cdao.deleteFile(conn, renameFileName);
			if(result > 0)
				commit(conn);
			else
				rollback(conn);
			close(conn);
		}
		//제목으로 검색시 목록갯수
		public int getSearchTitleListCount(String searchText) {
			Connection conn = getConnection();
			int listCount = cdao.getSearchTitleListCount(conn, searchText);
			close(conn);
			return listCount;
		}
		
		//제목으로검색
		public ArrayList<Complain> searchTitle(int startlist, int endlist, String searchText) {
			Connection conn = getConnection();
			ArrayList<Complain> clist = cdao.searchTitle(conn, startlist, endlist, searchText);
			close(conn);
			return clist;
		}
		//작성자로 검색시 목록 갯수
		public int getSearchUserNameListCount(String searchText) {
			Connection conn = getConnection();
			int listCount = cdao.getSearchUserNameListCount(conn, searchText);
			close(conn);
			return listCount;
		}

		//작성자로검색
		public ArrayList<Complain> searchUserName(int startlist, int endlist, String searchText) {
			Connection conn = getConnection();
			ArrayList<Complain> clist = cdao.searchUserName(conn, startlist, endlist, searchText);
			close(conn);
			return clist;
		}
		//관리자 답변작성/수정
 		public int updateAdminComplain(Complain comp) {
 			Connection conn = getConnection();
			int result =cdao.updateAdminComplain(conn, comp);
			if(result > 0)
				commit(conn);
			else
				rollback(conn);
			close(conn);
			return result;
		}

}
