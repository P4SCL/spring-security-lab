package com.rudesfot.springsecurity.security;

import java.util.Set;

import com.google.common.collect.Sets;
import static com.rudesfot.springsecurity.security.Enum_Permission.*;

public enum Enum_Role {
	STUDENT(Sets.newHashSet()),
	ADMIN(Sets.newHashSet(STUDENT_READ,STUDENT_WRITE,COURSE_READ,COURSE_WRITE));
	
	private final Set<Enum_Permission> permissions;
	
	Enum_Role(Set<Enum_Permission> permissions){
		this.permissions = permissions;
	}

	public Set<Enum_Permission> getPermissions() {
		return permissions;
	}
		
}
