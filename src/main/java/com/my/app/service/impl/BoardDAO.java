package com.my.app.service.impl;

import java.util.List;
import java.util.Map;

import com.my.app.service.BoardVO;
import com.my.app.service.SearchVO;

public interface BoardDAO {
	
	public int insertBoard(BoardVO vo) throws Exception;
	
	public List<?> selectBoardList(SearchVO param) throws Exception;
	
	public int selectBoardTotal(SearchVO param) throws Exception;
	
	public BoardVO selectBoardDetail(String param) throws Exception;

	public int updateBoardHits(String unq) throws Exception;
	
}
