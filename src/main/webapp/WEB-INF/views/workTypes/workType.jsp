<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div class="container-fluid">
<div class="row">
<div class="col-md-12">
<div class="table-responsive">
  <table id="workTypes" class="table table-hover table-striped table-bordered">
    <thead>
      <tr>
        <th class="col-md-4">Назва робіт</th>
        <th class="col-md-1">Кількість люд/год.</th>
        <th class="col-md-1">Заробітна плата</th>
        <th class="col-md-1">Нарахування</th>
        <th class="col-md-1">Загальні витрати</th>
        <th class="col-md-1">Всього витрати</th>
        <th class="col-md-1">Прибуток</th>
        <th class="col-md-1">Разом</th>
        <th class="col-md-1">Вартість матеріалів</th>
        <th class="col-md-1">Відпускна вартість</th>
        <th class="col-md-1">ПДВ</th>
        <th class="col-md-1">Вартість ПДВ</th>
        <th class="col-md-1">Редагувати</th>
        <th class="col-md-1">Видалити</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${typeWorks}" var="workType">
      <tr id = "${workType.id}" class="dataRow">
          <td class="no-vertical-padding">
            <c:out value="${workType.name}"></c:out>
          </td>
          <td class="no-vertical-padding">
            <c:out value="${workType.count_hours}"></c:out>
          </td>
          <td class="no-vertical-padding">
            <c:out value="${workType.salary}"></c:out>
          </td>
          <td class="no-vertical-padding">
            <c:out value="${workType.social_insurance}"></c:out>
          </td>
          <td class="no-vertical-padding">
            <c:out value="${workType.production_costs}"></c:out>
          </td>
          <td class="no-verical-padding">
            <c:out value="${workType.all_costs}"></c:out>
          </td>
          <td class="no-vertical-padding">
            <c:out value="${workType.profit}"></c:out>
          </td>
          <td class="no-vertical-padding">
            <c:out value="${workType.sum}"></c:out>
          </td>
          <td class="no-vertical-padding">
            <c:out value="${workType.cost_of_materials}"></c:out>
          </td>
          <td class="no-vertical-padding">
            <c:out value="${workType.selling_price}"></c:out>
          </td>
          <td class="no-vertical-padding">
            <c:out value="${workType.vat}"></c:out>
          </td>
          <td class="no-vertical-padding">
            <c:out value="${workType.price_including_vat}"></c:out>
          </td>
          <td class="no-padding">
            <a href=<c:url value="/admin/workType/${workType.id}" /> class="btn btn-primary">Редагувати</a>
          </td>
          <td class="no-padding">
			<button id="${workType.id}" class="btn btn-danger delete">Видалити</button>
          </td>           
      </tr>
      </c:forEach>
    </tbody>
  </table>
  </div>
  <a href=<c:url value="/admin/workType/newWorkType"/> class="btn btn-primary">Створити нову послугу</a>
  <a href=<c:url value="/admin/order"/> class="btn btn-info">Список замовлень</a>

</div>
</div>
</div>
<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" />

<!-- Main page script -->
<script src=<c:url value="/resources/js/workType/workType.js" />></script>
