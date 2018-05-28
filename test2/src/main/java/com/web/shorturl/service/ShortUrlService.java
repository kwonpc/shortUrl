package com.web.shorturl.service;

import com.web.shorturl.vo.ShortUrlVO;

public interface ShortUrlService{
	
	public ShortUrlVO getUrl(ShortUrlVO vo);
		
	public ShortUrlVO createUrl(ShortUrlVO vo);

}
