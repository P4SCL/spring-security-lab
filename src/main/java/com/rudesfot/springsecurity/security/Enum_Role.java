package com.rudesfot.springsecurity.security;

import static com.rudesfot.springsecurity.security.Enum_Permission.COURSE_READ;
import static com.rudesfot.springsecurity.security.Enum_Permission.COURSE_WRITE;
import static com.rudesfot.springsecurity.security.Enum_Permission.STUDENT_READ;
import static com.rudesfot.springsecurity.security.Enum_Permission.STUDENT_WRITE;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.google.common.collect.Sets;

public enum Enum_Role {
	STUDENT(Sets.newHashSet()),
	ADMIN(Sets.newHashSet(STUDENT_READ,STUDENT_WRITE,COURSE_READ,COURSE_WRITE)),
	ADMINTRAINEE(Sets.newHashSet(STUDENT_READ,COURSE_READ));
	
	private final Set<Enum_Permission> permissions;
	
	Enum_Role(Set<Enum_Permission> permissions){
		this.permissions = permissions;
	}

	public Set<Enum_Permission> getPermissions() {
		return permissions;
	}
	
	public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
		Set<SimpleGrantedAuthority> permisos = getPermissions().stream()
			.map(permiso -> new SimpleGrantedAuthority(permiso.getPermission()))
			.collect(Collectors.toSet());
			
		System.out.println("enum_role "+this);
		
		permisos.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
		
		return permisos;
		
	}
		
}
