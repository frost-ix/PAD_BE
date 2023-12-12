package com.pad.dev.vo.boardVO;

import java.util.Date;

import lombok.Data;

@Data
public class BoardImgCateVO {
	// Board
	private int currentBoardID;
	private int boardID;
	private String boardTitle;
	private String boardContent;
	private Date modifyDate;
	private String bCateID;
	private String memID;

	// Img
	private int imgID;
	private String imageType;
	private String imagePath;

	// Cate
	private String cateID;
	private String cateName;
	private String cateRef;
}
