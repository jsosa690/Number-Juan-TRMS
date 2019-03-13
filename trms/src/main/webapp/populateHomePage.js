function findSubmissions(){

    var url = 'http://localhost:8080/trms/populate';
    fetch(url, {
        method: 'POST',
    }).then(res => res.text())
    .then(response => {
        var forms = JSON.parse(response);
// If you want to do anything the forms object stores all of the forms to manipulate as you see fit.
//        N.B. I reccomend using the .forEach() method
        forms.forEach(makeFormButton);
        console.log("there are " + forms.length + " forms");

    })
    .catch(error => console.error('Error:', error));

}

function makeFormButton (jsonform) {
    console.log(jsonform);
    var newDiv  = document.createElement("div");
    var newButton = document.createElement("button");
    var newContent = document.createTextNode("Reimbursement: " + jsonform.formID + " Description: " + jsonform.description);
    newButton.appendChild(newContent);
    newDiv.appendChild(newButton);
    sloshy = document.querySelector('.container-fluid')
    sloshy.insertBefore(newDiv,document.querySelector("#populateReimbursementsButton"))
    


}