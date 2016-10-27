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
              <p><strong>Ви успішно увійшли до системи!</strong></p>
              <p><a href=<c:url value="/logout" /> class="btn transparent">Вийти</a></p>
            </div>
          </div>
        </c:if>

        <c:if test="${succes!=true}">
          <div class="form-signin">
            <div class="login-title">
              <h3>Будь ласка увійдіть до системи</h3>
            </div>
            <c:if test="${not empty param.error}">
              <div class="alert alert-danger">
                <strong>Неправильний логін або пароль!</strong>
              </div>
            </c:if>

            <form role="" action="${pageContext.request.contextPath}/loginCheck" method="POST">
              <fieldset>
                <input class="form-control" required="required" name="username" placeholder="Введіть логін" autofocus>
                <input class="form-control pull-down" type="password" name="password" placeholder="Введіть пароль" value="">
                <input type="submit" class="btn col-md-12 transparent" value="Увійти" />
              </fieldset>
            </form>
          </div>
        </c:if>
      </div>
    </div>
  </div>
</div>