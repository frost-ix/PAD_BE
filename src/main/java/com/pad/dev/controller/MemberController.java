package com.pad.dev.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pad.dev.serviceImpl.MemberServiceImpl;
import com.pad.dev.vo.memberVO.MemberVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
	private final MemberServiceImpl ms;

	/***
	 * <h2>R : read one member</h2>
	 * 
	 * @author Frost-ix
	 * @apiNote
	 *          <p>
	 *          resource path : /member/{memID}
	 *          </p>
	 * @param memID : One member's id (type : String).
	 * @return member (type : MemberVO)
	 */
	@GetMapping("/{memID}")
	public MemberVO getMemberOne(@PathVariable String memID) {
		System.out.println("Get member one | " + memID);
		MemberVO member = ms.getMember(memID);
		return member;
	}

	/***
	 * <h2>R : Checking member</h2>
	 * 
	 * @apiNote
	 *          <p>
	 *          resource path : /member/{member}
	 *          </p>
	 * @param memberVO : Member's id & pw (type : MemberVO :: RequestBody)
	 * @return member (type : MemberVO)
	 */
	@PostMapping("")
	public MemberVO signInMember(@RequestBody MemberVO memberVO) {
		System.out.println(">> Member sign in");
		MemberVO member = ms.signInMember(memberVO);
		return member;
	}

	@GetMapping("")
	public List<MemberVO> getMemberList() {
		List<MemberVO> memberList = null;
		return memberList;
	}

	@GetMapping("/{memberID}/shortcut")
	public String getMemberShortcut() {
		return "memberShortcut";
	}

	/***
	 * <h2>C : Create Member</h2>
	 * 
	 * @apiNote
	 *          <p>
	 *          resource path : /member/SignUp
	 *          </p>
	 * 
	 * @param memberVO (type : MemberVO :: RequestBody)
	 * @return result (type : int use like boolean)
	 */
	@PostMapping("/SignUp")
	public int memberCreate(@RequestBody MemberVO memberVO) {
		System.out.println(">> Member create");
		int result = ms.insertMember(memberVO);
		return result;
	}

	/***
	 * <h2>U : Update Member</h2>
	 * 
	 * @apiNote
	 *          <p>
	 *          resource path : /member/update
	 *          </p>
	 * 
	 * @param memberVO (type : MemberVO :: RequestBody)
	 * @return result (type : int use like boolean)
	 */
	@PostMapping("/Update")
	public int updateMember(@RequestBody MemberVO memberVO) {
		System.out.println(">> Member update");
		int result = ms.updateMember(memberVO);
		return result;
	}

	/***
	 * <h2>D : Delete Member</h2>
	 * 
	 * @apiNote
	 *          <p>
	 *          resource path : /member/delete
	 *          </p>
	 * 
	 * @param memberVO (type : MemberVO :: RequestBody)
	 * @return result (type : int use like boolean)
	 */
	@PostMapping("/Delete")
	public int deleteMember(@RequestBody MemberVO memberVO) {
		System.out.println(">> Member delete");
		int result = ms.deleteMember(memberVO);
		return result;
	}
}
