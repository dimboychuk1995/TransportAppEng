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
        <p><b>Назва робіт</b>
          <form:input type="text" path="name" class="form-control" cssErrorClass="error form-control" />
          <form:errors path="name" class="help-block with-errors" cssErrorClass="" />
        </p>
        <p><b>Кількість люд/год.</b>
          <form:input type="text" path="count_hours" class="form-control" cssErrorClass="error form-control" />
          <form:errors path="count_hours" class="help-block with-errors" cssErrorClass="" />
        </p>
        <p><b>Заробітна плата</b>
          <form:input type="text" path="salary" class="form-control" cssErrorClass="error form-control" />
          <form:errors path="salary" class="help-block with-errors" cssErrorClass="" />
        </p>
        <p><b>Нарахування</b>
          <form:input type="text" path="social_insurance" class="form-control" cssErrorClass="error form-control" />
          <form:errors path="social_insurance" class="help-block with-errors" cssErrorClass="" />
        </p>
        <p><b>Загальні витрати</b>
          <form:input type="text" path="production_costs" class="form-control" cssErrorClass="error form-control" />
          <form:errors path="production_costs" class="help-block with-errors" cssErrorClass="" />
        </p>
        <p><b>Всього витрати</b>
          <form:input type="text" path="all_costs" class="form-control" cssErrorClass="error form-control" />
          <form:errors path="all_costs" class="help-block with-errors" cssErrorClass="" />
        </p>
        <p><b>Прибуток</b>
          <form:input type="text" path="profit" class="form-control" cssErrorClass="error form-control" />
          <form:errors path="profit" class="help-block with-errors" cssErrorClass="" />
        </p>
        <p><b>Разом</b>
          <form:input type="text" path="sum" class="form-control" cssErrorClass="error form-control" />
          <form:errors path="sum" class="help-block with-errors" cssErrorClass="" />
        </p>
        <p><b>Вартість матеріалів</b>
          <form:input type="text" path="cost_of_materials" class="form-control" cssErrorClass="error form-control" />
          <form:errors path="cost_of_materials" class="help-block with-errors" cssErrorClass="" />
        </p>
        <p><b>Відпускна вартість</b>
          <form:input type="text" path="selling_price" class="form-control" cssErrorClass="error form-control" />
          <form:errors path="selling_price" class="help-block with-errors" cssErrorClass="" />
        </p>
        <p><b>ПДВ</b>
          <form:input type="text" path="vat" class="form-control" cssErrorClass="error form-control" />
          <form:errors path="vat" class="help-block with-errors" cssErrorClass="" />
        </p>
        <p><b>Відпускна вартість з ПДВ</b>
          <form:input type="text" path="price_including_vat" class="form-control" cssErrorClass="error form-control" />
          <form:errors path="price_including_vat" class="help-block with-errors" cssErrorClass="" />
        </p>
        <button id="" type="submit" class="btn btn-success">Зберегти</button>
        <a href=<c:url value="/admin" /> class="btn btn-default">Повернутись на сторінку послуг</a>
      </form:form>
    </div>
  </div>
</div>