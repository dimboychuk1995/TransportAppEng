<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<div>
    <form:form action="" method="POST" modelAttribute="orders" class="">
        <fieldset>
            <p><b>Вид робіт</b>
                <form:input type="text" path="name_servise_id" class="" cssErrorClass=""/>                
            </p>
            <p><b>Замовник</b>
                <form:input type="text" path="customer" class="" cssErrorClass=""/>                
            </p>
            <p><b>Марка авто</b>
                <form:input type="text" path="car_name_id" class="" cssErrorClass=""/>                
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
            </p>
            <p><b>Дата</b>
                <form:input type="text" id = "datepicker" path="date" class="" cssErrorClass=""/>                
            </p>
            <p><b>Час</b>
                <form:input type="text" id = "timepicker" path="time" class="" cssErrorClass=""/>                
            </p>
            <p><b>Табельний номер</b>
                <form:input type="text" id = "" path="user_tab" class="" cssErrorClass=""/>                
            </p>
            <p><b>Номер авто</b>
                <form:input type="text" id = "" path="car_number" class="" cssErrorClass=""/>                
            </p>
            <p><b>Статус замовлення</b>
                <form:input type="text" id = "" path="status_order" class="" cssErrorClass=""/>                
            </p>
            <button id="" type="submit" class="">save</button>
        </fieldset>
    </form:form>
</div>
<!-- DatePicker -->
<script src=<c:url value="/resources/js/datePicker/datePicker.js" />></script>
<script src=<c:url value="/resources/js/datePicker/jquery-ui.min.js" />></script>
<script src=<c:url value="/resources/js/datePicker/jquery-ui.js" />></script>

<!-- TimePicker -->

<script src=<c:url value="/resources/js/timePicker/timePicker.js" />></script>
<script src=<c:url value="/resources/js/timePicker/bootstrap.min.js" />></script>
<script src=<c:url value="/resources/js/timePicker/bootstrap-datetimepicker.min.js" />></script>
<script src=<c:url value="/resources/js/timePicker/moment-with-locales.min.js" />></script>

