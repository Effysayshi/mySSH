<%--
  Created by IntelliJ IDEA.
  User: effy
  Date: 2019/4/3
  Time: 下午3:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>

<head>
    <title>青少年阅读网</title>
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
                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown"> <i class="icon-user"></i>
                            <s:property value="#session.existAuthor.authname"/><i class="caret"></i>
                        </a>
                        <ul class="dropdown-menu">
                            <li>
                                <a tabindex="-1" href="author_authorCheck?id=<s:property value="#session.existAuthor.id"/>">个人帐户</a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a tabindex="-1" href="loginPage.jsp">切换账户</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <ul class="nav">
                    <!-- class = active 显示当前页面 -->
                    <li class="">
                        <a href="news_authorFindAll">最新资讯</a>
                    </li>
                    <li class="dropdown">
                        <a href="#" data-toggle="dropdown" class="dropdown-toggle">原创乐园<b class="caret"></b>

                        </a>
                        <ul class="dropdown-menu" id="menu1">
                            <li>
                                <a href="novel_authorFindN">小小说</a>
                            </li>
                            <li>
                                <a href="novel_authorFindP">诗歌</a>
                            </li>
                            <!--<li class="divider"></li>-->
                            <li>
                                <a href="novel_authorFindS">散文</a>
                            </li>
                        </ul>
                    </li>
                    <li >
                        <a href="novel_authorFindD">我读我写</a>
                    </li>
                    <li class="">
                        <a href="novel_getBest">最佳文章榜</a>
                    </li>
                    <li class="">
                        <a href="author_getBest">原创新星榜</a>
                    </li>
                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
    </div>
</div>
<div class="span9" id="content">
    <div class="row-fluid">
        <div class="navbar">
            <div class="navbar-inner">
                <ul class="breadcrumb">
                    <i class="icon-chevron-left hide-sidebar"><a href='#' title="Hide Sidebar" rel='tooltip'>&nbsp;</a></i>
                    <i class="icon-chevron-right show-sidebar" style="display:none;"><a href='#' title="Show Sidebar" rel='tooltip'>&nbsp;</a></i>
                    <li>
                        <a href="novel_showAll">首页</a> <span class="divider">/</span>
                    </li>
                    <li>
                        <a href="#">原创乐园</a> <span class="divider">/</span>
                    </li>
                    <li class="active">诗歌列表</li>
                </ul>
            </div>
        </div>
        <!--/span-->

            <div class="row-fluid">
                <!-- block -->
                <div class="block">
                    <div class="navbar navbar-inner block-header">
                        <div class="muted pull-left">诗歌</div>
                    </div>
                    <div class="block-content collapse in">
                        <div class="span12">
                            <div class="table-toolbar">
                                <div class="btn-group">
                                    <a href="postNovel.jsp"><button class="btn btn-success">我要投稿 <i class="icon-plus icon-white"></i></button></a>
                                </div>
                                <!--<div class="btn-group pull-right">-->
                                <!--&lt;!&ndash;<button data-toggle="dropdown" class="btn dropdown-toggle">Tools <span class="caret"></span></button>&ndash;&gt;-->
                                <!--&lt;!&ndash;<ul class="dropdown-menu">&ndash;&gt;-->
                                <!--&lt;!&ndash;<li><a href="#">Print</a></li>&ndash;&gt;-->
                                <!--&lt;!&ndash;<li><a href="#">Save as PDF</a></li>&ndash;&gt;-->
                                <!--&lt;!&ndash;<li><a href="#">Export to Excel</a></li>&ndash;&gt;-->
                                <!--&lt;!&ndash;</ul>&ndash;&gt;-->
                                <!--</div>-->
                            </div>
                            <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example2">
                                <thead>
                                <tr>
                                    <th>诗歌标题</th>
                                    <th>作者</th>
                                    <th>学校</th>
                                    <th>投稿日期</th>
                                </tr>
                                </thead>
                                <tbody>
                                <s:iterator value="list" var="d">
                                    <tr class="odd gradeX">
                                        <td><a href="novel_authorCheckP?id=<s:property value="#d.id"/>"><s:property value="#d.noveltitle"/></a></td>
                                        <td><s:property value="#d.novelwriter"/> </td>
                                        <td><s:property value="#d.school"/></td>
                                        <td class="center"><s:date name="#d.writetime" format="yyyy-MM-dd"/></td>
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

    <hr>
    <!--<footer>-->
    <!--<p>&copy; Vincent Gabriel 2013 - More Templates <a href="http://www.cssmoban.com/" target="_blank" title="cssmoban">cssmoban</a>-->
    <!--</footer>-->
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