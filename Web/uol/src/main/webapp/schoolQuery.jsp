<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>学校信息维护</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css?v=4.1.0" rel="stylesheet">
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>学校信息维护</h5>
                </div>
                <div class="ibox-content">
                    <div style="margin: 8px 0px;">
                        <form role="form" class="form-inline" action="${pageContext.request.contextPath}/school">
                            <div class="form-group">
                                学校名称：<input type="text" name="schoolName" value="${schoolName}" id="exampleInputEmail2" class="form-control">
                                <input type="hidden" name="method" value="querySchool"/>
                            </div>
                            <button class="btn btn-info" type="submit" style="margin: 2px 0px 2px 4px;">查询</button>
                            <a href="${pageContext.request.contextPath}/schoolAdd.jsp" class="btn btn-primary" style="margin: 2px 0px 2px 4px;">添加</a>
                        </form>
                    </div>
                    <div style="text-align: center;margin: 8px 0px;">
                        <span style="color: red;">${message}</span>
                    </div>
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>学校名称</th>
                            <th>地址</th>
                            <th width="180">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pageInfo.list}" varStatus="status" var="schoolInfo">
                            <tr>
                                <td>${status.index+1}</td>
                                <td>${schoolInfo.schoolName}</td>
                                <td>${schoolInfo.address}</td>
                                <td>
                                    <a class="btn btn-xs btn-primary" href="${pageContext.request.contextPath}/school?method=deleteSchool&id=${schoolInfo.id}" >删除</a>
                                    <a class="btn btn-xs btn-primary" href="${pageContext.request.contextPath}/school?method=toUpdateSchool&id=${schoolInfo.id}" >修改</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="row">
                        <div style="width:300px;margin: 0 auto;">
                            <c:if test="${pageInfo.curPage!=1}">
                                <a href="${pageContext.request.contextPath}/school?method=querySchool&curPage=1&schoolName=${schoolName}">首页</a>
                                <a href="${pageContext.request.contextPath}/school?method=querySchool&curPage=${pageInfo.curPage-1}&schoolName=${schoolName}">上一页</a>
                            </c:if>
                            <span style="padding: 5px 10px;display: inline-block;height: 32px;line-height: 32px">
                            第${pageInfo.curPage}页/共${pageInfo.totalPage}页，
                            共${pageInfo.totalCount}记录</span>
                            <c:if test="${pageInfo.totalPage!=pageInfo.curPage}">
                                <a href="${pageContext.request.contextPath}/school?method=querySchool&curPage=${pageInfo.curPage+1}&schoolName=${schoolName}">下一页</a>
                                <a href="${pageContext.request.contextPath}/school?method=querySchool&curPage=${pageInfo.totalPage}&schoolName=${schoolName}">尾页</a>
                            </c:if>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 全局js -->
<script src="${pageContext.request.contextPath}/js/jquery.min.js?v=2.1.4"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.3.6"></script>

</body>

</html>
