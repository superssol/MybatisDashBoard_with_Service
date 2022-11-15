package com.exercise.spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.spring.dao.ISimpleBbsDao;
import com.exercise.spring.dto.SimpleBbsDto;

@Service
public class SimpleBbsService implements ISimpleBbsService {

	@Autowired
	private ISimpleBbsDao dao;
	
	@Override
	public List<SimpleBbsDto> list() {
		return dao.listDao();
	}

	@Override
	public SimpleBbsDto view(String id) {
		return dao.viewDao(id);
	}

	@Override
	public int write(Map<String, String> map) {
		int nResult = dao.writeDao(map);
		return nResult;
	}

	@Override
	public int delete(String id) {
		int sResult = dao.deleteDao(id);
		return sResult;
	}

	@Override
	public int count() {
		int nTotalCount = dao.articleCount();
		return nTotalCount;
	}

}
