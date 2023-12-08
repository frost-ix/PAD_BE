package com.pad.dev.daoImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.pad.dev.vo.boardVO.BoardVO;
import com.pad.dev.vo.memberVO.MemberVO;
import com.pad.dev.dao.MemberDAO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private PasswordEncoder pwEncoder;

	private final SqlSession sqlSession;

	@Override
	public List<MemberVO> getMyInfo(String memID) {
		List<MemberVO> myInfo = null;
		try {
			myInfo = sqlSession.selectList("getMyInfo", memID);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return myInfo;
	}

	@Override
	public MemberVO signInMember(MemberVO memberVO) {
		try {
			MemberVO member = new MemberVO();
			member.setMemID(memberVO.getMemID());
			member.setMemPW(memberVO.getMemPW());
			member = sqlSession.selectOne("signInMember", memberVO);
			if (pwEncoder.matches(memberVO.getMemPW(), member.getMemPW())) {
				return member;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public int insertMember(MemberVO member) {
		int result = 0;
		System.out.println("memID: " + member.getMemID() + ", memPW: " + member.getMemPW() + ", memTel: "
				+ member.getMemTel() + "memMail: " + member.getMemMail() + member.getMemNN());
		try {
			member.setMemPW(pwEncoder.encode(member.getMemPW()));
			result = sqlSession.insert("insertMember", member);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	@Override
	public int updateMember(MemberVO member) {
		int result = 0;
		try {
			MemberVO memberVO = new MemberVO();
			memberVO.setMemID(member.getMemID());
			memberVO.setMemPW(member.getMemPW());
			memberVO.setNewPW(member.getNewPW());
			member.setNewPW(pwEncoder.encode(member.getNewPW()));
			result = sqlSession.update("updateMember", member);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	@Override
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
	public List<BoardVO> showMyBoard(String memID) {
		List<BoardVO> myBoard = null;
		try {
			myBoard = sqlSession.selectList("showMyBoard", memID);
		} catch (Exception e) {
			e.getMessage();
		}
		return myBoard;
	}
}
