<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<div class="container-fluid">
  <div class="row">
    <h1 class="pull-down col-md-6">Редагування замовлення</h1>
  </div>
<div class="row">
<div class="col-md-4">

    <form:form action="" method="POST" modelAttribute="orders" class="form-group pull-down">
        <fieldset>
            <p><b>Вид робіт</b>
                <form:select path="workType.id" items="${typeWorks}" class="form-control"
                    data-placeholder="work"
                    itemLabel="name" itemValue="id" />             
            </p>
            <p><b>Замовник</b>
                <form:input type="text" path="customer" class="form-control" cssErrorClass=""/>                
            </p>
            <p id="car_name"><b>Марка авто</b>
                <form:select path="car.id" items="${cars}" class="form-control"
                        data-placeholder="cars"
                        itemLabel="name" itemValue="id" />               
            </p>
            <p><b>Модель</b>
                <form:input type="text" path="car_model" class="form-control" cssErrorClass=""/>                
            </p>
          
            <p><b>Виконавець</b>
                <form:input type="text" path="performer_id" class="form-control" cssErrorClass=""/> 

            
            <label class="col-md-6 no-padding-left">Дата</label>
            <label class="col-md-6">Час</label> 
            <div id ="datePicker" >
            	<div class="col-md-6 no-padding">
		           	<form:input id = "dpicker" type="text" path="date" class="date start form-control" cssErrorClass=""/>
		           	<form:errors path="date" class="" cssErrorClass="" />
				</div>
				<div class="col-md-6 no-padding-right">
				 <form:select id="selectForm" path="time" class="tpicker form-control"  >
    				<form:option value="${orders.time}">${orders.time}</form:option>
           		</form:select>
           		</div>
 			</div>
            <p><b>Табельний номер</b>
                <form:input type="text" id = "" path="user_tab" class="form-control" cssErrorClass=""/>                
            </p>
            <p><b>Номер авто</b>
                <form:input type="text" id = "" path="car_number" class="form-control" cssErrorClass=""/>                
            </p>
            <p><b>Статус замовлення</b>
                <form:select path="status_order" items="${items}" itemLabel="statusOrder" class = "form-control"/>
            </p>
            <button id="sendForm" type="submit" class="btn btn-success">Зберегти</button>
            <a href=<c:url value="/admin/order" /> class="btn btn-default">Повернутись на сторінку замовлень</a>
        </fieldset>
    </form:form>
</div>
</div>
</div>

<input id="idOrder" type="hidden" value="${orders.id}" />
<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" />

<!-- DateTimePicker -->
<script src=<c:url value="/resources/js/dateTimePicker/timeForAdmin.js" />></script>
<script src=<c:url value="/resources/js/dateTimePicker/dateTimePicker.js" />></script>

<script src=<c:url value="/resources/js/dateTimePicker/bootstrap-datepicker.js" />></script>
<script src=<c:url value="/resources/js/dateTimePicker/datepair.js" />></script>
<script src=<c:url value="/resources/js/dateTimePicker/jquery.timepicker.js" />></script>  


