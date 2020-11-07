<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Register Page</title>
    <link rel="stylesheet" href="style.css" />
  </head>
  <body>
    <div id="app">
      <jsp:include page="header.jsp" />
      <div class="wrapper wrapper--main">
        <div class="main">
          <jsp:include page="sidebar.jsp" />
          <div class="main__content">
            <form action="register" class="sign sign--up" method="POST">
              <div class="sign__title">
                <p>Register to the Blog</p>
              </div>
              <div class="sign__field sign__field--text">
                <label for="email">Email:</label>
                <input
                  name="email"
                  type="email"
                  id="email"
                  placeholder="Enter email"
                  value="${mail}"
                />
              </div>
              <div
                class="error__message"
                style="color: red; max-width: 200px; overflow-wrap: break-word"
              >
                ${notValidEmail}
              </div>
              <div class="sign__field sign__field--text">
                <label for="password">Password:</label>
                <input
                  name="password"
                  type="password"
                  id="password"
                  placeholder="Enter password"
                  value="${pass}"
                />
              </div>
              <div
                class="error__message"
                style="color: red; max-width: 200px; overflow-wrap: break-word"
              >
                ${notValidPassword}
              </div>
              <div class="sign__field sign__field--text">
                <label for="confirm__password">Confirm Password:</label>
                <input
                  name="confirm__password"
                  type="password"
                  id="confirm__password"
                  placeholder="Enter password again"
                  value="${confPass}"
                />
              </div>
              <div
                class="error__message"
                style="color: red; max-width: 200px; overflow-wrap: break-word"
              >
                ${notMatchConfirm}
              </div>
              <div class="sign__field sign__field--text">
                <label for="confirm__password">First Name:</label>
                <input
                  name="first__name"
                  type="text"
                  id="first__name"
                  placeholder="First Name"
                  value="${fN}"
                />
              </div>
              <div
                class="error__message"
                style="color: red; max-width: 200px; overflow-wrap: break-word"
              >
                ${notValidFirst}
              </div>
              <div class="sign__field sign__field--text">
                <label for="confirm__password">Last Name:</label>
                <input
                  name="last__name"
                  type="text"
                  id="last__name"
                  placeholder="Last Name"
                  value="${lN}"
                />
              </div>
              <div
                class="error__message"
                style="color: red; max-width: 200px; overflow-wrap: break-word"
              >
                ${notValidLast}
              </div>
              <input type="submit" value="Submit" />
            </form>
          </div>
        </div>
      </div>
      <jsp:include page="footer.jsp" />
    </div>
  </body>
</html>
