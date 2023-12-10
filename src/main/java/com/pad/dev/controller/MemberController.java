package com.pad.dev.controller;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
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
	private final PasswordEncoder encoder;

	@PostMapping("/MyInfo")
	public List<MemberVO> getMyInfo(@RequestBody String memID) {
		List<MemberVO> myInfo = ms.getMyInfo(memID);
		return myInfo;
	}

	@PostMapping("/SignUp")
	public int memberCreate(@RequestBody MemberVO memberVO) {
		memberVO.setMemPW(encoder.encode(memberVO.getMemPW()));
		System.out.println(memberVO.getMemID() + ", encodePW: " + memberVO.getMemPW());
		int result = ms.insertMember(memberVO);
		return result;
	}

	@PostMapping("/SignIn")
	public MemberVO signInMember(@RequestBody MemberVO memberVO, HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberVO checkMember = ms.signInMember(memberVO);
		if(checkMember != null) session.setAttribute("Member", checkMember);
		
		if(encoder.matches(memberVO.getMemPW(), checkMember.getMemPW())) 
		return checkMember;
		else return null;
	}

	@PostMapping("/Logout")
	public void logout(HttpSession session) {
		session.invalidate();
	}

	@PostMapping("/Update")
	public int updateMember(@RequestBody MemberVO memberVO) {
		int result = 0;
		System.out.println(memberVO.toString());
		MemberVO checkMember = ms.signInMember(memberVO);
		if(encoder.matches(memberVO.getMemPW(), checkMember.getMemPW())) {
			memberVO.setMemPW(checkMember.getMemPW());
			memberVO.setNewPW(encoder.encode(memberVO.getNewPW()));
			result = ms.updateMember(memberVO);
		}
		return result;
	}

	@PostMapping("/Delete")
	public int deleteMember(@RequestBody MemberVO memberVO) {
		int result = ms.deleteMember(memberVO);
		return result;
	}

	@PostMapping("/ShowMyBoard")
	public List<BoardVO> showMyBoard(@RequestParam String memID) {
		List<BoardVO> myBoard = ms.showMyBoard(memID);
		System.out.println("myBoard: " + myBoard);
		return myBoard;
	}

}
