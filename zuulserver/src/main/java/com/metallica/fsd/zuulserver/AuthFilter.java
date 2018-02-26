/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metallica.fsd.zuulserver;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author Mohammad yasir
 */
public class AuthFilter extends ZuulFilter{

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        return ctx.getRequest().getRequestURI().startsWith("/auth");
    }

    @Override
    public Object run() {
        try {
            String credential = "Basic "+Base64.encodeBase64String(("metallica:H$!78@ghy").getBytes("UTF-8"));
            System.out.println("com.metallica.fsd.zuulserver.AuthFilter.run(): "+credential);
            RequestContext ctx = RequestContext.getCurrentContext();
            ctx.addZuulRequestHeader("Authorization", credential);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(AuthFilter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
