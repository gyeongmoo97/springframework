package com.mycompany.webapp.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.mycompany.webapp.controller.Ch16Controller;
import com.mycompany.webapp.dao.Ch16AccountDao;
import com.mycompany.webapp.dto.Ch16Account;
import com.mycompany.webapp.exception.Ch16NotFoundAccoutException;

@Service
public class Ch16AccountService {
	private static final Logger logger = LoggerFactory.getLogger(Ch16AccountService.class);
	
	public enum TransferResult{
		SUCCESS,
		FAIL_NO_FOUND_ACCOUNT,
		FAIL_NO_ENOUGH_BALANCE,
		FAIL
		
	}
	
	@Resource
	private Ch16AccountDao accountDao;
	
	@Resource
	private TransactionTemplate transactionTemplate;
	
	public List<Ch16Account> getAccounts(){
		logger.info("실행");
		List<Ch16Account> accounts = accountDao.selectAll();
		return accounts;
	}
	
	//트랜젝션 처리 전혀 안된것.
	public TransferResult transfer1(int fromAno, int toAno, int amount) {
		logger.info("실행");
		
		String result = transactionTemplate.execute(new TransactionCallback<String>() {

			@Override
			public String doInTransaction(TransactionStatus status) {
				try {
					//출근하기
					Ch16Account fromAccount = accountDao.selectByAno(fromAno);
				
					fromAccount.setBalance(fromAccount.getBalance() -amount);
					accountDao.updateBalance(fromAccount);
					
					//예금하기
					Ch16Account toAccount = accountDao.selectByAno(toAno);
					toAccount.setBalance(toAccount.getBalance() +amount);
					accountDao.updateBalance(toAccount);
					return "success";
				} catch (Exception e) {
					status.setRollbackOnly();
					return "fail";
				}
			}
		});
		if(result.equals("success")) {
			return TransferResult.SUCCESS;
			//추가작업
		}else {
			return TransferResult.FAIL_NO_FOUND_ACCOUNT;
		}
	
	}
	
	// 어노테이션
	@Transactional
	public void transfer2(int fromAno, int toAno, int amount) {
		logger.info("실행");
		
		try {
			//출금하기
			Ch16Account fromAccount = accountDao.selectByAno(fromAno);
		
			fromAccount.setBalance(fromAccount.getBalance() -amount);
			accountDao.updateBalance(fromAccount);
			
			//예금하기
			Ch16Account toAccount = accountDao.selectByAno(toAno);
			toAccount.setBalance(toAccount.getBalance() +amount);
			accountDao.updateBalance(toAccount);
			
		} catch (Exception e) {
			throw new Ch16NotFoundAccoutException("계좌가 존재하지 않습니다");
		}
	}
//	
//	// 이렇게만하면 트렌젝션 안된거임
//	public void transfer2(int fromAno, int toAno, int amount) {
//		logger.info("실행");
//		
//		//출근하기
//		Ch16Account fromAccount = accountDao.selectByAno(fromAno);
//		
//		fromAccount.setBalance(fromAccount.getBalance() -amount);
//		accountDao.updateBalance(fromAccount);
//		
//		//예금하기
//		Ch16Account toAccount = accountDao.selectByAno(toAno);
//		toAccount.setBalance(toAccount.getBalance() +amount);
//		accountDao.updateBalance(toAccount);
//	}
	
}
