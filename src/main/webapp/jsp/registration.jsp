<html>
<head>
    <title>Registration</title>
    <link href="../css/styles.css" rel="stylesheet">
</head>
<body>


<header align="center">
    <img src="../images/header.jpg" alt="Header" width="999" align="middle">
</header>

<div class="middle">

    <div class="container">
        <div align="center">
            <h3>Registration</h3>

            <form name='auto' method='POST' action='ControllerServlet' class='radial'>

                <b>Login:</b><br>
                <input type='text' size='20' class='inp radial' spellcheck="false" name='login' required><br>

                <b>Password:</b><br>
                <input type='password' size='20' class='inp radial' name='password' required><br>

                <b>Name:</b><br>
                <input type='text' size='20' class='inp radial' spellcheck="false" name='firstname' required><br>

                <b>Surname:</b><br>
                <input type='text' size='20' class='inp radial' spellcheck="false" name='lastname' required><br>

                <input type='submit' name='register_btn' value='Registration' size='40' class='radial'>
                <a href="/jsp/login.jsp.jsp">Login page</a>
                <input type="hidden" name="action" value="registration">

            </form>

        </div>
    </div>
    <!-- .container-->


</div>
<!-- .middle-->

<footer class="footer">
    <p><strong>Одесса 2015 ©</strong></p>
</footer>
<!-- .footer -->


</body>
</html>
