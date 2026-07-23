package templates.provider;

public class offeringProviderdetails {

}
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Details</title>
    <link rel="stylesheet" href="/../style.css">
</head>

<body>

    <nav>

        <div class="logo">
            <img src="../images/trailbuddy_logo.png" alt="TrailBuddy Logo by Bryan Palma">
            <span>TrailBuddy</span>
        </div>

        <div>
            <a href="/provider/providerProfile">Profile</a>
            <a href="/login">Logout</a>
        </div>

    </nav>



    <div class="details">


        <h1>${outdoorService.name}</h1>

        <br>

        <img>


        <br><br>


        <h3>Skill Level</h3>

        <span class="tag">
            ${outdoorService.skillLevel}
        </span>


        <h3>About This Activity</h3>

        <p>
            ${outdoorService.description}
        </p>


        <br>


        <h3>Gear Checklist</h3>

        <ul>

            ${outdoorService.gearList}

        </ul>


        <br>


            <h3>Location</h3>
            <p>${outdoorService.location}</p>

            <br>
            <h3>Date</h3>
            <p>${outdoorService.date}</p>
            <br>
            <h3>Provider name</h3>
            <p>${provider.name}</p><br>
            <h3>Provider email</h3>
            <p>${provider.email}</p>

        <h3>Reviews</h3>

        <p>
            ★★★★★
            Great guide and amazing views!
        </p>

        <br>

        <a href="/register/prior" class="btn btn-warning">Register</a>


    </div>

</body>

</html>