package com.pad.dev.vo.boardVO;

import java.util.ArrayList;
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
	private String cateID;
	private String memID;

	// Img
	private int imageID;
	private ArrayList<String> imagePath;

	// Cate
	private String cateName;
	private String cateRef;
}
