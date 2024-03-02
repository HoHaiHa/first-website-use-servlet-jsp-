<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/view/admin/includesAdmin/header.jsp" %>

<div class="navbar navbar-expand-lg navbar-light bg-light col-xl-9 mx-auto ">
	<form action="./managecategory" method="post" class="ml-auto"  onsubmit="return newCate()">
		<input type="hidden" name="formType" value="addNewCategory"/>
		<input type="hidden" name="addNewCateInput" id="addNewCateInput" value=""/>
        <input class="btn btn-primary" type="submit" value="Thêm danh mục" />
    </form>
</div> 



<div class="navbar navbar-expand-lg navbar-light bg-light col-xl-9 mx-auto">


	<table class="table table-striped 	">
	  <thead>
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">Tên danh mục</th>
	      
	    </tr>
	  </thead>
	  <tbody>
	   <%
	   java.util.List<model.CategoryModel> list = dao.CategoryDao.readCategory();
	   int stt = 1;
	   for(model.CategoryModel c : list){
		  %>
		  <tr>
		      <th scope="row"><%=stt %></th>
		      <td><%=c.getCateName()%></td>   
		      <th  class="d-flex flex-row">
		      	<form action="./managecategory" method="post" class="d-inline-block" onsubmit="return updateCate()">
				    <input name="manage" class="btn btn-primary mr-2" type="submit" value="Sửa"/>
				    <input type="hidden" name="updateInput" id="updateInput" value=""/>    
				    <input type="hidden" name="formType" value="manageCateItem"/>                     
				    <input type="hidden" name="cateId" value="<%=c.getCateId()%>"/>                                     
				</form>
				
				<form action="./managecategory" method="post" class="d-inline-block" onsubmit ="return validateDelete()">
				    <input name="manage" class="btn btn-primary mr-2" type="submit" value="Xoá" />
				    <input type="hidden" name="formType" value="manageCateItem"/>                     
				    <input type="hidden" name="cateId" value="<%=c.getCateId()%>"/>                                     
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
			return confirm("Xoá danh mục?");			
		}

		function newCate() {
		    var input = prompt("Nhập tên danh mục:");
		    if (input !== null) {
		        input = input.trim(); // Loại bỏ các khoảng trắng ở đầu và cuối chuỗi
		        if (input === "") {
		            alert("Chưa nhập tên danh mục.");
		            return false;
		        } else {
		            document.getElementById("addNewCateInput").value = input;
		            return true;
		        }
		    } else {
		        return false;
		    }
		}

		function updateCate() {
		    var input = prompt("Nhập tên danh mục:");
		    if (input !== null) {
		        input = input.trim(); // Loại bỏ các khoảng trắng ở đầu và cuối chuỗi
		        if (input === "") {
		            alert("Chưa nhập tên danh mục.");
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