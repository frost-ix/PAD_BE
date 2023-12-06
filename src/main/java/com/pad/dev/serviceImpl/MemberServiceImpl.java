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
}
