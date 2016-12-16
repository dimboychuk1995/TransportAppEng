<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<div class="container-fluid">
  <div class="row">
    <h1 class="pull-down col-md-6">Створення нової послуги</h1>
  </div>
  <div class="row">
    <div class="col-md-4">
      <form:form action="" method="POST" modelAttribute="workType" class="form-group pull-down">

        <p><b>Введіть id послуги(З САП)</b>
          <form:input required="required" path="id" class="form-control" cssErrorClass="error form-control" />
          <form:errors path="id" class="help-block with-errors" cssErrorClass="" />
        </p>
        <button id="" type="submit" class="btn btn-success">Зберегти</button>
        <a href=<c:url value="/admin" /> class="btn btn-default">Повернутись на сторінку послуг</a>
      </form:form>
    </div>
  </div>
</div>