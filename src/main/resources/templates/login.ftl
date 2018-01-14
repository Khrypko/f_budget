<#-- @ftlvariable name="error" type="java.util.Optional<String>" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Log in</title>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
    </ul>
</nav>

<h1>Увійди</h1>

<form role="form" action="/login" method="post">

    <div>Login form</div>

    <div>
        <label for="email">Email address</label>
        <input type="text" name="name" id="name" required autofocus/>
    </div>
    <div>
        <label for="password">Password</label>
        <input type="password" name="password" id="password" required/>
    </div>
    <div>
        <label for="remember-me">Remember me</label>
        <input type="checkbox" name="remember-me" id="remember-me"/>
    </div>
    <button type="submit">Увійти</button>
</form>

<#if error.isPresent()>
<p>Неправильний логін або пароль!</p>
</#if>
</body>
</html>