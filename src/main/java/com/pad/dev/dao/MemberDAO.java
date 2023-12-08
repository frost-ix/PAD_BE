package com.pad.dev.dao;

import java.util.List;

import com.pad.dev.vo.boardVO.BoardVO;
import com.pad.dev.vo.memberVO.MemberVO;

public interface MemberDAO {
	public List<MemberVO> getMyInfo(String memID);

	public int insertMember(MemberVO member);

	public int updateMember(MemberVO member);

	public int deleteMember(MemberVO member);

	public MemberVO signInMember(MemberVO memberVO);

    public List<BoardVO> showMyBoard(String memID);
}
