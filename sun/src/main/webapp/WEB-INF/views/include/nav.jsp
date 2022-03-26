<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul>
	<c:if test="${member == null}">
		<li><a href="/member/signin">ログイン</a></li>
		<li><a href="/member/signup">会員登録</a></li>
	</c:if>
	<c:if test="${member != null}">

		<c:if test="${member.verify == 9}">
			<li><a href="/admin/index">管理画面</a></li>
		</c:if>

		<li>ようこそ ${member.userName}様</li>
		<li><a href="/member/signout">ログアウト</a></li>
	</c:if>

</ul>