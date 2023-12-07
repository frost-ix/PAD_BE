package com.pad.dev.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pad.dev.vo.boardVO.BoardVO;
import com.pad.dev.vo.memberVO.MemberVO;
import com.pad.dev.dao.MemberDAO;
import com.pad.dev.service.MemberService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	private final MemberDAO md;

	public List<MemberVO> getMyInfo(String memID) {
		List<MemberVO> myInfo = md.getMyInfo(memID);
		return myInfo;
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

	public MemberVO signInMember(MemberVO memberVO) {
		MemberVO member = md.signInMember(memberVO);
		return member;
	}

	@Override
	public List<BoardVO> showMyBoard(String memID) {
		List<BoardVO> myBoard = md.showMyBoard(memID);
		return myBoard;
	}
}
