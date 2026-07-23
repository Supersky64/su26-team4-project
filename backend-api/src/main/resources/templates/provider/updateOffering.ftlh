<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Offering</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<!-- Using Bootstrap CSS -->
    <link rel="stylesheet" href="/../style.css">
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

            <form action="/services/edit/${outdoorService.id}" method="post">

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

                <label for="location">Change location: </label>
                <select id="location" name="location" required>
                <option value="">Select location:</option>
                <option value="AL">Alabama</option>
                <option value="AK">Alaska</option>
                <option value="AZ">Arizona</option>
                <option value="AR">Arkansas</option>
                <option value="CA">California</option>
                <option value="CO">Colorado</option>
                <option value="CT">Connecticut</option>
                <option value="DE">Delaware</option>
                <option value="DC">District Of Columbia</option>
                <option value="FL">Florida</option>
                <option value="GA">Georgia</option>
                <option value="HI">Hawaii</option>
                <option value="ID">Idaho</option>
                <option value="IL">Illinois</option>
                <option value="IN">Indiana</option>
                <option value="IA">Iowa</option>
                <option value="KS">Kansas</option>
                <option value="KY">Kentucky</option>
                <option value="LA">Louisiana</option>
                <option value="ME">Maine</option>
                <option value="MD">Maryland</option>
                <option value="MA">Massachusetts</option>
                <option value="MI">Michigan</option>
                <option value="MN">Minnesota</option>
                <option value="MS">Mississippi</option>
                <option value="MO">Missouri</option>
                <option value="MT">Montana</option>
                <option value="NE">Nebraska</option>
                <option value="NV">Nevada</option>
                <option value="NH">New Hampshire</option>
                <option value="NJ">New Jersey</option>
                <option value="NM">New Mexico</option>
                <option value="NY">New York</option>
                <option value="NC">North Carolina</option>
                <option value="ND">North Dakota</option>
                <option value="OH">Ohio</option>
                <option value="OK">Oklahoma</option>
                <option value="OR">Oregon</option>
                <option value="PA">Pennsylvania</option>
                <option value="RI">Rhode Island</option>
                <option value="SC">South Carolina</option>
                <option value="SD">South Dakota</option>
                <option value="TN">Tennessee</option>
                <option value="TX">Texas</option>
                <option value="UT">Utah</option>
                <option value="VT">Vermont</option>
                <option value="VA">Virginia</option>
                <option value="WA">Washington</option>
                <option value="WV">West Virginia</option>
                <option value="WI">Wisconsin</option>
                <option value="WY">Wyoming</option>
                </select>

                <label for="date">Change date:</label>
                <input id="date" type="date" name="date" required/>

                <button type="submit">Update listing</button>

            </form>

        </div>

    </div>

</body>

</html>