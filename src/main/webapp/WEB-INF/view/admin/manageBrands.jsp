<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/view/admin/includesAdmin/header.jsp" %>

<div class="navbar navbar-expand-lg navbar-light bg-light col-xl-9 mx-auto ">
	<form action="./managebrands" method="post" class="ml-auto"  onsubmit="return newBrand()">
		<input type="hidden" name="formType" value="addNewBrands"/>
		<input type="hidden" name="addNewBrandInput" id="addNewBrandInput" value=""/>
        <input class="btn btn-primary" type="submit" value="Thêm Thương hiệu" />
    </form>
</div> 



<div class="navbar navbar-expand-lg navbar-light bg-light col-xl-9 mx-auto">


	<table class="table table-striped 	">
	  <thead>
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">Tên thương hiệu</th>
	      
	    </tr>
	  </thead>
	  <tbody>
	   <%
	   java.util.List<model.BrandsModel> list = dao.BrandsDao.readBrands();
	   int stt = 1;
	   for(model.BrandsModel c : list){
		  %>
		  <tr>
		      <th scope="row"><%=stt %></th>
		      <td><%=c.getBrandName() %></td>   
		      <th  class="d-flex flex-row">
		      	<form action="./managebrands" method="post" class="d-inline-block" onsubmit="return updateBrand()">
				    <input name="manage" class="btn btn-primary mr-2" type="submit" value="Sửa"/>
				    <input type="hidden" name="updateInput" id="updateInput" value=""/>    
				    <input type="hidden" name="formType" value="manageBrandItem"/>                     
				    <input type="hidden" name="BrandId" value="<%=c.getBrandId() %>"/>                                     
				</form>
				
				<form action="./managebrands" method="post" class="d-inline-block" onsubmit ="return validateDelete()">
				    <input name="manage" class="btn btn-primary mr-2" type="submit" value="Xoá" />
				    <input type="hidden" name="formType" value="manageBrandItem"/>                     
				    <input type="hidden" name="BrandId" value="<%=c.getBrandId() %>"/>                                     
				</form>
		      </th>
		    </tr>
		  <% 
		  stt++;
	   };
	   %>
	  </tbody>
	</table>
	<script>
		function validateDelete(){
			return confirm("Xoá thương hiệu?");			
		}

		function newBrand() {
		    var input = prompt("Nhập tên thương hiệu:");
		    if (input !== null) {
		        input = input.trim(); // Loại bỏ các khoảng trắng ở đầu và cuối chuỗi
		        if (input === "") {
		            alert("Chưa nhập tên thượng hiệu");
		            return false;
		        } else {
		            document.getElementById("addNewBrandInput").value = input;
		            return true;
		        }
		    } else {
		        return false;
		    }
		}

		function updateBrand() {
		    var input = prompt("Nhập tên thương hiệu:");
		    if (input !== null) {
		        input = input.trim(); // Loại bỏ các khoảng trắng ở đầu và cuối chuỗi
		        if (input === "") {
		            alert("Chưa nhập tên thương hiệu.");
		            return false;
		        } else {
		            document.getElementById("updateInput").value = input;
		            return true;
		        }
		    } else {
		        return false;
		    }
		}
	</script>
	
</div>
<%@ include file = "/WEB-INF/view/includes/footer.jsp" %>