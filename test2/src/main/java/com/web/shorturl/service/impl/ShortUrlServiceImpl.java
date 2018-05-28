package com.web.shorturl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.shorturl.dao.ShortUrlDAO;
import com.web.shorturl.service.ShortUrlService;
import com.web.shorturl.util.CryptUtil;
import com.web.shorturl.util.DataUtil;
import com.web.shorturl.vo.ShortUrlVO;

@Service
public class ShortUrlServiceImpl implements ShortUrlService{
	
	@Autowired
	private ShortUrlDAO shorturlDao;

	@Override
	public ShortUrlVO getUrl(ShortUrlVO vo){
		return shorturlDao.getUrl(vo);
	}
	
	@Override
	public ShortUrlVO createUrl(ShortUrlVO vo){
		
		ShortUrlVO resVo = shorturlDao.getContext(vo);
				
		if(resVo==null){
			shorturlDao.insertUrl(vo);
			
			String currdate = DataUtil.getToday("yyMMdd");
			long seqNo = Integer.parseInt(currdate)*100000000L+vo.getSeqNo();
			
			vo.setContext(CryptUtil.encrypt(seqNo));
			shorturlDao.updateContext(vo);
		}else{
			return resVo;
		}

		return vo;
	}
	
}
