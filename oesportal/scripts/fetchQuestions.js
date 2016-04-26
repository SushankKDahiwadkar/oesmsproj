$(document).ready(function(){
    
        $("#submitButton").on('click', function(){
             var testId = $("#testId").val();
    var URL = "http://52.38.175.35:8080/oes/api/Question/Test/" + testId.toString();
            $.ajax({
            type : 'GET',
            url : URL,
            success : function(questions){
                localStorage.setItem("questions", JSON.stringify(questions));
                window.open("showTest.html", "_self");
            },
            error : function() {
                alert('error');
            }
        });
});
});