package com.pad.dev.controller;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

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
@Log4j2
@SessionAttributes("memID")
@RequestMapping("/proxy/member")
public class MemberController {
	private final MemberService ms;
	private final PasswordEncoder encoder;

	@PostMapping("/MyInfo")
	public List<MemberVO> getMyInfo(@RequestBody String memID) {
		log.info("MyInfo");
		return ms.getMyInfo(memID);
	}

	@PostMapping("/SignUp")
	public int SignUpMember(@RequestBody MemberVO memberVO) {
		log.info("SignUp");
		return ms.signUpMember(memberVO);
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
	public int updateMember(@RequestBody MemberVO memberVO, @ModelAttribute("memID") String memID) {
		log.info("Update");
		memberVO.setMemID(memID);
		return ms.updateMember(memberVO);
	}

	@PostMapping("/Delete")
	public int deleteMember(@RequestBody MemberVO memberVO) {
		log.info("Delete");
		return ms.deleteMember(memberVO);
	}

	@PostMapping("/MyFavoriteCount")
	public int countMyFavorite(@ModelAttribute("memID") String memID) {
		log.info("MyFavoriteBoard");
		return ms.countMyFavorite(memID);
	}

	@PostMapping("/MyFavorite")
	public List<BoardImgVO> showMyFavorite(@ModelAttribute("memID") String memID) {
		log.info("MyFavorite");
		return ms.showMyFavorite(memID);
	}
	
	@PostMapping("/InsertFavorite")
	public int insertFavorite(@RequestBody FavVO favVO, @ModelAttribute("memID") String memID) {
		log.info("InsertFavorite");
		favVO.setMemID(memID);
		return ms.insertFavorite(favVO);
	}
	
	
}
