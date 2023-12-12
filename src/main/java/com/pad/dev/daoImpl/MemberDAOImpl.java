package com.pad.dev.daoImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.pad.dev.vo.boardVO.BoardImgVO;
import com.pad.dev.vo.memberVO.MemberVO;
import com.pad.dev.dao.MemberDAO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberDAOImpl implements MemberDAO {
	private final SqlSession sqlSession;

	public List<MemberVO> getMyInfo(String memID) {
		List<MemberVO> myInfo = null;
		try {
			myInfo = sqlSession.selectList("getMyInfo", memID);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return myInfo;
	}

	public MemberVO signInMember(MemberVO memberVO) {
		MemberVO member = null;
		try {
			member = sqlSession.selectOne("signInMember", memberVO);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return member;
	}

	public int signUpMember(MemberVO member) {
		int result = 0;
		try {
			result = sqlSession.insert("insertMember", member);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public int updateMember(MemberVO memberVO) {
		int result = 0;
		try {
			result = sqlSession.update("updateMember", memberVO);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public int deleteMember(MemberVO member) {
		int result = 0;
		try {
			result = sqlSession.delete("deleteMember", member);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	@Override
	public List<BoardImgVO> showMyFavorite(String memID) {
		List<BoardImgVO> favoriteList = null;
		
		return favoriteList;
	}

}
