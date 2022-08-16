package com.my.app.service.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.my.app.service.BoardVO;

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

}


