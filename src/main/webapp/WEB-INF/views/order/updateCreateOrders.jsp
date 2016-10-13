<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<div>
    <form:form action="" method="POST" modelAttribute="orders" class="">
        <fieldset>
            <p><b>Вид робіт</b>
                <form:select path="workType.id" items="${typeWorks}" class=""
                    data-placeholder="work"
                    itemLabel="name" itemValue="id" />             
            </p>
            <p><b>Замовник</b>
                <form:input type="text" path="customer" class="" cssErrorClass=""/>                
            </p>
            <p id="car_name"><b>Марка авто</b>
                <form:select path="car.id" items="${cars}" class=""
                        data-placeholder="cars"
                        itemLabel="name" itemValue="id" />               
            </p>
            <p><b>Модель</b>
                <form:input type="text" path="car_model" class="" cssErrorClass=""/>                
            </p>
            <p><b>Сума без ПДВ</b>
                <form:input type="text" path="sum_vithput_pdv" class="" cssErrorClass=""/>                
            </p>
            <p><b>ПДВ</b>
                <form:input type="text" path="pdv" class="" cssErrorClass=""/>                
            </p>
            <p><b>Вся сума</b>
                <form:input type="text" path="all_sum" class="" cssErrorClass=""/>                
            </p>
            <p><b>Виконавець</b>
                <form:input type="text" path="performer_id" class="" cssErrorClass=""/> 

            <p id ="datePicker" ><b>Дата</b>
	           	<form:input id = "dpicker" type="text" path="date" class="date start" cssErrorClass=""/>
	           	<form:errors path="date" class="" cssErrorClass="" />

				<form:select id="selectForm"  path="time" class="" >
				<form:option value="${orders.time}">${orders.time}</form:option>
				</form:select>
 			</p>
            <p><b>Табельний номер</b>
                <form:input type="text" id = "" path="user_tab" class="" cssErrorClass=""/>                
            </p>
            <p><b>Номер авто</b>
                <form:input type="text" id = "" path="car_number" class="" cssErrorClass=""/>                
            </p>
            <p><b>Статус замовлення</b>
                <form:select path="status_order" items="${items}" itemLabel="statusOrder"/>
            </p>
            <button id="sendForm" type="submit" class="">Зберегти</button>
        </fieldset>
    </form:form>
</div>

<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" />

<!-- DateTimePicker -->
<script src=<c:url value="/resources/js/dateTimePicker/time.js" />></script>
<script src=<c:url value="/resources/js/dateTimePicker/dateTimePicker.js" />></script>

<script src=<c:url value="/resources/js/dateTimePicker/bootstrap-datepicker.js" />></script>
<script src=<c:url value="/resources/js/dateTimePicker/datepair.js" />></script>
<script src=<c:url value="/resources/js/dateTimePicker/jquery.timepicker.js" />></script>  


