<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h1 {
		background-color: rgba(0,255,0,0.7);
		color: white;
		padding: 1.2rem;
		text-align: center;
	}
	
	a {
		text-decoration: none; /* 텍스트에 설정된 것을 없애라(밑줄사라졌음) */
	}
	
	/* 위에 코드들은 한번 지정하면 페이지 바뀔때까지 변하지 않음 */
	
	/*
		CSS3을 사용한 interactive 스타일 지정
		동적(Dynamic) 스타일 지정
		(실시간)
	*/
	/* a tag에 마우스가 떠 있으면 */
	a:hover {
		text-decoration: underline; /* 마우스 올리면 밑줄생김 */
		background-color: rgba(0,0,255,0.3);
	}
</style>
</head>
<body>
	<h1>다이어트를 도와줘!!!</h1>
	<%-- /diet/food/search --%>
	<a href="${pageContext.request.contextPath}/food/search">섭취정보 등록</a>
</body>
</html>