$(document).ready( ()=>{
    $(document).keydown(function(e){
        if (e.which == 37) {
           $("audio#dit")[0].currentTime = 0;
           $("audio#dit")[0].play();
           return false;
        }
    });
    $(document).keydown(function(e){
        if (e.which == 39) {
        $("audio#dah")[0].currentTime = 0;
        $("audio#dah")[0].play();
        return false;
        }
    });
});

