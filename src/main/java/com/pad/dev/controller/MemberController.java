package com.pad.dev.controller;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	public int memberCreate(/* @RequestBody MemberVO memberVO */ @RequestParam String memID, @RequestParam String memPW, @RequestParam String memTel, @RequestParam String memMail, @RequestParam String memNN) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println("memID: " + memID + ", memPW: " + memPW + ", memTel: " + memTel + "memMail: " + memMail + ", memNN:" + memNN);
		MemberVO memberVO = new MemberVO();
		memberVO.setMemID(memID);
		String ecnodePW = encoder.encode(memPW);
		System.out.println(ecnodePW);
		memberVO.setMemPW(ecnodePW);
		memberVO.setMemTel(memTel);
		memberVO.setMemMail(memMail);
		memberVO.setMemNN(memNN);
		System.out.println(memberVO.getMemID() + ", encodePW: " + memberVO.getMemPW());
		
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
	public MemberVO signInMember(@RequestParam String memID, @RequestParam String memPW, HttpServletRequest request) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		MemberVO memberVO = new MemberVO();
		memberVO.setMemID(memID);
		memberVO.setMemPW(memPW);

		HttpSession session = request.getSession();
		MemberVO member = ms.signInMember(memberVO);
		System.out.println("dao갔다온 후 pw: " + member.getMemPW());

		if(member != null) session.setAttribute("Member", member);
		
		memPW = encoder.encode(memPW); // 로그인 시, 입력한 pw값을 인코딩
		
		boolean isVaild = false;
		if(memberVO != null) {
			// 입력한 pw값과 db의 pw값이 일치하는가
			isVaild = BCrypt.checkpw(memberVO.getMemPW(), memPW);
		}
		if(isVaild) {
			System.out.println("세션처리");
			return member;
		}
		return null;
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
