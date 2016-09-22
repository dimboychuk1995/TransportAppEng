<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<div>
    <form:form action="" method="POST" modelAttribute="orders" class="">
        <p><b>Виконавець</b>
            <form:input type="text" path="performer_id" class="" cssErrorClass=""/>                
        </p>
        <p><b>Дата</b>
            <form:input type="text" path="date" class="" cssErrorClass=""/>                
        </p>
        <p><b>Час</b>
            <form:input type="text" path="time" class="" cssErrorClass=""/>                
        </p>
    </form:form>
</div>