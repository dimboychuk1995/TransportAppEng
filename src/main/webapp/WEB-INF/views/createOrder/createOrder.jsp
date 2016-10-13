<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<link rel="stylesheet" href=<c:url value="/resources/dist/css/userOrder.css"/>>

<!DOCTYPE html>

<form:form action="" method="POST" modelAttribute="orders" class="">
    <fieldset>    
        <p class="option_in_new_order"><b>Вид робіт</b>
            <form:select path="workType.id" items="${typeWorks}" class=""
                    data-placeholder="work"
                    itemLabel="name" itemValue="id" />               
        </p>
        <p class="option_in_new_order"><b>Табельний номер</b>
            <form:input type="text" id = "" path="user_tab" class="" cssErrorClass=""/>
            <form:errors path="user_tab" class="" cssErrorClass="" />                
        </p>
        <p class="option_in_new_order"><b>Марка авто</b>
            <form:select path="car.id" items="${cars}" class=""
                    data-placeholder="cars"
                    itemLabel="name" itemValue="id" />               
        </p>
        <p class="option_in_new_order"><b>Модель</b>
            <form:input type="text" path="car_model" class="" cssErrorClass=""/> 
            <form:errors path="car_model" class="" cssErrorClass="" />                
        </p>
        <p class="option_in_new_order"><b>Номер авто</b>
            <form:input type="text" id = "" path="car_number" class="" cssErrorClass=""/>   
            <form:errors path="car_number" class="" cssErrorClass="" />               
        </p>
        <p id ="datePicker" class="option_in_new_order" ><b>Дата</b>
           	<form:input id = "dpicker" type="text" path="date" class="date start" cssErrorClass=""/>
           	<form:errors path="date" class="" cssErrorClass="" />
           	
           	<input  type="hidden" class="" id = "butShow">
           	
           
            <form:select id="selectForm" path="time" class="" />
    
           
<!--            	<select id ="selectTime" style="" hidden="true"> -->
<!--            		<option disabled>виберіть час</option> -->
<!--            	</select> -->
 		</p>
        <button id="" type="submit" class="btn btn-lg btn-primary btn_create_order">Замовити</button>
    </fieldset>
</form:form>
<br>


<div class="container">
    <h3>Список наших послуг</h3>
    
	<div class="table-responsive">
	  <table class="table_on_main_view table table-hover">
	    <thead>
	      <tr>
	        <th>Назва робіт</th>
	        <th>Вартість послуги</th>
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
	 
</div>

<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" />

<!-- DateTimePicker -->
<script src=<c:url value="/resources/js/dateTimePicker/time.js" />></script>
<script src=<c:url value="/resources/js/dateTimePicker/dateTimePicker.js" />></script>

<script src=<c:url value="/resources/js/dateTimePicker/bootstrap-datepicker.js" />></script>
<script src=<c:url value="/resources/js/dateTimePicker/datepair.js" />></script>
<script src=<c:url value="/resources/js/dateTimePicker/jquery.timepicker.js" />></script>        
