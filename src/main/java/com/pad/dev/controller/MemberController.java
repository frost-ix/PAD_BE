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

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
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
	public List<MemberVO> signInMember(@RequestParam String memID, @RequestParam String memPW, HttpServletRequest request) {
		// 세션 생성
		MemberVO memberVO = new MemberVO();
		memberVO.setMemID(memID);
		memberVO.setMemPW(memPW);
		System.out.println("id, pw: " + memberVO.getMemID() + ", " + memberVO.getMemPW());
		HttpSession session = request.getSession();
		System.out.println("session: " + session);
		List<MemberVO> member = ms.signInMember(memberVO);
		if(member != null) session.setAttribute("Member", member);
		return member;
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
