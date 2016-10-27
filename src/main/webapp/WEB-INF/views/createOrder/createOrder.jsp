<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<link rel="stylesheet" href=<c:url value="/resources/dist/css/user/userOrder.css" />>
<div class="container-fluid">

  <div class="col-md-12">

    <c:if test="${param.id == null}">
      <div class="row">
        <h2>Для реєстрації замовлення заповніть дану форму</h2>
      </div>
      <div class="col-md-4 col-md-offset-4">

        <form:form action="" method="POST" modelAttribute="orders" class="form-group" id="orderForm">

          <label>Вид робіт</label>
          <form:select id="typeOfWork" path="workType" items="${typeWorks}" class="form-control orderInput" data-placeholder="work" itemLabel="name" itemValue="id" cssErrorClass="error form-control" />
		  <form:errors path="workType" class="help-block with-errors" cssErrorClass="" />
          <label>Табельний номер</label>
          <form:input required="required" id="tableNumber" class="form-control orderInput" path="user_tab" placeholder="Введіть Ваш табельний номер"  cssErrorClass="error form-control" />
          <form:errors path="user_tab" class="help-block with-errors" cssErrorClass="" />

          <label>Марка автор</label>
          <form:select id="carBrand" path="car" items="${cars}" class="form-control orderInput" data-placeholder="cars" itemLabel="name" itemValue="id" cssErrorClass="error form-control" />
		  <form:errors path="car" class="help-block with-errors" cssErrorClass="" />

          <label>Модель</label>
          <form:input id="modelCar" required="required" path="car_model" placeholder="Введіть модель авто" class="form-control orderInput" cssErrorClass="error form-control" />
          <form:errors path="car_model" class="help-block with-errors" cssErrorClass="" />

          <label>Номер авто</label>
          <form:input id="numberCar" required="required" path="car_number" class="form-control orderInput" placeholder="Введіть номер Вашого авто" cssErrorClass="error form-control" />
          <form:errors path="car_number" class="help-block with-errors" cssErrorClass="" />

          <label class="col-md-6 no-padding-left">Дата</label>
          <label class="col-md-6">Час</label>
          <div id="datePicker">
            <div class="col-md-6 no-padding">
              <form:input id="dpicker" required="required" path="date" class="date start dateChange form-control col-md-6" placeholder="Виберіть дату" cssErrorClass="date start dateChange error form-control" />
              <form:errors path="date" class="help-block with-errors" cssErrorClass="" />
            </div>

            <div class="col-md-6 no-padding-right">
              <form:select id="selectForm" path="time" class="form-control orderTime col-md-6">
                <option disabled="disabled">Виберіть дату спочатку</option>
              </form:select>
            </div>
          </div>

          <div class="">
            <button id="" type="submit" class="btn btn-success paymentApprove form-control pull-down">Замовити
		      <span class="glyphicon glyphicon-ok"></span>
		      </button>
          </div>

        </form:form>

      </div>

      <div class="row">

        <div class="col-md-8 col-md-offset-2">
          <h2>Перелік доступних послуг</h2>
          <div class="table-responsive">
            <table class="table table-bordered table-hover">
              <thead>
                <tr>
                  <th class="col-md-6">Назва робіт</th>
                  <th class="col-md-6">Вартість послуги</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${typeWorks}" var="workType">
                  <tr id="${workType.id}">
                    <td>
                      <c:out value="${workType.name}"></c:out>
                    </td>
                    <td>
                      <c:out value="${workType.price_including_vat},грн"> </c:out>
                    </td>
                  </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </c:if>

    <c:if test="${param.id != null}">

      <div class="row">
        <div class="alert alert-success col-md-4 col-md-offset-4">
          Ваше замовлення оформлено, для здійснення оплати та в'їзду на територію підприємтсва роздрукуйте будь ласка чек!
        </div>
      </div>

      <div class="row">
        <div class="col-md-4 col-md-offset-4">
          <form:form action="${pageContext.request.contextPath}/pdf/${param.id}" method="GET">
            <button type="submit" class="btn btn-success">Роздрукувати чек</button>
            <a href=<c:url value="/" /> class="btn btn-default">Повернутися</a>
          </form:form>
        </div>
      </div>

    </c:if>
  </div>
</div>

<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" />

<!-- DateTimePicker -->
<script src=<c:url value="/resources/js/dateTimePicker/time.js" />></script>
<script src=<c:url value="/resources/js/dateTimePicker/dateTimePicker.js" />></script>
<script src=<c:url value="/resources/js/dateTimePicker/dateTimePicker.js" />></script>
<script src=<c:url value="/resources/js/dateTimePicker/bootstrap-datepicker.js" />></script>
<script src=<c:url value="/resources/js/dateTimePicker/datepair.js" />></script>
<script src=<c:url value="/resources/js/dateTimePicker/jquery.timepicker.js" />></script>        
