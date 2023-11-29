package com.pad.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	@GetMapping("/{noticeID}")
	public String notice() {
		return "noticeOne";
	}

	@GetMapping("")
	public String noticeAll() {
		return "notice";
	}

}
