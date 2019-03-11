function setCookie(cname,cvalue,exdays) {
  var d = new Date();
  d.setTime(d.getTime() + (exdays*24*60*60*1000));
  var expires = "expires=" + d.toGMTString();
  document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
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

function checkCookie() {
	  var username = getCookie("username");
	  if (username != "") {
			document.getElementById("welcomeHeader").innerHTML = "Welcome " + username;
	  } else {
	    //username = prompt("Please enter your name:", "");
		  var url = 'http://localhost:8080/trms/login';
			fetch(url, {
				  method: 'GET', // or 'PUT'
				  headers:{
				    'Content-Type': 'application/json'
				  }
				}).then(res => res.text())
				.then(response => console.log('Success:', JSON.stringify(response)))
				.catch(error => console.error('Error:', error));
	    if (username != "" && username != null) {
	      setCookie("username", username, 365);
	    }
	  }
	}
