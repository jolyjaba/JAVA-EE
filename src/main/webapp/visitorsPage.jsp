<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Home Page</title>
    <link rel="stylesheet" href="style.css" />
  </head>
  <body>
    <div id="app">
      <div class="wrapper">
        <div class="header">
          <div class="header__title">
            <h1>Blog</h1>
            <p>Share your story!</p>
          </div>
          <div class="header__navigation">
            <div class="header__nav-button"><a href="home.jsp">Home</a></div>
            <div class="header__nav-button"><a href="logout">Logout</a></div>
          </div>
        </div>
      </div>
      <div class="wrapper wrapper--main">
        <div class="main">
          <jsp:include page="sidebar.jsp" />
          <div class="main__content">
            <div class="home-page">
              <p class="home-page__title">
                ${user.firstName} ${user.lastName}'s Home Page
              </p>
              <div class="post">
                <div class="post__main">
                  <div class="post__info">
                    <div class="post__owner">${user.firstName}</div>
                    <div class="post__date">Posted on [Date, Time]</div>
                  </div>
                  <div class="post__content">
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Dolorem, maiores aut obcaecati nulla repudiandae quae vero
                    aspernatur magni nihil corporis?
                  </div>
                  <div class="post__comments">
                    <div class="post">
                      <button class="post__delete">X</button>
                      <div class="post__main">
                        <div class="post__info">
                          <div class="post__owner">[User]</div>
                          <div class="post__date">
                            Commented on [Date, Time]
                          </div>
                        </div>
                        <div class="post__content">
                          Lorem ipsum dolor sit amet consectetur adipisicing
                          elit. Dolorem, maiores aut obcaecati nulla repudiandae
                          quae vero aspernatur magni nihil corporis?
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <form method="POST" class="new-comment">
                <div class="newComment">
                  <textarea
                    name="newComment"
                    id="newComment"
                    cols="30"
                    rows="3"
                  ></textarea>
                  <button type="submit">Submit</button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
      <jsp:include page="footer.jsp" />
    </div>
  </body>
</html>
