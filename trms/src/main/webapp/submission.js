function toJSONString( form ) {
	var obj = {};
	var elements = form.querySelectorAll( "input, select" );
	for( var i = 0; i < elements.length; ++i ) {
		var element = elements[i];
		var name = element.name;
		var value = element.value;

		if( name ) {
			obj[ name ] = value;
		}
	}

	return JSON.stringify( obj );
}

document.addEventListener( "DOMContentLoaded", function() {
	var form = document.getElementById( "test" );
	var output = document.getElementById( "output" );
	form.addEventListener( "submit", function( e ) {
		e.preventDefault();
		var url = '/trms/form';
		var data = {username: 'example'};
		fetch(url, {
			  method: 'POST', // or 'PUT'
			  body: JSON.stringify(data), // data can be `string` or {object}!
			  headers:{
			    'Content-Type': 'application/json'
			  }
			}).then(res => res.json())
			.then(response => console.log('Success:', JSON.stringify(response)))
			.catch(error => console.error('Error:', error));
//
//		var data = toJSONString( this );
//		fetch(url, {
//			method: 'POST', // or 'PUT'
//			body: data, // data can be `string` or {object}!
//			headers:{
//				'Content-Type': 'application/json'
//			}
//		}).then(res => res.json())
//		.then(response => console.log('Success:', JSON.stringify(response)))
//		.catch(error => console.error('Error:', error));
		output.innerHTML = data;
	})
});

