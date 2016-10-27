<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<link rel="stylesheet" href=<c:url value="/resources/dist/css/order.css"/>>
<div class="container-fluid">
  	<div class="row">
    	<div class="col-md-12">
			<div class="table-responsive">
			    <table class="table table-hover table-bordered table-striped" id="orders">
			        <thead>
			            <tr>
			                <th class="col-md-2">Вид робіт</th>
			                <th class="col-md-1">Замовник</th>
			                <th class="col-md-1">Марка авто</th>
			                <th class="col-md-1">Модель</th>
			                <th class="col-md-1">Номер авто</th>
			                <th class="col-md-1">Дата</th>
			                <th class="col-md-1">Час</th>
			                <th class="col-md-1">Табельний номер</th>
			                <th class="col-md-1">Статус замовлення</th>
			                <th class="col-md-1">Редагувати</th>
			                <th class="col-md-1">Видалити</th>
			            </tr>
			        </thead>
			        <tbody>
			            <c:forEach items="${order}" var="orders">
			                <tr id="${orders.id}" class="dataRow">
			                    <td>
			                        <c:out value="${orders.workType.name}"></c:out>
			                    </td>
			                    <td>
			                        <c:out value="${orders.customer}"></c:out>
			                    </td>
			                    <td>
			                        <c:out value="${orders.car.name}"></c:out>               
			                    </td>
			                    <td>
			                        <c:out value="${orders.car_model}"></c:out>
			                    </td>    
			                    <td>
			                        <c:out value="${orders.car_number}"></c:out>
			                    </td>  
			                    <td>
			                        <c:out value="${orders.date}"></c:out>
			                    </td>
			                    <td>
			                        <c:out value="${orders.time}"></c:out>
			                    </td>
			                    <td>
			                        <c:out value="${orders.user_tab}"></c:out>
			                    </td>		
			                    <td>
			                        <c:out value="${orders.status_order.statusOrder}"></c:out>
			                    </td>
			                    <td class="no-padding">
			                        <a class="btn btn-primary col-md-12" href=<c:url value="/admin/order/${orders.id}"/>>Редагувати</a>
			                    </td>
			                    <td class="no-padding">
			                        <button id="${orders.id}" type="submit" class="btn btn-danger delete col-md-12">Видалити</button>
			                    </td>
			                </tr>
			            </c:forEach>
			        </tbody>
			    </table>
			    <div class="btns_bottom">	    
				    <a class="btn btn-primary" href=<c:url value="/admin"/>>Довідник послуг</a>
			    </div>
			</div>
		</div>
	</div>
</div>
<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" />

<p id="messageField"></p>

<!-- Main page script -->
<script src=<c:url value="/resources/js/order/order.js" />></script>
