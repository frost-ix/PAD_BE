package com.pad.dev.dao;

import java.util.List;

import com.pad.dev.vo.boardVO.BoardImgVO;
import com.pad.dev.vo.favVO.FavVO;
import com.pad.dev.vo.memberVO.MemberVO;

public interface MemberDAO {
	public List<MemberVO> getMyInfo(String memID);

	public int signUpMember(MemberVO member);

	public int updateMember(MemberVO memberVO);

	public int deleteMember(MemberVO member);

	public MemberVO signInMember(MemberVO memberVO);

    public List<BoardImgVO> showMyFavorite(BoardImgVO boardImgVO);

    public int countMyFavorite(String memID);

	public int insertFavorite(FavVO favVO);

	public MemberVO getMemberSession(String memID);

}
