package com.springbook.biz.board.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDAOMybatis {
	@Autowired(required=false)
	private SqlSessionTemplate mybatis;
 
	
	public void insertBoard(BoardVO vo) {
		System.out.println("insertboard 기능");
		mybatis.insert("BoardDAO.insertBoard",vo);
	}
	public void updateBoard(BoardVO vo) {
		System.out.println("updateboard");
		mybatis.update("BoardDAO.updateBoard",vo);
	}
	public void deleteBoard(BoardVO vo) {
		System.out.println("deleteBoard");
		mybatis.delete("BoardDAO.deleteBoard",vo);
	}
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("getBoard");
		return (BoardVO)mybatis.selectOne("BoardDAO.getBoard",vo);
	}
	public List<BoardVO>getBoardList(BoardVO vo){
		System.out.println("getboardlist");
		return mybatis.selectList("BoardDAO.getBoardList",vo);
	}
}
