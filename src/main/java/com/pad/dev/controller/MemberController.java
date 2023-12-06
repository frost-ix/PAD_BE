package com.pad.dev.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pad.dev.serviceImpl.MemberServiceImpl;
import com.pad.dev.vo.memberVO.MemberVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
	private final MemberServiceImpl ms;

	@GetMapping("/{memID}")
	public MemberVO getMemberOne(@PathVariable String memID) {
		System.out.println("Get member one | " + memID);
		MemberVO member = ms.getMember(memID);
		return member;
	}

	@GetMapping("")
	public String getMember() {
		MemberVO member = new MemberVO();
		member.setMemID("admin");
		return member.getMemID();
	}

	@GetMapping("/{memberID}/shortcut")
	public String getMemberShortcut() {
		return "memberShortcut";
	}

	@PostMapping("/signUp")
	public String memberCreate() {
		return "memberCreate";
	}
}
