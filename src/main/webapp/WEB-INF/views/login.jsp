<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<div class="container">
  <div class="row">
    <div class="col-md-4 col-md-offset-4">
      <c:if test="${succes==true}">
        <div class="form-signin">
          <div class="login-title">
            Ви успішно увійшли до системи!
            <a href=<c:url value="/logout" /> class="btn btn-default col-md-4 col-md-offset-4">Вийти</a>
          </div>
        </div>
      </c:if>

      <c:if test="${succes!=true}">
        <div class="form-signin">
          <div class="login-title">
            <h3 class="">Будь ласка увійдіть до системи</h3>
            <c:if test="${not empty param.error}">
              <div class="alert alert-danger">
                Неправильний логін або пароль!
              </div>
            </c:if>

            <form role="" action="${pageContext.request.contextPath}/loginCheck" method="POST">
              <fieldset>
                <input class="form-control" type="text" name="username" placeholder="Введіть логін" autofocus>
                <input class="form-control pull-down" type="password" name="password" placeholder="Введіть пароль" value="">
                <input type="submit" class="btn btn-primary col-md-3" value="Увійти" />
              </fieldset>
            </form>
          </div>
        </div>
      </c:if>

    </div>
  </div>
</div>