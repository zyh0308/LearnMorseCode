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
$(document).ready(function(){
    $("button").click(function(){
        let id = $(this).val();
        console.log($('#' + id).text());
        playAudio($('#' + id).text());
    })

    $("p").each(function(){
        $(this).text(displayMorse($(this).text()));
    });
});
