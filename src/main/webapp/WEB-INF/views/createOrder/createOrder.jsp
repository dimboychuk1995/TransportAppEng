<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<link rel="stylesheet" href=<c:url value="/resources/dist/css/userOrder.css" />>
<div class="container-fluid">
  <div class="row">
    <div class="col-md-12">
      <div class="row">

        <div class="col-md-6 textForm">
          <h2>Форма для реєстрації замовлення</h2>
        </div>
      </div>
      <c:if test="${param.id == null}">
        <div class="col-md-6">

          <form:form action="" method="POST" modelAttribute="orders" class="form-group" id="orderForm">

            <fieldset>

              <label>Вид робіт</label>
              <form:select id="typeOfWork" path="workType.id" items="${typeWorks}" class="form-control orderInput" data-placeholder="work" itemLabel="name" itemValue="id" />

              <label>Табельний номер</label>
              <form:input type="text" id="tableNumber" class="form-control orderInput" path="user_tab" placeholder="Введіть Ваш табельний номер" cssErrorClass="error" />
              <form:errors path="user_tab" class="help-block with-errors" cssErrorClass="" />

              <label>Марка автор</label>
              <form:select id="carBrand" path="car.id" items="${cars}" class="form-control orderInput" data-placeholder="cars" itemLabel="name" itemValue="id" />

              <label>Модель</label>
              <form:input id="modelCar" type="text" path="car_model" placeholder="Введіть Вашу марку авто" class="form-control orderInput" cssErrorClass="error" />
              <form:errors path="car_model" class="help-block with-errors" cssErrorClass="" />

              <label>Номер авто</label>
              <form:input id="numberCar" type="text" path="car_number" class="form-control orderInput" placeholder="Введіть номер Вашого авто" cssErrorClass="error" />
              <form:errors path="car_number" class="help-block with-errors" cssErrorClass="" />

              <label>Дата</label>
              <div id="datePicker">
                <form:input id="dpicker" type="text" path="date" class="date start dateChange form-control orderDate" placeholder="Виберіть дату" cssErrorClass="date start dateChange orderDate error" />
                <form:errors path="date" class="help-block with-errors" cssErrorClass="" />
                <form:select id="selectForm" path="time" class="form-control orderTime">
                  <option disabled="disabled">Виберіть дату спочатку</option>
                </form:select>
              </div>

              <button id="" type="submit" class="btn btn-success paymentApprove pull-down">Замовити
		      <span class="glyphicon glyphicon-ok"></span>
		      </button>
            </fieldset>
          </form:form>
        </div>

        <div class="col-md-6">
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
                  <tr id="${workType.id}">
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
</div>
<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" />

<!-- DateTimePicker -->
<script src=<c:url value="/resources/js/dateTimePicker/time.js" />></script>
<script src=<c:url value="/resources/js/dateTimePicker/dateTimePicker.js" />></script>
<script src=<c:url value="/resources/js/dateTimePicker/dateTimePicker.js" />></script>
<script src=<c:url value="/resources/js/dateTimePicker/bootstrap-datepicker.js" />></script>
<script src=<c:url value="/resources/js/dateTimePicker/datepair.js" />></script>
<script src=<c:url value="/resources/js/dateTimePicker/jquery.timepicker.js" />></script>        
