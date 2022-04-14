package com.topvel.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

	private String id;
	
	private String phone;
	
	private String name;
	
	private String nickname;
	
	private String password;
	
	private String email;
}
