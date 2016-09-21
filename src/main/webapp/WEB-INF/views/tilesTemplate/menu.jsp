<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<nav class="" role="navigation">
  <div class="">
    <div class="" id="">
      <ul class="">

        <sec:authorize access="isAuthenticated()">
          <li class="">
            <a href=<c:url value="/logout" />>Logout</a>
          </li>
        </sec:authorize>

        <sec:authorize access="isAnonymous()">
          <li class="">
            <a href=<c:url value="/login" />>Login</a>
          </li>
        </sec:authorize>

      </ul>
    </div>
  </div>
</nav>