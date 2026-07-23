<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Leave Review</title>

    <link rel="stylesheet" href="/style.css">

</head>


<body>


<nav>

    <div class="logo">

        <img src="/images/trailbuddy_logo.png" 
             alt="TrailBuddy Logo">

        <span>TrailBuddy</span>

    </div>


    <div>

        <a href="/services">Home</a>

        <a href="/customer/profile/${customerId?c}">
            Profile
        </a>

        <a href="/login">
            Logout
        </a>

    </div>

</nav>



<div class="details">


<h1>
    Leave a Review
</h1>



<form action="/reviews/create" method="post">


    <!-- Customer ID -->

    <input type="hidden"
           name="customer.id"
           value="${customerId}">



    <!-- Provider ID -->

    <input type="hidden"
           name="provider.id"
           value="${providerId}">



    <h3>
    Rating
</h3>

<select name="rating" required>

    <option value="5">
        5 - Excellent
    </option>

    <option value="4">
        4 - Good
    </option>

    <option value="3">
        3 - Average
    </option>

    <option value="2">
        2 - Poor
    </option>

    <option value="1">
        1 - Bad
    </option>

</select>


    <br><br>



    <h3>
        Comment
    </h3>


    <textarea 
        name="comments"
        rows="5"
        cols="40"
        placeholder="Share your experience..."
        required></textarea>



    <br><br>



    <button type="submit">
        Submit Review
    </button>


</form>



</div>


</body>

</html>