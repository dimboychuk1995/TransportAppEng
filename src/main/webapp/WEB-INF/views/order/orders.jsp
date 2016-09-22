<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<div>
    <table>
        <thead>
            <tr>
                <th>id</th>
                <th>Вид робіт</th>
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
                <tr>
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
                        <a href=<c:url value="/orders/${orders.id}" />>Update</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

