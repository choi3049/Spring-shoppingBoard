package com.sun.persistence;

import java.util.List;

import com.sun.domain.CategoryVO;

public interface AdminDAO {

	// 카테고리
	public List<CategoryVO> category() throws Exception;
}
