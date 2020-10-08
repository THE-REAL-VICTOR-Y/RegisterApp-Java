    document.addEventListener("DOMContentLoaded", function(event) {
        const employeeIdElement = getEmployeeIdEditElement();
        employeeIdElement.focus();
        employeeIdElement.select();
    });
    
    function validateForm() {
        const employeeIdElement = getEmployeeIdEditElement();
        if (isNaN(Number(employeeIdElement.value))
            || (Number(employeeIdElement.value) <= 0)) {
    
            displayError("Please provide a valid employee ID.");
    
           // employeeIdElement.focus();
           // employeeIdElement.select();
            
            return false;
        }
    
        const passwordEditElement = getPasswordEditElement();
        if ((passwordEditElement.value == null)
            || (passwordEditElement.value.trim() === "")) {
    
            displayError("Your password is blank, please provide a real password");
    
           // passwordEditElement.focus();
          //  passwordEditElement.select();
            
            return false;
        }
    
        return true;
    }
    
    //Getters and setters
    function getPasswordEditElement() {
        return document.getElementById("pword");
    }
    
    function getEmployeeIdEditElement() {
        return document.getElementById("employeeid");
    }