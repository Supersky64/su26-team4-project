//change skill

const skillSelect = document.getElementById("skillSelect");
const currentSkill = document.getElementById("currentSkill");
const recommendSkill = document.getElementById("recommendSkill");
const recommendation = document.getElementById("recommendation");


skillSelect.addEventListener("change", function(){

    let skill = skillSelect.value;

    currentSkill.textContent = skill;
    recommendSkill.textContent = skill;


    if(skill === "Beginner"){
        recommendation.textContent = "Something not to daring like a nice forest walk.";
    }

    else if(skill === "Intermediate"){
        recommendation.textContent = "Let's try something a bit more daring, like a mountain hike!";
    }

    else if(skill === "Advanced"){
        recommendation.textContent = "Ok you pro, try doing a wilderness expidition or somthing!";
    }

});

