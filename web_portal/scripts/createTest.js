$(document).ready(function(){
    
    $("#submitButton").on('click', function(){
        var userId = $("#userId").val();
        var testName = $("#testName").val();
        var subjectName = $("#subjectName").val();
        var totalQuestions = $("#totalQuestions").val();
    
        var question = {
                userId : userId,
                testName : testName,
                subject : subjectName,
                totalQuestions : totalQuestions,
                activated : 'false'
            };
        
        $.ajax({
            type : 'POST',
            url : 'http://localhost:8080/oes/api/Test',
            contentType : "application/json; charset=utf-8",
            data : JSON.stringify(question),
            datatype : 'json',
            success : function(createdTest){
                localStorage.setItem("createdTest", JSON.stringify(createdTest));
                alert("Test Created Successfully, Test Id : " + createdTest.testId);
            },
            error : function() {
                alert('error');
            }
        });
    });
    });