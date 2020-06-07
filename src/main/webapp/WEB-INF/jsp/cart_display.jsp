<%@ include file="header.jsp" %>



<div class="container">    
  <div class="row">
  <c:forEach items="${cartitem}" var="cart">
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading"> ${cart.name} </div>
        <div class="panel-body">
        <p>Unit Price : ${cart.price}  </p>
       
        
        
		 <form method="get" action="">
        <input type="hidden" id="pid" name="pid" value="${cart.id }">
		 <p>Quantity:<select id="quantity" name="quantity" >
		 	<option value="" selected disabled hidden>${cart.quantity}</option>
  			<option value="1">1</option>
  			<option value="2">2</option>
  			<option value="3">3</option>
  			<option value="4">4</option>
  			<option value="5">5</option>
  			
		</select></p>
		<p>Amount :  <c:out value="${cart.price*cart.quantity}" /> </p>
        
        <div class="panel-footer"> <button type="submit" class="btn btn-primary btn-md" 
        onclick="form.action='/cart/additem' ;">update cart item</button>
        <button type="submit" class="btn btn-primary btn-md"
         	onclick="form.action='/cart/delitem ' ;">Remove from cart</button></div>
         
         
         	</form>
        </div>
        
        
      </div>
    </div>
    </c:forEach>
  </div>
  <div class="row"><div class="panel-footer"> <button type="button" class="btn btn-primary btn-md"
           onClick="location.href='/checkout/allitems' ">Checkout</button></div></div>
</div><br>

</body>
</html>