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

    public List<BoardImgVO> showMyFavorite(String memID);

    public int countMyFavorite(int memID);

	public int insertFavorite(FavVO favVO);

}
