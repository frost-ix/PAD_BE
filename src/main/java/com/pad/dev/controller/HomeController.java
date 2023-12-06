package com.pad.dev.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pad.dev.VO.boardVO.BoardVO;
// import com.pad.dev.service.HomeService;
import com.pad.dev.service.HomeServiceImple;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
	private final HomeServiceImple hs;

	@RequestMapping(value = "/", method = { RequestMethod.GET })
	public String home() {
		System.out.println("Controller");
		List<BoardVO> boardList = hs.getBoardList();
		// System.out.println(boardList.toString());
		return "index";
	}
}
