<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<input type="hidden" id="currentPage" value="${page.totalpage}">
<input type="hidden" id="pageNum" value="${page.pageno}">
<input type="hidden" id="pageSize" value="${page.pagesize}">
<c:forEach items="${page.data}" var="conference">
    <tr>
        <td>${conference.serialId}</td>
        <td>${conference.conferenceId}</td>
        <td>${conference.conferenceName}</td>
        <td>${conference.conferenceAddr}</td>
        <td>${conference.conferenceSize}</td>
        <td>
            <button class="btn btn-success" onclick="update('${conference.serialId}','${conference.conferenceId}','${conference.conferenceName}','${conference.conferenceAddr}','${conference.conferenceSize}')">修改</button>
            <button class="btn btn-warning" onclick="del(${conference.serialId})">删除</button>
        </td>
    </tr>
</c:forEach>
