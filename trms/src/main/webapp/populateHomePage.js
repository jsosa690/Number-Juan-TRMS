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
    //
    usertype = getCookie("usertype");
    console.log(usertype);
    if(usertype == 2) {
    	document.querySelector('#superApproval').disabled = false;
    	document.querySelector('#superContext').disabled = false;
    }else if(usertype == 3) {
    	document.querySelector('#benCoApproval').disabled = false;
    	document.querySelector('#benCoContext').disabled = false;
    }

}

function makeFormButton (jsonform) {
    console.log(jsonform);
    var newDiv  = document.createElement("div");
    var divContent = document.createTextNode(jsonform.formID)
    newDiv.appendChild(divContent);
    var newButton = document.createElement("button");
    newButton.addEventListener("click",function() {
		modal.style.display = "block";
		document.querySelector('#mhead').innerHTML = jsonform.formID;
//		Full name: <br> <input type="text" id="fullName"><br>
		document.querySelector('#fullName').value = jsonform.fullName;
//		Date: <br> <input type="date" id="startDate"><br>
		document.querySelector('#startDate').value = jsonform.startDate;
//		Start Time: <br> <input type="time" id="startTime"><br>
		document.querySelector('#startTime').value = jsonform.startTime;
//		End Time: <br> <input type="time" id="endTime"><br>
		document.querySelector('#endTime').value = jsonform.endTime;	
//		Location: <br> <input type="text" id="location"><br>
		document.querySelector('#location').value = jsonform.location;
//		Description: <br> <input type="text" id="description"><br>
		document.querySelector('#description').value = jsonform.description;
//		Cost: <br> <input type="text" id="cost"><br>
		document.querySelector('#cost').value = jsonform.cost;
//		Grading Format: <br> <input type="text" id="format"><br>
		document.querySelector('#format').value = jsonform.gradingFormat;
//		Type of event: <br> <select id="select">
		document.querySelector('#select').value = jsonform.eventType; 
//		Supervisor: <br> <input type="text" id="supervisor"><br>
		document.querySelector('#supervisor').value = jsonform.supervisor;
//		Benefits Coordinator: <br> <input type="text" id="benCo"><br>
		document.querySelector('#benCo').value = jsonform.benCo;
	});
    var butContent = document.createTextNode('Update form')
    newButton.appendChild(butContent)
    newDiv.appendChild(newButton);
    sloshy = document.querySelector('.container-fluid')
    sloshy.insertBefore(newDiv,document.querySelector("#populateReimbursementsButton"))
    


}