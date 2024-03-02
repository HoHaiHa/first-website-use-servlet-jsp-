<%@page import="model.ProductModel"%>
<%@page import="dao.ProductDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/view/admin/includesAdmin/header.jsp" %>
<div class="col-9 mx-auto"> 
	<div class="col-9 ml-auto">
		<div class="dropdown float-right">
		  <button class="btn btn-secondary dropdown-toggle ml-4" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		  Sắp xếp
		  </button>
		  <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
		    <form action = "./manageproduct" method="post">
			    <input type="submit" name="dropdownItem" value="Tên tăng" class="btn btn-link"/>	
			    <input type="submit" name="dropdownItem" value="Tên giảm" class="btn btn-link"/>	
			    <input type="submit" name="dropdownItem" value="Số lượng tăng" class="btn btn-link"/>
			    <input type="submit" name="dropdownItem" value="Số lượng giảm" class="btn btn-link"/>
			    <input type="submit" name="dropdownItem" value="Ngày thêm tăng" class="btn btn-link"/>	
			    <input type="submit" name="dropdownItem" value="Ngày thêm giảm" class="btn btn-link"/>	
			    <input type="submit" name="dropdownItem" value="Giá tăng" class="btn btn-link"/>
			    <input type="submit" name="dropdownItem" value="Giá giảm" class="btn btn-link"/>
			    <input type="submit" name="dropdownItem" value="Giảm giá tăng" class="btn btn-link"/>
			    <input type="submit" name="dropdownItem" value="Giảm giá giảm" class="btn btn-link"/>			        		
			    <input type="hidden" name="formType" value ="sortedBy"/>
		    </form>
		  </div>
		</div> 
		
		<div class="dropdown float-right">
			<form action = "./manageproduct" method="post">
				<input type="submit" name="" value="Thêm sản phẩm" class="btn btn-secondary "/>	
				<input type="hidden" name="formType" value ="addNewProduct"/>
			</form>
		</div>
	</div>
	
	<table class="table table-bordered">
	  <thead>
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">Tên</th>
	      <th scope="col">Số lượng</th>	 
	      <th scope="col">Danh mục</th>     
	      <th scope="col">Mới</th>
	      <th scope="col">Hot</th>
	      <th scope="col">Giá</th>
	      <th scope="col">Giảm giá</th>
	      <th scope="col"></th>
	    </tr>
	  </thead>
	  <tbody>
	  <%
		java.util.List<model.ProductModel> list = (java.util.List<model.ProductModel>) request.getAttribute("productList");
		if(request.getAttribute("productList") == null){
			list = dao.ProductDao.readProduct();
		}
	  	int stt = 1;
		for(model.ProductModel p : list){
	  %>
	    <tr>
	      <th scope="row"><%=stt %></th>
	      <td><%=p.getProName() %></td>
	      <td><%=p.getQuantity() %></td>
	      <td><%=p.getCategory() %></td>
	      
	      <td>	      
		      <% if ("Yes".equals(p.getNewness())) { %>
				    <%="x"%>
				<% } %>    
	      </td>	      
	       <td>	      
		      <% if ("Yes".equals(p.getHot())) { %>
				    <%="x"%>
				<% } %>    
	      </td>
	      
	      <td><%=p.getPrice() %></td>
	      <td><%=p.getDiscounts() %></td>
	      
	      <td>
			    <div class="dropdown">
				  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				  </button>
				  <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
				    <button class="dropdown-item" type="button">Action</button>
				    <button class="dropdown-item" type="button">Another action</button>
				    <button class="dropdown-item" type="button">Something else here</button>
				  </div>
				</div> 
			</td>
	   	 </tr>
	    <%
	    stt++;
		}
	    %>	    
	  </tbody>
</table>
</div>


<%@ include file = "/WEB-INF/view/includes/footer.jsp" %>