package com.egor.usersdb.security;

import com.egor.usersdb.entities.UsersEntity;
import com.egor.usersdb.repositories.UsersRepository;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UsersRepository repository;

    public UserDetailsServiceImpl(UsersRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersEntity user = repository.findByUserName(username);

        if (user == null) {
            throw new UsernameNotFoundException("User is not found!");
        }

        return new User(user.getUserName(), user.getPassword(),
                AuthorityUtils.createAuthorityList("ROLE_USER"));
    }
}
