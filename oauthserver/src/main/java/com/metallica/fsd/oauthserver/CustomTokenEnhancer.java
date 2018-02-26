package com.metallica.fsd.oauthserver;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mohammad yasir
 */
public class CustomTokenEnhancer implements TokenEnhancer{

    public OAuth2AccessToken enhance(OAuth2AccessToken oaat, OAuth2Authentication oaa) {
        Map<String, Object> additionalInfo = new HashMap<>();
        Collection<GrantedAuthority> authorities = oaa.getAuthorities();
        Object [] authoritiesArray = authorities.toArray();
        SimpleGrantedAuthority simpleGrantedAuthority = (SimpleGrantedAuthority) authoritiesArray[0];
        String role = simpleGrantedAuthority.getAuthority();
        additionalInfo.put("role", role);
        ((DefaultOAuth2AccessToken)oaat).setAdditionalInformation(additionalInfo);
        return oaat;
    }
    
}
