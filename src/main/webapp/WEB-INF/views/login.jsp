<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<link href="<c:url value = "/resources/dist/css/login/login.css" />" rel="stylesheet">

<div class="container-fluid">
  <div class="row">
    <div class="col-md-6 col-md-offset-4">
      <div class="col-md-8">
        <c:if test="${succes==true}">
          <div class="form-signin">
            <div class="login-title">
              <p><strong>Login successful!</strong></p>
              <p><a href=<c:url value="/logout" /> class="btn transparent">Logout</a></p>
            </div>
          </div>
        </c:if>

        <c:if test="${succes!=true}">
          <div class="form-signin">
            <div class="login-title">
              <h3>Login <please></please></h3>
            </div>
            <c:if test="${not empty param.error}">
              <div class="alert alert-danger">
                <strong>Wrong login or password!</strong>
              </div>
            </c:if>

            <form role="" action="${pageContext.request.contextPath}/loginCheck" method="POST">
              <fieldset>
                <input class="form-control" name="username" placeholder="Login" autofocus required>
                <input class="form-control pull-down" type="password" name="password" placeholder="Password" value="" required>
                <input type="submit" class="btn col-md-12 transparent" value="Login" />
              </fieldset>
            </form>
          </div>
        </c:if>
      </div>
    </div>
  </div>
</div>