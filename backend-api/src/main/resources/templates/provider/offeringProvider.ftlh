<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All offerings</title>

</head>

    <link rel="stylesheet" href="/style.css">


<body>
    <nav>

        <div class="logo">
            <img src="/images/trailbuddy_logo.png" alt="TrailBuddy Logo by Bryan Palma">
            <span>TrailBuddy</span>
        </div>

        <div>
            <a href="/provider/providerProfile/${provider.id?c}">Activities</a>
            <a href="/login">Logout</a>
        </div>

    </nav>

<div class="card-container" style="padding-bottom: 265px;">

            <#list offerings as offer>
                <div class="card">
                    <img src="">
                    <h2>${offer.name}</h2>
                    <p>Skill level: ${offer.skillLevel}</p>
                    <p>Location: ${offer.location}</p>
                    <p>Date: ${offer.date}
                    <a href="">View Details</a>
                      <button type="button" class="btn btn-danger">Remove</button>
                        <button type="button" class="btn btn-warning">Update</button>
                </div>
         </#list>

</div>


        </div>
    </div>

<footer>
        <p>@ 2026 TrailBuddy</p>
    </footer>
</body>
</html>