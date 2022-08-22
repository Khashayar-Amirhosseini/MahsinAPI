package com.MahSinApi.controller.auth;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JwtAuthenticationFilter implements Filter {

        private static final java.util.logging.Logger LOG = Logger.getLogger( JwtAuthenticationFilter.class.getName() );

        private static final String AUTH_HEADER_KEY = "Authorization";
        private static final String AUTH_HEADER_VALUE_PREFIX = "Bearer "; // with trailing space to separate token

        private static final int STATUS_CODE_UNAUTHORIZED = 401;

        @Override
        public void init( FilterConfig filterConfig ) throws ServletException {
            LOG.info( "JwtAuthenticationFilter initialized" );
        }

        @Override
        public void doFilter( final ServletRequest servletRequest,
                              final ServletResponse servletResponse,
                              final FilterChain filterChain ) throws IOException, ServletException {
            HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
            boolean loggedIn = false;
            try {

                String jwt = getBearerToken( httpRequest );

                if ( jwt != null && !jwt.isEmpty() ) {
                   // httpRequest.login( jwt, "" );
                    loggedIn = true;
                    System.out.println("Logged in using JWT");
                    filterChain.doFilter( servletRequest, servletResponse );
                } else {
                    System.out.println("No JWT provided, go on unauthenticated");
                }



                if ( loggedIn ) {
                   // httpRequest.logout();
                    System.out.println("Logged out");
                }
            } catch ( final Exception e ) {
                LOG.log( Level.WARNING, "Failed logging in with security token", e );
                HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
                httpResponse.setContentLength( 0 );
                httpResponse.setStatus( STATUS_CODE_UNAUTHORIZED );
            }
        }

        @Override
        public void destroy() {
            LOG.info( "JwtAuthenticationFilter destroyed" );
        }

        /**
         * Get the bearer token from the HTTP request.
         * The token is in the HTTP request "Authorization" header in the form of: "Bearer [token]"
         */
        private String getBearerToken( HttpServletRequest request ) {
            String authHeader = request.getHeader( AUTH_HEADER_KEY );
            if ( authHeader != null && authHeader.startsWith( AUTH_HEADER_VALUE_PREFIX ) ) {
                return authHeader.substring( AUTH_HEADER_VALUE_PREFIX.length() );
            }
            return null;
        }
}

