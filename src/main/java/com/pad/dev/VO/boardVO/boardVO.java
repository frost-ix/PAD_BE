package com.pad.dev.VO.BoardVO;

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
}
