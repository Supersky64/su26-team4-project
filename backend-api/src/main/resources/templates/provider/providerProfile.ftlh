<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>

</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<!-- Using Bootstrap CSS -->

<link rel="stylesheet" href="/../style.css">


<body>
    <nav class="navbar bg-body-tertiary" style="padding-top: 0%; padding-bottom: 0%; justify-content: space-between;">
        <div class="container-fluid" style="background-color: #2a5726;">
            <a class="navbar-brand" href="#">
                <img src="/../images/trailbuddy_logo.png" alt="Logo" width="60" height="70"
                    class="d-inline-block align-text-center"><span>TrailBuddy</span>
            </a>
            <a href="/login" class="btn btn-secondary" style="margin-right: 27px;">Logout</a>
        </div>
    </nav>
    <div class="profile" style="width: 1000px;">
        <h2 style="text-align: center;">My Profile</h2>
        <div>
            <div>
                <p>Current email: <placeholder id="currentEmail">${provider.emailAddress}</placeholder>
                </p>
                <p>Current name: <placeholder id="currentName"></placeholder>${provider.name}</p>
                <p>Current location: <placeholder id="currentLocation">${provider.location}</placeholder></p>
                <p>Current description: <placeholder id="currentDescription">${provider.description}</placeholder></p>

                <form action="/provider/update/${provider.id?c}" method="post">
                    <label for="aligned-name" style="padding-right: 30px;">Change email:</label>
                    <input id="aligned-name" type="text" id="email" name="emailAddress" required
                        style="border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box;" />
            </div>
            <br>
            <div>
                <label for="aligned-password">Change password: </label>
                <input id="aligned-password" type="password" id="password" name="password" required
                    style="border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box;" />
            </div>
            <br>
            <div>
                <label for="aligned-foo" style="padding-right: 30px;">Change name: </label>
                <input id="aligned-foo" type="text" id="name" name="name" required
                    style="border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box;" />
            </div>
            <br>
            <div>
                <label for="aligned-foo" style="padding-right: 30px;">Change description: </label>
                <input id="aligned-foo" type="text" id="description" name="description" required
                    style="border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box;" />
            </div>
            <br>
            <label for="location">Change State:</label>
            <select id="location" name="location" required
                style="margin-left: 31px; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box;">
                <option value="notNeeded">Select State</option>
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
            <br>
            <button class="submit">Update Profile</button>
        </form>
        </div>
        <br>
        <br>
        <a class="btn btn-warning" href="/provider/OfferingProvider" role="button">View your offerings</a>
        <h2><br>Create a Listing</h2>
        <form action="provider/createOffering" method="post">
        <div>
            <label for="aligned-name" style="padding-right: 100px;">Name:</label>
            <input id="aligned-name" type="text" class="pure-input-1"
                style="border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box; min-width: 500px;" required/>
        </div>
        <br>
        <div>
            <label for="date" style="padding-right: 109px;">Date: </label>
            <input id="date" type="date" style="border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box;" required/>
        </div>
        <br>
        <div>
            <label for="description" style="padding-right: 62px;">Description: </label>
            <input id="description" name="description" rows="4" cols="50"
                style="border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box;" required/>
        </div>
        <br>
        <label for="location" style="padding-right: 25px;">Select State:</label>
        <select id="location" name="location"
            style="margin-left: 31px; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box;" required>
            <option value="notNeeded">Select State</option>
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
        <p><br></p>
        <div class="mb-3">
            <label for="formFile" class="form-label">Upload image (optional)</label>
            <input class="form-control" type="file" id="formFile">
        </div>
        <br>
        <label for="skill-level" style="padding-right: 12px;">Select Skill level:</label>
        <select id="skill-level" name="skillLevel"
            style="margin-left: 15px; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box;" required>
            <option value="">Select Skill</option>
            <option value="begineer">Begineer</option>
            <option value="intermediate">Intermediate</option>
            <option value="advanced">Advanced</option>
        </select>
        <p><br></p>
        <div>

            <label for="aligned-list" style="padding-right: 43px;">Gear Checklist:</label>
            <input id="aligned-lsit" type="text" name="gearList" class="pure-input-1"
                style="border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box; min-width: 500px;" /><span>
                Seperate with commas</span>
        </div>
        <br><br>
        <button type="submit">Create</button>
        </form>
    </div>

    <footer>
        <p>@ 2026 TrailBuddy</p>
    </footer>
</body>

</html>