function findSubmissions(){

    var url = 'http://localhost:8080/trms/populate';
    fetch(url, {
        method: 'POST',
    }).then((res) => {
        return res.json();
    })
    .then((json) => {
       console.log(json); // The json object is here
       james = json;
       james.forEach(makeFormButton);
       return james;
       
    })
    .catch(error => console.error('Error:', error));
    //HOLY SHIT BOYS IT WORKED

}

function makeFormButton (jsonform) {
    console.log(jsonform);
    var newDiv  = document.createElement("div");
    var divContent = document.createTextNode(jsonform.cost)
    newDiv.appendChild(divContent);
    var newButton = document.createElement("button");
    newButton.addEventListener("click",function() {
		modal.style.display = "block";
//		Full name: <br> <input type="text" id="fullName"><br>
		document.querySelector('#fullName').value = jsonform.fullName;
//		Date: <br> <input type="date" id="startDate"><br>
		document.querySelector('#startDate').value = 'jsonform.startDate';
//		Start Time: <br> <input type="time" id="startTime"><br>
		document.querySelector('#startTime').value = 'jsonform.startTime';
//		End Time: <br> <input type="time" id="endTime"><br>
		document.querySelector('#endTime').value = 'jsonform.endTime';	
//		Location: <br> <input type="text" id="location"><br>
		document.querySelector('#location').value = jsonform.location;
//		Description: <br> <input type="text" id="description"><br>
		document.querySelector('#description').value = jsonform.description;
//		Cost: <br> <input type="text" id="cost"><br>
		document.querySelector('#cost').value = jsonform.cost;
//		Grading Format: <br> <input type="text" id="format"><br>
		document.querySelector('#format').value = jsonform.gradingFormat;
//		Type of event: <br> <select id="select">
//		Supervisor: <br> <input type="text" id="supervisor"><br>
//		Benefits Coordinator: <br> <input type="text" id="benCo"><br>
	});
    var butContent = document.createTextNode('Update form')
    newButton.appendChild(butContent)
    newDiv.appendChild(newButton);
    sloshy = document.querySelector('.container-fluid')
    sloshy.insertBefore(newDiv,document.querySelector("#populateReimbursementsButton"))
    


}