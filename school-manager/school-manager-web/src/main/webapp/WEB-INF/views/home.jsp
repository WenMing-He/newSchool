<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>


    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/bootstrap/css/fileinput.min.css" rel="stylesheet">
    <script src="/js/jquery-3.2.1.js"></script>
    <script src="/bootstrap/js/bootstrap.js"></script>
    <script src="/bootstrap/js/fileinput.js"></script>
    <script src="/bootstrap/js/zh.js"></script>
    <script>
        $(function () {
            //0.初始化fileinput
            var oFileInput = new FileInput();
            oFileInput.Init("file", "/upload");
        });

        //初始化fileinput
        var FileInput = function () {
            var oFile = new Object();

            //初始化fileinput控件（第一次初始化）
            oFile.Init = function (ctrlName, uploadUrl) {
                var control = $('#' + ctrlName);

                //初始化上传控件的样式
                control.fileinput({
                    language: 'zh', //设置语言
                    uploadUrl: uploadUrl, //上传的地址
                    allowedFileExtensions: ['xml'],//接收的文件后缀
                    showUpload: true, //是否显示上传按钮
                    showCaption: false,//是否显示标题
                    browseClass: "btn btn-primary", //按钮样式
                    maxFileCount: 10, //表示允许同时上传的最大文件个数
                    enctype: 'multipart/form-data',
                    validateInitialCount: true,
                    previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
                    msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
                });

                //导入文件上传完成之后的事件
                $("#file").on("fileuploaded", function (event, data, previewId, index) {
                    var jsonstr =data.response ;
                    var studentList="";
                    for (var i=0;i<jsonstr.length;i++)
                    {

                        student = jsonstr[i];
                    studentList+="<tr>"+
                    "<td>"+student.xsbh+"</td>"+
                    "<td>"+student.xsxm+"</td>";
                    if(student.sfzx==0){
                        studentList+=  "<td>不在校 </td>";
                    }else{
                        studentList+= "<td> 在校</td>";
                    }
                    studentList+="<td>"+student.zgxlm+"/td>"+
                    "<td>"+student.zgxlmc+"</td>"+
                    "<td>"+student.gkzf+"</td>"+
                    "<td>"+student.yx+"</td>"+
                    "<td>"+student.zy+"</td>"+
                    "<td>"+student.nj+"</td>"+
                    "<td>"+student.bj+"</td>"+
                    "<td>"+
                    "<div class=\"btn-group\">"+
                        "<a href=\"/edit?id="+student.id+"\" class=\"btn btn-default\">修改</a>"+
                        "<a href=\"/delete?id="+student.id+"\" class=\"btn btn-danger\">删除</a>"+
                        "</div>"+

                        "</td>"+
                        "</tr>";
                    }
                    $("tbody").html("");
                    $("tbody").html(studentList);

                });
            }
            return oFile;
        };
    </script>
</head>

<body>

<div class="col-md-1 column"></div>
<div class="col-md-10 column">
    <div class="panel panel-default">
        <div class="panel-heading">
            搜索
        </div>
        <div class="panel-body">
            <form role="form" class="form-inline" action="/find">

                <div class="form-group">
                    <select id="selects" name="selects" class="form-control" onchange="chanage(this)">
                        <option value="xsbh">编号</option>
                        <option value="xsxm">姓名</option>
                    </select>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control"  name="sreach" id="sreach" placeholder="请输入内容">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-default">开始搜索</button>
                </div>
                <!-- Modal -->
                <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                <button type="button" class="close" data-dismiss="moxdal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>

                            <div class="modal-body">
                                <input type="file" name="file" id="file" multiple class="file-loading"/>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
                <script>
                    $(document).ready( function() {
                        $("#input-b2").fileinput({
                            showPreview: false,
                            showUpload: false,
                            elErrorContainer: '#kartik-file-errors',
                            allowedFileExtensions: ["xml"],
                            uploadUrl: '/upload'
                        });

                    });

                </script>

                <a href="" class="btn btn-default" data-toggle="modal" data-target="#exampleModal" style="float: right;margin-right: 9px;">导入</a>
                <a href="/download" class="btn btn-default" style="float: right;">导出</a>
                <a href="/edit" class="btn btn-default" style="float: right;margin-right: 9px;">新增</a>
            </form>
        </div>
    </div>
    <!--
        列表展示
    -->
    <div class="table-responsive">
        <table class="table table-striped ">
            <thead>
            <tr>
                <th>学生编号</th>
                <th>学生姓名</th>
                <th>是否在校</th>
                <th>最高学历编码</th>
                <th>最高学历名称</th>
                <th>高考总分</th>
                <th>院校</th>
                <th>专业</th>
                <th>年级</th>
                <th>班级</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${StudentList}" var="student" >
            <tr>
                <td>${student.xsbh}</td>
                <td>${student.xsxm}</td>
                <td><c:if test="${student.sfzx==0}">不在校</c:if><c:if test="${student.sfzx==1}">在校</c:if> </td>
                <td>${student.zgxlm}</td>
                <td>${student.zgxlmc}</td>
                <td>${student.gkzf}</td>
                <td>${student.yx}</td>
                <td>${student.zy}</td>
                <td>${student.nj}</td>
                <td>${student.bj}</td>
                <td>
                    <div class="btn-group">
                        <a href="/edit?id=${student.id}" class="btn btn-default">修改</a>
                        <a href="/delete?id=${student.id}" class="btn btn-danger">删除</a>
                    </div>

                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


</body></html>