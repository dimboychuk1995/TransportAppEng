<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">

var delereWorkType = function(id) {
        var msg   = $('#delete' + id).serialize();
    $.ajax({
        type: 'GET',
        url: 'workType/deleteType/' + id,
        data: msg,
    success: function(data) {
        $('#results').html(data); 
        var row = document.getElementById(id);
        var table = row.parentNode;
        while ( table && table.tagName != 'TABLE' )
            table = table.parentNode;
            if ( !table )
            return;
        table.deleteRow(row.rowIndex);
    },
    error:  function(xhr, str){
        alert('Помилка видалення даних: ' + xhr.responseCode);
    }
  });
}



</script>

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
			<form:form id = "delete${workType.id}"  action="javascript:void(null);" method="GET" onsubmit= "delereWorkType(${workType.id})" modelAttribute="" class="">
			<button id="" type="submit" class="">Delete</button>
			</form:form>
          </td>           
      </tr>
      </c:forEach>
    </tbody>
  </table>
  <a href=<c:url value="/workTypes/newWorkType" />>Create</a>
  
</div>
