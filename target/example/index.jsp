<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Main Page</title>
    <link rel="stylesheet" href="style.css" />
  </head>
  <body>
    <div id="app">
      <jsp:include page="header.jsp" />
      <div class="wrapper wrapper--main">
        <div class="main">
          <jsp:include page="sidebar.jsp" />
          <div class="main__content">
            <form method="POST" class="sign sign--in" action="login">
              <div class="sign__title">
                <p>Login to your blog</p>
              </div>
              <div class="sign__field sign__field--text">
                <label for="email">Email:</label>
                <input
                  name="email"
                  type="email"
                  id="email"
                  placeholder="Enter email"
                  value="${user.email}"
                />
              </div>
              <div
                class="error__message"
                style="color: red; max-width: 200px; overflow-wrap: break-word"
              >
                ${userNotExist}
              </div>
              <div class="sign__field sign__field--text">
                <label for="password">Password:</label>
                <input
                  name="password"
                  type="password"
                  id="password"
                  placeholder="Enter password"
                  value="${user.password}"
                />
              </div>
              <div
                class="error__message"
                style="color: red; max-width: 200px; overflow-wrap: break-word"
              >
                ${inCorrectPassword}
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
