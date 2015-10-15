// Computes the fibonacci numbers recursively using memoization (efficient)
var fibonacci = function(){
	var memo = [0, 1];
	var fib = function(n){
		var result = memo[n];
		if (typeof result !== 'number'){
			result = fib(n-1) + fib(n-2);
			memo[n] = result;
		}
		return result;
	};
	return fib;
};

// Compute the first n fibonacci numbers recursively
var n = 10;

document.writeln("First " + n + " fibonacci numbers ");

for (var i = 0; i <= 10; i+=1){
	var fib_num = fibonacci();
	document.writeln(i + " : " + fib_num(i));
}
