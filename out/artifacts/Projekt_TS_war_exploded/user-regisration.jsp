<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hotel rezerwacje</title>
    <meta name="description" content="Sprawdź aktualny ranking najlepszych hoteli"/>
    <meta name="keywords" content="hotel, najlepszy hotel, ranking hoteli"/>
    <meta name="author" content="Oskar Pielech">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<main>
    <form action="ServletAddingUsers" method="get">
        <section class="hotels">
            <div class="container">
                <div class="row">


                    <div class="col-lg-3 offset-lg-3">
                        Imie:
                    </div>
                    <div class="col-lg-3">
                        <label>
                            <input type="text" name="userName">
                        </label>
                    </div>

                    <div class="w-100"></div>
                    <div class="col-lg-3 offset-lg-3">
                        Nazwisko:
                    </div>
                    <div class="col-lg-3">
                        <label>
                            <input type="text" name="userSurname">
                        </label>
                    </div>

                    <div class="w-100"></div>
                    <div class="col-lg-3 offset-lg-3">
                        E-mail:
                    </div>
                    <div class="col-lg-3">
                        <label>
                            <input type="email" name="userEmail">
                        </label>
                    </div>

                    <div class="w-100"></div>
                    <div class="col-lg-3 offset-lg-3">
                        Data urodzenia:
                    </div>
                    <div class="col-lg-3">
                        <label>
                            <input type="date" name="userBirthDate">
                        </label>
                    </div>

                    <div class="w-100"></div>
                    <div class="col-lg-3 offset-lg-3">
                        Miasto:
                    </div>
                    <div class="col-lg-3">
                        <label>
                            <input type="text" name="userCity">
                        </label>
                    </div>

                    <div class="w-100"></div>
                    <div class="col-lg-3 offset-lg-3">
                        Kod pocztowy:
                    </div>
                    <div class="col-lg-3">
                        <label>
                            <input type="text" name="userPostcode">
                        </label>
                    </div>

                    <div class="w-100"></div>
                    <div class="col-lg-3 offset-lg-3">
                        Numer telefonu:
                    </div>
                    <div class="col-lg-3">
                        <label>
                            <input type="tel" name="userPhone">
                        </label>
                    </div>

                    <div class="w-100"></div>
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
                    <div class="col-lg-2 offset-lg-5">
                        <input type="submit" value="Rezerwuj">
                    </div>

                    <div class="w-100"></div>
                    <div class="col-lg-2 offset-lg-6">
                        <div class="stronaGlowna">
                            <a href="index.jsp" style="font-size:15px;"><br/>Strona główna</a>
                            <br><a href="admin-logowanie.html" style="font-size:15px;">Dla admina</a>
                        </div>
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


</html>