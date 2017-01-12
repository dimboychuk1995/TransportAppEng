<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div class="container-fluid">
  <div class="row">
    <div class="col-md-12">
      <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered" id="orders">
          <thead>
            <tr>
              <th class="col-md-2">Customer</th>
              <th class="col-md-1">Tab number</th>
              <th class="col-md-3">Type of work</th>
              <th class="col-md-1">Date</th>
              <th class="col-md-1">Time</th>
              <th class="col-md-1">Price</th>
              <th class="col-md-1">Order number</th>
              <th class="col-md-1">Confirm payment</th>
            </tr>
          </thead>
          <tbody>
           <c:forEach items="${orders}" var="order">
              <tr id="${order.id}" class="dataRow">
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
                  <c:out value="${order.all_sum}"></c:out>
                </td>
                <td>
                  <c:out value="${order.bill_number}"></c:out>
                </td>
                <td class="no-padding">
                  <button id="${order.customer}" class="btn btn-success paymentApprove">
                    <span class="glyphicon glyphicon-ok"></span> Submit
                  </button>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>


<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" />

<!-- Main page script -->
<script src=<c:url value="/resources/js/cashier/cashier.js" />></script>
