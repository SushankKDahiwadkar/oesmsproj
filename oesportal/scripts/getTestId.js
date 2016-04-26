$(document).ready(function(){
    
    $("#submitButton").on('click', function(){
        var testId = $("#testId").val();
        alert(testId);
        localStorage.setItem("testId", testId);
    });
    });