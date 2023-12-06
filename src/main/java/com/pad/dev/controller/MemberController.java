package com.pad.dev.controller;

import org.apache.ibatis.javassist.compiler.ast.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pad.dev.serviceImpl.BoardServiceImple;
import com.pad.dev.serviceImpl.MemberServiceImpl;
import com.pad.dev.vo.memberVO.MemberVO;

import lombok.RequiredArgsConstructor;

/***
 * <h1>Member Controller</h1>
 * <p>
 * This class is a controller class that handles member-related requests.
 * </p>
 */

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
	private final MemberServiceImpl ms;

	/***
	 * <h2>R : read one member's data</h2>
	 * 
	 * @author Frost-ix
	 * @apiNote
	 *          <p>
	 *          resource path : /member/{memberID}
	 *          </p>
	 * @param memID : One member's account id.
	 */
	@GetMapping("/{memID}")
	public MemberVO getMemberOne(@PathVariable String memID) {
		System.out.println("Get member one | " + memID);
		MemberVO member = ms.getMember(memID);
		return member;
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
		return member.getMemID();
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
