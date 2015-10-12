// Solves the tower of Hanoi problem using recursion
var hanoi = function (disc, src, aux, dst){
	if (disc > 0){
		hanoi (disc - 1, src, dst, aux);
		document.writeln('Move disc ' + disc + ' from ' + src + 'to ' + dst);
		hanoi (disc - 1, aux, src, dst);
	}
};

// Create a function to call hanoi
var helper = function(){
	document.writeln("Tower of Hanoi problem with 3 pegs");
	hanoi(3, "Source", "Auxiliary", "Desination");
	document.writeln("Tower of Hanoi problem with 4 pegs");
	hanoi(4, "Source", "Auxiliary", "Destination");
};

// Call the helper function
helper();