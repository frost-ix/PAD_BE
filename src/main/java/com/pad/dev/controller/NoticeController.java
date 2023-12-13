package com.pad.dev.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pad.dev.service.NoticeService;
import com.pad.dev.vo.notiVO.NotiVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/proxy/notice")
public class NoticeController {
	private final NoticeService ns;

	@PostMapping("mainNotice")
	public List<NotiVO> getNoticeList() {
		log.info("noti controller");
		return ns.getNoticeList();
	}
	
}
