// Demonstrates the use of functions in JAVASCRIPT
document.writeln("Hello World ")

// functions are used to specify the behavior of objects
// functions in JS are objects

// functions in JS are objects, Objects are collections of name/value pairs
// having a hidden link to a prototype object
// Objects produced from object literals are linked to Object.prototype

// The function's context and the code that implements the functions behaviour

// Function objects are created with function literals
// Create a variable called add and store a functions
// in it that adds two numbers

var add = function(a, b){
	return a+b;
};

// a function literal has four parts, the first part is the reserved word function
// the optional second part is the name of the function, the function can use its name
// to call itself recursively. A function with no name is called anonymous
// The third part is the set of parameters of the function, wrapped in parentheses.
// Zero or more arguments can be passed to the function wrapped between the parentehses
// The fourth part is the set of statements wrapper in curly braces. 
// These statements are called as the body of the function. 
// An inner function has access to the parameters and variables of the function in which it is defined. 
var multiply = function(a, b){
	return a*b;
};

// a function to subtract two numbers
var sub = function(a, b){
	return a - b;
};

// Invoking a functoion suspends the execution of the current function
// passing control and parameters to the new function. 
// Every function receives two additional arguments, the this and the arguments
// There is no runtime error when the number of arguments and the number of parameters do not match
// If there are too many argument values, the extra argument values will be ignore. 
// If there are too few argument values, the missing argument values will be substituted with undefined values. 

// When a function is stored as a property of an object it is called as method

// Create an object myobject, it has a value and an increment function associated with it
var myObject = {
	value: 0,
	increment: function(inc){
		this.value += typeof inc === 'number' ? inc : 1;
	}
};

// Call the methods, no runtime error is generated if more or less number of arguments than required are supplied
myObject.increment();
document.writeln("value of myObject : ",myObject.value); // 1

myObject.increment(2);
document.writeln("value of myObject : ",myObject.value); // 3

// method can use this to access the object so that it can retrieve values from the object or modify the object
// Function Invocation pattern
// When a function is not a property of an object, then it is invoked as a function
var sum = add(3, 4); // add is not a property of an object, and hence it is invoked as a function
document.writeln("The sum is : ",sum); // this is bound to the global object

// Augment myObject with a double method
myObject.double = function(){
	var that = this; // Workaround.

	var helper = function(){
		that.value = add(that.value, that.value);
	};

	helper(); // Invokes helper as a function
};

myObject.double();
document.writeln(myObject.value); // 6

// Augmenting methods of the object using the that variable

var object  = {
	value: 0,
	increment: function(inc){
		this.value += typeof inc === 'number'?inc : 1
	}
};

object.increment();
document.writeln("The object value is : ",object.value); // 1

object.increment(2);
document.writeln("The object value is : "+object.value); // 3

// Augmenting the double method of the object
object.double = function(){
	var that = this;
	var helper = function(){
		// document.wrinteln("The object value inside helper : ",this.value);
		that.value = 2 * that.value;
	};
	helper();
};

object.double();
document.writeln("The object value is : ",object.value); // 6

// The Constructor Invocation pattern
// JS is a prototypal inheritance language, that means that objects can inherit properties directly from other objects
// This is a radical departure, as most languages today are classical

// If t function is invoked with the new prefix, then a new object will be created with a hidden link 
// to the value of the function's prototype member, and this will be bound to that new object.
// The new prefix also changes the behavior of the return statement.

// Create a constructor function called Quo. 
// It makes an object with a status property. 

var Quo = function(string){
	this.status = string;
};

// Give all instances of Quo a public method
// called get_status

Quo.prototype.get_status = function(){
	return this.status;
}

// Make an instance of Quo.
var myQuo = new Quo("Confused");
document.writeln(myQuo.get_status()); // Confused

// Create a constructor
var Hello = function(string){
	this.print = string;
};

// create a method that returns the string 
Hello.prototype.return_print = function(){
	return this.print;
};

