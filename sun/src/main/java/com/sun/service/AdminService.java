package com.sun.service;

import java.util.List;

import com.sun.domain.CategoryVO;

public interface AdminService {

	// 카테고리
	public List<CategoryVO> category() throws Exception;

}
