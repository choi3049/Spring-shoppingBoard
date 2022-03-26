<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
								name="userId" placeholder="example@email.com"
								required="required" />
						</div>

						<div class="input_area">
							<label for="userPass">パスワード</label> <input type="password"
								id="userPass" name="userPass" required="required" />
						</div>

						<div class="input_area">
							<label for="userName">ユーザー名</label> <input type="text"
								id="userName" name="userName" placeholder="ユーザー名を入力してください"
								required="required" />
						</div>

						<div class="input_area">
							<label for="userPhon">電話番号</label> <input type="text"
								id="userPhon" name="userPhon" placeholder="電話番号を入力してください"
								required="required" />
						</div>

						<button type="submit" id="signup_btn" name="signup_btn">会員登録</button>

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