<%--
  Created by IntelliJ IDEA.
  User: oskar
  Date: 17.05.2020
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
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
    <link rel="stylesheet" href="css/cssIndex.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<main>
    <section class="clinic">
        <div class="container">
            <div class="col-12">
                <header>
                    <h1>MONSTER CLINIC</h1>
                    <p>
                        Umów się na wizytę z najlepszymi lekarzami w Polsce
                    </p>

                    <p2>
                        W naszej bazie znajdują sie tylko najllepsi lekarze. Każdy z nich jest znanym i szanowanym
                        specjalistą w swojej dziedzinie. Załóż bezpłatne konto i ciesz się wymarzoną wizytą u lekarza.
                    </p2>
                </header>
            </div>
            <%--            <form action="user-registration.html">--%>
            <%--                <button type="submit">Rejestracja</button>--%>
            <%--            </form>--%>
            <%--            <form action="user-login.jsp">--%>
            <%--                <button type="submit">Logowanie</button>--%>
            <%--            </form>--%>
            <div class="col-1 offset-lg-8">
                <nav>
                    <ul>
                        <li>
                            <a href="user-login.jsp">Logowanie</a>
                            <span></span><span></span><span></span><span></span>
                        </li>
                        <li>
                            <a href="user-registration.html">Rejestracja</a>
                            <span></span><span></span><span></span><span></span>
                        </li>

                    </ul>
                </nav>
            </div>
        </div>
    </section>
</main>
</body>
<style>
    body {
        background-repeat: no-repeat;
        background-size: cover;
        background-color: black;
    }
</style>
</html>
