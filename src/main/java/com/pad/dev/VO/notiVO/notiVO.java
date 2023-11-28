package com.pad.dev.VO.notiVO;

import java.util.Date;
import lombok.Data;

@Data
public class notiVO {
	private int notiID;
	private String notiTitle;
	private String notiContent;
	private Date notiRegDate;
}
