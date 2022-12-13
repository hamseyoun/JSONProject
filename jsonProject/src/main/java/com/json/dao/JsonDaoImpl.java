package com.json.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.json.domain.MenuDTO;

@Repository
public class JsonDaoImpl implements JsonDAO {

	@Override
	public List<MenuDTO> jsonTest1() {
		MenuDTO menu1 = new MenuDTO("교촌치킨", 1, "허니콤보순살", 21000, "살맛나는 꿀조합! 부드럽고 담백한 안심과 정육을 사용한 순살치킨과 달콤한 허니소스의 조화!", "2022-12-01");
		MenuDTO menu2 = new MenuDTO("교촌치킨", 2, "블랙시크릿콤보", 23000, "다섯가지 맛과 향을 내는 오향에 맛 간장과 청양고추를 더한 깊은 풍미로 날개와 다리를 함께 즐길 수 있는 메뉴", "2022-12-02");
		MenuDTO menu3 = new MenuDTO("교촌치킨", 3, "교촌윙", 19000, "마늘과 간장소스의 풍부한 맛이 묻어나는 날개와 봉의 멋진 조화 교촌윙", "2022-12-03");
		MenuDTO menu4 = new MenuDTO("교촌치킨", 4, "레드오리지날", 17000, "국내산 청양 홍고추의 매콤함이 일품인 한 마리 교촌레드오리지날", "2022-12-04");
		MenuDTO menu5 = new MenuDTO("교촌치킨", 5, "치즈트러플순살", 19000, "진한 치즈 맛과 깊은 풍미의 트러플 향이 조화로운 부드러운 순살 치킨", "2022-12-05");
		
		List<MenuDTO> dtoList = new ArrayList<MenuDTO>();
		dtoList.add(menu1);
		dtoList.add(menu2);
		dtoList.add(menu3);
		dtoList.add(menu4);
		dtoList.add(menu5);
		
		System.out.println("dtoList: " + dtoList);
		
		return dtoList;
	}
	
	
	@Override
	public List<Map<Object,Object>> jsonTest2() {
			
		List<Map<Object,Object>> menuList = new ArrayList<Map<Object,Object>>();
		
		Map<Object, Object> menuMap1 = new HashMap<Object, Object>();
		Map<Object, Object> menuMap2 = new HashMap<Object, Object>();
		Map<Object, Object> menuMap3 = new HashMap<Object, Object>();
		Map<Object, Object> menuMap4 = new HashMap<Object, Object>();
		Map<Object, Object> menuMap5 = new HashMap<Object, Object>();
		
		menuMap1.put("marketName", "교촌치킨");
		menuMap1.put("menuId", 1);
		menuMap1.put("menuName", "허니콤보순살");
		menuMap1.put("menuPrice", 21000);
		menuMap1.put("introduce", "살맛나는 꿀조합! 부드럽고 담백한 안심과 정육을 사용한 순살치킨과 달콤한 허니소스의 조화!");
		menuMap1.put("sysRegDate", "2022-12-01");
		menuList.add(menuMap1);

		menuMap2.put("marketName", "교촌치킨");
		menuMap2.put("menuId", 2);
		menuMap2.put("menuName", "블랙시크릿콤보");
		menuMap2.put("menuPrice", 23000);
		menuMap2.put("introduce", "다섯가지 맛과 향을 내는 오향에 맛 간장과 청양고추를 더한 깊은 풍미로 날개와 다리를 함께 즐길 수 있는 메뉴");
		menuMap2.put("sysRegDate", "2022-12-02");
		menuList.add(menuMap2);

		menuMap3.put("marketName", "교촌치킨");
		menuMap3.put("menuId", 3);
		menuMap3.put("menuName", "교촌윙");
		menuMap3.put("menuPrice", 19000);
		menuMap3.put("introduce", "마늘과 간장소스의 풍부한 맛이 묻어나는 날개와 봉의 멋진 조화 교촌윙");
		menuMap3.put("sysRegDate", "2022-12-03");
		menuList.add(menuMap3);

		menuMap4.put("marketName", "교촌치킨");
		menuMap4.put("menuId", 4);
		menuMap4.put("menuName", "레드오리지날");
		menuMap4.put("menuPrice", 17000);
		menuMap4.put("introduce", "국내산 청양 홍고추의 매콤함이 일품인 한 마리 교촌레드오리지날");
		menuMap4.put("sysRegDate", "2022-12-04");
		menuList.add(menuMap4);
		
		menuMap5.put("marketName", "교촌치킨");
		menuMap5.put("menuId", 5);
		menuMap5.put("menuName", "치즈트러플순살");
		menuMap5.put("menuPrice", 19000);
		menuMap5.put("introduce", "진한 치즈 맛과 깊은 풍미의 트러플 향이 조화로운 부드러운 순살 치킨");
		menuMap5.put("sysRegDate", "2022-12-05");
		menuList.add(menuMap5);
		
		return menuList;
	}

}
