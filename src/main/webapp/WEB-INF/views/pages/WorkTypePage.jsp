<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div>
	<table>
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
		<tr>
			<c:forEach items = "${typeWorks}" var = "WorkTypePage">
			<td><c:out value="${WorkTypePage.id}"></c:out></td>
				<td><c:out value="${WorkTypePage.name}"></c:out></td>
				<td><c:out value="${WorkTypePage.count_hours}"></c:out></td>
				<td><c:out value="${WorkTypePage.salary}"></c:out></td>
				<td><c:out value="${WorkTypePage.social_insurance}"></c:out></td>
				<td><c:out value="${WorkTypePage.production_costs}"></c:out></td>
				<td><c:out value="${WorkTypePage.all_costs}"></c:out></td>
				<td><c:out value="${WorkTypePage.profit}"></c:out></td>
				<td><c:out value="${WorkTypePage.sum}"></c:out></td>
				<td><c:out value="${WorkTypePage.cost_of_materials}"></c:out></td>
				<td><c:out value="${WorkTypePage.selling_price}"></c:out></td>
				<td><c:out value="${WorkTypePage.vat}"></c:out></td>
				<td><c:out value="${WorkTypePage.price_including_vat}"></c:out></td>
			</c:forEach>
		</tr>
	</table>
</div>