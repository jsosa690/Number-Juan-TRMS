function toJSONString(formID, name, date, timeStart, timeEnd, loc, desc, amount, format, sel, sup, head, ben, superDecision, superContext, headDecision, headContext, benCoDecision, benCoContext) {
	var obj = {
			formID: formID,
			fullName : name,
			date : date,
			startTime : timeStart,
			endTime : timeEnd,
			location : loc,
			description : desc,
			cost : amount,
			gradingFormat : format,
			eventType : sel,
			supervisor : sup,
			deptHead: head,
			benCo : ben,
			superDecision: superDecision,
			superContext: superContext,
			headDecision: headDecision,
			headContext: headContext,
			benCoDecision: benCoDecision,
			benCoContext: benCoContext	
	};
	var url = 'http://localhost:8080/trms/form';
	fetch(url, {
		  method: 'POST', // or 'PUT'
		  body: JSON.stringify(obj), // data can be `string` or {object}!
		  headers:{
		    'Content-Type': 'application/json'
		  }
		}).then(res => res.text())
		.then(response => console.log('Success:', JSON.stringify(response)))
		.catch(error => console.error('Error:', error));

}
