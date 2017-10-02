package com.itemsharing.authorizationserver.model;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority{
	private final String authority;
	
	public Authority(String authority) {
		this.authority = authority;
	}
	
	@Override
	public String getAuthority() {
		return authority;
	}
}
