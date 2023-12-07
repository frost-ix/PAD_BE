package com.pad.dev.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pad.dev.service.NoticeService;
import com.pad.dev.vo.notiVO.NotiVO;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notice")
public class NoticeController {
	private final NoticeService ns;

	@PostMapping("")
	public List<NotiVO> getNoticeList() {
		System.out.println("noti controller");
		List<NotiVO> noticeList = ns.getNoticeList();
		return noticeList;
	}
	
}
