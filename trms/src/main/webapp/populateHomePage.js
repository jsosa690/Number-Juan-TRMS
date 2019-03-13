function findSubmissions(){

	var url = 'http://localhost:8080/trms/populate';
	fetch(url, {
		method: 'POST',
	}).then(res => res.text())
	.then(response => {
		console.log(response.length);
		var forms = JSON.parse(response);
		forms.forEach(makeFormButton);
		console.log("there are " + forms.length + " forms");

	})
	.catch(error => console.error('Error:', error));

}

function makeFormButton (jsonform) {
	console.log(jsonform);
	console.log(jsonform.cost);
	var newDiv  = document.createElement("div");
	var newButton = document.createElement("button");
	var newContent = document.createTextNode("Reimbursement: " + jsonform.formID + " Description: " + jsonform.description); 
	newButton.appendChild(newContent);
	newDiv.appendChild(newButton);
	var currentDiv = document.getElementById("populateReimbursementsButton"); 
	document.querySelector("body").appendChild(currentDiv);


}