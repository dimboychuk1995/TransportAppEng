<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div>
  <table>
    <thead>
      <tr>
        <th>Назва робіт</th>
        <th>Кількість люд/год.</th>
        <th>Заробітна плата</th>
        <th>Нарахування</th>
        <th>Загальні витрати</th>
        <th>Всього витрати</th>
        <th>Прибуток</th>
        <th>Разом</th>
        <th>Вартість матеріалів</th>
        <th>Відпускна вартість</th>
        <th>ПДВ</th>
        <th>Вартість ПДВ</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${typeWorks}" var="workType">
      
      <tr id = "${workType.id}">
          <td>
            <c:out value="${workType.name}"></c:out>
          </td>
          <td>
            <c:out value="${workType.count_hours}"></c:out>
          </td>
          <td>
            <c:out value="${workType.salary}"></c:out>
          </td>
          <td>
            <c:out value="${workType.social_insurance}"></c:out>
          </td>
          <td>
            <c:out value="${workType.production_costs}"></c:out>
          </td>
          <td>
            <c:out value="${workType.all_costs}"></c:out>
          </td>
          <td>
            <c:out value="${workType.profit}"></c:out>
          </td>
          <td>
            <c:out value="${workType.sum}"></c:out>
          </td>
          <td>
            <c:out value="${workType.cost_of_materials}"></c:out>
          </td>
          <td>
            <c:out value="${workType.selling_price}"></c:out>
          </td>
          <td>
            <c:out value="${workType.vat}"></c:out>
          </td>
          <td>
            <c:out value="${workType.price_including_vat}"></c:out>
          </td>
          <td>
            <a href=<c:url value="/workType/${workType.id}" />>Update</a>
          </td>
          <td>
			<button id="${workType.id}" class="delete">Delete</button>
          </td>           
      </tr>
      </c:forEach>
    </tbody>
  </table>
  <a href=<c:url value="/workTypes/newWorkType" />>Create</a>
  <a href=<c:url value="/order"/>>Order</a>
</div>

<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" />

<!-- Main page script -->
<script src=<c:url value="/resources/js/workType/workType.js" />></script>
