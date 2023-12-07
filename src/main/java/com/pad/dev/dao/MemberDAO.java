package com.pad.dev.dao;

import com.pad.dev.vo.memberVO.MemberVO;

public interface MemberDAO {
	public MemberVO getMember(String memID);

	public int insertMember(MemberVO member);

	public int updateMember(MemberVO member);

	public int deleteMember(MemberVO member);

	public MemberVO signInMember(MemberVO member);
}
