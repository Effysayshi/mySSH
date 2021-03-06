<%--
  Created by IntelliJ IDEA.
  User: effy
  Date: 2019/4/3
  Time: 下午3:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<!--管理员查看用户账户界面-->
<head>
    <title>青少年阅读网</title>
    <!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
    <link href="assets/styles.css" rel="stylesheet" media="screen">
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
            <a class="brand" href="indexPage.jsp">青少年阅读网</a>
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

        <!--/span-->
        <div class="span9" id="content">
            <!-- validation -->
            <div class="row-fluid">
                <!-- block -->
                <div class="block">
                    <div class="navbar navbar-inner block-header">
                        <div class="muted pull-left">个人帐户</div>
                    </div>
                    <div class="block-content collapse in">
                        <div class="span12">
                            <!-- BEGIN FORM-->
                            <s:form action="author_authorUpdate" method="POST" id="form_sample_1" class="form-horizontal" theme="simple" namespace="/">
                                <s:hidden name="id" value="%{model.id}"/>
                                <fieldset>
                                    <div class="control-group">
                                        <label class="control-label">用户名<span class="required">*</span></label>
                                        <div class="controls">
                                            <input type="text" name="authname" value="${model.authname}" data-required="1" class="span6 m-wrap"/>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">性别<span class="required">*</span></label>
                                        <div class="controls">
                                            <input name="sex" type="text" value="${model.sex}" class="span6 m-wrap">
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">年龄</label>
                                        <div class="controls">
                                            <input name="age" type="number" class="span6 m-wrap" value="${model.age}"/>
                                        </div>
                                    </div>
                                        <%--<div class="control-group">--%>
                                        <%--<label class="control-label" for="date01">生日</label>--%>
                                        <%--<div class="controls">--%>
                                        <%--<input type="text" class="input-xlarge datepicker" id="date01" value="02/16/97">--%>
                                        <%--<!--<p class="help-block">In addition to freeform text, any HTML5 text-based input appears like so.</p>-->--%>
                                        <%--</div>--%>
                                        <%--</div>--%>
                                    <div class="control-group">
                                        <label class="control-label">邮箱</label>
                                        <div class="controls">
                                            <input name="mail" type="text" class="span6 m-wrap" value="${model.mail}"/>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">电话</label>
                                        <div class="controls">
                                            <input name="tel" type="number" class="span6 m-wrap" value="${model.tel}"/>
                                        </div>
                                    </div>
                                    <input type="hidden" name="sum" value="0">
                                    <input type="hidden" name="clazz" value="1">
                                    <div class="form-actions">
                                        <button type="submit" class="btn btn-primary">更新</button>
                                    </div>
                                </fieldset>
                            </s:form>
                            <!-- END FORM-->
                        </div>
                    </div>
                </div>
                <!-- /block -->
            </div>
            <!-- /validation -->
        </div>


<!--/.fluid-container-->
<link href="vendors/datepicker.css" rel="stylesheet" media="screen">
<link href="vendors/uniform.default.css" rel="stylesheet" media="screen">
<link href="vendors/chosen.min.css" rel="stylesheet" media="screen">

<link href="vendors/wysiwyg/bootstrap-wysihtml5.css" rel="stylesheet" media="screen">

<script src="vendors/jquery-1.9.1.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="vendors/jquery.uniform.min.js"></script>
<script src="vendors/chosen.jquery.min.js"></script>
<script src="vendors/bootstrap-datepicker.js"></script>

<script src="vendors/wysiwyg/wysihtml5-0.3.0.js"></script>
<script src="vendors/wysiwyg/bootstrap-wysihtml5.js"></script>

<script src="vendors/wizard/jquery.bootstrap.wizard.min.js"></script>

<script type="text/javascript" src="vendors/jquery-validation/dist/jquery.validate.min.js"></script>
<script src="assets/form-validation.js"></script>

<script src="assets/scripts.js"></script>
<script>

    // jQuery(document).ready(function() {
    //     FormValidation.init();
    // });
    //
    //
    // $(function() {
    //     $(".datepicker").datepicker();
    //     $(".uniform_on").uniform();
    //     $(".chzn-select").chosen();
    //     $('.textarea').wysihtml5();
    //
    //     $('#rootwizard').bootstrapWizard({onTabShow: function(tab, navigation, index) {
    //             var $total = navigation.find('li').length;
    //             var $current = index+1;
    //             var $percent = ($current/$total) * 100;
    //             $('#rootwizard').find('.bar').css({width:$percent+'%'});
    //             // If it's the last tab then hide the last button and show the finish instead
    //             if($current >= $total) {
    //                 $('#rootwizard').find('.pager .next').hide();
    //                 $('#rootwizard').find('.pager .finish').show();
    //                 $('#rootwizard').find('.pager .finish').removeClass('disabled');
    //             } else {
    //                 $('#rootwizard').find('.pager .next').show();
    //                 $('#rootwizard').find('.pager .finish').hide();
    //             }
    //         }});
    //     $('#rootwizard .finish').click(function() {
    //         alert('Finished!, Starting over!');
    //         $('#rootwizard').find("a[href*='tab1']").trigger('click');
    //     });
    // });
</script>
</body>

</html>