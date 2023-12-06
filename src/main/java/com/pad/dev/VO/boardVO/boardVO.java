package com.pad.dev.vo.boardVO;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private int boardID;
	private String boardtTitle;
	private String boardContent;
	private Date modifyDate;
	private String cateID;
	private String memID;

	// test
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private String hiredate;
	private int sal;
	private int comm;
	private int deptno;
}
