<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>SUN</title>
</head>
<body>
	<div id="root">
		<header id="header">
			<div id="header_box">
				<%@ include file="../include/header.jsp"%>
			</div>
		</header>

		<nav id="nav">
			<div id="nav_box">
				<%@ include file="../include/nav.jsp"%>
			</div>
		</nav>

		<section id="container">
			<div id="container_box">

				<section id="content">
					<form role="form" method="post" autocomplete="off">
						<div class="input_area">
							<label for="userId">ID</label> <input type="email" id="userId"
								name="userId" required="required" value="sun@gmail.com" />
						</div>

						<div class="input_area">
							<label for="userPass">パスワード</label> <input type="password"
								id="userPass" name="userPass" required="required" value="1111" />
						</div>

						<button type="submit" id="signin_btn" name="signin_btn">ログイン</button>

						<c:if test="${msg == false}">
							<p style="color: #f00;">ログインできませんでした。</p>
						</c:if>

					</form>
				</section>

			</div>
		</section>

		<footer id="footer">
			<div id="footer_box">
				<%@ include file="../include/footer.jsp"%>
			</div>
		</footer>

	</div>
</body>
</html> 