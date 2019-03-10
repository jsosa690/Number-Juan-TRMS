function toJSONString(name, date, timeStart, timeEnd, loc, desc, amount, format, sel, sup, ben) {
	var obj = {
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
			benCo : ben
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

function getCookie(cname) {
	  var name = cname + "=";
	  var decodedCookie = decodeURIComponent(document.cookie);
	  var ca = decodedCookie.split(';');
	  for(var i = 0; i <ca.length; i++) {
	    var c = ca[i];
	    while (c.charAt(0) == ' ') {
	      c = c.substring(1);
	    }
	    if (c.indexOf(name) == 0) {
	      return c.substring(name.length, c.length);
	    }
	  }
	  return "";
	}
