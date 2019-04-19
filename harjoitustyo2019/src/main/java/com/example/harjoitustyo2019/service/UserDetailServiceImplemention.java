package com.example.harjoitustyo2019.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.harjoitustyo2019.model.User;
import com.example.harjoitustyo2019.repositories.UserRepository;
import com.example.harjoitustyo2019.model.Role;

import java.util.Set;
import java.util.HashSet;

@Service
public class UserDetailServiceImplemention implements UserDetailsService  {


	@Autowired
	private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
    	User user = userRepository.findByUsername(username);
    	if(user == null) throw new UsernameNotFoundException(username);
    	
    	Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
    	for (Role role : user.getRoles()) {
    		grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
    	}
    	
    	return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
} 