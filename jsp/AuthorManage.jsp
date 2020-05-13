<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>

<head>
    <title>青少年阅读网-作者管理</title>
    <!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
    <link href="assets/styles.css" rel="stylesheet" media="screen">
    <link href="assets/DT_bootstrap.css" rel="stylesheet" media="screen">
    <!--[if lte IE 8]><script language="javascript" type="text/javascript" src="vendors/flot/excanvas.min.js"></script><![endif]-->
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <script src="vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>
</head>

<body>
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container-fluid">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="#">青少年阅读网</a>
            <div class="nav-collapse collapse">
                <ul class="nav pull-right">
                    <li class="dropdown">
                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown"> <i class="icon-user"></i> 管理员 <i class="caret"></i>

                        </a>
                        <ul class="dropdown-menu">
                            <li>
                                <a tabindex="-1" href="loginPage.jsp">切换账户</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <ul class="nav">
                    <li class="">
                        <a href="novel_showAll">前台首页</a>
                    </li>
                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
    </div>
</div>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span3" id="sidebar">
            <ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
                <li>
                    <a href="news_managerFindAll"><i class="icon-chevron-right"></i>资讯管理</a>
                </li>
                <li>
                    <a href="novel_managerFindN"><i class="icon-chevron-right"></i> 小小说管理</a>
                </li>
                <li>
                    <a href="novel_managerFindP"><i class="icon-chevron-right"></i> 诗歌管理</a>
                </li>
                <li >
                    <a href="novel_managerFindS"><i class="icon-chevron-right"></i> 散文管理</a>
                </li>
                <li >
                    <a href="novel_managerFindD"><i class="icon-chevron-right"></i> 读后感管理</a>
                </li>
                <li >
                    <a href="comment_findAll"><i class="icon-chevron-right"></i> 评论管理</a>
                </li>
                <li class="active">
                    <a href="author_findAll"><i class="icon-chevron-right"></i> 用户管理</a>
                </li>
            </ul>
        </div>
        <!--/span-->
        <div class="span9" id="content-admin">
            <div class="row-fluid">
                <!-- block -->
                <div class="block">
                    <div class="navbar navbar-inner block-header">
                        <div class="muted pull-left">用户列表</div>
                    </div>
                    <div class="block-content collapse in">
                        <div class="span12">
                            <div class="table-toolbar">
                                <!--<div class="btn-group">-->
                                <!--<a href="#"><button class="btn btn-success">增加资讯<i class="icon-plus icon-white"></i></button></a>-->
                                <!--</div>-->
                                <!--<div class="btn-group pull-right">-->
                                <!--<button data-toggle="dropdown" class="btn dropdown-toggle">Tools <span class="caret"></span></button>-->
                                <!--<ul class="dropdown-menu">-->
                                <!--<li><a href="#">Print</a></li>-->
                                <!--<li><a href="#">Save as PDF</a></li>-->
                                <!--<li><a href="#">Export to Excel</a></li>-->
                                <!--</ul>-->
                                <!--</div>-->
                            </div>

                            <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example2">
                                <thead>
                                <tr>
                                    <th>作者</th>
                                    <th>性别</th>
                                    <th>年龄</th>
                                    <th>文章数</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <s:iterator value="list" var="d">
                                <tr class="odd gradeX">
                                    <td><s:property value="#d.authname"/></td>
                                    <td><s:property value="#d.sex"/></td>
                                    <td><s:property value="#d.age"/></td>
                                    <td><s:property value="#d.sum"/></td>
                                    <td class="center"><a href="author_managerCheck?id=<s:property value="#d.id"/>">修改</a> | <a href="author_delete?id=<s:property value="#d.id"/>">删除</a></td>
                                </tr>
                                </s:iterator>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!-- /block -->
            </div>
        </div>
    </div>
    <hr>

</div>
<!--/.fluid-container-->

<script src="vendors/jquery-1.9.1.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="vendors/datatables/js/jquery.dataTables.min.js"></script>


<script src="assets/scripts.js"></script>
<script src="assets/DT_bootstrap.js"></script>
<script>
    $(function() {

    });
</script>
</body>

</html>