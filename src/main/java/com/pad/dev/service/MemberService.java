package com.pad.dev.service;

import java.util.List;

import com.pad.dev.vo.boardVO.BoardVO;
import com.pad.dev.vo.memberVO.MemberVO;

public interface MemberService {
	List<MemberVO> getMyInfo(String memID);

	int insertMember(MemberVO member);

	int updateMember(MemberVO member);

	int deleteMember(MemberVO member);

	MemberVO signInMember(MemberVO memberVO);

	List<BoardVO> showMyBoard(String memID);
}
