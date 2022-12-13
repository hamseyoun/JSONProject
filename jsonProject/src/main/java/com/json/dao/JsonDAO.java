package com.json.dao;

import java.util.List;
import java.util.Map;

import com.json.domain.MenuDTO;

public interface JsonDAO {
	
	//DTO로 넘기기
	public List<MenuDTO> jsonTest1();
		
	//Map으로 넘기기
	public List<Map<Object,Object>> jsonTest2();
	
}
