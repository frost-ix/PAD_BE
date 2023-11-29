package com.pad.dev.VO.NotiVO;

import java.util.Date;
import lombok.Data;

@Data
public class NotiVO {
	private int notiID;
	private String notiTitle;
	private String notiContent;
	private Date notiRegDate;
}
