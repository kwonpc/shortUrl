package com.web.shorturl.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.shorturl.service.ShortUrlService;
import com.web.shorturl.util.CryptUtil;
import com.web.shorturl.vo.ShortUrlVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ShortUrlController {
	
	@Autowired
	private ShortUrlService shortUrlService;
	
	private static final Logger logger = LoggerFactory.getLogger(ShortUrlController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/{context}", method = RequestMethod.GET)
	public String goUrl( Model model, HttpServletRequest request, @PathVariable("context") String context) {
		ShortUrlVO vo = new ShortUrlVO();
		vo.setContext(context);
		
		vo = shortUrlService.getUrl(vo);
		
		if(vo!=null){
			model.addAttribute("url", vo.getUrl());
		}
		
		return "goUrl";
		
	}	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( Model model, HttpServletRequest request) {

		return "home";
	}
	
	@RequestMapping(value = "/shorturl/generate", method = RequestMethod.POST)
	public String createUrl( Model model, HttpServletRequest request, ShortUrlVO vo) {
				
		vo = shortUrlService.createUrl(vo);
		
		model.addAttribute("VO", vo);
		return "createUrl";
	}
	
}
