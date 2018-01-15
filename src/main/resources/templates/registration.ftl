<#-- @ftlvariable name="error" type="java.util.Optional<String>" -->
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="CoreUI Bootstrap 4 Admin Template">
    <meta name="author" content="Lukasz Holeczek">
    <meta name="keyword" content="CoreUI Bootstrap 4 Admin Template">
    <!-- <link rel="shortcut icon" href="assets/ico/favicon.png"> -->

    <title>Регистрация</title>

    <!-- Icons -->
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/simple-line-icons.css" rel="stylesheet">

    <!-- Main styles for this application -->
    <link href="css/style.css" rel="stylesheet">

    <!-- Styles required by this views -->

</head>

<body class="app flex-row align-items-center">
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card mx-4">
                <div class="card-body p-4">
                    <h1>Регистрация</h1>
                    <form>
                        <p class="text-muted">Создайте свой аккаунт</p>
                        <div class="input-group mb-3">
                            <span class="input-group-addon"><i class="icon-user"></i></span>
                            <input type="text" name="name" class="form-control" placeholder="Имя">
                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-addon"><i class="icon-user"></i></span>
                            <input type="text" name="surname" class="form-control" placeholder="Фамилия">
                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-addon">@</span>
                            <input type="text" name="email" class="form-control" placeholder="Имейл">
                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-addon"><i class="icon-lock"></i></span>
                            <input type="password" name="password" class="form-control" placeholder="Пароль">
                        </div>

                        <div class="input-group mb-4">
                            <span class="input-group-addon"><i class="icon-lock"></i></span>
                            <input type="password" name="repeatpassword" class="form-control" placeholder="Повторите пароль">
                        </div>

                        <button type="button" class="btn btn-block btn-success">Создать аккаунт</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap and necessary plugins -->
<script src="js/jquery.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>