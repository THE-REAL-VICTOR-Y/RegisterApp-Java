/*
On page load[1], define “click” event handlers[2] for the various navigation buttons defined in the
view
*/

// Define Main Menu buttons functions
//Start Transaction
function start_transaction()
{
    return document.getElementById("start_transaction");
} 

//View Products
function view_products()
{
    return document.getElementById("view_products");
}

//Create Employee
function create_employee()
{
    return document.getElementById("create_employee");
}

//Sales Report
function sales_report()
{
    return document.getElementById("sales_report");
}

//Cashier Report
function cashier_report()
{
    return document.getElementById("cashier_report");
}

//Sign Out
function sign_out()
{
    return document.getElementById("sign_out");
}

//button navigation
//window.addEventListener('DOMContentLoaded', (event) => {
document.addEventListener('DOMContentLoaded', function(event) {    
    start_transaction().addEventListener("click", () => {displayError("Functionality has not yet been implemented."); });
    view_products().addEventListener("click", () => {window.location.assign("/productListing"); });
    create_employee().addEventListener("click", () => {window.location.assign("/employeeDetail"); });
    sales_report().addEventListener("click", () => {displayError("Functionality has not yet been implemented."); });
    cashier_report().addEventListener("click", () => {displayError("Functionality has not yet been implemented."); });
    sign_out().addEventListener("click", () => {(ajaxDelete()); location.replace("https://victor-y-app.herokuapp.com/signin"); });
});

