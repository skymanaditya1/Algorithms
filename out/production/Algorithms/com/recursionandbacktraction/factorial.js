// Find the factorial of a number using recursion
var factorial = function (n){
	if (n === 1 || n === 0){
		return 1;
	}

	return n * factorial (n - 1);
};

// A helper function to return the factorial of the number
var helper = function(){
	document.writeln("The factorial of 4 is : " + factorial (4));
	document.writeln("The factorial of 10 is : " + factorial (10));
}

// Call the helper function
helper();