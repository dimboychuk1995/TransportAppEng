package com.oblenergo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ErrorHandlerFilter implements Filter {
  
  private final String pathToErrorJSP="/WEB-INF/views/error.jsp";

  @Override
  public void destroy() {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
      throws IOException, ServletException {

    try {
      filterChain.doFilter(request, response);
    } catch (Exception ex) {
      request.getRequestDispatcher(pathToErrorJSP).forward(request, response);
    }
  }

  @Override
  public void init(FilterConfig arg0) throws ServletException {
  }

}
