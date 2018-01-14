
<#--<!DOCTYPE html>-->
<#--<html lang="en">-->
<#--<head>-->
    <#--<meta charset="utf-8">-->
    <#--<title>Log in</title>-->
<#--</head>-->
<#--<body>-->

<#--opo-->

<#--<div id="categories">-->

<#--</div>-->

<#--<script>-->
    <#--window.onload = function(){-->
        <#--loadCategories();-->
    <#--};-->

    <#--function loadCategories() {-->
        <#--var xhr = new XMLHttpRequest();-->
        <#--xhr.open("get", "/api/category");-->
        <#--xhr.setRequestHeader("content-type", "application/json");-->
        <#--xhr.setRequestHeader("authorization", "Basic a2F2YWxvcm46Z2FuZGlrYXA=");-->

        <#--xhr.send();-->
        <#--xhr.onreadystatechange = function(){-->
            <#--if (xhr.readyState == XMLHttpRequest.DONE) {-->
                <#--var response = JSON.parse(xhr.responseText);-->
                <#--for (var i = 0; i < response.length; i++){-->
                    <#--document.querySelector("#categories").innerHTML += response[i].name + "<br>";-->
                <#--}-->
            <#--}-->
        <#--}-->
    <#--}-->
<#--</script>-->
<#--</body>-->
<#--</html>-->






<#-- @ftlvariable name="error" type="java.util.Optional<String>" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="CoreUI - Open Source Bootstrap Admin Template">
    <meta name="author" content="Łukasz Holeczek">
    <meta name="keyword" content="Bootstrap,Admin,Template,Open,Source,AngularJS,Angular,Angular2,Angular 2,Angular4,Angular 4,jQuery,CSS,HTML,RWD,Dashboard,React,React.js,Vue,Vue.js">
    <link rel="shortcut icon" href="img/favicon.png">
    <title>CoreUI - Open Source Bootstrap Admin Template</title>

    <!-- Icons -->
    <link href="node_modules/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="node_modules/simple-line-icons/css/simple-line-icons.css" rel="stylesheet">

    <!-- Main styles for this application -->
    <link href="css/style.css" rel="stylesheet">
    <!-- Styles required by this views -->

</head>

<!-- BODY options, add following classes to body to change options

// Header options
1. '.header-fixed'					- Fixed Header

// Brand options
1. '.brand-minimized'       - Minimized brand (Only symbol)

// Sidebar options
1. '.sidebar-fixed'					- Fixed Sidebar
2. '.sidebar-hidden'				- Hidden Sidebar
3. '.sidebar-off-canvas'		- Off Canvas Sidebar
4. '.sidebar-minimized'			- Minimized Sidebar (Only icons)
5. '.sidebar-compact'			  - Compact Sidebar

// Aside options
1. '.aside-menu-fixed'			- Fixed Aside Menu
2. '.aside-menu-hidden'			- Hidden Aside Menu
3. '.aside-menu-off-canvas'	- Off Canvas Aside Menu

// Breadcrumb options
1. '.breadcrumb-fixed'			- Fixed Breadcrumb

// Footer options
1. '.footer-fixed'					- Fixed footer

-->

<body class="app header-fixed sidebar-fixed aside-menu-fixed aside-menu-hidden">
<header class="app-header navbar">
    <button class="navbar-toggler mobile-sidebar-toggler d-lg-none mr-auto" type="button">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="#"></a>
    <button class="navbar-toggler sidebar-toggler d-md-down-none" type="button">
        <span class="navbar-toggler-icon"></span>
    </button>

</header>

<div class="app-body">
    <div class="sidebar">
        <nav class="sidebar-nav">
            <ul class="nav">
                <li class="nav-item">
                    <a class="nav-link" href="index.html"><i class="icon-speedometer"></i> Dashboard <span class="badge badge-primary">NEW</span></a>
                </li>

            </ul>
        </nav>
        <button class="sidebar-minimizer brand-minimizer" type="button"></button>
    </div>

    <!-- Main content -->
    <main class="main">

        <div class="container-fluid">

        </div>
        <!-- /.conainer-fluid -->
    </main>

</div>

<footer class="app-footer">
    <span><a href="http://coreui.io">CoreUI</a> © 2017 creativeLabs.</span>
    <span class="ml-auto">Powered by <a href="http://coreui.io">CoreUI</a></span>
</footer>

<!-- Bootstrap and necessary plugins -->
<script src="node_modules/jquery/dist/jquery.min.js"></script>
<script src="node_modules/popper.js/dist/umd/popper.min.js"></script>
<script src="node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="node_modules/pace-progress/pace.min.js"></script>

<!-- CoreUI main scripts -->

<script src="js/app.js"></script>

<!-- Plugins and scripts required by this views -->

<!-- Custom scripts required by this view -->
<script src="js/views/main.js"></script>

</body>
</html>