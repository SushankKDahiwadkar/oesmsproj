$(document).ready(function(){
    var question1 = localStorage.getItem("createdQuestion");
    var question = JSON.parse(question1);
    $("#testId").text(question.testId);
    $("#questionId").text(question.id);
    $("#question").text(question.question);
    $("#option1").text(question.option1);
    $("#option2").text(question.option2);
    $("#option3").text(question.option3);
    $("#option4").text(question.option4);
    $("#correctAnswer").text(question.correctAnswer);
});