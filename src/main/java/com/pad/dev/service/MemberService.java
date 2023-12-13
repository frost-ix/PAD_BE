package com.pad.dev.service;

import java.util.List;

import com.pad.dev.vo.boardVO.BoardImgVO;
import com.pad.dev.vo.favVO.FavVO;
import com.pad.dev.vo.memberVO.MemberVO;

public interface MemberService {
	List<MemberVO> getMyInfo(String memID);

	int signUpMember(MemberVO member);

	int updateMember(MemberVO memberVO);

	int deleteMember(MemberVO member);

	MemberVO signInMember(MemberVO memberVO);

	List<BoardImgVO> showMyFavorite(String memID);

    int countMyFavorite(String memID);

	int insertFavorite(FavVO favVO);
}
