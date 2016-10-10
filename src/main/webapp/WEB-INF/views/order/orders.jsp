<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<script src="/transportApp/resources/dist/js/jquery.min.js"></script>
<script type="text/javascript" src="/transportApp/resources/dist/js/jsonDeleteOrder.js"></script>

<div>
    <table>
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
                        <c:out value="${orders.sum_vithput_pdv}"></c:out>
                    </td>
                    <td>
                        <c:out value="${orders.pdv}"></c:out>
                    </td>
                    <td>
                        <c:out value="${orders.all_sum}"></c:out>
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
                        <c:out value="${orders.car_number}"></c:out>
                    </td>
                    <td>
                        <c:out value="${orders.status_order}"></c:out>
                    </td>
                    <td>
                        <a href=<c:url value="/order/${orders.id}" />>Update</a>
                    </td>
                    <td>
                        <form:form id="delete${orders.id}" action="javascript:void(null)" method="GET" onsubmit="deleteOrder(${orders.id})" modelAttribute="" class="">
                            <button id="" type="submit" class="">Delete</button>
                        </form:form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <a href=<c:url value="/order/newOrder" />>Create</a>
    <a href=<c:url value="/admin"/>>workType</a>
</div>

<div>
<button id="sendMessage">Send</button>
<button id="estConnection">Connect</button>
<button id="disConnection">Disconnect</button>
</div>

<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" />

<p id="messageField"></p>

<!-- Main page script -->
<script src=<c:url value="/resources/js/admin/admin.js" />></script>

