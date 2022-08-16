<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<%@ include file="./header.jsp" %>

<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<p>"src/main/resources/mappers" folder가 없으면 tocat server가 정상 구동되지 않습니다.</p>
<p>"src/main/resources/mappers"에 파일이 없으면 mappers folder가 eclipse에서 생성되지 않습니다</p>
<p>mappers folder 생성을 위한 dummy file을 추가합니다.</p>
<p>아래는 console error message</p>
<p>org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'sqlSessionFactory' defined in ServletContext resource [/WEB-INF/spring/appServlet/servlet-context.xml]: Initialization of bean failed; nested exception is org.springframework.beans.TypeMismatchException: Failed to convert property value of type 'java.lang.String' to required type 'org.springframework.core.io.Resource[]' for property 'mapperLocations'; nested exception is java.lang.IllegalArgumentException: Could not resolve resource location pattern [classpath:mappers/**/*.xml]: class path resource [mappers/] cannot be resolved to URL because it does not exist</p>

</body>
</html>
