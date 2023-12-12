package com.pad.dev.serviceImpl;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pad.dev.vo.boardVO.BoardImgVO;
import com.pad.dev.vo.favVO.FavVO;
import com.pad.dev.vo.memberVO.MemberVO;
import com.pad.dev.dao.MemberDAO;
import com.pad.dev.service.MemberService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	private final MemberDAO md;
	private final PasswordEncoder encoder;

	public List<MemberVO> getMyInfo(String memID) {
		List<MemberVO> myInfo = md.getMyInfo(memID);
		return myInfo;
	}

	public int signUpMember(MemberVO memberVO) {
		memberVO.setMemPW(encoder.encode(memberVO.getMemPW()));
		int result = md.signUpMember(memberVO);
		return result;
	}

	public MemberVO signInMember(MemberVO memberVO) {
		MemberVO member = md.signInMember(memberVO);
		return member;
	}

	public int updateMember(MemberVO memberVO) {
		int result = 0;
		MemberVO checkMember = md.signInMember(memberVO);
		if(encoder.matches(memberVO.getMemPW(), checkMember.getMemPW())) {
			memberVO.setMemPW(checkMember.getMemPW());
			memberVO.setNewPW(encoder.encode(memberVO.getNewPW()));
			result = md.updateMember(memberVO);
		}
		return result;
	}

	public int deleteMember(MemberVO member) {
		int result = md.deleteMember(member);
		return result;
	}

    public List<BoardImgVO> showMyFavorite(String memID) {
        return md.showMyFavorite(memID);
    }

	@Override
	public int countMyFavorite(int memID) {
		int boardCount = md.countMyFavorite(memID);
		return boardCount;
	}

	@Override
	public int insertFavorite(FavVO favVO) {
		int result = md.insertFavorite(favVO);
		return result;
	}

}
