package com.pad.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	@GetMapping("/board")
	public String board() {
		return "board";
	}

	@GetMapping("/board/?={boardID}")
	public String boardOne() {
		return "boardOne";
	}
}
