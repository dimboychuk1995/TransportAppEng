<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div class="container-fluid">
  <div class="row">
    <div class="col-md-12">
      <div class="table-responsive">
        <table id="workTypes" class="table table-hover table-striped table-bordered">
          <thead>
            <tr>
              <th class="col-md-2">id work type</th>
              <th class="col-md-3">Work type name</th>
              <th class="col-md-2">Edit</th>
              <th class="col-md-1">Delete</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${typeWorks}" var="workType">
              <tr id="${workType.id}" class="dataRow">
                <td class="no-vertical-padding">
                  <c:out value="${workType.id}"></c:out>
                </td>
                <td class="no-vertical-padding">
                  <c:out value="${workType.name}"></c:out>
                </td>
                <td class="no-padding">
                <c:choose>
	                <c:when test="${workType.enabled}">
	                	<input type="checkbox" checked data-toggle="toggle" data-on="on" data-off="off" data-onstyle="success" data-offstyle="danger">
	                </c:when>
	                <c:otherwise>
	                	<input type="checkbox" data-toggle="toggle" data-on="on" data-off="off" data-onstyle="success" data-offstyle="danger">
	                </c:otherwise>
                </c:choose>
                
                </td>
                <td class="no-padding">
                  <button id="${workType.id}" class="btn btn-danger delete">Delete</button>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      <a href=<c:url value="/admin/workType/newWorkType" /> class="btn btn-primary">Create new work type</a>
      <a href=<c:url value="/admin/order" /> class="btn btn-info">Order list</a>
    </div>
  </div>
</div>
<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" />

<!-- Main page script -->
<script src=<c:url value="/resources/js/workType/workType.js" />></script>
