$(document).ready(function(){
    var question1 = localStorage.getItem("questions");
    var t = JSON.parse(question1);
    var questionSet = "";
    
    for(var i=0;i < t.entries.length; i++){
        var q = "<p><span>Question Id</span><span>"+t.entries[i].id+"</span></p><p><span>Question</span><span>"+t.entries[i].question+"</span></p><p><span>Option 1</span><span>"+t.entries[i].option1+"</span></p><p><span>Option 2</span><span>"+t.entries[i].option2+"</span></p><p><span>Option 3</span><span>"+t.entries[i].option3+"</span></p><p><span>Option 4</span><span>"+t.entries[i].option4+"</span></p><p><span>Correct Answer</span><span>"+t.entries[i].correctAnswer+"</span></p><p><span>----------------</span></p><p><span>-------------------</span></p>";
        questionSet = questionSet + q;
    }
    document.getElementById('show').innerHTML = questionSet;
    /*var question = JSON.parse(question1);
    $("#testId").text(question.testId);
    $("#questionId").text(question.id);
    $("#question").text(question.question);
    $("#option1").text(question.option1);
    $("#option2").text(question.option2);
    $("#option3").text(question.option3);
    $("#option4").text(question.option4);
    $("#correctAnswer").text(question.correctAnswer);*/
});