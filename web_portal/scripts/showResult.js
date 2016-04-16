$(document).ready(function(){
    
        $("#submitButton").on('click', function(){
             var testId = $("#testId").val();
    var URL = "http://52.38.175.35:8080/oes/api/Score/Test/" + testId.toString();
            $.ajax({
            type : 'GET',
            url : URL,
            success : function(createdTest){
                showTable(createdTest);
            },
            error : function() {
                alert('error');
            }
        });
    function showTable(result){
        var table = document.createElement("TABLE");
        table.border= "1";
        var columnCount = 4;
        
        var row = table.insertRow(-1);
        
        var columns = ["User Id", "Score", "Total Marks"];
        for (var i = 0; i < columns.length ; i++) {
            var headerCell = document.createElement("TH");
            headerCell.innerHTML = columns[i];
            row.appendChild(headerCell);
        }
        
        for(var i = 0; i<result.length; i++){
            row = table.insertRow(-1);
            var cell = row.insertCell(-1);
            //alert(getUser(result[i].userId));
            cell.innerHTML = getUser(result[i].userId); //result[i].userId;
            var cell = row.insertCell(-1);
            cell.innerHTML = result[i].score;
            var cell = row.insertCell(-1);
            cell.innerHTML = result[i].totalMarks;
        }
        
        var dvTable = document.getElementById("content");
        dvTable.innerHTML = "";
        dvTable.appendChild(table);
    }
            
            function getUser(userId){
                var userName = "test";
                    var URL = "http://localhost:8080/oes/api/User/" + userId;
                    $.ajax({
                    type : 'GET',
                    url : URL,
                    async : false,
                    success : function(user){
                         userName = user.firstName + " " + user.lastName;
                    },
                    error : function() {
                        alert('error');
                    }
                });
                return userName;
            }
        });
   
});