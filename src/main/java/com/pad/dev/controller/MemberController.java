package com.pad.dev.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pad.dev.serviceImpl.MemberServiceImpl;
import com.pad.dev.vo.boardVO.BoardVO;
import com.pad.dev.vo.memberVO.MemberVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@RequestMapping("/proxy/member")
@Log4j2
public class MemberController {
	private final MemberServiceImpl ms;

	@PostMapping("/MyInfo")
	public List<MemberVO> getMyInfo(@PathVariable String memID) {
		List<MemberVO> myInfo = ms.getMyInfo(memID);
		return myInfo;
	}

	@PostMapping("/SignUp")
	public int memberCreate(@RequestBody MemberVO memberVO) {
		int result = ms.insertMember(memberVO);
		return result;
	}

	@PostMapping("/Update")
	public int updateMember(@RequestParam String memID, @RequestParam String memPW, @RequestParam String newPW) {
		MemberVO memberVO = new MemberVO();
		memberVO.setMemID(memID);
		memberVO.setMemPW(memPW);
		memberVO.setNewPW(newPW);
		int result = ms.updateMember(memberVO);
		return result;
	}

	@PostMapping("/Delete")
	public int deleteMember(@RequestBody MemberVO memberVO) {
		int result = ms.deleteMember(memberVO);
		return result;
	}

	@PostMapping("/SignIn")
	public MemberVO signInMember(@RequestBody MemberVO member, HttpServletRequest request) {
		// 세션 생성
		MemberVO memberVO = new MemberVO();
		memberVO.setMemID(member.getMemID());
		memberVO.setMemPW(member.getMemPW());
		System.out.println("id, pw: " + memberVO.getMemID() + ", " + memberVO.getMemPW());
		HttpSession session = request.getSession();
		System.out.println("session: " + session);
		MemberVO memberRes = ms.signInMember(memberVO);
		log.info("Member : " + memberRes.getMemID() + " + " + memberRes.getMemPW());
		if (memberRes != null)
			session.setAttribute("Member", memberRes);
		return memberRes;
	}

	@PostMapping("/Logout")
	public void logout(HttpSession session) {
		session.invalidate();
	}

	@PostMapping("/ShowMyBoard")
	public List<BoardVO> showMyBoard(@RequestParam String memID) {
		List<BoardVO> myBoard = ms.showMyBoard(memID);
		System.out.println("myBoard: " + myBoard);
		return myBoard;
	}

}
