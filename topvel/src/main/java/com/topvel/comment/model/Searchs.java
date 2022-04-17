package com.topvel.comment.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Searchs extends PaginationInfo {
	
	private String searchType; //구분 값
	private String fundType; // 펀드 값
	private String searchWrd;  //검색 입력값
	
	private String searchUseAt;  //사용구분
	
	private String startDate;  //시작일자
	private String endDate;   //종료일자
	
	private String id;
	
	private String sortType;  //정렬조건
	
	private String subMenu;  //서브메뉴명	 
	private String menu;     //메뉴명

	public Searchs() {
		super();
	}
	
}
