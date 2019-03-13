function findSubmissions(){
	console.log('isathing')
	var url = 'http://localhost:8080/trms/populate';
    fetch(url, {
    	method: 'POST',
    }).then(res => res.text())
	.then(response => {
		var fu = JSON.stringify(response);
		console.log(fu);
			})
	.catch(error => console.error('Error:', error));
    return fu;
}