// Create an instance of the Hello object
var myHello = new Hello("Hello World");
document.writeln(myHello.return_print());

// Since JS is a functional object-oriented language, functions can have methods
// The apply methods takes two parameters, the first is the value that should be returned to this,
// the second is an array of parameters. 

// Make an array of 2 numbers (parameters) and add them
var array = [3, 4];
var sum = add.apply(null, array); // the sum is 7

// Make an object with a status member
var statusObject = {
	status: 'A-Ok'
};

var status = Quo.prototype.get_status.apply(statusObject);
// status is 'A-Ok'

// Arguments
// Bonus parameters available to functions when they are invoked is the arguments array,
// Make a function that adds a lots of stuff

var sum = function(){
	var i; var sum = 0;
	for (i=0; i<arguments.length; i+=1){
		if (typeof arguments[i] === 'number'){
			sum += arguments[i];
		}
	}
	return sum;
};

document.writeln(sum(3, 4, 5, 2, 1, 6, 3));

// If the return value is not specified then undefined value is returned
// If the function was invoked with the new prefix and the return value is not an object, then this (new object) is returned instead

// Exceptions
// Exceptions should be given a name property that identifies the type of the exception and a descriptive message indicating the type of the exception

var add = function(a, b){
	if (typeof a !== 'number' || typeof b !== 'b'){
		throw{
			name: 'TypeError',
			message: 'add needs numbers'
		};
	}
	return a+b;
};

// The exception object is delivered to the catch clause of a try statement
// Make a try_it function that calls the new add function incorrectly

var try_it = function(){
	try{
		add("Seven", "Eight");
	}catch(e){
		document.writeln(e.name + ":" + e.message);
	}
}

try_it();

// Create a method multiply that takes two numbers as arguments, error should be generated (expcetions raised) if the two numbers cannot be added

var mul = function(a, b){
	if (typeof a !== 'number' || typeof b != 'number'){
		throw{
			name: 'TypeError',
			message: 'mul expects numbers'
		};
	}

	return a * b;
};

var try_mul = function(){
	try{
		document.writeln(mul(10, 20));
	}
	catch(e){
		document.writeln(e.name + ":" + e.message);
	}
}

try_mul();

// If an exception is thrown within a try block then control will go to its corresponding catch clause

// Augmenting types
// by augmenting the Function.prototype we can make a method available to all of the functions
Function.prototype.method = function(name, func){
	this.prototype[name] = func;
	return this;
};

// How to extract just the integer part of a number in JS
document.writeln("Hello World");
var i = 3.6;
document.writeln(i);

Number.method('integer', function() {
	return Math[this < 0 ? 'ceiling' : 'floor'](this);
});

document.writeln(i.integer());

// Add a method conditionally
Function.prototype.method = function(name, func){
	if (!this.prototype[name]){
		this.prototype[name] = func;
	}
};

// Recursion
// A problem divided into a set of similar subproblems, each solved with a trivial solution
// Tower of hanoi problem using recursion
var hanoi = function (disc, src, aux, dst){
	if (disc > 0){
		hanoi (disc - 1, src, dst, aux);
		document.writeln('Move disc ' + disc + ' from ' + src + ' to ' + dst);
		hanoi (disc - 1, aux, src, dst);
	}
};

hanoi(3, "Source", "Auxiliary", "Destination");

// Recursion is very useful for solving tree problems
// DOM stands for Document Object Model

// Tail recursion optimization
// Factorial in JS using recu5rsion

var factorial = function (n){
	if ( n===1 || n===0){
		return 1;
	}
	return n * factorial (n-1);
};

document.writeln(factorial(4));

// Scope in a programming language controls the visibility and lifetime of variables and parameters. 
// This is important because it prevents naming collisions and automatic memory management. 

