package com.json.domain;

public class MenuDTO {
	private String marketName;
	private int menuId;
	private String menuName;
	private int menuPrice;
	private String introduce;	
	private String sysRegDate;
	

	public MenuDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public MenuDTO(String marketName, int menuId, String menuName, int menuPrice, String introduce,
			String sysRegDate) {
		super();
		this.marketName = marketName;
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.introduce = introduce;
		this.sysRegDate = sysRegDate;
	}


	public int getMenuId() {
		return menuId;
	}


	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}


	public String getMenuName() {
		return menuName;
	}


	public void setMenuName(String menuNanme) {
		this.menuName = menuNanme;
	}


	public String getMarketName() {
		return marketName;
	}


	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}


	public int getMenuPrice() {
		return menuPrice;
	}


	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}


	public String getIntroduce() {
		return introduce;
	}


	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}


	public String getSysRegDate() {
		return sysRegDate;
	}


	public void setSysRegDate(String sysRegDate) {
		this.sysRegDate = sysRegDate;
	}
	
	
	
	
}
