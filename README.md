<p align="center" width="100%">
    <img width="60%" src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Spring_Framework_Logo_2018.svg/1280px-Spring_Framework_Logo_2018.svg.png"> 
</p>

<br/>
<br/>

# 1. Overview

#### 개요

<ins>`eclipse` IDE를 이용하여  springframework MVC project에 oracle, mybatis, transactionManger를 사용한 결과물이 나오도록 단계별로 commit을 수행하여, 변경된 이력을 쉽게 알수 있도록 작성된 sample project 입니다.</ins><br><br>

<b>[개발에 사용한 Tool]</b>

>Eclipse IDE Version: 2020-06 (4.16.0)<br/>
>Oracle 10이상<br/>
>Golden7<br/>
>apache-tomcat-9.0.65<br>
>Git-2.37.2.2-64-bit<br>
>TortoiseGit 2.13.0.1<br>

※ 화면 갭쳐된 이미지는 upload된 project와 다를 수 있습니다.

#### Git commit
1. New > Other... > Spring > Spring Legacy Project > Spring MVC Project

2. oracle, mybatis, transactionManager 사용 설정

3. boardWrite.jsp, boardList.jsp 추가

4. boardDAO, boardDAOImpl 추가

5. README 추가

<br><br>


# 2. Flow

## 2.1. Spring Legacy Project 생성
New > Other... > Spring > Spring Legacy Project > Spring MVC Project<br><br>
<p align="" >
    <img width="80%" src="https://github.com/soon24/SpringMVC/blob/main/docs/image/%EC%9D%B4%EB%AF%B8%EC%A7%80%20030.png?raw=true"> 
</p>
<p align="" >
    <img width="80%" src="https://github.com/soon24/SpringMVC/blob/main/docs/image/%EC%9D%B4%EB%AF%B8%EC%A7%80%20031.png?raw=true"> 
</p>
<p align="" >
    <img width="80%" src="https://github.com/soon24/SpringMVC/blob/main/docs/image/%EC%9D%B4%EB%AF%B8%EC%A7%80%20032.png?raw=true"> 
</p>

## 2.2. Spring Legacy Project 생성 후 설정
Project 우측마우스 "Properties > Java Build Path"<br><br>
설정 한 후에는 반드시 "Apply"를 적용 바랍니다.<br>
<p align="" >
    <img width="80%" src="https://github.com/soon24/SpringMVC/blob/main/docs/image/%EC%9D%B4%EB%AF%B8%EC%A7%80%20034.png?raw=true"> 
</p>
<p align="" >
    <img width="80%" src="https://github.com/soon24/SpringMVC/blob/main/docs/image/%EC%9D%B4%EB%AF%B8%EC%A7%80%20035.png?raw=true"> 
</p>

Java Compiler버전을 일치시키고 "Apply" 버튼
<p align="" >
    <img width="80%" src="https://github.com/soon24/SpringMVC/blob/main/docs/image/%EC%9D%B4%EB%AF%B8%EC%A7%80%20036.png?raw=true"> 
</p>

Project Facets Java 버전 일시키고 "Apply"버튼
<p align="" >
    <img width="80%" src="https://github.com/soon24/SpringMVC/blob/main/docs/image/%EC%9D%B4%EB%AF%B8%EC%A7%80%20037.png?raw=true"> 
</p>


## 2.3. pom.xml 수정
pom.xml maven-compiler-plugin 버전 일치
<p align="" >
    <img width="80%" src="https://github.com/soon24/SpringMVC/blob/main/docs/image/%EC%9D%B4%EB%AF%B8%EC%A7%80%20038.png?raw=true"> 
</p>


## 2.4. Oracle Library 추가
"src/main/webapp/WEB-INF/" lib 폴더를 만들고 ojdbc14.jar를 복사<br><br>
<p align="" >
    <img width="80%" src="https://github.com/soon24/SpringMVC/blob/main/docs/image/%EC%9D%B4%EB%AF%B8%EC%A7%80%20055.png?raw=true"> 
</p>

Project에서 우클릭 Properties에서 ojdbc14.jar를 등록<br><br>
<p align="" >
    <img width="80%" src="https://github.com/soon24/SpringMVC/blob/main/docs/image/%EC%9D%B4%EB%AF%B8%EC%A7%80%20053.png?raw=true"> 
</p>
<p align="" >
    <img width="80%" src="https://github.com/soon24/SpringMVC/blob/main/docs/image/%EC%9D%B4%EB%AF%B8%EC%A7%80%20054.png?raw=true"> 
</p>


# 3. 기타

## 3.1. Test시 주의사항
Eclipse IDE에서 tomcat server path를  "/app" 로 등록하고 jquery path는 등록된 "/app"이 최상위 경로입니다<br><br>
<p align="" >
    <img width="80%" src="https://github.com/soon24/SpringMVC/blob/main/docs/image/%EC%9D%B4%EB%AF%B8%EC%A7%80%20002.png?raw=true"> 
</p>
<p align="" >
    <img width="80%" src="https://github.com/soon24/SpringMVC/blob/main/docs/image/%EC%9D%B4%EB%AF%B8%EC%A7%80%20004.png?raw=true"> 
</p>





