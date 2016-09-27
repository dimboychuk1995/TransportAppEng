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
                <th>Виконавець</th>
                <th>Дата</th>
                <th>Час</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${order}" var="orders">
                <tr id="${orders.id}">
                    <td>
                        <c:out value="${orders.name_servise_id}"></c:out>
                    </td>
                    <td>
                        <c:out value="${orders.customer}"></c:out>
                    </td>
                    <td>
                        <c:out value="${orders.car_name_id}"></c:out>
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
                        <c:out value="${orders.performer_id}"></c:out>
                    </td>
                    <td>
                        <c:out value="${orders.date}"></c:out>
                    </td>
                    <td>
                        <c:out value="${orders.time}"></c:out>
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
    <a href=<c:url value="/"/>>workType</a>
</div>

