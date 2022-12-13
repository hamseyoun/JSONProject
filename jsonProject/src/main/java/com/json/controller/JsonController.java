package com.json.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.json.dao.JsonDAO;
import com.json.domain.MenuDTO;

@Controller
public class JsonController {
	
	@Autowired
	private JsonDAO dao;
	
	//DTO로 넘기기
	@RequestMapping(value="/jsonTest1", method=RequestMethod.GET)
	public void jsonTest1(HttpSession session) {
		System.out.println("jsonTest 진입");
		
		List<MenuDTO> menuList = dao.jsonTest1();
		//JSON은 key:value로 이루어진 형태이므로 JSON으로 변환해주기 전에 먼저 값을 Map형식으로 만들어줘야함!
		Map<Object, Object> map = new HashMap<Object, Object>();

		map.put("menuList0", menuList.get(0));
		map.put("menuList1", menuList.get(1));
		map.put("menuList2", menuList.get(2));
		map.put("menuList3", menuList.get(3));
		map.put("menuList4", menuList.get(4));
		
		//자바 map 형태{key=value}를 ---> json map 형태{key:value}로 변환
		JSONObject json = new JSONObject(map);
		String jsonMap = json.toString();
		
		
		session.setAttribute("menuList", menuList);
		session.setAttribute("jsonMap", jsonMap);		
	}
	
	
	//Map으로 넘기기
	@RequestMapping(value="/jsonTest2", method=RequestMethod.GET)
	public void jsonTest2(HttpSession session) {
		List<Map<Object,Object>> menuList = dao.jsonTest2();
		//JSON은 key:value로 이루어진 형태이므로 JSON으로 변환해주기 전에 먼저 값을 Map형식으로 만들어줘야함!
		Map<Object, Object> map = new HashMap<Object, Object>();
		for(int i=0 ; i<menuList.size() ; i++) {
			map.put("menuList"+i, menuList.get(i));
		}
		
		//자바 map 형태{key=value}를 ---> json map 형태{key:value}로 변환
		JSONObject json = new JSONObject(map);
		String jsonMap = json.toString();
		
		System.out.println("menuList: " + menuList);
		System.out.println("jsonMap: " + jsonMap);
		
		session.setAttribute("menuList", menuList);
		session.setAttribute("jsonMap", jsonMap);				
	}

	

	@RequestMapping(value="/menuUpdatePage1", method=RequestMethod.POST)
	public void menuUpadatePage1(@RequestBody List<Map<String, String>> menu, HttpSession session) {
		System.out.println("menuUpdatePage1 POST 진입");
		System.out.println("data list: " + menu);
		
		for(int i=0; i<menu.size() ; i++) {
			System.out.println("data" + i + ": " + menu.get(i));			
		}

	}
	
	
	
	@RequestMapping(value="/menuUpdatePage2", method=RequestMethod.POST)
	public void menuUpadatePage2(@RequestBody List<Map<Object,Object>> arr, HttpSession session) {
		System.out.println("menuUpdatePage2 POST 진입");
		
		//arr는 ajax에서 data에 실어보낸 List 
		System.out.println("data arr: " + arr);
		
		//list에 List의 0번째 값을 담음
		Map<Object, Object> list = arr.get(0);
		System.out.println("menuId: " + list);
		
		//list에서 key값이 "menuId"인것을 추출해서 숫자로 형변환하여 j에 담음
		Map<String,String> i = (Map<String, String>) list.get("menuId");
		int j = Integer.parseInt(i.get("menuId"))-1;
		
		//list에서 key값이 "menuList"인것을 추출하고, 여기서 j번째인 것을 추출
		List<Map<Object, Object>> l = (List<Map<Object, Object>>) list.get("menuList");
		Map<Object, Object> menu = l.get(j);
		System.out.println("========================================================");
		System.out.println(j + 1 +"번째 menu: " + menu);
		System.out.println("marketName: " + menu.get("marketName"));
		System.out.println("menuId: " + menu.get("menuId"));
		System.out.println("menuName: " + menu.get("menuName"));
		System.out.println("menuPrice: " + menu.get("menuPrice"));
		System.out.println("introduce: " + menu.get("introduce"));
		System.out.println("sysRegDate: " + menu.get("sysRegDate"));
	}
}
