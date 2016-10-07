<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div>
    <table>
        <thead>
            <tr>
            	<th>Замовник</th>
                <th>Табельний номер</th>
                <th>Вид робіт</th>
                <th>Дата</th>
                <th>Час</th>
                <th>Сума без ПДВ</th>
                <th>ПДВ</th>
                <th>Всього</th>
                <th>Підтвердити оплату</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${orders}" var="order">
                 <tr id="${order.id}">
                  	<td>
                        <c:out value="${order.customer}"></c:out>
                    </td>
                    <td>
                        <c:out value="${order.user_tab}"></c:out>
                    </td>
                    <td>
                        <c:out value="${order.workType.name}"></c:out>
                    </td>
                    <td>
                        <c:out value="${order.date}"></c:out>
                    </td>
                     <td>
                        <c:out value="${order.time}"></c:out>
                    </td>                   
                    <td>
                        <c:out value="${order.sum_vithput_pdv}"></c:out>
                    </td>
                    <td>
                        <c:out value="${order.pdv}"></c:out>
                    </td>
                    <td>
                        <c:out value="${order.all_sum}"></c:out>
                    </td>
                    <td>
                        <button id="${order.user_tab}" class="sendMessage">Підтвердити оплату</button>
                    </td>    
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" />


<!-- Main page script -->
<script src=<c:url value="/resources/js/cashier/cashier.js" />></script>
