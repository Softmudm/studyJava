<%--这个jsp用作ajax返回时的html--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:forEach items="${list}" var="province" varStatus="s">
    <tr>
        <td><button class="btn btn-sm btn-primary">+</button></td>
        <td class="col-sm-1">${s.count}</td>
        <td>${province.pid}</td>
        <td>${province.pname}</td>
        <td>${province.fid}</td>
        <td>
            <button class="btn btn-warning" onclick="update(${province.pid})">修改</button>
            <button class="btn btn-danger" onclick="delProvince(${province.pid})">删除</button>
        </td>
    </tr>
    <tr hidden>
        <td></td>
        <td colspan="5">
            <div style="display:inline-block;width:97%;max-height: 200px;overflow-y:scroll">
            <table class="table table-striped table-bordered table-hover table-condensed text-center">
                <tr>
                    <td></td>
                    <td class="col-sm-1">序号</td>
                    <td>市编号</td>
                    <td>市名称</td>
                    <td>上级编号</td>
                    <td>操作</td>
                </tr>
                <tbody>
                    <c:if test="${fn:length(province.list)!=0}">
                        <c:forEach items="${province.list}" var="province1" varStatus="s1">
                            <tr>
                                <td></td>
                                <td>${s1.count}</td>
                                <td>${province1.pid}</td>
                                <td>${province1.pname}</td>
                                <td>${province1.fid}</td>
                                <td>
                                    <button class="btn btn-warning" onclick="update(${province1.pid})">修改</button>
                                    <button class="btn btn-danger" onclick="delProvince(${province1.pid})">删除</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${fn:length(province.list)==0}">
                        <tr><td colspan="6">没有数据！</td></tr>
                    </c:if>
                </tbody>
            </table>
            </div>
        </td>
    </tr>
</c:forEach>
