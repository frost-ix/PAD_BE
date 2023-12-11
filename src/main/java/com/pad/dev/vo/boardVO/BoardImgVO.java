package com.pad.dev.vo.boardVO;

import java.util.Date;
import lombok.Data;

@Data
public class BoardImgVO {
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
}
