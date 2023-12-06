package com.pad.dev.daoImpl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.pad.dev.vo.memberVO.MemberVO;
import com.pad.dev.dao.MemberDAO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberDAOImpl implements MemberDAO {
	private final SqlSession sqlSession;

	public MemberVO getMember(String memID) {
		MemberVO member = null;
		try {
			System.out.println(">> BoardDAO implements section");
			member = sqlSession.selectOne("getMember", memID);
			System.out.println(">> select one query clear");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(member);
		return member;
	}
}
