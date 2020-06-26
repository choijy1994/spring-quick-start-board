package com.springbook.biz.board.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
@Repository
public class BoardDAOJPA {
	@PersistenceContext
	private EntityManager em;
	
	public void insertBoard(BoardVO vo) {
		System.out.println("insertboard 기능");
		em.persist(vo);
	}
	public void updateBoard(BoardVO vo) {
		System.out.println("updateboard");
		em.merge(vo);
	}
	public void deleteBoard(BoardVO vo) {
		System.out.println("deleteBoard");
		em.remove(vo);
	}
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("getBoard");
		return (BoardVO)em.find(BoardVO.class,vo.getSeq());
	}
	public List<BoardVO>getBoardList(BoardVO vo){
		System.out.println("getboardlist");
		return em.createQuery("from BoardVO b order by b.seq desc").getResultList();
	}
}
