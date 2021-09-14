package com.mycompany.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.mycompany.webapp.dto.Ch14Member;

@Repository
public class Ch14MemberDao {
	private static final Logger logger = LoggerFactory.getLogger(Ch14MemberDao.class);

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	

	public int insert(Ch14Member member) {
		//member라는 메퍼를 찾아서 id가 insert 라는 sql 을 실행하라는 의미!!
		int row = sqlSessionTemplate.insert("member.insert", member);
		return row;
	}
	//매개변수에 들어간 게 parameterType return 해줘야하는게 returnType
	public Ch14Member selectByMid(String mid) {
		return sqlSessionTemplate.selectOne("member.selectByMid", mid);
	}
}
