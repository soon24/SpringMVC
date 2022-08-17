package com.my.app.service.impl;

import java.util.List;
import java.util.Map;

import com.my.app.service.BoardVO;

public interface BoardDAO {
	
	public int insertBoard(BoardVO vo) throws Exception;
	
	public List<?> selectBoardList(Map<String, Object> paramMap) throws Exception;
	
	public int selectBoardTotal(BoardVO vo) throws Exception;

}
