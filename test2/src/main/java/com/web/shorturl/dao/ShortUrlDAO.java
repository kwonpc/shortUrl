package com.web.shorturl.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.web.shorturl.vo.ShortUrlVO;

@Repository
public class ShortUrlDAO {

	@Inject
	private SqlSession sqlSession;

	public ShortUrlVO getUrl(ShortUrlVO vo) {
		return sqlSession.selectOne("com.web.shorturl.mapper.shortUrl.getUrl", vo);
	}
	
	public ShortUrlVO getContext(ShortUrlVO vo){
		return sqlSession.selectOne("com.web.shorturl.mapper.shortUrl.getContext", vo);
	}

	public void insertUrl(ShortUrlVO vo) {
		sqlSession.insert("com.web.shorturl.mapper.shortUrl.insertUrl", vo);
	}
	
	public long updateContext(ShortUrlVO vo) {
		return sqlSession.update("com.web.shorturl.mapper.shortUrl.updateContext", vo);
	}
}
