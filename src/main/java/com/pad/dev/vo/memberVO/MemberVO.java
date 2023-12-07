package com.pad.dev.vo.memberVO;

import lombok.Data;

@Data
public class MemberVO {
	private String memID;
	private String memPW;
	private String memNN;
	private String memTel;
	private String memMail;

	// 변경할 비밀번호를 담을 변수
	private String newPW;
}
