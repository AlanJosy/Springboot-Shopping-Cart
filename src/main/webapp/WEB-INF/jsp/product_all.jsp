<%@ include file="header.jsp" %>

<div class="container">    
  <div class="row">
  <c:forEach items="${products}" var="product">
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading"> ${product.name} </div>
        <div class="panel-body">
        <center><img src="/images/${product.name}.jpg" width="130" height="130"></center>
        <p>Price : ${product.price}  </p>
		 
        </div>
        <div class="panel-footer"> <button type="button" class="btn btn-primary btn-md"
           onClick="location.href='/products/${product.id} ' ">ADD</button></div>
      </div>
    </div>
    </c:forEach>
  </div>
</div><br>

</body>
</html>