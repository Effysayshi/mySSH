<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html >

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
                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown"> <i class="icon-user"></i> <s:property value="#session.existAuthor.authname"/> <i class="caret"></i>
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
                    <li class="active">
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
        <div class="navbar">
            <div class="navbar-inner">
                <ul class="breadcrumb">
                    <i class="icon-chevron-left hide-sidebar"><a href='#' title="Hide Sidebar" rel='tooltip'>&nbsp;</a></i>
                    <i class="icon-chevron-right show-sidebar" style="display:none;"><a href='#' title="Show Sidebar" rel='tooltip'>&nbsp;</a></i>
                    <li>
                        <a href="novel_showAll">首页</a> <span class="divider">/</span>
                    </li>
                    <li>
                        <a href="novel_authorFindD">我读我写</a> <span class="divider">/</span>
                    </li>
                    <li class="active">${model.noveltitle}</li>
                </ul>
            </div>
        </div>
        <!-- block -->
        <div class="block">
            <div class="article-content-box">
                <div class="article-header-box">
                    <h3 class="title-article">
                        ${model.noveltitle}
                    </h3>
                    <span class="article-info article-time"><fmt:formatDate value="${model.writetime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
                    <span class="article-info follow-name">作者：${model.novelwriter}</span>
                    <span class="article-info follow-source">学校： ${model.school}</span>
                    <span class="article-info follow-vote">点数赞：${model.vote}</span>
                </div>
                <p class="line"></p>
                <div class="article-content">
                    ${model.novelcontext}
                </div>
                <div class="btn-group pull-right">
                    <button class="btn"><a href="novel_vote?id=${model.id}">点赞</a> <i class="icon-plus icon-thumbs-up"></i></button>
                </div>
                <div class="comment-title-box">
                    <span class="comment-title">评论列表</span>
                    <p class="line-gray"></p>
                </div>
                <div class="comment-input">
                    <s:form action="comment_add" method="POST" theme="simple" namespace="/">
                        <input type="hidden" name="commentauthor" value="<s:property value="#session.existAuthor.authname"/>">
                        <input type="hidden" name="novelname" value="${model.noveltitle}">
                        <textarea class="comment" id="textarea" name="commentcontext"  placeholder="输入评论"></textarea>
                        <button class="btn btn-warning pull-right " type="submit">发表评论</button>
                    </s:form>
                </div>
                <div class="comment-list">
                    <s:iterator value="set" var="c">
                        <li class="comment-box">
                            <span class="comment-author"><s:property value="#c.commentauthor"/></span>
                            <span class="comment-time"><s:date name="#c.commenttime" format="yyyy-MM-dd"/></span>
                            <br>
                            <span class="comment-content">
                                    <s:property value="#c.commentcontext"/>
                             </span>
                            <p class="line-comment"/>
                        </li>

                    </s:iterator>
                    <%--<table>--%>
                    <%--<s:iterator value="set" var="c">--%>
                    <%--<tr>--%>
                    <%--<td><s:property value="#c.commentauthor"/></td>--%>
                    <%--</tr>--%>
                    <%--</s:iterator>--%>
                    <%--</table>--%>
                </div>
            </div>
        </div>
        <!-- /block-->
    </div>
</div>
<!--/.fluid-container-->


<script src="vendors/jquery-1.9.1.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="vendors/datatables/js/jquery.dataTables.min.js"></script>


<script src="assets/scripts.js"></script>
<script src="assets/DT_bootstrap.js"></script>
<script>

    setInterval("document.getElementById('jnkc').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);
    var text = document.getElementById("textarea");
    autoTextarea(text);// 调用
</script>
</body>

</html>