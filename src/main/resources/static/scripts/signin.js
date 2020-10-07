function ValidationEvent(){
    var employee = document.getElementById("employeeid").value;
    var password = document.getElementById("pword").value;

    if(employee < 0){
        alert("Employee ID must be greater than 0");
    }
    else if(password == ''){
        alert("Password field is blank");
    }

}