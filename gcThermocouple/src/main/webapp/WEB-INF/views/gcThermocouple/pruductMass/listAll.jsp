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

<title>主要产品</title>
<%@include file="/WEB-INF/views/gcThermocouple/link.jsp"%>
</head>

<body style="min-height: 700px; padding-top: 50px;">

	<%@include file="/WEB-INF/views/gcThermocouple/header.jsp"%>

	<!-- Main component for a primary marketing message or call to action -->
	<div class="jumbotron"
		style="background: #898D8E url(/images/jxbs1.jpg) no-repeat left; background-size: cover; margin-bottom: 3px;">
		<div class="container"></div>
	</div>


	<div class="container-fluid" style="padding-top: 20px;">
		<!-- 
		<div class="row">
			<div class="col-md-12">
				<ul class="breadcrumb">
					<li><a href="#">产品列表</a> <span class="divider"></span></li>

					<li><a href="#">类目</a> <span class="divider"></span></li>
					<li class="active">主题</li> 
				</ul>
			</div>
		</div>
		-->
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
					<!-- 
					<div class="panel panel-default">
						<div class="panel-heading">
							<a class="accordion-toggle" data-toggle="collapse"
								data-parent="#accordion-773609" href="#accordion-element-360096">选项卡
								#1</a>
						</div>
						<div id="accordion-element-360096" class="panel-collapse collapse">
							<div class="panel-body">功能块...</div>
						</div>
					</div> -->

				</div>
			</div>
			<div class="col-md-10">
				<div class="row">
					<div class="col-md-7">
						<div class="page-header" style="margin-top: 20px;">
							<h1>
								产品列表 <small>按产品手册分类</small>
							</h1>
						</div>
						<c:forEach items="${typeFList}" var="typeF">
							<div>
								<h2>
									<c:out value="${typeF.name}" />
								</h2>
								<h6>
									<small><c:out value="${typeF.description}" /></small>
								</h6>
								<p>
									<c:forEach items="${typeSMap.get(typeF.typeID)}" var="typeS">
										<a
											href="/productMass/typeS/id/<c:out value="${typeS.typeID}" />"><c:out
												value="${typeS.name}" /></a>|
									</c:forEach>
									<a
										href="/productMass/typeF/id/<c:out value="${typeF.typeID}" />">查看更多
										»</a>
								</p>
							</div>
						</c:forEach>
					</div>
					<div class="col-md-5">
						<div class="jumbotron">
							<h1>特殊产品</h1>
							<p>本公司除去量产产品之外，还针对特别用户进行产品的定制。</p>
							<p>
								详情请看：<a href="#">历年案例</a>
							</p>
							<p>
								<a class="btn btn-primary btn-large" href="#">非标准定制 »</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- /container -->
	<%@include file="/WEB-INF/views/gcThermocouple/footer.jsp"%>
	<%@include file="/WEB-INF/views/gcThermocouple/jslink.jsp"%>
</body>
</html>