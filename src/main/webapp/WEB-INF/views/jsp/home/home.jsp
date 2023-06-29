<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
          <meta charset="UTF-8">
          <meta name="viewport" content="width=device-width, initial-scale=1.0">
          <title>Shopping Cart</title>
          <!-- Link to Bootstrap CSS -->
          <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
          <!-- Link to Bootstrap JS -->
          <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
          <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
          <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
          <style>
            <%@include file="/resources/css/home.css" %>
          </style>
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
          <script>
             <%@include file="/resources/script/home.js" %>
          </script>
        </head>

        <body>
          <jsp:include page="header.jsp" />

          <div class="contain pt-10">
            <!-- search box -->
            <form:form action="${action}" method="get">
              <div class="d-flex search-box">
                <div class="input-group w-auto">
                  <input name="searchInput" type="text" class="form-control" placeholder="Search..."
                    aria-label="Search input" />
                  <button class="btn btn-primary" type="submit" data-mdb-ripple-color="dark">Search
                  </button>
                </div>
              </div>
            </form:form>

            <!-- table box -->
            <div class="mt-10 table-box">
            <form:form action="${action}" method="post">
            <div class="d-flex justify-content-center"><button class="btn-mines" type="submit">Submit</button></div>
            </br>
              <table class="table">
                <thead class="thead-dark">
                  <tr>
                    <th scope="col">Object Id</th>
                    <th scope="col">Object Name</th>
                    <th scope="col">Object Data</th>
                  </tr>
                </thead>

                <tbody>
                  <c:if test="${empty objList}">
                    <p>List is empty</p>
                  </c:if>

                  <c:if test="${not empty objList}">
                    <input type="hidden" name="objId" value="${product.productId}" />
                    <c:forEach var="obj" items="${objList}" varStatus="e">
                      <tr>
                        <td>${obj.objId}</td>
                        <td>${obj.objName}</td>
                        <td>${obj.objData}</td>
                      </tr>
                    </c:forEach>
                  </c:if>
                </tbody>
              </table>
              </form:form>
            </div>
          </div>

          <ul class="pagination home-product__pagination">
            <li class="pagination-item"><a href="" class="pagination-item__link"> <i
                  class="pagination-item__icon fas fa-angle-left"></i>
              </a></li>
            <!-- page list -->
            <c:forEach var="page" items="${pageList}">
              <li class="pagination-item pagination-item--active"><a onclick="location.href='/Shopping/page/${page}'"
                  class="pagination-item__link">${page }</a></li>
            </c:forEach>
            <li class="pagination-item"><a href="" class="pagination-item__link"> <i
                  class="pagination-item__icon fas fa-angle-right"></i>
              </a></li>
          </ul>
        </body>

        </html>