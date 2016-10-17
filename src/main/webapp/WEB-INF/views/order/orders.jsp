<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<link rel="stylesheet" href=<c:url value="/resources/dist/css/order.css"/>>

<div>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Вид робіт</th>
                <th>Замовник</th>
                <th>Марка авто</th>
                <th>Модель</th>
                <th>Сума без ПДВ</th>
                <th>ПДВ</th>
                <th>Всього</th>
                <th>Дата</th>
                <th>Час</th>
                <th>Табельний номер</th>
                <th>Номер авто</th>
                <th>Статус замовлення</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${order}" var="orders">
                <tr id="${orders.id}">
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
                        <c:out value="${orders.workType.selling_price}"></c:out>
                    </td>
                    <td>
                        <c:out value="${orders.workType.vat}"></c:out>
                    </td>
                    <td>
                        <c:out value="${orders.workType.price_including_vat}"></c:out>
                    </td>
                    <td class="date_td">
                        <c:out value="${orders.date}"></c:out>
                    </td>
                    <td>
                        <c:out value="${orders.time}"></c:out>
                    </td>
                    <td>
                        <c:out value="${orders.user_tab}"></c:out>
                    </td>
                    <td>
                        <c:out value="${orders.car_number}"></c:out>
                    </td>
                    <td>
                        <c:out value="${orders.status_order.statusOrder}"></c:out>
                    </td>
                    <td>
                        <a class="btn btn-primary" href=<c:url value="/admin/order/${orders.id}"/>>Оновити</a>
                    </td>
                    <td>
                        <button id="${orders.id}" type="submit" class="btn btn-danger delete">Видалити замовлення</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="btns_bottom">	    
	    <a class="btn btn-primary" href=<c:url value="/admin"/>>Довідник послуг</a>
    </div>
</div>

<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" />

<p id="messageField"></p>

<!-- Main page script -->
<script src=<c:url value="/resources/js/order/order.js" />></script>
