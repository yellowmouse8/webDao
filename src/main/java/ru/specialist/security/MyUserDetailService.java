package ru.specialist.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.specialist.DAO.Course;
import ru.specialist.DAO.User;
import ru.specialist.DAO.UserRepository;

import java.util.Collection;
import java.util.HashSet;

@Component("MyUserDetailService")
public class MyUserDetailService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public void setContactService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new UserDetails() {
            private User u;

            {
                u = userRepository.findOne(username);
            }

            @Override
            public boolean isEnabled() {
                return (u != null) ? u.isEnabled() : false;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return isEnabled();
            }

            @Override
            public boolean isAccountNonLocked() {
                return isEnabled();
            }

            @Override
            public boolean isAccountNonExpired() {
                return isEnabled();
            }

            @Override
            public String getUsername() {
                return (u != null) ? u.getUsername() : null;
            }

            @Override
            public String getPassword() {
                return (u != null) ? u.getPassword() : null;
            }

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                Collection<GrantedAuthority> roles = new HashSet<>();
                roles.add(()-> "ROLE_USER");
                return roles;
            }
        };
    }
}

