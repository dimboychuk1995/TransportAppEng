<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div>
  <table>
    <thead>
      <tr>
        <th>id</th>
        <th>Назва робіт</th>
        <th>Кількість люд/год.</th>
        <th>Заробітна плата</th>
        <th>Нарахування</th>
        <th>Загальні витрати</th>
        <th>Всього витрати</th>
        <th>Прибуток</th>
        <th>Разом</th>
        <th>Вартість матеріалів</th>
        <th>Відпускна вартість</th>
        <th>ПДВ</th>
        <th>Вартість ПДВ</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${typeWorks}" var="WorkTypePage">
      <tr>
       
          <td>
            <c:out value="${WorkTypePage.id}"></c:out>
          </td>
          <td>
            <c:out value="${WorkTypePage.name}"></c:out>
          </td>
          <td>
            <c:out value="${WorkTypePage.count_hours}"></c:out>
          </td>
          <td>
            <c:out value="${WorkTypePage.salary}"></c:out>
          </td>
          <td>
            <c:out value="${WorkTypePage.social_insurance}"></c:out>
          </td>
          <td>
            <c:out value="${WorkTypePage.production_costs}"></c:out>
          </td>
          <td>
            <c:out value="${WorkTypePage.all_costs}"></c:out>
          </td>
          <td>
            <c:out value="${WorkTypePage.profit}"></c:out>
          </td>
          <td>
            <c:out value="${WorkTypePage.sum}"></c:out>
          </td>
          <td>
            <c:out value="${WorkTypePage.cost_of_materials}"></c:out>
          </td>
          <td>
            <c:out value="${WorkTypePage.selling_price}"></c:out>
          </td>
          <td>
            <c:out value="${WorkTypePage.vat}"></c:out>
          </td>
          <td>
            <c:out value="${WorkTypePage.price_including_vat}"></c:out>
          </td>
        
      </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
<div>
  <form:form action="" method="POST" modelAttribute="workType" class="">
    <fieldset>
      <p><b>Назва робіт</b><br>
        <form:input type="text" path="name" class="" cssErrorClass="" />
      </p>
      <p><b>Кількість люд/год.</b><br>
        <form:input type="text" path="count_hours" class="" cssErrorClass="" />
      </p>
      <p><b>Заробітна плата</b><br>
        <form:input type="text" path="salary" class="" cssErrorClass="" />
      </p>
      <p><b>Нарахування</b><br>
        <form:input type="text" path="social_insurance" class="" cssErrorClass="" />
      </p>
      <p><b>Загальні витрати</b><br>
        <form:input type="text" path="production_costs" class="" cssErrorClass="" />
      </p>
      <p><b>Всього витрати</b><br>
        <form:input type="text" path="all_costs" class="" cssErrorClass="" />
      </p>
      <p><b>Прибуток</b><br>
        <form:input type="text" path="profit" class="" cssErrorClass="" />
      </p>
      <p><b>Разом</b><br>
        <form:input type="text" path="sum" class="" cssErrorClass="" />
      </p>

      <p><b>Вартість матеріалів</b><br>
        <form:input type="text" path="cost_of_materials" class="" cssErrorClass="" />
      </p>
      <p><b>Відпускна вартість</b><br>
        <form:input type="text" path="selling_price" class="" cssErrorClass="" />
      </p>
      <p><b>ПДВ</b><br>
        <input type="text" size="40">
        <form:input type="text" path="vat" class="" cssErrorClass="" />
      </p>
      <p><b>Вартість ПДВ</b><br>
        <form:input type="text" path="price_including_vat" class="" cssErrorClass="" />
      </p>
      <button id="" type="submit" class="">Save</button>
    </fieldset>
  </form:form>
</div>