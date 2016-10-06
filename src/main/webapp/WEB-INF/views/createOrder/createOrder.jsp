<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>

<form:form action="" method="POST" modelAttribute="orders" class="">
    <fieldset>    
        <p><b>Вид робіт</b>
            <form:input type="text" path="workType.name" class="" cssErrorClass=""/>                
        </p>
        <p><b>Табельний номер</b>
            <form:input type="text" id = "" path="user_tab" class="" cssErrorClass=""/>                
        </p>
<!--         <p><b>Марка авто</b> -->
<%--             <form:input type="text" path="car.name" class="" cssErrorClass=""/>                 --%>
<!--         </p> -->
        <p><b>Модель</b>
            <form:input type="text" path="car_model" class="" cssErrorClass=""/>                
        </p>
        <p><b>Номер авто</b>
            <form:input type="text" id = "" path="car_number" class="" cssErrorClass=""/>                
        </p>
        <p><b>Дата</b>
            <form:input type="text" id = "datepicker" path="date" class="" cssErrorClass=""/>                
        </p>
        <p><b>Час</b>
            <form:input type="text" id = "timepicker" path="time" class="" cssErrorClass=""/>                
        </p>
        
        <button id="" type="submit" class="">Замовити</button>
    </fieldset>
</form:form>
<br>
    Список наших послуг
    
<div>
  <table>
    <thead>
      <tr>
        <th>Назва робіт</th>
        <th>Вартість з ПДВ</th>
      </tr>
    </thead>
    <tbody>
        <c:forEach items="${typeWorks}" var="workType">

        <tr id = "${workType.id}">
            <td>
              <c:out value="${workType.name}"></c:out>
            </td>
            <td>
              <c:out value="${workType.price_including_vat}"></c:out>
            </td>       
        </tr>
        </c:forEach>
    </tbody>
  </table>
</div>       
