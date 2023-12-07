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
			System.out.println(">> BoardDAO get section");
			member = sqlSession.selectOne("getMember", memID);
			System.out.println(">> select one query clear");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(member);
		return member;
	}

	public MemberVO signInMember(MemberVO member) {
		MemberVO result = null;
		try {
			System.out.println(">> BoardDAO sign in section");
			result = sqlSession.selectOne("signInMember", member);
			System.out.println(">> select one query clear");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public int insertMember(MemberVO member) {
		int result = 0;
		try {
			System.out.println(">> BoardDAO insert section");
			result = sqlSession.insert("insertMember", member);
			if (result == 1) {
				System.out.println(">> insert query clear");
			} else {
				System.out.println(">> insert query failed");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public int updateMember(MemberVO member) {
		int result = 0;
		try {
			System.out.println(">> BoardDAO update section");
			result = sqlSession.update("updateMember", member);
			if (result == 1) {
				System.out.println(">> update query clear");
			} else {
				System.out.println(">> update query failed");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public int deleteMember(MemberVO member) {
		int result = 0;
		try {
			System.out.println(">> BoardDAO delete section");
			result = sqlSession.delete("deleteMember", member);
			if (result == 1) {
				System.out.println(">> delete query clear");
			} else {
				System.out.println(">> delete query failed");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
}
