package com.pad.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	/***
	 * <h2>R : read one notice</h2>
	 * 
	 * @author Frost-ix
	 * @apiNote
	 *          <p>
	 *          resource path : /notice/{noticeID}
	 *          </p>
	 * 
	 * @param noticeID : One notice's article id.
	 */
	@GetMapping("/{noticeID}")
	public String notice(String noticeID) {
		return "noticeOne";
	}

	/***
	 * <h2>R : read all notices</h2>
	 * 
	 * @author Frost-ix
	 * @apiNote
	 *          resource path : /notice
	 */
	@GetMapping("")
	public String noticeAll() {
		return "notice";
	}

}
