package com.metallica.fsd.oauthserver;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 *
 * @author Mohammad yasir
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

    @Override
    public Authentication authenticate(Authentication a) throws AuthenticationException {
        final String username = a.getName();
        final String password = a.getCredentials().toString();
        
        if(!"yasir".equalsIgnoreCase(username)) {
            throw new BadCredentialsException("Username incorrect!");
        }
        
        if(!"abcd".equalsIgnoreCase(password)) {
            throw new BadCredentialsException("Password incorrect!");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("TEMP_USER"));
        
        final UserDetails principal = new User(username, password, authorities);
        return new UsernamePasswordAuthenticationToken(principal, password, authorities);
    }

    @Override
    public boolean supports(Class<?> type) {
        //return type.equals(UsernamePasswordAuthenticationToken.class);
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(type);
    }
    
}