var foo = function(){
	var a = 3, b = 5;

	var bar = function(){
		var b = 7, c = 11;

		// At this point the value of a is 3, b is 7 and c is 11
		a += b + c;

		// At this point the value of a is 21, b is 7 and c is 11
	};

	// At this point the value of a is 3, b is 5 and c is undefined

	bar();

	// At this point the value of a is 21, b is 5 and c is undefined
};

// Most languages with C syntax have block scope. 
// JS does not have block scope, even though its block syntax suggests that it does.
// JS does have function scope
// It is best in JS to declare all variables and parameters used in a function at the top of the function body.

// CLOSURE
// Inner functions get access to the parameters and variables of the function they are defined within
// A more interesting case is when the inner function has a longer lifetime that its outer function.
// Suppose we would like to protect the value from unauthorized changes, the value variable
var myObject = {
	value: 0,
	increment: function(inc){
		this.value += typeof inc === 'number' ? inc : 1;
	}
};

myObject.increment(5);
document.writeln(myObject.value);

// If we want to prevent the unauthorized modification of the value, then we can provide methods to prevent this. 
var myObject = function(){
	var value = 0;
	return{
		increment: function(inc){
			value += typeof inc === 'number' ? inc : 1;
		},
		getValue: function () {
			return value;
		}
	};
}();

// In this case we are not assigning a function to myObject
// We are assigning the result of invoking the function to myObject
var myObject = function(){
	var value = 0;

	return{
		increment: function(inc){
			value += typeof inc === 'number' ? inc : 1;
		},
		getValue: function(){
			return value;
		}
	};
};

// myObject is assigned the resulting of invoking the function.
// Why define a getter method for a property that can be accessed directly. 
// We should define a getter method for a property that cannot be accessed directly (like a private variable)

// object with a get_status method and a private status property
var quo = function(status){
	return{
		get_status: function(){
			return status;
		}
	};
};

// make an instance of quo
var myquo = new quo("Amazed");
document.writeln(myquo.get_status());

// defining variables with private scope
var cons = function(msg){
	return{
		get_msg: function(){
			return msg;
		}
	};
};

// create an instance of cons
var mycons = cons("Hello World");

// print out the msg
document.writeln("Message is " + mycons.get_msg());

// A function has access to the context in which it is created. 
// This is called as closure. 

// Callbacks
// Suppose there is a sequence that begins with a user interaction, making a request of the server, and finally displaying the server's response. 
// If either the network or the server is slow, the degradation in responsiveness will be unacceptable.
// An asynchronous function returns immediately, so the client isn't blocked.

// The function parameter to the send_request_asynchronously function will be called when the response is available

// The function(response) will be called only when the response from the server is available
// We use functions and closure to make modules. 
// module presents an interface but hides its state and implementation 
// Use of the module pattern eliminates the use of the global variables
// It promotes information hiding and encapsulation

// A method to produce an object that produces unique strings.
// A unique string is made up of two parts: a prefix and a sequence number
// The object comes with methods for setting up the prefix and sequence number and a method for genrating a unique sequence number

var serial_maker = function(){
	var prefix = '';
	var sequence = 0;

	return{
		set_prefix: function(p){
			prefix = String(p);
		},
		set_sequence: function(s){
			sequence = s;
		},
		gensym: function(){
			var result = prefix + sequence; 
			sequence += 1;
			return result;
		}
	};
};

var seqer = serial_maker();
seqer.set_prefix('Q');
seqer.set_sequence(1000);
var unique = seqer.gensym();
document.writeln("Unique is : " + unique);

// We cannot change the values of the prefix and sequence without the permission of the methods, without making use of the seqer object

// CASCADE
// Some methods that set or change the state of an object to return nothing. 
// If we can have those methods return this instead of undefined, we can enable cascades, in cascades we can call many methods on the same object in a sequence in a single statement. 

// CURRY
// Functions are values and we can manipulate function values in interesting ways.
// Currying allows us to produce a new function by combining a function and an argument. 

var add1 = add.curry(1);
document.writeln(add1(6));

// MEMOIZATION
