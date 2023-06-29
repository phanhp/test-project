<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <!DOCTYPE html>
        <html lang="en">

<head>
          <meta charset="UTF-8">
          <meta name="viewport" content="width=device-width, initial-scale=1.0">
          <title>Test Page </title>
<!-- Bootstrap -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<!-- Ajax -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<!-- Css -->
<style>
  <%@include file="/resources/css/objPage.css" %>
</style>

</head>

<body>
<jsp:include page="header.jsp" />

<div class="container"><div class="d-flex justify-content-lg-center"><div class="title">Đây là Object Page</div></div><div>
</br>

<form:form method="post" id="objForm" action="${action}">
<div class="input-group">
<label class="label">Object name</label>
<input id="objName" name="objName" class="form-control" type="text" placeholder="Object Name" value="This is obj name"/>
</div>
<button class="btn btn-success" type="button" id="buttonSubmit">Submit</button>
</form:form>

<div class="container">
</br>
<div class="title">Result Data</div>
<div id="resultData"></div>
</div>

<script src="${pageContext.request.contextPath}/resources/script/objPage.js"></script>

</body>

</html>