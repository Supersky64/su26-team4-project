<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sign-up as a Customer</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css"
        integrity="sha384-X38yfunGUhNzHpBaEBsWLO+A0HDYOQi8ufWDkZ0k9e0eXz/tH3II7uKZ9msv++Ls" crossorigin="anonymous">
    <!--Using Pure CSS-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <!-- Using Bootstrap CSS -->
    <style>
        .mainContent {
            display: block;
            margin-left: 450px;
            margin-right: 450px;
            margin-top: 50px;
        }
    </style>

</head>

<body style="background-color:rgba(85, 107, 47, 0.781)">
    <div class="mainContent"> <!--main place for signup to go in-->
        <div>
            <div class="card"
                style="background-color: rgba(248, 252, 255, 0.623); border-radius: 3px; padding-top: 8px;">
                <div class="card-body">
                    <h5 class="card-title" style="text-align: center;">Customer sign-up</h5>
                    <p class="card-text">
                    <fieldset>
                        <form action="/customer/signup" method="post" class="pure-form pure-form-stacked">

                            <label for="name">Name</label>
                            <input type="text" id="name" name="name" value="${(customer.name)!}"
                                placeholder="Enter your name" required>

                            <br>

                            <label for="email">Email</label>
                            <input type="email" id="email" name="email" value="${(customer.email)!}"
                                placeholder="Enter your email" required>

                            <br>

                            <label for="password">Password</label>
                            <input type="password" id="password" name="password" value="${(customer.password)!}"
                                placeholder="Enter a password" required>

                            <br>

                            <label for="skillLevel">Skill Level</label>

                            <select id="skillLevel" name="skillLevel" required>

                                <option value="">Select</option>

                                <option value="Beginner">Beginner</option>
                                <option value="Intermediate">Intermediate</option>
                                <option value="Advanced">Advanced</option>

                            </select>

                            <br>

                            <label for="preference">Favorite Activity</label>

                            <input type="text" id="preference" name="preference" value="${(customer.preference)!}"
                                placeholder="Hiking, Kayaking, Camping..." required>

                            <br><br>

                            <button type="submit" class="btn btn-dark">
                                Sign Up
                            </button>

                        </form>
                    </fieldset>
                    </p>
                    <p style="text-align: center;"><a href="customer.html" class="btn btn-dark">Sign up</a></p>
                    <p>
                        <a href="providerSignup.html">Sign up as provider</a> •
                        <a href="login.html">Already have an account? Log in</a>
                </div>
            </div>
        </div>
    </div>
</body>

</html>