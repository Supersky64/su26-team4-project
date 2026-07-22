<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Offering</title>

    <link rel="stylesheet" href="/style.css">
</head>

<body>

    <nav>
        <div class="logo">
            <img src="/../images/trailbuddy_logo.png" alt="TrailBuddy Logo">
            <span>TrailBuddy</span>
        </div>
    </nav>


    <div class="signup-container">

        <div class="signup-card">

            <h1>Update offering</h1>

            <form action="/customer/signup" method="post">

                <label for="name">Change name: </label>
                <input type="text" id="name" name="name" value="${(outdoorService.name)!}" placeholder="Enter name"
                    required>


                <label for="description">Change description: </label>
                <input type="text" id="description" name="description" value="${(outdoorService.description)!}" placeholder="Enter new description"
                    required>


                <label for="gearList">Gear List: </label>
                <input type="text" id="gearList" name="gearList" placeholder="Edit gearList">


                <label for="skillLevel">Skill Level:</label>

                <select id="skillLevel" name="skillLevel" required>

                    <option value="">Select skill level</option>

                    <option value="Beginner">Beginner</option>
                    <option value="Intermediate">Intermediate</option>
                    <option value="Advanced">Advanced</option>

                </select>


                <select id="skillLevel" name="skillLevel" required>

                    <option value="">Select skill level</option>

                    <option value="Beginner">Beginner</option>
                    <option value="Intermediate">Intermediate</option>
                    <option value="Advanced">Advanced</option>

                </select>


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