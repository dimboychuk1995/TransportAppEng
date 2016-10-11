<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
  <div class="container-fluid">
      <ul class="nav navbar-nav">
        <li><img alt="no photo" class="logo" src="<c:url value="/resources/oblenergoLogo.png" />" >
        </li>
      </ul>
      
      <ul class="nav navbar-nav navbar-right">
        <sec:authorize access="isAuthenticated()">
          <li>  
            <a href=<c:url value="/logout" /> class="login-logout">
              <span class="glyphicon glyphicon-log-out login-logout" aria-hidden="true"></span> Вийти
            </a>   
          </li>
        </sec:authorize>

        <sec:authorize access="isAnonymous()">
          <li>
            <a href=<c:url value="/login" /> class="login-logout">
              <span class="glyphicon glyphicon-log-in login-logout" aria-hidden="true"></span> Увійти
            </a>
          </li>
        </sec:authorize>
      </ul>
    </div>

</nav>