package com.pad.dev.vo.boardImgCateVO;

import java.util.Date;

import lombok.Data;

@Data
public class boardImgCateVO {
    // Board
    private int boardID;
	private String boardtTitle;
	private String boardContent;
	private Date modifyDate;
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
