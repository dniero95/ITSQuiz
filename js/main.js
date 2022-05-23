var rightAnswer = `<div class="alert alert-success" role="alert">
Risposta Corretta!
</div>`;

var wrongAnswer = `<div class="alert alert-danger" role="alert">
Risposta Errata!
</div>`;

const checkAnswer = () =>{
    let answer = document.getElementById("a-q-1").innerHTML;
    if (document.getElementById("a-q-1").checked) {
        document.getElementById("result1").innerHTML = rightAnswer; 
    } else {
        document.getElementById("result1").innerHTML = wrongAnswer;
        
    }
    
}