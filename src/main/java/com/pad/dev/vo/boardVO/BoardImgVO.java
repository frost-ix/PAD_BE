package com.pad.dev.vo.boardVO;

import java.util.*;
import lombok.Data;

@Data
public class BoardImgVO {
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
}
