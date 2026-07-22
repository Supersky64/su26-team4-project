<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Sign Up</title>

    <link rel="stylesheet" href="/style.css">
</head>

<body>

    <nav>
        <div class="logo">
            <img src="/images/trailbuddy_logo.png" alt="TrailBuddy Logo">
            <span>TrailBuddy</span>
        </div>
    </nav>


    <div class="signup-container">

        <div class="signup-card">

            <h1>Create Account</h1>

            <p>Join TrailBuddy and start discovering outdoor adventures.</p>

            <form action="/customer/signup" method="post">

                <label for="name">Full Name</label>
                <input type="text" id="name" name="name" value="${(customer.name)!}" placeholder="Enter your name"
                    required>


                <label for="email">Email Address</label>
                <input type="email" id="email" name="email" value="${(customer.email)!}" placeholder="Enter your email"
                    required>


                <label for="password">Password</label>
                <input type="password" id="password" name="password" placeholder="Create a password" required>


                <label for="skillLevel">Skill Level</label>

                <select id="skillLevel" name="skillLevel" required>

                    <option value="">Select your experience</option>

                    <option value="Beginner">Beginner</option>
                    <option value="Intermediate">Intermediate</option>
                    <option value="Advanced">Advanced</option>

                </select>


                <label for="preference">Favorite Activity</label>

                <input type="text" id="preference" name="preference" value="${(customer.preference)!}"
                    placeholder="Hiking, Camping, Kayaking..." required>


                <button type="submit">
                    Create Account
                </button>

            </form>

            <div class="signup-links">

                <p>Already have an account?</p>
                <a href="/login">Log In</a>

            </div>

        </div>

    </div>

</body>

</html>