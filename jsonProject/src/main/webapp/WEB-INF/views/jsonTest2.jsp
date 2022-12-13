<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- bootstrap -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!--jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!--propper jquery -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!--latest javascript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<meta charset="UTF-8">
<title>JSON TEST2</title>
</head>
<body>

<h1>
	교촌치킨 메뉴
</h1><hr/>

<table border="1">
	<tr>
		<th>가게명</th>
		<th>메뉴Id</th>
		<th>메뉴명</th>
		<th>가격</th>
		<th>소개</th>
		<th>메뉴 등록일</th>
		<th>메뉴 수정</th>
	</tr>
	<c:forEach items="${menuList}" var="list">
		<tr>
			<td>${list.marketName}</td>
			<td>${list.menuId}</td>
			<td>${list.menuName}</td>
			<td>${list.menuPrice}</td>
			<td>${list.introduce}</td>
			<td>${list.sysRegDate}</td>		 
			<th>
				<a id="menuUpdateBtn"  class="menuUpdateBtn btn btn-success" type="button" 
				href="/menuUpdatePage2" data-menuId="${list.menuId}">x</a>
			</th>
		</tr>
	</c:forEach>
</table>


<script>
const jsonMap = '${jsonMap}';
console.log(jsonMap);

const jsonMapParse = JSON.parse(jsonMap);
console.log(jsonMapParse);

const jsonMapParseList = [
	jsonMapParse.menuList0,
	jsonMapParse.menuList1,
	jsonMapParse.menuList2,
	jsonMapParse.menuList3,
	jsonMapParse.menuList4 ];
console.log(jsonMapParseList);


//forEach로 반복생성한 애들 중에 클릭한 아이의 값들만 서버로 전송하기
$(function(){
	$("a.menuUpdateBtn").click(function(event){
		event.preventDefault();
		alert("진입!");
		let e = $(event.target);
		
		const menuId = { 'menuId' : e.attr("data-menuId")};
		const menuIdStr = JSON.stringify(menuId);
		
		const arr = [{
			menuId: menuId,
			menuList: jsonMapParseList }];
		console.log(arr);

	
		//주의할 점!! JSON형식으로 response하기 위해서는 jackson라이브러리가 필요한데, 
		//jackson 라이브러리는 스프링 버전 3.1.2 이상에서만 지원함
		//pom.xml에서 springframework-version을 꼭 3.1.2 이상으로 수정해줘야 정상적으로 작동함!
		var headers = {"Content-Type" : "application/json" ,
				"X-HTTP-Method-Override" : "POST"};
		
		$.ajax({
			headers: headers, 
			url: e.attr("href"),
			type: "post",
			dataType: 'text', 
			data: JSON.stringify(arr)
		});
	});
});

</script>


</body>
</html>