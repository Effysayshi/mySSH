<%--
  Created by IntelliJ IDEA.
  User: effy
  Date: 2019/4/3
  Time: 下午2:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<!-- 用户登录后进入的首页-->
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
            <a class="brand" href="novel_showAll">青少年阅读网</a>
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
                    <li class="">
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
<!--/span-->
<div class="span9" id="content">
    <div class="row-fluid">
        <!-- block -->
        <div class="block">

            <img class="img-max" alt="538x289" src="images/2.jpg"  >

        </div>
        <!-- /block -->
    </div>
    <div class="row-fluid">
        <div class="span6">
            <!-- block -->
            <div class="block">
                <div class="navbar navbar-inner block-header">
                    <div class="muted pull-left">最新资讯</div>
                    <div class="pull-right"><a href="news_authorFindAll" class="badge badge-info">查看更多</a>
                    </div>
                </div>
                <div class="block-content collapse in">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>新闻标题</th>
                            <th>时间</th>
                        </tr>
                        </thead>
                        <tbody>
                          <s:iterator value="newsList" var="n">
                              <tr>
                                  <td class="news"><a href="news_authorCheck?id<s:property value="#n.id"/>="><s:property value="#n.newstitle"/></a></td>
                                  <td><s:date name="#n.addtime" format="yyyy-MM-dd"/></td>
                              </tr>
                          </s:iterator>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- /block -->
        </div>
        <div class="span6">
            <!-- block -->
            <div class="block">
                <div class="navbar navbar-inner block-header">
                    <div class="muted pull-left">小小说</div>
                    <div class="pull-right"><span class="badge badge-info">查看更多</span>

                    </div>
                </div>
                <div class="block-content collapse in">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>标题</th>
                            <th>作者</th>
                            <th>时间</th>
                        </tr>
                        </thead>
                        <tbody>
                        <s:iterator value="novelList" var="n">
                        <tr>
                            <td class="normal"><a href="novel_authorCheckN?id<s:property value="#n.id"/>="><s:property value="#n.noveltitle"/></a></td>
                            <td><s:property value="#n.novelwriter" /></td>
                            <td><s:date name="#n.writetime" format="yyyy-MM-dd"/></td>
                        </tr>
                        </s:iterator>

                        </tbody>
                    </table>
                </div>
            </div>
            <!-- /block -->
        </div>
    </div>
    <div class="row-fluid">
        <div class="span6">
            <!-- block -->
            <div class="block">
                <div class="navbar navbar-inner block-header">
                    <div class="muted pull-left">诗歌</div>
                    <div class="pull-right"><span class="badge badge-info">查看更多</span>

                    </div>
                </div>
                <div class="block-content collapse in">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>标题</th>
                            <th>作者</th>
                            <th>时间</th>
                        </tr>
                        </thead>
                        <tbody>
                        <s:iterator value="poemList" var="n">
                            <tr>
                                <td class="normal"><a href="novel_authorCheckP?id<s:property value="#n.id"/>="><s:property value="#n.noveltitle"/></a></td>
                                <td><s:property value="#n.novelwriter" /></td>
                                <td><s:date name="#n.writetime" format="yyyy-MM-dd"/></td>
                            </tr>
                        </s:iterator>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- /block -->
        </div>
        <div class="span6">
            <!-- block -->
            <div class="block">
                <div class="navbar navbar-inner block-header">
                    <div class="muted pull-left">散文</div>
                    <div class="pull-right"><span class="badge badge-info">查看更多</span>

                    </div>
                </div>
                <div class="block-content collapse in">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>标题</th>
                            <th>作者</th>
                            <th>时间</th>
                        </tr>
                        </thead>
                        <tbody>
                        <s:iterator value="sanwenList" var="n">
                            <tr>
                                <td class="normal"><a href="novel_authorCheckS?id<s:property value="#n.id"/>="><s:property value="#n.noveltitle"/></a></td>
                                <td><s:property value="#n.novelwriter" /></td>
                                <td><s:date name="#n.writetime" format="yyyy-MM-dd"/></td>
                            </tr>
                        </s:iterator>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- /block -->
        </div>
    </div>

</div>
<!--/.fluid-container-->
<div class="span3">
    <div class="row-fluid">

        <div id="jnkc" ></div>

    </div>
    <div class="row-fluid">
        <!--<div class="span3">-->
        <!-- block -->
        <div class="block">
            <div class="navbar navbar-inner block-header">
                <div class="muted pull-left">原创达人榜</div>
                <div class="pull-right"><a class="badge badge-info">查看更多</a>
                </div>
            </div>
            <div class="block-content collapse in">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>作者</th>
                        <th>原创文章数</th>
                    </tr>
                    </thead>
                    <tbody>
                    <s:iterator value="bestAuthor" var="n">
                        <tr>
                            <td class="normal"><s:property value="#n.authname"/></td>
                            <td><s:property value="#n.sum"/></td>
                        </tr>
                    </s:iterator>
                    </tbody>
                </table>
            </div>
        </div>
        <!-- /block -->
        <!--</div>-->
    </div>
    <div class="row-fluid">
        <!--<div class="span3">-->
        <!-- block -->
        <div class="block">
            <div class="navbar navbar-inner block-header">
                <div class="muted pull-left">最佳文章榜</div>
                <div class="pull-right"><a class="badge badge-info">查看更多</a>
                </div>
            </div>
            <div class="block-content collapse in">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>标题</th>
                        <th>作者</th>
                    </tr>
                    </thead>
                    <tbody>
                    <s:iterator value="bestNovel" var="n">
                        <tr>
                            <td class="normal"><s:property value="#n.noveltitle"/></td>
                            <td><s:property value="#n.novelwriter"/></td>
                        </tr>
                    </s:iterator>
                    </tbody>
                </table>
            </div>
        </div>
        <!-- /block -->
        <!--</div>-->
    </div>
</div>

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
