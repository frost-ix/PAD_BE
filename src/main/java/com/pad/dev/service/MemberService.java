package com.pad.dev.service;

import com.pad.dev.vo.memberVO.MemberVO;

public interface MemberService {
	MemberVO getMember(String memID);

	int insertMember(MemberVO member);

	int updateMember(MemberVO member);

	int deleteMember(MemberVO member);

	MemberVO signInMember(MemberVO member);
}
