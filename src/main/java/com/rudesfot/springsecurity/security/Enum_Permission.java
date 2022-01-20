package com.rudesfot.springsecurity.security;

public enum Enum_Permission {
	STUDENT_READ("student:read"),
	STUDENT_WRITE("student:write"),
	COURSE_READ("course:read"),
	COURSE_WRITE("course:write");
	
	private final String permission;
	
	Enum_Permission(String permission){
		this.permission = permission;
	}

	public String getPermission() {
		return permission;
	}
}
