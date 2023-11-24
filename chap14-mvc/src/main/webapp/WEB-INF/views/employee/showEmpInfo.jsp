<%@ page contentType="text/html; UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Servlet-mvc</title>
</head>
<body>
    <jsp:include page="../common/header.jsp"/>

    <p>
        사원 번호 : ${requestScope.emp.empId}
    </p>
    <p>
        사원 이름 : ${requestScope.emp.empName}
    </p>
    <p>
        사원 이메일 : ${requestScope.emp.email}
    </p>
    <p>
        사원 전화번호 : ${requestScope.emp.phone}
    </p>
</body>
</html>