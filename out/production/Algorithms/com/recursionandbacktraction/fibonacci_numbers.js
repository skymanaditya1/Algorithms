// Generates the first n Fibonacci Numbers
var fibonacci = function(n){
	return n < 2 ? n : fibonacci ( n - 1) + fibonacci ( n - 2);
};

// for loop to generate the first n fibo numbers

var n = 10;

document.writeln("First " + n + " fibonacci numbers ");

for ( var i = 0; i <= n; i += 1){
	document.writeln(i + " : " + fibonacci(i));
}