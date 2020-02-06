
$(document).ready( ()=>{
    // Grabs the morse, cleans it up, hides the ugly morse with the slashes, displays the clean morse
    // and gets the correct answers
    const correctAnswerMorse = checkMorse($("#output").text());
    const correctAnswerEnglish = $("#correctAnswer").val();
    $("#output").hide();
    $("#correctAnswer").hide();
    const cleanMorse = displayMorse($("#output").text());
    $("#display").text(cleanMorse);
    
    // left arrow makes a dit sound and inputs a "."
    $(document).keydown(function(e){
        if (e.which == 37) {
           $("audio#dit")[0].currentTime = 0;
           $("audio#dit")[0].play();
           $("#input").text(()=> $("#input").text() + ".");
           return false;
        }
    });
    // right arrow makes a dah sound and inputs a "-"
    $(document).keydown(function(e){
        if (e.which == 39) {
        $("audio#dah")[0].currentTime = 0;
        $("audio#dah")[0].play();
        $("#input").text(()=> $("#input").text() + "-");
        return false;
        }
    });
    // space bar creats a space in the input
    $(document).keydown(function(e){
        if (e.which == 32) {
            $("#input").text(()=> $("#input").text() + " ");
        }
        if(e.which==8){
            $("#input").text(()=> $("#input").text().slice(0, $("#input").text().length-1));

        }
    })
    // pressing play plays the audio of the output

    const morse = $("#output").text();
    $("#play").click(function(){
    playAudio(morse);
    })
    // checks the input against the correct answer for english to morse
    $("#checkMorse").click(function checkMorse(e){
    if(correctAnswerMorse == $("#input").text()){
    alert("Correct!");

    } else {
        e.preventDefault();
        alert("Incorrect!");
    }
    })
    // checks the input against the correct answer for morse to english
    $("#checkEnglish").click(function checkEnglish(e){
    if(correctAnswerEnglish == $("#userAnswer").val().toLowerCase()){
        alert("Correct!");
    } else {
        e.preventDefault();
        alert("Incorrect!");
    }
    })
    $("#messageSubmit").click(()=>{
    $("#messageText").val($("#input").text());
    })
});

// plays the audio with the correct timing
function playAudio(string){
    counter = 0;
    bar = false;
    space = false;
    timeUnit = 300;
    for(i = 0; i < string.length; i++){
        if(string.charAt(i) == "."){
            if(space){
            setTimeout(playDit,((7 * timeUnit) + (timeUnit * counter)));
            counter++;
            space = false;
            } else if(bar){
                setTimeout(playDit,((3 * timeUnit) + (timeUnit * counter)));
                counter++;
                bar = false;
            } else {
                setTimeout(playDit,(timeUnit * counter));
                counter++;
            }
        } else if(string.charAt(i) == "-"){
            if(space){
                setTimeout(playDah,((7 * timeUnit) + (timeUnit * counter)));
                counter++;
                space = false;
                } else if(bar){
                    setTimeout(playDah,((3 * timeUnit) + (timeUnit * counter)));

                    counter++;
                    bar = false;
                } else {
                    setTimeout(playDah,(timeUnit * counter));

                    counter++;
                }
            } else if(string.charAt(i) == "/"){
            bar = true;
        } else if (string.charAt(i) == " "){
            space = true;
        }
    }
}

// plays the dit sound
function playDit(){
    $("audio#dit")[0].currentTime = 0;
    $("audio#dit")[0].play();
}

// plays the dah sound
function playDah(){
    $("audio#dah")[0].currentTime = 0;
    $("audio#dah")[0].play();
}

// cleans the morse up by changing the /s to spaces for display
function displayMorse(code){
     result = "";
     for(i = 0;i<code.length;i++){
         if(code.charAt(i) == "."){
             result += ".";
         } else if(code.charAt(i) == "-"){
             result += "-";
         } else if(code.charAt(i) == "/"){
             result += " ";
         }
     }
     return result;
 }

// cleans the morse up by getting rid of /s to use as a check for the correct answer
 function checkMorse(code){
     result = "";
     for(i = 0;i<code.length;i++){
         if(code.charAt(i) == "."){
             result += ".";
         } else if(code.charAt(i) == "-"){
             result += "-";
         }
     }
     return result;
 }

