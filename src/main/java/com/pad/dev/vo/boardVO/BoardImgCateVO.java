package com.pad.dev.vo.boardVO;

import java.util.List;
import java.util.Date;

import com.pad.dev.vo.imgVO.ImgVO;

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

	private int start;
	private int end;

	// Img
	private int imageID;
	private String imagePath;
	private List<ImgVO> imageVO;

	// Cate
	private String cateName;
	private String cateRef;
}
