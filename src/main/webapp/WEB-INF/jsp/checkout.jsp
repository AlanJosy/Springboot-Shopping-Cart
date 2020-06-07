<%@ include file="header.jsp" %>



<div class="container">
    
    
    <div class="row">
    	<div class="col-md-12">
    		<div class="panel panel-primary">
    			<div class="panel-heading">
    				<h3 class="panel-title"><strong>Order summary</strong></h3>
    			</div>
    			<div class="panel-body">
    				<div class="table-responsive">
    					<table class="table table-condensed">
    						<thead>
                                <tr>
        							<td><strong>Item</strong></td>
        							<td class="text-center"><strong>Price</strong></td>
        							<td class="text-center"><strong>Quantity</strong></td>
        							<td class="text-right"><strong>Totals</strong></td>
                                </tr>
    						</thead>
    						<tbody>
    							<c:set var="itemTotalamount" value="${0}" />
    							<c:forEach items="${cartitem}" var="cart">
    							<tr>
    								<td>${cart.name}</td>
    								<td class="text-center">${cart.price}</td>
    								<td class="text-center">${cart.quantity}</td>
    								<td class="text-right"><c:out value="${cart.price*cart.quantity}" /></td>
    								<c:set var="itemTotalamount" value="${itemTotalamount + cart.price*cart.quantity}" />
    							</tr>
                                </c:forEach>
                                
    							<tr>
    								<td class="thick-line"></td>
    								<td class="thick-line"></td>
    								<td class="thick-line text-center"><strong>Subtotal</strong></td>
    								<td class="thick-line text-right">${itemTotalamount}</td>
    							</tr>
    							<tr>
    								<td class="no-line"></td>
    								<td class="no-line"></td>
    								<td class="no-line text-center"><strong>Shipping</strong></td>
    								
    								<c:set var="shippingAmount" value="${12}" />
    								
    								<td class="no-line text-right">${shippingAmount}</td>
    							</tr>
    							<tr>
    								<td class="no-line"></td>
    								<td class="no-line"></td>
    								<td class="no-line text-center"><strong>Total</strong></td>
    								<td class="no-line text-right"><c:out value="${itemTotalamount+shippingAmount}" /></td>
    							</tr>
    						</tbody>
    					</table>
    				</div>
    			</div>
    			
    			<div class="panel-footer"> <button type="button" class="btn btn-primary btn-md"
           onClick="location.href='/products/${product.id} ' ">Confirm Order</button></div>
    		</div>
    	</div>
    </div>
</div>

</body>
</html>