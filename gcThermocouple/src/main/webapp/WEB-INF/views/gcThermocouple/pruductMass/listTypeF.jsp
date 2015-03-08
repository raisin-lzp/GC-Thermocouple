<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="raisin-lzp">
<meta name="keyword" content="">

<title>产品列表-<c:out value="${thisPageType.name}" /></title>
<%@include file="/WEB-INF/views/gcThermocouple/link.jsp"%>
</head>

<body style="min-height: 700px; padding-top: 50px;">

	<%@include file="/WEB-INF/views/gcThermocouple/header.jsp"%>

	<!-- Main component for a primary marketing message or call to action -->
	<div class="jumbotron"
		style="background: #898D8E url(/images/jxbs1.jpg) no-repeat left; background-size: cover; margin-bottom: 3px;">
		<div class="container"></div>
	</div>


	<div class="container-fluid">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="/productMass/">产品列表</a></li>
				<li class="active"><c:out value="${thisPageType.name}" /></li>
			</ol>
			<!-- 
					<a href="/productMass/">产品列表</a>/<a
						href="/productMass/typeF/id/<c:out value="${thisPageType.typeID}" />"><c:out
							value="${thisPageType.name}" /></a> -->
		</div>
		<div class="row">
			<div class="col-md-2">
					<div class="panel-group" id="accordion-773609">
						<c:forEach items="${typeFList}" var="typeF">
							<div class="panel panel-default">
								<div class="panel-heading">
									<a class="accordion-toggle" data-toggle="collapse"
										data-parent="#accordion-773609"
										href="#accordion-element-<c:out value="${typeF.typeID}" />"><c:out
											value="${typeF.name}" /></a>
								</div>
								<div id="accordion-element-<c:out value="${typeF.typeID}" />"
									class="panel-collapse collapse">
									<c:forEach items="${typeSMap.get(typeF.typeID)}" var="typeS">
										<div class="panel-body">
											<a
												href="/productMass/typeS/id/<c:out value="${typeS.typeID}" />"><c:out
													value="${typeS.name}" /></a>
										</div>
									</c:forEach>
									<div class="panel-body text-center">
										<a
											href="/productMass/typeF/id/<c:out value="${typeF.typeID}" />">查看更多…<!--<c:out
											value="${typeF.typeID}" />-->
										</a>
									</div>

								</div>
							</div>
						</c:forEach>
					</div>
			</div>
			<div class="col-md-10">

				<div class="page-header" style="margin-top: 5px;">
					<h2 style="padding-left: 10px; margin-top: 1px;">
						<c:out value="${thisPageType.name}" />
					</h2>
					<h6 style="padding-left: 25px;">
						<small><c:out value="${thisPageType.description}" /></small>
					</h6>
				</div>

				<c:forEach items="${typeSMap.get(thisPageType.typeID)}"
					var="thisPageTypeS">
					<div class="col-sm-6 col-md-3">
						<div class="thumbnail">
							<img
								src="/images/productMass/type/typeId_<c:out value="${thisPageTypeS.typeID}" />.jpg"
								alt="<c:out
									value="${thisPageTypeS.name}" />">
							<div class="caption">
								<h3>
									<c:out value="${thisPageTypeS.name}" />
								</h3>
								<p>
									<c:out value="${thisPageTypeS.description}" />
								</p>
								<p>
									<a
										href="/productMass/typeS/id/<c:out value="${thisPageTypeS.typeID}" />"
										class="btn btn-primary" role="button">查看</a>
								</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

		</div>
	</div>


	<!-- /container -->
	<%@include file="/WEB-INF/views/gcThermocouple/footer.jsp"%>
	<%@include file="/WEB-INF/views/gcThermocouple/jslink.jsp"%>


</body>
</html>