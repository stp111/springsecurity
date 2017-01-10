package com.dcloud.service;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dcloud.dao.UserDAO;

/**
 * 实现UserDetailsService接口，自己处理spring security的authentication中的user处理
 * 
 * @author David T. Shen
 *
 */
@Service
public class CustomUserDetailService implements UserDetailsService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserDAO userDao;

	/**
	 * 实现UserDetailsService接口
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("loadUserByUsername {}",username);
		
		//
		com.dcloud.model.User user = userDao.findByName(username);
		if (null == user) {
			throw new UsernameNotFoundException("not find user with name " + username);
		}

		// TODO ... 获取该用户的role
		Collection<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<SimpleGrantedAuthority>();
		grantedAuthorities.add(new SimpleGrantedAuthority("admin"));
		grantedAuthorities.add(new SimpleGrantedAuthority("user"));
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		org.springframework.security.core.userdetails.User u = new org.springframework.security.core.userdetails.User(
				username, user.getPassword(), grantedAuthorities);
		UserDetails ud = (UserDetails) u;
		return ud;
	}

}
