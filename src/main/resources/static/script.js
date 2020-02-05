$(document).ready( ()=>{
    $(document).keydown(function(e){
        if (e.which == 37) {
           $("audio#dit")[0].currentTime = 0;
           $("audio#dit")[0].play();
           $("#input").text(()=> $("#input").text() + ".");
           $("#result").val($("#input").text());
           return false;
        }
    });
    $(document).keydown(function(e){
        if (e.which == 39) {
        $("audio#dah")[0].currentTime = 0;
        $("audio#dah")[0].play();
        $("#input").text(()=> $("#input").text() + "-");
        $("#result").val($("#input").text());
        return false;
        }
    });
    const morse = $("#output").text();
    $("#play").click(function(){
    playAudio(morse);
    })


});

function playAudio(string){
    counter = 0;
    space = false;
    for(i = 0; i < string.length; i++){
        if(string.charAt(i) == "."){
            if(space){
            setTimeout(PlayDit,(600 + (200 * counter)));
            counter++;
            space = false;
            }
            setTimeout(PlayDit,(200 * counter));
            counter++;
        } else if(string.charAt(i) == "-"){
            if(space){
                setTimeout(PlayDit,(600 + (200 * counter)));
                counter++;
                space = false;
                 }
            setTimeout(playDah,(200 * counter));
            counter++;
            } else if(string.charAt(i) == "/"){
            space = true;
        }
    }
}

function PlayDit(){
    $("audio#dit")[0].currentTime = 0;
    $("audio#dit")[0].play();
}

function playDah(){
    $("audio#dah")[0].currentTime = 0;
    $("audio#dah")[0].play();
}