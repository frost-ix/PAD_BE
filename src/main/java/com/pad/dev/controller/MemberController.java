package com.pad.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pad.dev.VO.MemberVO.MemberVO;

/***
 * <h1>Member Controller</h1>
 * <p>
 * This class is a controller class that handles member-related requests.
 * </p>
 */
@Controller
@RequestMapping("/member")
public class MemberController {
	/***
	 * <h2>R : read one member's data</h2>
	 * 
	 * @author Frost-ix
	 * @apiNote
	 *          <p>
	 *          resource path : /member/{memberID}
	 *          </p>
	 * @param memberID : One member's account id.
	 */
	@GetMapping("/{memberID}")
	public String getMemberOne(String memberID) {
		return "member";
	}

	/***
	 * <h2>R : read all members' data</h2>
	 * 
	 * @apiNote
	 *          resource path : /member
	 * 
	 * @return
	 */
	@GetMapping("")
	public String getMember() {
		MemberVO member = new MemberVO();
		member.setMemID("admin");
		return "member";
	}

	/***
	 * <h2>R : read one member's shortcut</h2>
	 * 
	 * @author Frost-ix
	 * @apiNote
	 *          resource path : /member/{memberID}/shortcut
	 */
	@GetMapping("/{memberID}/shortcut")
	public String getMemberShortcut() {
		return "memberShortcut";
	}

	/***
	 * <h2>C : Create Member</h2>
	 * 
	 * @apiNote
	 *          resource path : /member/signUp
	 * 
	 * @return
	 */
	@PostMapping("/signUp")
	public String memberCreate() {
		return "memberCreate";
	}
}
