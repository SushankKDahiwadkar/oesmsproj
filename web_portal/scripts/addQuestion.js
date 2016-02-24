$(document).ready(function(){
    
    $("#submitButton").on('click', function(){
        var testId = $("#testId").val();
        var question = $("#question").val();
        var option1 = $("#option1").val();
        var option2 = $("#option2").val();
        var option3 = $("#option3").val();
        var option4 = $("#option4").val();
        var correctAnswer = $("#correctAnswer").val();
    
        var question = {
                testId : testId,
                question : question,
                option1 : option1,
                option2 : option2,
                option3 : option3,
                option4 : option4,
                correctAnswer : correctAnswer
            };
        
        $.ajax({
            type : 'POST',
            url : 'http://localhost:8080/oes/api/Question',
            contentType : "application/json; charset=utf-8",
            data : JSON.stringify(question),
            datatype : 'json',
            success : function(createdQuestion){
                localStorage.setItem("createdQuestion", JSON.stringify(createdQuestion));
                window.open("createdQuestion.html", "_self");
            },
            error : function() {
                alert('error');
            }
        });
    });
    });