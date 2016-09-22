<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<div>
    <table>
        <thead>
            
        </thead>
        <tbody>
            <c:forEach items="${order}" var="orders">
                <tr>
                    <td>
                        
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

