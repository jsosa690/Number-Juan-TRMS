function myfunction(usr, pw) {
			var url = 'http://localhost:8080/trms/login';
			var data = {username: usr, password: pw};
			var myname = document.getElementById('usr');
			fetch(url, {
				  method: 'POST', // or 'PUT'
				  body: JSON.stringify(data), // data can be `string` or {object}!
				  headers:{
				    'Content-Type': 'application/json'
				  },
				  redirect: "follow",
				}).then(res => res.text())
				.then(response => {
					if (!response.includes("TRMS login")) {
						window.location.href="/trms/home";						
					} else {
						console.log('Success:', JSON.stringify(response))
					}
						})
				.catch(error => console.error('Error:', error));
		}

