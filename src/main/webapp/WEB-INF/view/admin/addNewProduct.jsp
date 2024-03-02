<%@page import="dao.BrandsDao"%>
<%@page import="dao.CategoryDao"%>
<%@page import="model.ProductModel"%>
<%@page import="dao.ProductDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/view/admin/includesAdmin/header.jsp" %>

<div class="col-9 mx-auto">
<h2>Thêm sản phẩm</h2>
<form action = "./manageproduct" method="post" onsubmit="return validateAdd()">
<input type="hidden" name="formType" value ="addNewProductForm"/>
	<table class="table col-9 mx-auto">
	  <tbody>
	    <tr>      
	      <td class="col-2">Thêm ảnh</td>
	      <td>
	      <input type="file" name="image" accept="image/*" onchange="displayImage(event)"/>
	      <img id="selectedImage" src="#" alt="Selected Image" style="max-width: 120px; max-height: 120px;">
	      </td>   
	    </tr>
	    <tr>      
	      <td>Tên</td>
	      <td><input type="text" name="proName" class="form-control col-6"/></td>      
	    </tr>
	    <tr>      
	      <td>Chất liệu</td>
	      <td><input type="text" name="material" class="form-control col-6"/></td>      
	    </tr>
	    <tr>      
	      <td>Màu sắc</td>
	      <td><input type="text" name="color" class="form-control col-6"/></td>      
	    </tr>
	    <tr>      
	      <td>Mô tả</td>
	      <td><input type="text" name="discriber" class="form-control col-6"/></td>      
	    </tr>
	 
	    <tr>      
	      <td>Tính năng đặc biệt</td>
	      <td><input type="text" name="feature" class="form-control col-6"/></td>      
	    </tr>
	    <tr>      
	      <td>Giá bán</td>
	      <td><input type="text" name="price" class="form-control col-6"/></td>      
	    </tr>
	    <tr>      
	      <td>Giảm giá</td>
	      <td><input type="text" name="discounts" class="form-control col-6"/></td>      
	    </tr>
	    <tr>      
	      <td>Số lượng</td>
	      <td><input type="text" name="quanity" class="form-control col-6"/></td>      
	    </tr>
	    <tr>      
	      <td>Thương hiệu</td>
	      <td>
	      <select name="brands" class="form-select" aria-label="Default select example">
	      		<%
	      		java.util.List<model.BrandsModel> list1 = dao.BrandsDao.readBrands();
	      		for(model.BrandsModel c : list1){
	      		%>
		        <option value="<%= c.getBrandName() %>"><%=c.getBrandName() %></option>
		        <%} %>
		   </select>
		   </td>      
	    </tr>
	    
	    <tr>      
	      <td>Danh mục</td>
	      <td>
	      <select name="category" class="form-select" aria-label="Default select example">
	      		<%
	      		java.util.List<model.CategoryModel> list = dao.CategoryDao.readCategory();
	      		for(model.CategoryModel c : list){
	      		%>
		        <option value="<%= c.getCateName()%>"><%=c.getCateName() %></option>
		        <%} %>
		   </select>
		   </td>      
	    </tr>
	  </tbody>
	</table>
	<input type="submit" name="submitAdd" value="Lưu" class="btn btn-primary"/>
</form>
<form action = "./manageproduct" method="post" onsubmit="return validateCancel()">
	<input type="hidden" name="formType" value ="addNewProductForm"/>
	<input type="submit" name="submitAdd" value="Huỷ" class="btn btn-primary mt-2"/>
</form>
</div>
<script type="text/javascript">
function validateAdd(){
	return confirm("xác nhận lưu?");
}
function validateCancel(){
	return confirm("xác nhận huỷ?");
}
function displayImage(event) {
    var selectedFile = event.target.files[0];
    var reader = new FileReader();
    
    reader.onload = function(event) {
        var imgElement = document.getElementById('selectedImage');
        imgElement.src = event.target.result;
    };
    
    reader.readAsDataURL(selectedFile);
}
</script>

<%@ include file = "/WEB-INF/view/includes/footer.jsp" %>