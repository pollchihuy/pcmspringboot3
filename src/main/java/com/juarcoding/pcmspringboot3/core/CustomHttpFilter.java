package com.juarcoding.pcmspringboot3.core;


import com.juarcoding.pcmspringboot3.config.JwtConfig;
import com.juarcoding.pcmspringboot3.security.Crypto;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class CustomHttpFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        // Inisialisasi filter jika diperlukan
        System.out.println("Filter initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String strContentType = request.getContentType()==null?"":request.getContentType();
        String token= ((HttpServletRequest) request).getHeader("Authorization");
        if(JwtConfig.getTokenEncryptEnable().equals("y")){
            token = Crypto.performDecrypt(token);
        }
        if(!strContentType.startsWith("multipart/form-data") || "".equals(strContentType)){
            request = new MyHttpServletRequestWrapper(httpRequest);
        }

        // Logika sebelum memproses request
        System.out.println("Request URI: " + httpRequest.getRequestURI());
        System.out.println("Request Method: " + httpRequest.getMethod());

        // Melanjutkan ke filter chain
        chain.doFilter(request, response);

        // Logika setelah memproses request
        System.out.println("Response sent");
    }

    @Override
    public void destroy() {
        // Logika cleanup jika diperlukan
        System.out.println("Filter destroyed");
    }
}
