<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="./js/jquery-3.2.1.js"></script>
    <script src="./bootstrap/js/bootstrap.min.js"></script>
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-4 column">
        </div>
        <div class="col-md-4 column">
            <form role="form" action="/addOrUpdate" method="post">
                <div class="form-group">
                    <label for="xsbh">学生编号</label><input type="text" class="form-control" name ="xsbh" id="xsbh" value="${student.xsbh}"/>
                </div>
                <div class="form-group">
                    <label for="xsxm">学生姓名</label><input type="text" class="form-control"  name ="xsxm" id="xsxm" value="${student.xsxm}" />
                </div>
                <div class="form-group">
                    <label for="sfzx">是否在校*</label>
                    <select  name ="sfzx"  id = "sfzx" class="form-control">
                        <option value="0"<c:if test="${student.sfzx==0}">selected</c:if>>不在校</option>
                        <option value="1"<c:if test="${student.sfzx==1}">selected</c:if>>在校</option>

                    </select>

                    <!--<input type="text" class="form-control" id="sfzx" />-->
                </div>
                <div class="form-group">
                    <label for="zgxlm">最高学历编码</label><input  name ="zgxlm"  type="text" class="form-control" id="zgxlm" value="${student.zgxlm}"/>
                </div>
                <div class="form-group">
                    <label for="zgxlmc">最高学历名称</label><input  name ="zgxlmc" type="text" class="form-control" id="zgxlmc" value="${student.zgxlmc}"/>
                </div>    <div class="form-group">
                <label for="gkzf">高考总分</label><input type="text"  name ="gkzf" class="form-control" id="gkzf"value="${student.gkzf}" />
            </div>
                <div class="form-group">
                    <label for="yx">院校</label><input type="text"  name ="yx" class="form-control" id="yx" value="${student.yx}"/>
                </div>
                <div class="form-group">
                    <label for="zy">专业</label><input type="text"  name ="zy" class="form-control" id="zy" value="${student.zy}" />
                </div>    <div class="form-group">
                <label for="nj">年级</label><input type="text"  name ="nj" class="form-control" id="nj" value="${student.nj}"/>
            </div>
                <div class="form-group">
                    <label for="bj">班级</label><input type="text"  name ="bj" class="form-control" id="bj" value="${student.bj}"/>
                </div>    <div class="form-group"><input type="hidden"  name ="id" class="form-control" id="id" value="${student.id}" />
            </div>




                <button type="submit" class="btn btn-default">保存</button>
            </form>
        </div>
        <div class="col-md-4 column">
        </div>
    </div>
</div>
</body>
</html>