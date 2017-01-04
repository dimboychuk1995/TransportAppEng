<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <title>Error</title>
  <link href=<c:url value="/resources/dist/css/error-style.css" /> rel="stylesheet" type="text/css" media="all" />
</head>

<body>
  <div class="wrap">
    <div class="header">
      <div class="logo">
        <h1>
          Щось пішло не так
		</h1>
      </div>
    </div>
    <div class="content">
      <img src=<c:url value="/resources/travolta.gif" /> title="error" />
      <p>
        <span>Оува.....</span>Зверніться до адміністратора або повторіть спробу.
      </p>
      <a href="#" onclick="window.history.back();">Назад</a>
      <a href=<c:url value="/" />>Початкова сторінка</a>
    </div>
  </div>
</body>

</html>