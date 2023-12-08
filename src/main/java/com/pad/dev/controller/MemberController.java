package com.pad.dev.controller;

import java.util.List;

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

	// React Fetch
	@PostMapping("/SignUp")
	public int memberCreate(@RequestBody MemberVO memberVO, HttpServletRequest request) {
		int result = ms.insertMember(memberVO);
		if (result == 1) {
			log.info("{}님이 회원가입하셨습니다.", memberVO.getMemID());
		} else {
			log.info("회원가입에 실패하였습니다. <이미 있는 아이디>");
		}
		return result;
	}

	// Local Test
	// @PostMapping("/SignUp")
	// public int memberCreate(@RequestParam String memID, @RequestParam String
	// memPW, @RequestParam String memTel,
	// @RequestParam String memMail,
	// @RequestParam String memNN) {
	// BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	// System.out.println("memID: " + memID + ", memPW: " + memPW + ", memTel: " +
	// memTel + "memMail: " + memMail + ", memNN:" + memNN);
	// MemberVO memberVO = new MemberVO();
	// memberVO.setMemID(memID);
	// String ecnodePW = encoder.encode(memPW);
	// System.out.println(ecnodePW);
	// memberVO.setMemPW(ecnodePW);
	// memberVO.setMemTel(memTel);
	// memberVO.setMemMail(memMail);
	// memberVO.setMemNN(memNN);
	// System.out.println(memberVO.getMemID() + ", encodePW: " +
	// memberVO.getMemPW());
	// int result = ms.insertMember(memberVO);
	// return result;
	// }

	@PostMapping("/Update")
	public int updateMember(@RequestBody MemberVO member, HttpServletRequest request) {
		int result = ms.updateMember(member);
		log.info("{}님의 비밀번호가 수정되었습니다.", member.getMemID());
		return result;
	}

	// @PostMapping("/Update")
	// public int updateMember(@RequestParam String memID, @RequestParam String
	// memPW, @RequestParam String newPW) {
	// MemberVO memberVO = new MemberVO();
	// memberVO.setMemID(memID);
	// memberVO.setMemPW(memPW);
	// memberVO.setNewPW(newPW);
	// int result = ms.updateMember(memberVO);
	// return result;
	// }

	@PostMapping("/Delete")
	// @DeleteMapping("/Delete")
	public int deleteMember(@RequestBody MemberVO memberVO) {
		int result = ms.deleteMember(memberVO);
		log.info(memberVO.getMemID() + "님이 회원탈퇴하셨습니다.");
		return result;
	}

	@PostMapping("/SignIn")
	// public MemberVO signInMember(@RequestParam String memID, @RequestParam String
	// memPW, HttpServletRequest request) {
	public MemberVO signInMember(@RequestBody MemberVO member, HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberVO memberRes = ms.signInMember(member);
		if (memberRes != null) {
			session.setAttribute("Member", memberRes);
			log.info("{}님이 로그인하셨습니다.", memberRes.getMemID());
		} else {
			log.info("로그인에 실패하였습니다.");
		}
		return memberRes;
	}

	@PostMapping("/Logout")
	public void logout(HttpSession session) {
		MemberVO member = (MemberVO) session.getAttribute("Member");
		log.info("{}님이 로그아웃하셨습니다.", member.getMemID());
		session.invalidate();
	}

	@PostMapping("/ShowMyBoard")
	public List<BoardVO> showMyBoard(@RequestParam String memID) {
		List<BoardVO> myBoard = ms.showMyBoard(memID);
		System.out.println("myBoard: " + myBoard);
		return myBoard;
	}

}
