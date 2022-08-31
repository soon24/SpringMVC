package com.my.app.service.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.my.app.service.BoardVO;
import com.my.app.service.SearchVO;

public class BoardDAOImpl implements BoardDAO {
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);			
	private PlatformTransactionManager transactionManager;	
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public void setTemplate(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	@Override
	public int insertBoard(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
        int rtn_val =0;
		
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
		
    	try { 
    		rtn_val = sqlSession.insert("BoardSpace.insertBoard", vo);
    		
    		if (rtn_val > 0){
    			transactionManager.commit(status);
    			return 1;	
    		}else{
    			transactionManager.rollback(status);
    			return 9;
    		}        		         		        		
        }catch(Exception e){
        	System.out.println(e.toString());
          	transactionManager.rollback(status);                    
            return 9;
        }catch(Throwable e){
        	System.out.println(e.toString());
           	transactionManager.rollback(status);                    
            return 9;
        }
	}

	@Override
	public int selectBoardTotal(SearchVO param) throws Exception {
		// TODO Auto-generated method stub
		int resInt = 0;
		if (sqlSession.selectOne("BoardSpace.selectBoardTotal", param) != null) {
			resInt = sqlSession.selectOne("BoardSpace.selectBoardTotal", param);
		}
		return resInt;
	}

	@Override
	public List<?> selectBoardList(SearchVO param) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("BoardSpace.selectBoardList", param);
	}

	@Override
	public BoardVO selectBoardDetail(String param) throws Exception {
		// TODO Auto-generated method stub
		return (BoardVO) sqlSession.selectOne("BoardSpace.selectBoardDetail", param);
	}

	@Override
	public int updateBoardHits(String unq) throws Exception {
		// TODO Auto-generated method stub
        int rtn_val =0;
		
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
		
    	try { 
    		rtn_val = sqlSession.update("BoardSpace.updateBoardHits", unq);
    		
    		if (rtn_val > 0){
    			transactionManager.commit(status);
    			return 1;	
    		}else{
    			transactionManager.rollback(status);
    			return 9;
    		}        		         		        		
        }catch(Exception e){
        	System.out.println(e.toString());
          	transactionManager.rollback(status);                    
            return 9;
        }catch(Throwable e){
        	System.out.println(e.toString());
           	transactionManager.rollback(status);                    
            return 9;
        }
	}
}


