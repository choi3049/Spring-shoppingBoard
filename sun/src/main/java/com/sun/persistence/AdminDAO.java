package com.sun.persistence;

import java.util.List;

import com.sun.domain.CategoryVO;
import com.sun.domain.GoodsVO;
import com.sun.domain.GoodsViewVO;


public interface AdminDAO {

	// 카테고리
	public List<CategoryVO> category() throws Exception;
	
	// 상품등록
	public void register(GoodsVO vo) throws Exception;
	
	// 상품목록
	public List<GoodsViewVO> goodslist() throws Exception;
	
	// 상품조회 + 카테고리 조인
	public GoodsViewVO goodsView(int gdsNum) throws Exception;
}
