<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${pageTitle}</title>

    <link rel="stylesheet" href="/style.css">
</head>

<body>

    <!-- Navbar -->
    <nav>

        <div class="logo">
            <img src="/images/trailbuddy_logo.png" alt="TrailBuddy Logo">
            <span>TrailBuddy</span>
        </div>

        <div>
            <a href="/customer/profile/${customerId?c}">Profile</a>
            <a href="/login">Logout</a>
        </div>

    </nav>


    <section class="hero">

        <h1>Find Your Next Adventure!</h1>

        <p>
            Guided hikes, paddles, and outdoor classes
            for every skill level.
        </p>

    </section>


    <div class="container">

        <div class="search">
            <input type="text" placeholder="Search for activity...">
        </div>


        <div class="card-container">

            <#list services as service>

                <div class="card">

                    <img src="/images/trailbuddy_logo.png" alt="Activity Image">

                    <h2>${service.name}</h2>


                    <p>
                        Skill Level:
                        <span class="tag">
                            ${service.skillLevel}
                        </span>
                    </p>


                    <p>
                        Location:
                        ${service.location}
                    </p>


                    <p>
                        Date:
                        ${service.date}
                    </p>


                    <p>
                        Description:
                        ${service.description}
                    </p>


                    <a href="/services/${service.id?c}">
                        <button>
                            View Details
                        </button>
                    </a>

                </div>

            </#list>


        </div>

    </div>


    <footer>
        <p>@ 2026 TrailBuddy</p>
    </footer>


</body>

</html>