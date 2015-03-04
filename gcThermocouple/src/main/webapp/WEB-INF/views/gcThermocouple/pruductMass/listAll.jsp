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


	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<ul class="breadcrumb">
					<li><a href="#">产品列表</a> <span class="divider"></span></li>
					<!-- 
					<li><a href="#">类目</a> <span class="divider"></span></li>
					<li class="active">主题</li> -->
				</ul>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<div class="panel-group" id="accordion-773609">
					<c:forEach items="${typeMap}" var="typeF">
						<c:out value="${typeF.key}" />
						<c:out value="${typeF.value.typeFId}" />
						<c:forEach items="${typeF.value}" var="typeS">
							<c:out value="${typeS.key}" />
						</c:forEach>

						<div class="panel panel-default">
							<div class="panel-heading">
								<a class="accordion-toggle" data-toggle="collapse"
									data-parent="#accordion-773609"
									href="#accordion-element-<c:out value="${typeF.value.typeFId}" />"><c:out
										value="${typeF.key}" /></a>
							</div>
							<div
								id="accordion-element-<c:out value="${typeF.value.typeFId}" />"
								class="panel-collapse collapse">
								<c:forEach items="${typeF.value}" var="typeS">
									<div class="panel-body">
										<a
											href="/productMass/typeF/<c:out value="${typeS.value.typeID}" />"><c:out
												value="${typeS.key}" /></a>
									</div>
								</c:forEach>

							</div>
						</div>
					</c:forEach>
					<div class="panel panel-default">
						<div class="panel-heading">
							<a class="accordion-toggle" data-toggle="collapse"
								data-parent="#accordion-773609" href="#accordion-element-360096">选项卡
								#1</a>
						</div>
						<div id="accordion-element-360096" class="panel-collapse collapse">
							<div class="panel-body">功能块...</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<a class="accordion-toggle collapsed" data-toggle="collapse"
								data-parent="#accordion-773609" href="#accordion-element-674542">选项卡
								#2</a>
						</div>
						<div id="accordion-element-674542" class="panel-collapse collapse">
							<div class="panel-body">功能块...</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="row">
					<div class="col-md-4">
						<div class="media">
							<a class="pull-left" href="#"><img class="media-object"
								src="img/a_002.jpg" alt='' /></a>
							<div class="media-body">
								<h4 class="media-heading">嵌入媒体标题</h4>
								请尽量使
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="media">
							<a class="pull-left" href="#"><img class="media-object"
								src="img/a_002.jpg" alt='' /></a>
							<div class="media-body">
								<h4 class="media-heading">嵌入媒体标题</h4>
								请尽量使用HTML
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="media">
							<a class="pull-left" href="#"><img class="media-object"
								src="img/a_002.jpg" alt='' /></a>
							<div class="media-body">
								<h4 class="media-heading">嵌入媒体标题</h4>
								请尽量使用
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<ul class="pagination">
							<li><a href="#">上一页</a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#">下一页</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="jumbotron">
					<h1>公司概况：</h1>
					<p>本公司除去量产产品之外，还针对特别用户进行产品的特别定制。</p>
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


	<!-- /container -->
	<%@include file="/WEB-INF/views/gcThermocouple/footer.jsp"%>
	<%@include file="/WEB-INF/views/gcThermocouple/jslink.jsp"%>


</body>
</html>