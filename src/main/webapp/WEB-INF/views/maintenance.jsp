<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<c:url value = "/resources/design.css"/>"/>
<title>Insert title here</title>
<base href="http://localhost:8080/erp/maintenance/"/>
</head>
<body>
<div id="icon">
	<img src="<c:url value = "/resources/magnum_opus_logo.jpg"/>" width="200" height="200"
    alt="Logo Here" />
</div>
<header>
	<h1> Maintenance </h1>
</header>
<%@ include file="/resources/navbar.jsp" %>
<nav id="nav2">
	<ul>
		<li><a href="ingredient"> Ingredient </a></li>
		<li><a href="mi"> Menu Item </a></li>
		<li><a href="unit"> Unit </a></li>
		<li><a href="discount"> Discount </a></li>
	</ul>
</nav>
<c:choose>
	<c:when test="${model.tabletype == 'ingredient'}">
		<section>
			<article>
				<a href="ingredient"> Refresh </a>
				<h2>Ingredient Maintenance</h2>
				<form>
					<table>
						<tr>
							<th><input type ="checkbox"></th>
							<th>Ingredient Code</th>
							<th>Brand</th>
							<th>Name</th>
							<th>Type</th>
						</tr>
						<c:forEach items="${model.ingredient}" var="prod">
							<tr>
								<td>
									<input type = "checkbox" name = "code" value = "${prod.code}" />
								</td>
								<td><c:out value="${prod.code}" /></td>
								<td><c:out value="${prod.brand}" /></td>
								<td><c:out value="${prod.name}" /></td>
								<td><c:out value="${prod.type}" /></td>
							</tr>
						</c:forEach>
					</table>
					<button type="submit" formaction="ingredient/add">Add</button>
					<input type="submit" formaction="ingredient/delete" formmethod="post" value="Delete"/>
				</form>
			</article>
		</section>
		<aside>
			<h3>Options</h3>
			<ul>
				<li><a href="ingredient/type"> Ingredient Type </a></li>
			</ul>
		</aside>
	</c:when>
	
	<c:when test="${tabletype == 'menuItem'}">
		<section>
			<article>
				<a href="mi"> Refresh </a>
				<h2>Menu Item Maintenance</h2>
				<form>
					<table>
						<tr>
							<th><input type ="checkbox"></th>
							<th>Recipe Code</th>
							<th>Type</th>
							<th>Name</th>
							<th>Description</th>
							<th>Price</th>
						</tr>
						<c:forEach items="${menuItem.menuItemList}" var="menuItemList" varStatus="status">
							<tr>
								<td>
									<input type="checkbox" name="code" value = "${menuItemList.code}" />
								</td>
								<td>${menuItemList.code}</td>
								<td>${menuItemList.type}</td>
								<td>${menuItemList.name}</td>
								<td>${menuItemList.description}</td>
								<td>${menuItemList.price}</td>
							</tr>
						</c:forEach>
					</table>
					<input type="submit"  formaction="mi/edit" value="Edit" />
				</form>
			</article>
		</section>
		<aside>
			<h3>Options</h3>
			<ul>
				<li><a href="mi/type"> Menu Item Type </a></li>
				<li><a href="/erp/recipe-flow"> Recipe </a></li>
			</ul>
		</aside>
	</c:when>
	
	<c:when test="${tabletype == 'menuItemEdit'}">
		<section>
			<article>
				<a href="mi/edit"> Refresh </a>
				<h2>Menu Item Maintenance</h2>
				<sf:form method="post" modelAttribute="menuItem" >
					<table>
						<tr>
							<th>Recipe Code</th>
							<th>Type</th>
							<th>Name</th>
							<th>Description</th>
							<th>Price</th>
						</tr>
						<c:forEach items="${menuItem.menuItemList}" var="menuItemList" varStatus="status">
							<tr>
								<td><sf:input path="menuItemList[${status.index}].code" readonly="true"/></td>
								<td>	
									<sf:select path="menuItemList[${status.index}].typeCode" >
			        					<sf:options items="${menuItemType}" itemLabel="name" itemValue="code"/>
			        				</sf:select>
			        			</td>
								<td><sf:input path="menuItemList[${status.index}].name" /></td>
								<td><sf:input path="menuItemList[${status.index}].description" /></td>
								<td><sf:input path="menuItemList[${status.index}].price" /></td>
							</tr>
						</c:forEach>
					</table>
					<input type="submit" value="Accept" />
				</sf:form>
			</article>
		</section>
		<aside>
			<h3>Options</h3>
			<ul>
				<li><a href="mi/type"> Menu Item Type </a></li>
				<li><a href="/erp/recipe-flow"> Recipe </a></li>
			</ul>
		</aside>
	</c:when>
	
	<c:when test="${tabletype == 'editRecipe'}">
		<section>
			<article>
				<a href="mi"> Refresh </a>
				<h2>Menu Item Maintenance</h2>
					<table>
						<tr>
							<th>Recipe Code</th>
							<th>Type</th>
							<th>Name</th>
							<th>Description</th>
							<th>Price</th>
							<th>Options</th>
						</tr>
						<c:forEach items="${menuItem.menuItemList}" var="menuItemList" varStatus="status">
							<tr>
								<td>${menuItemList.code}</td>
								<td>${menuItemList.type}</td>
								<td>${menuItemList.name}</td>
								<td>${menuItemList.description}</td>
								<td>${menuItemList.price}</td>
								<td>
								<form action="mi/recipe/edit">
									<input type="submit" value="Recipe" />
									<input type="hidden" name="code" value="${menuItemList.code}"/>
								</form>
								</td>
							</tr>
						</c:forEach>
					</table>
				
			</article>
		</section>
		<aside>
			<h3>Options</h3>
			<ul>
				<li><a href="mi/type"> Menu Item Type </a></li>
				<li><a href="/erp/recipe-flow"> Recipe </a></li>
			</ul>
		</aside>
	</c:when>
	
	<c:when test="${tabletype == 'ingredientType'}">
		<section>
			<article>
				<a href="ingredient/type"> Refresh </a>
				<h2>Ingredient Type</h2>
				<form>
					<table>
						<tr>
							<th><input type="checkbox"/></th>
							<th>Code</th>
							<th>Name</th>
						</tr>
						<c:forEach items="${ingredientType}" var="type">
							<tr>
								<td>
										<input type = "checkbox" name = "code" value = "${type.code}" />
								</td>
								<td><c:out value="${type.code}" /></td>
								<td><c:out value="${type.name}" /></td>	
							</tr>
						</c:forEach>
					</table>
					<button type="submit" formaction="ingredient/type/add">Add</button>
					<input type="submit" formaction="ingredient/type/delete" formmethod="post" value="Delete"/>
				</form>
			</article>
		</section>
		<aside>
		
		</aside>
	</c:when>
	
	<c:when test="${model.tabletype == 'unit'}">
		<section>
			<article>
				<a href="unit"> Refresh </a>
				<h2>Unit Maintenance</h2>
				<form>
					<table>
						<tr>
							<th><input type ="checkbox"/></th>
							<th>Unit Code</th>
							<th>Name</th>
							<th>Post Unit</th>
							<th>Conversion Factor</th>
						</tr>
						<c:forEach items="${model.object}" var="prod">
							<tr>
								<td>
									<input type = "checkbox" name = "codeUnit" value = "${prod.codeUnit}" />
								</td>
								<td><c:out value="${prod.codeUnit}" /></td>
								<td><c:out value="${prod.name}" /></td>
								<td><c:out value="${prod.namePostUnit}" /></td>
								<td><c:out value="${prod.conversionFactor}" /></td>
								
							</tr>
						</c:forEach>
					</table>
					<button type="submit" formaction="unit/add">Add</button>
					<input type="submit" formaction="unit/delete" formmethod="post" value="Delete"/>
				</form>
			</article>
		</section>
		<aside>
			<h3>Options</h3>
			<ul>
				
			</ul>
		</aside>
	</c:when>
	
	<c:when test="${model.tabletype == 'mitype'}">
		<section>
			<article>
				<a href="mi/type"> Refresh </a>
				<h2>Menu Item Maintenance</h2>
				<form>
					<table>
						<tr>
							<th><input type ="checkbox"/></th>
							<th>Code</th>
							<th>Name</th>
						</tr>
						<c:forEach items="${model.object}" var="prod">
							<tr>
								<td>
									<input type = "checkbox" name = "code" value = "${prod.code}" />
								</td>
								<td><c:out value="${prod.code}" /></td>
								<td><c:out value="${prod.name}" /></td>
							</tr>
						</c:forEach>
					</table>
					<button type="submit" formaction="mi/type/add">Add</button>
					<input type="submit" formaction="mi/type/delete" formmethod="post" 
					value="Delete" onClick="return confirm('Do you want to delete item number ${prod.name}?')"/>
				</form>
			</article>
		</section>
		<aside>
			<h3>Options</h3>
			<ul>
			
			</ul>
		</aside>
	</c:when>
	
	<c:when test="${tabletype == 'discount'}">
		<section>
			<article>
				<a href="discount"> Refresh </a>
				<h2>Discount Maintenance</h2>
				<form>
					<table>
						<tr>
							<th><input type ="checkbox"/></th>
							<th>Code</th>
							<th>Name</th>
							<th>Discount Factor</th>
							<th>Vatable</th>
						</tr>
						<c:forEach items="${discount}" var="prod">
							<tr>
								<td>
									<input type = "checkbox" name = "codeDiscount" value = "${prod.codeDiscount}" />
								</td>
								<td><c:out value="${prod.codeDiscount}" /></td>
								<td><c:out value="${prod.name}" /></td>
								<td><c:out value="${prod.discountFactor}" /></td>
								<td><c:out value="${prod.indVatable }"/></td>
							</tr>
						</c:forEach>
					</table>
					<button type="submit" formaction="discount/add">Add</button>
					<input type="submit" formaction="discount/delete" formmethod="post" 
					value="Delete" onClick="return confirm('Do you want to delete item number ${prod.name}?')"/>
				</form>
			</article>
		</section>
		<aside>
			<h3>Options</h3>
			<ul>
			
			</ul>
		</aside>
	</c:when>
	
	<c:otherwise>
		<section>
			<article>
				<h2>Please choose action</h2>
			</article>
		</section>
		<aside>
			<h3>Options</h3>
			<ul>
				<li><a href="ingredient"> Ingredient </a></li>
				<li><a href="mi"> Menu Item </a></li>
				<li><a href="unit"> Unit </a></li>
				<li><a href="discount"> Discount </a></li>
				
			</ul>
		</aside>
	</c:otherwise>
</c:choose>

<%@ include file="/resources/footer.html" %>
</body>
</html>