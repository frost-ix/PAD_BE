package com.pad.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pad.dev.service.HomeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {

	private final HomeService hs;

	@RequestMapping(value = "/", method = { RequestMethod.GET })
	public String home() {
		return "index";
	}
}
