package com.sun.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sun.domain.CategoryVO;
import com.sun.persistence.AdminDAO;

@Service
public class AdminServiceImpl implements AdminService {

	@Inject
	private AdminDAO dao;

	// 카테고리
	@Override
	public List<CategoryVO> category() throws Exception {
		return dao.category();
	}

}