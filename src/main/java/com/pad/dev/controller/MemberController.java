package com.pad.dev.controller;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.pad.dev.service.MemberService;
import com.pad.dev.vo.boardVO.BoardImgVO;
import com.pad.dev.vo.favVO.FavVO;
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
	private final MemberService ms;
	private final PasswordEncoder encoder;

	@PostMapping("/MyInfo")
	public List<MemberVO> getMyInfo(@RequestBody String memID) {
		log.info("MyInfo");
		List<MemberVO> myInfo = ms.getMyInfo(memID);
		return myInfo;
	}

	@PostMapping("/SignUp")
	public int SignUpMember(@RequestBody MemberVO memberVO) {
		log.info("SignUp");
		int result = ms.signUpMember(memberVO);
		return result;
	}

	@PostMapping("/SignIn")
	public MemberVO signInMember(@RequestBody MemberVO memberVO, HttpServletRequest request) {
		log.info("SignIn");
		HttpSession session = request.getSession(true);
		MemberVO checkMember = ms.signInMember(memberVO);
		String checkPassword = checkMember.getMemPW();
		if(encoder.matches(memberVO.getMemPW(), checkPassword)) {
			session.setAttribute("memID", memberVO.getMemID());
			log.info("Session memID: " + memberVO.getMemID());
			session.setMaxInactiveInterval(1800);
			return checkMember;
		} else return null;
	}

	@PostMapping("/Logout")
	public void logout(HttpServletRequest request) {
		log.info("Logout");
		HttpSession session = request.getSession(false);
		session.invalidate();
	}

	@PostMapping("/Update")
	public int updateMember(@RequestBody MemberVO memberVO, HttpServletRequest request) {
		log.info("Update");
		int result = 0;
		HttpSession session = request.getSession();
		memberVO.setMemID((String)session.getAttribute("memID"));
		result = ms.updateMember(memberVO);
		return result;
	}

	@PostMapping("/Delete")
	public int deleteMember(@RequestBody MemberVO memberVO) {
		log.info("Delete");
		int result = ms.deleteMember(memberVO);
		return result;
	}

	@PostMapping("/MyFavoriteCount")
	public int countMyFavorite(@RequestBody String memID) {
		int boardCount = ms.countMyFavorite(Integer.parseInt(memID));
		return boardCount;
	}

	@PostMapping("/MyFavorite")
	public List<BoardImgVO> showMyFavorite(HttpServletRequest request) {
		log.info("MyFavorite");
		HttpSession session = request.getSession();
		String memID = (String)session.getAttribute("memID");
		List<BoardImgVO> favoriteList = ms.showMyFavorite(memID);
		System.out.println("favoriteList: " + favoriteList);
		return favoriteList;
	}
	
	@PostMapping("/InsertFavorite")
	public int insertFavorite(@RequestBody FavVO favVO, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int result = 0;
		favVO.setMemID((String)session.getAttribute("memID"));
		result = ms.insertFavorite(favVO);
		return result;
	}
	
	
}
