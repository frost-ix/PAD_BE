package com.pad.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
	@GetMapping("/{memberID}")
	public String getMember() {
		return "member";
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
