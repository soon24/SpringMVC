package com.my.app.service.impl;

import java.util.List;
import java.util.Map;

import com.my.app.service.BoardVO;
import com.my.app.service.SearchVO;

public interface BoardDAO {
	 // 저장 처리
	public int insertBoard(BoardVO vo) throws Exception;
	
	// 화면 목록
	public List<?> selectBoardList(SearchVO param) throws Exception;  
	
	// TOTAL 갯수 얻기
	public int selectBoardTotal(SearchVO param) throws Exception; 
	
	// 상세화면
	public BoardVO selectBoardDetail(String param) throws Exception;

	// 조회수 증가
	public int updateBoardHits(String unq) throws Exception;
	
	// 수정 처리
	public int updateBoard(BoardVO vo) throws Exception;
	
	// 암호 확인
	public int selectBoardPass(BoardVO vo) throws Exception;
	
	// 삭제 처리
	public int deleteBoard(BoardVO vo) throws Exception;
	
}
