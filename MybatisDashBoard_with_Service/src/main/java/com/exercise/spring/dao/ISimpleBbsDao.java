package com.exercise.spring.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.exercise.spring.dto.SimpleBbsDto;

@Mapper
public interface ISimpleBbsDao {

	public List<SimpleBbsDto> listDao();
	public SimpleBbsDto viewDao(String id);
	public int writeDao(Map<String, String> map);
	public int deleteDao(@Param("_id") String id);
	public int articleCount();
	
}