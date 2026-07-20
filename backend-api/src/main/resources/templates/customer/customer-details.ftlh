<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${pageTitle}</title>
    <link rel="stylesheet" href="/style.css">
    <script src="/script.js" defer></script>
</head>


<body>

    <nav>

        <div class="logo">
            <img src="../images/trailbuddy_logo.png" alt="TrailBuddy Logo by Bryan Palma">
            <span>TrailBuddy</span>
        </div>

        <div>
            <a href="../customer/index.html">Home</a>
            <a href="../customer/login.html">Logout</a>
        </div>

    </nav>

    <div class="profile">

        <h1>Hi, ${customer.name}</h1>

        <br>

        <h3>${customer.name}</h3>


        <p>
            <strong>Email:</strong>
            ${customer.email}
        </p>


        <p>
            <strong>Favorite Activity:</strong>
            ${customer.preference}
        </p>



        <br>


        <p>

            Current Skill Level:

            <span id="currentSkill" class="tag">

                ${customer.skillLevel}

            </span>

        </p>



        <br>


        <h3>Based on your skill level: </h3>


        <div class="card">


            <h3 id="recommendation">

                <#if customer.skillLevel=="Beginner">

                    Something easy like a relaxing forest walk.

                    <#elseif customer.skillLevel=="Intermediate">

                        Let's try something more challenging, like a mountain hike!

                        <#else>

                            You're ready for a wilderness expedition!
                </#if>


            </h3>


            <br>

            <!-- Update Customer Information -->

            <form action="/customer/update/${customer.id}" method="post">

                <label for="name">Name</label>
                <input type="text" id="name" name="name" value="${(customer.name)!}" placeholder="Edit Name">
                

                <h3>Change Skill Level</h3>


                <select id="skillSelect" name="skillLevel" required>


                    <option value="Beginner" <#if customer.skillLevel=="Beginner">
                        selected
                        </#if>>
                        Beginner
                    </option>


                    <option value="Intermediate" <#if customer.skillLevel=="Intermediate">
                        selected
                        </#if>>
                        Intermediate
                    </option>


                    <option value="Advanced" <#if customer.skillLevel=="Advanced">
                        selected
                        </#if>>
                        Advanced
                    </option>


                </select>


                <br><br>


                <button type="submit">
                    Save Changes
                </button>


            </form>



            <br>







            <p>
                Here are some activities recommended for you.
            </p>


            <button>
                View Activities
            </button>


        </div>




        <br>




        <h3>Upcoming Trips</h3>



        <#if customer.rsvps?has_content>


            <#list customer.rsvps as rsvp>


                <p>

                    Trip RSVP #${rsvp.id}

                </p>


            </#list>


            <#else>


                <p>
                    No upcoming trips.
                </p>


        </#if>




        <br>




        <h3>Reviews</h3>



        <#if customer.reviews?has_content>


            <#list customer.reviews as review>


                <p>

                    Rating:
                    ${review.rating}/5

                </p>


                <p>

                    "${review.comments}"

                </p>


                <hr>


            </#list>



            <#else>


                <p>
                    No reviews yet.
                </p>



        </#if>




    </div>



</body>

</html>