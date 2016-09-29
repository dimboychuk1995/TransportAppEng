<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <!-- jQuery -->
  <script src="<c:url value = "/resources/dist/js/jquery.min.js" />"></script>
  <script src="<c:url value = "/resources/dist/js/jquery.js" />"></script>

  <!-- Bootstrap JS -->
  <script src="<c:url value = "/resources/dist/js/bootstrap.min.js" />"></script>
  <script src="<c:url value = "/resources/dist/js/bootstrap.js" />"></script>

   <!-- DatePicker CSS -->
   <link href="<c:url value = "/resources/dist/css/datePicker/jquery-ui.css" />" rel="stylesheet">
   <link href="<c:url value = "/resources/dist/css/datePicker/jquery-ui.min.css" />" rel="stylesheet">
   <link href="<c:url value = "/resources/dist/css/datePicker/jquery-ui.structure.css" />" rel="stylesheet">
   <link href="<c:url value = "/resources/dist/css/datePicker/jquery-ui.theme.css" />" rel="stylesheet">
   <link href="<c:url value = "/resources/dist/css/datePicker/jquery-ui.theme.min.css" />" rel="stylesheet">
   
   <!-- TimePicker CSS -->
   <link href="<c:url value = "/resources/dist/css/timePicker/jquery.timepicker.css" />" rel="stylesheet">
  
  <title>
    <tiles:insertAttribute name="title" ignore="true" />
  </title>

</head>

<body>
  
  <tiles:insertAttribute name="menu" />

  <div id="">
    <tiles:insertAttribute name="body" />
  </div>

</body>

</html>