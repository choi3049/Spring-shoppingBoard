package com.sun.persistence;

import java.util.List;

import com.sun.domain.GoodsViewVO;
import com.sun.domain.ReplyListVO;
import com.sun.domain.ReplyVO;

public interface ShopDAO {

	// 카테고리별 상품 리스트 : 1차 분류
	public List<GoodsViewVO> list(int cateCode, int cateCodeRef) throws Exception;

	// 카테고리별 상품 리스트 : 2차 분류
	public List<GoodsViewVO> list(int cateCode) throws Exception;

	// 상품조회
	public GoodsViewVO goodsView(int gdsNum) throws Exception;

	// 상품 소감(댓글) 작성
	public void registReply(ReplyVO reply) throws Exception;

	// 상품 소감(댓글) 리스트
	public List<ReplyListVO> replyList(int gdsNum) throws Exception;

	// 상품 소감(댓글) 삭제
	public void deleteReply(ReplyVO reply) throws Exception;

	// 아이디 체크
	public String idCheck(int repNum) throws Exception;
	
	// 상품 소감(댓글) 수정
	public void modifyReply(ReplyVO reply) throws Exception;

}