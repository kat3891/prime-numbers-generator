# Prime Number Generator

WARNING: Only HTTPS communication works to communicate with the REST API.

A prime number generator written in Java that gives all prime numbers in the range between two numbers provided by the user.
It offers different prime number generation strategies, depending on the algorithm and the Java methods that have been chosen (for loops, Java Streams, threads, etc.).
All the algorithm have been tested.

## Prime Number Calculator

Two algorithms can be used to find prime numbers: the brute force algorithm and the sieve of Erathostenes. 
Each of these algorithms can be used with for loops or streams, and with one or many threads.

## Command Line Interface

A command line interface can be used to find all prime numbers in a range. Each time, the chosen algorithm must be specified.

## API Rest

An API can also be used. It has been developped with [Spark](http://sparkjava.com) and [OrmLite](http://ormlite.com/).
Responses are given a JSON format, but the home page is a HTML page, so that instructions can also be found by contacting the API.

### How to request the API ?
To get prime numbers in a range, two numbers must be given by the user and an integer corresponding to the algorithm to use. 
1) Brute force algorithm with for loops
2) Brute force algorithm with Java Streams
3) Brute force algorithm with Java Streams and multiple threads
4) Sieve of Erathostenes with for loops
5) Sieve of Erathostenes with Java Streams
6) Sieve of Erathostenes with Java Streams and multiple threads

If something is missing, default values are used. (min=0, max=100, algo=4).

Contact /primes?min=5&max=20&algo=2

### Audit
Each request is recorded in a SQLite database.
- the timestamp
- the range
- the number of prime numbers in this range
- the algorithm that has been used
- the elapsed time

### How to launch the server ?

Launch the Main.main() function in the RestApi folder. Server properties (ip address, etc.) are defined in the config.properties file


### Security measures
A maximum number for the range has been defined to prevent DoS attacks.

Some HTTP headers have been defined.

Communication with the API only works using HTTPS. (TODO: automatically redirect HTTP communication to HTTPS).

