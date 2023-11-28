package com.pad.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
	@GetMapping("/member/?={memberID}")
	public String member() {
		return "member";
	}

	@PostMapping("/member")
	public String memberCreate() {
		return "memberCreate";
	}
}
