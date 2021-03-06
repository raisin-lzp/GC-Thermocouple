<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="raisin-lzp">
<meta name="keyword" content="">

<title>欢迎光临国才热电偶</title>
<%@include file="/WEB-INF/views/gcThermocouple/link.jsp"%>
</head>

<body style="min-height: 700px; padding-top: 50px;">

	<%@include file="/WEB-INF/views/gcThermocouple/header.jsp"%>

	<!-- Main component for a primary marketing message or call to action -->
	<div class="jumbotron"
		style="background: #898D8E url(/images/jxbs1.jpg) no-repeat left; background-size: cover; margin-bottom: 3px;">
		<div class="container">
			<h2 style="color: #ffffff;">欢迎光临</h2>
			<h1 style="font-family: 微软雅黑; color: #ffffff;">&nbsp;&nbsp;&nbsp;&nbsp;国才热电偶</h1>
			<p style="color: #ffffff;">专业的热电偶制造商</p>
		</div>
	</div>

	<div class="container-fluid" style="max-width: 1000px;">
		<div class="row">
			<div class="col-sm-12 col-md-6">
				<div class="row">
					<h2 style="color: #000000; font-family: 微软雅黑;">
						<font style="border-bottom: #6896EA solid 2px; color: #4B5C54;">主营产品</font>
					</h2>
					<div onclick="window.open('http://www.baidu.com/')"
						style="background-image: url(/images/thermocouple.jpg);"
						class="col-md-6">
						<p>热电偶</p>
					</div>
					<div onclick="window.open('www.baidu.com')"
						style="background-image: url(/images/pt.jpg);" class="col-md-6">
						<p>铂电阻</p>
					</div>
					<div onclick="window.open('www.baidu.com')"
						style="background-image: url(/images/line.jpg);" class="col-md-6">
						<p>补偿导线</p>
					</div>
					<div onclick="window.open('www.baidu.com')"
						style="background-image: url(/images/meter.jpg);" class="col-md-6">
						<p>各种仪表</p>
					</div>
				</div>
			</div>
			<div class="col-sm-12 col-md-6"
				style="max-width: 400px; background-color: #2A51CD; padding-left: 20px; padding-right: 26px; padding-top: 10px; padding-bottom: 20px;">
				<div
					style="background-image: url(/images/job_small.jpg); cursor: auto; width: 355px; height: 215px; margin-left: 0px; margin-right: 0px; margin-top: 10px;"
					class="row"></div>
				<h2 style="color: #FFFFFF; font-family: 微软雅黑;">
					<font style="border-bottom: #6896EA solid 2px;">经营范围</font>
				</h2>

				<p>
					<a>铠装材料</a>&nbsp;<a>热电偶</a>&nbsp;<a>铂电阻</a>
				</p>
				<p>
					<a>补偿导线</a>&nbsp;<a>陶瓷管</a>&nbsp;<a>刚玉管</a>
				</p>
				<p>
					<a>瓷珠</a>&nbsp;<a>热缩管</a>&nbsp;<a>铜接线片</a>
				</p>
				<p>
					<a>热电偶钢管</a>&nbsp;<a>纱包线</a>&nbsp;<a>屏蔽线</a>
				</p>
				<p>
					<a>各种仪表</a>
				</p>
			</div>
		</div>

	</div>
	<!-- /container -->
	<%@include file="/WEB-INF/views/gcThermocouple/footer.jsp"%>
	<%@include file="/WEB-INF/views/gcThermocouple/jslink.jsp"%>


</body>
</html>