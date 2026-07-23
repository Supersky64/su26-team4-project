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
            <img src="/images/trailbuddy_logo.png" alt="TrailBuddy Logo by Bryan Palma">
            <span>TrailBuddy</span>
        </div>

        <div>
            <a href="/services">Home</a>
            <a href="/customer/profile/${customerId?c}">Profile</a>
            <a href="/login">Logout</a>
        </div>

    </nav>


    <div class="details">

        <h1>${outdoorService.name}</h1>

        <br>

        <img src="" alt="Activity Image">

        <br><br>


        <h3>Skill Level</h3>

        <span class="tag">
            ${outdoorService.skillLevel}
        </span>

        <br><br>

        <h3>Location</h3>

        <p>${outdoorService.location}</p>

        <h3>Date</h3>

        <p>${outdoorService.date}</p>

        <h3>Provider</h3>

        <p>${outdoorService.provider.name}</p>

        <h3>About This Activity</h3>

        <p>
            ${outdoorService.description}
        </p>

        <br>

        <h3>Gear Checklist</h3>

        <#if outdoorService.gearList?? && outdoorService.gearList?has_content>
            <ul>
                <#list outdoorService.gearList?split(",") as gear>
                    <li>${gear?trim}</li>
                </#list>
            </ul>
            <#else>
                <p>No gear required.</p>
        </#if>

        <br>

        <h3>Reviews</h3>
        <#if outdoorService.provider.reviews?? && outdoorService.provider.reviews?size gt 0>


            <#list outdoorService.provider.reviews as review>

                <div class="review">

                    <h4>
                        ${review.rating}/5
                    </h4>

                    <p>
                        ${review.comments}
                    </p>


                    <p>
                        <strong>
                            - ${review.customer.name}
                        </strong>
                    </p>

            <h3>Location</h3>
            <p>${outdoorService.location}</p>

            <br>
            <h3>Date</h3>
            <p>${outdoorService.date}</p>
            <br>
           

        <h3>Reviews</h3>

                    <#if review.replyText??>

                        <p>
                            <strong>
                                Provider Reply:
                            </strong>

                            ${review.replyText}
                        </p>

                    </#if>


                </div>

                <br>

            </#list>


        <a href="/register/prior" class="btn btn-warning">Register</a>
            <#else>

                <p>No reviews yet.</p>


        </#if>

        <form action="/reviews/new/${outdoorService.provider.id}" method="get">

            <button type="submit">
                Leave Review
            </button>

        </form>


        </form>

        <br>

        <form action="/rsvp/register/${outdoorService.id}" method="post">
            <button type="submit">
                Register
            </button>
        </form>

    </div>

</body>

</html>