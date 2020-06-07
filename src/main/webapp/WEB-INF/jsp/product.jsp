<%@ include file="header.jsp" %>

<div class="container">    
  <div class="row">
    <div class="col-sm-4">
      <div class="panel panel-primary">
      	
        <div class="panel-heading"> ${product.name} </div>
        <div class="panel-body">
        <p>Price : ${product.price}  </p>
        
        <form method="get" action="/cart/additem">
        <input type="hidden" id="pid" name="pid" value="${product.id }">
		 <p>quantity:<select id="quantity" name="quantity">
  			<option value="1">1</option>
  			<option value="2">2</option>
  			<option value="3">3</option>
  			<option value="4">4</option>
  			<option value="5">5</option>
  			
		</select></p>
        </div>
        <div class="panel-footer"> <button type="submit" class="btn btn-primary btn-md">add to cart</button></div>
         </form>
      </div>
    </div>
    
  </div>
</div><br>

</body>
</html>