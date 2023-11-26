<%--
  Created by IntelliJ IDEA.
  User: jinkyu
  Date: 11/27/23
  Time: 2:09 AM
  To change this template use File | Settings | File Templates.
--%>
<!-- 수정 폼 페이지 추가 -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>직원 정보 수정 페이지</title>
</head>
<body>
<h3>직원 정보 수정</h3>
<form action="${pageContext.servletContext.contextPath}/employees/update" method="post">
    <input type="hidden" name="empId" value="${employees.empId}"/>
    직원명 : <input type="text" name="empName" value="${employees.empName}"/> <br>
    이메일 : <input type="email" name="email" value="${employees.email}"/> <br>
    전화번호 : <input type="tel" name="phone" value="${employees.phone}"/> <br>
    부서코드 :
    <select name="deptCode">
        <option value="D1">인사관리부</option>
        <option value="D2">회계관리부</option>
        <option value="D3">마케팅부</option>
        <option value="D4">국내영업부</option>
        <option value="D5">해외영업1부</option>
        <option value="D6">해외영업2부</option>
        <option value="D7">해외영업3부</option>
        <option value="D8">기술지원부</option>
        <option value="D9">총무부</option>
    </select>
    <br>
    직급코드 :
    <select name="jobCode">
        <option value="J1">대표</option>
        <option value="J2">부사장</option>
        <option value="J3">부장</option>
        <option value="J4">차장</option>
        <option value="J5">과장</option>
        <option value="J6">대리</option>
        <option value="J7">사원</option>
    </select>
    <br>
    급여등급 :
    <select name="salLevel">
        <option value="S1">S1</option>
        <option value="S2">S2</option>
        <option value="S3">S3</option>
        <option value="S4">S4</option>
        <option value="S5">S5</option>
        <option value="S6">S6</option>
    </select>
    <br>
    급여 : <input type="number" name="salary" value="${employees.salary}"/> <br>
    보너스율 : <input type="text" name="bonus" value="${employees.bonus}"/> <br>
    관리자 사번 : <input type="text" name="managerId" value="${employees.managerId}"/> <br>
    입사일 : <input type="date" name="hireDate" value="${employees.hireDate}"/> <br>
    <input type="submit" value="수정 완료"/>
</form>
</body>
</html>
