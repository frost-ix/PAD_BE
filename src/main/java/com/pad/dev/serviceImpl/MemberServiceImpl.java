package com.pad.dev.serviceImpl;

import org.springframework.stereotype.Service;

import com.pad.dev.vo.memberVO.MemberVO;
import com.pad.dev.dao.MemberDAO;
import com.pad.dev.service.MemberService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	private final MemberDAO md;

	public MemberVO getMember(String memID) {
		MemberVO member = md.getMember(memID);
		return member;
	}

	public int insertMember(MemberVO member) {
		int result = md.insertMember(member);
		return result;
	}

	public int updateMember(MemberVO member) {
		int result = md.updateMember(member);
		return result;
	}

	public int deleteMember(MemberVO member) {
		int result = md.deleteMember(member);
		return result;
	}

	public MemberVO signInMember(MemberVO member) {
		MemberVO result = md.signInMember(member);
		return result;
	}
}
