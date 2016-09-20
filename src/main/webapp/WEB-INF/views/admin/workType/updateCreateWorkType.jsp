<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div>
  <form:form action="" method="POST" modelAttribute="workType" class="">
    <fieldset>
    
     <p><b>Назва робіт</b>
        <form:input type="text" path="name" class="" cssErrorClass=""/>
      </p>
      <p><b>Кількість люд/год.</b>
        <form:input type="text" path="count_hours" class="" cssErrorClass="" />
      </p>
      <p><b>Заробітна плата</b>
        <form:input type="text" path="salary" class="" cssErrorClass="" />
      </p>
      <p><b>Нарахування</b>
        <form:input type="text" path="social_insurance" class="" cssErrorClass="" />
      </p>
      <p><b>Загальні витрати</b>
        <form:input type="text" path="production_costs" class="" cssErrorClass="" />
      </p>
      <p><b>Всього витрати</b>
        <form:input type="text" path="all_costs" class="" cssErrorClass="" />
      </p>
      <p><b>Прибуток</b>
        <form:input type="text" path="profit" class="" cssErrorClass="" />
      </p>
      <p><b>Разом</b>
        <form:input type="text" path="sum" class="" cssErrorClass="" />
      </p>
      <p><b>Вартість матеріалів</b>
        <form:input type="text" path="cost_of_materials" class="" cssErrorClass="" />
      </p>
      <p><b>Відпускна вартість</b>
        <form:input type="text" path="selling_price" class="" cssErrorClass="" />
      </p>
      <p><b>ПДВ</b>
        <form:input type="text" path="vat" class="" cssErrorClass="" />
      </p>
      <p><b>Вартість ПДВ</b>
        <form:input type="text" path="price_including_vat" class="" cssErrorClass="" />
      </p>
      <button id="" type="submit" class="">Save</button>
    </fieldset>
  </form:form>
</div>