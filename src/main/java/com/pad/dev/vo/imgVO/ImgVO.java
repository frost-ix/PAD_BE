package com.pad.dev.vo.imgVO;

import java.util.ArrayList;
import lombok.Data;

@Data
public class ImgVO {
	private int imgID;
	private ArrayList<String> imagePath;
	private int boardID;
}
