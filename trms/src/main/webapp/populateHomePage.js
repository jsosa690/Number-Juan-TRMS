function findSubmissions(){

    verse = verse.replace(" ", "");
    verse = verse.toLowerCase();
    var url = verse + '.txt';
    
    fetch(url).then(function(response) {
    	  response.text().then(function(text) {
    	    poemDisplay.textContent = text;
    	  });
    	});
}