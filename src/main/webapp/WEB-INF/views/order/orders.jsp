<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<link rel="stylesheet" href=<c:url value="/resources/dist/css/order.css"/>>
<div class="container-fluid">
  <div class="row">
    <div class="col-md-12">
      <div class="table-responsive">
        <table class="table table-hover table-bordered table-striped" id="orders">
          <thead>
            <tr>
              <th class="col-md-1">Type of works</th>
              <th class="col-md-1">Customer</th>
              <th class="col-md-1">Car brand</th>
              <th class="col-md-1">Car model</th>
              <th class="col-md-1">Car number</th>
              <th class="col-md-1">Date</th>
              <th class="col-md-1">Time</th>
              <th class="col-md-1">Tab numer</th>
              <th class="col-md-1">Mobile phone number</th>
              <th class="col-md-1">Status order</th>
              <th class="col-md-1">Edit</th>
              <th class="col-md-1">Delete</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${order}" var="orders">
              <tr id="${orders.id}" class="dataRow">
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
                  <c:out value="${orders.car_number}"></c:out>
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
                  <c:out value="${orders.mobile_phone_number}"></c:out>
                </td>
                <td>
                  <c:out value="${orders.status_order.statusOrder}"></c:out>
                </td>
                <td class="no-padding">
                  <a class="btn btn-primary col-md-12" href=<c:url value="/admin/order/${orders.id}" />>Edit</a>
                </td>
                <td class="no-padding">
                  <button id="${orders.id}" type="submit" class="btn btn-danger delete col-md-12">Delete</button>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
        <div class="btns_bottom">
          <a class="btn btn-primary" href=<c:url value="/admin" />>Guide services</a>
        </div>
      </div>
    </div>
  </div>
</div>
<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" />

<p id="messageField"></p>

<!-- Main page script -->
<script src=<c:url value="/resources/js/order/order.js" />></script>
