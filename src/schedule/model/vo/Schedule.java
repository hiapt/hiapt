package schedule.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Schedule implements Serializable {
	private static final long serialVersionUID = 1717L;
	private int schNo;
	private String schTitle;
	private String schType;
	private Date schStart;
	private Date schEnd;	
	private String schMemo;
	private String schOpen;
	private String schAlarm;
	private String schBgColor;
	private String importance;
	private String writer;
	
	public Schedule() {}

	public Schedule(int schNo, String schTitle, String schType, Date schStart, Date schEnd, String schMemo,
			String schOpen, String schAlarm, String schBgColor, String importance, String writer) {
		super();
		this.schNo = schNo;
		this.schTitle = schTitle;
		this.schType = schType;
		this.schStart = schStart;
		this.schEnd = schEnd;
		this.schMemo = schMemo;
		this.schOpen = schOpen;
		this.schAlarm = schAlarm;
		this.schBgColor = schBgColor;
		this.importance = importance;
		this.writer = writer;
	}

	public int getSchNo() {
		return schNo;
	}

	public void setSchNo(int schNo) {
		this.schNo = schNo;
	}

	public String getSchTitle() {
		return schTitle;
	}

	public void setSchTitle(String schTitle) {
		this.schTitle = schTitle;
	}

	public String getSchType() {
		return schType;
	}

	public void setSchType(String schType) {
		this.schType = schType;
	}

	public Date getSchStart() {
		return schStart;
	}

	public void setSchStart(Date schStart) {
		this.schStart = schStart;
	}

	public Date getSchEnd() {
		return schEnd;
	}

	public void setSchEnd(Date schEnd) {
		this.schEnd = schEnd;
	}

	public String getSchMemo() {
		return schMemo;
	}

	public void setSchMemo(String schMemo) {
		this.schMemo = schMemo;
	}

	public String getSchOpen() {
		return schOpen;
	}

	public void setSchOpen(String schOpen) {
		this.schOpen = schOpen;
	}

	public String getSchAlarm() {
		return schAlarm;
	}

	public void setSchAlarm(String schAlarm) {
		this.schAlarm = schAlarm;
	}

	public String getSchBgColor() {
		return schBgColor;
	}

	public void setSchBgColor(String schBgColor) {
		this.schBgColor = schBgColor;
	}

	public String getImportance() {
		return importance;
	}

	public void setImportance(String importance) {
		this.importance = importance;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "Schedule [schNo=" + schNo + ", schTitle=" + schTitle + ", schType=" + schType + ", schStart=" + schStart
				+ ", schEnd=" + schEnd + ", schMemo=" + schMemo + ", schOpen=" + schOpen + ", schAlarm=" + schAlarm
				+ ", schBgColor=" + schBgColor + ", importance=" + importance + ", writer=" + writer + "]";
	}
	
	
}
