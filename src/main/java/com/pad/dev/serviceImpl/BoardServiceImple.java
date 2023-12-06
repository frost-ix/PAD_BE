package com.pad.dev.serviceImpl;

import java.util.List;

import org.apache.ibatis.javassist.compiler.ast.Member;
import org.springframework.stereotype.Service;

import com.pad.dev.dao.BoardDAO;
import com.pad.dev.service.BoardService;
import com.pad.dev.vo.boardVO.BoardVO;
import com.pad.dev.vo.memberVO.MemberVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImple implements BoardService {
	private final BoardDAO bm;

	public List<BoardVO> getBoardList() {
		System.out.println("Service");
		List<BoardVO> boardList = bm.getBoardList();
		return boardList;
	}
}
