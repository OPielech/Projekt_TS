
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl">
<head>
    <title>Monster Clinic</title>
    <meta name="description" content="Umów się na wizytę z najlepszymi lekarzami w Polsce"/>
    <meta name="keywords" content="lekarz, najlepszy lekarz, wizyta lekarska"/>
    <meta name="author" content="Oskar Pielech">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <link rel='icon' href='images/favicon.ico' type='image/x-icon'/>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/cssMain.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<main>
    <form action="ServletLoginUser" method="get">
        <section class="clinic">
            <div class="container">
                <div class="row">

                    <div class="col-lg-3 offset-lg-3">
                        Login:
                    </div>
                    <div class="col-lg-3">
                        <label>
                            <input type="text" name="userLogin">
                        </label>
                    </div>

                    <div class="w-100"></div>
                    <div class="col-lg-3 offset-lg-3">
                        Hasło:
                    </div>
                    <div class="col-lg-3">
                        <label>
                            <input type="password" name="userPassword">
                        </label>
                    </div>

                    <div class="w-100"></div>
                    <div class="col-lg-4 offset-lg-3">
                        Nieprawidłowe hasło lub login
                    </div>

                    <div class="w-100"></div>
                    <div class="col-lg-2 offset-lg-5">
                        <button type="submit" class="button5">Zaloguj</button>
                    </div>


                </div>
            </div>
        </section>
    </form>

</main>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
<style>
    body {
        background-repeat: no-repeat;
        background-size: cover;
        /*background-image: url("images/hotel(1).jfif");*/
        background-color: black;
    }
</style>

</html>