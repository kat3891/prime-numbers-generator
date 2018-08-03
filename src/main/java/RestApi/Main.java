package RestApi;

import Calculator.PrimeNumberCalculator;
import spark.Request;
import spark.Response;
import static spark.Spark.*;

import java.util.List;



/** This class defines the REST API and is used to launch the server. */
public class Main {

    // application parameters
    final private static ApplicationProperties APP_PROPERTIES = new ApplicationProperties();
    final private static Audit AUDIT = new Audit(APP_PROPERTIES.DATABASE_URL);

    /** This function build the HTTP response header. It contains some security measures, but needs to be improved. */
    private static void buildResponseHttpHeaders(Response response) {
        response.header("Server", APP_PROPERTIES.SERVER_NAME);
        response.header("Strict-Transport-Security", "max-age=31536000; includeSubDomains; preload");
        response.header("X-Content-Type-Options", "nosniff");
        response.header("X-Frame-Options", "SAMEORIGIN");
        response.header("X-XSS-Protection", "1; mode=block");
        response.header("Content-Security-Policy", APP_PROPERTIES.CSP_HEADERS);
        response.header("Upgrade-Insecure-Requests", "1");
    }

    public static void main(String[] args) {
        // set ip and port used by the server
        ipAddress(APP_PROPERTIES.IP_ADDRESS);
        port(APP_PROPERTIES.PORT);

        // enable ssl / https
        secure(APP_PROPERTIES.KEYSTORE_FILENAME, APP_PROPERTIES.KEYSTORE_PASSWORD, null, null);

        // list of the differents routes
        get("/", Main::giveAppliDescription);
        get("/primes", Main::getPrimes);

    }


    /** Get the prime numbers depending on the range given by the user.
     * These information must be given in the query : the min and the max.
     * If no information has been given, the default range is 0 - 100.
     *
     * The sieve of Erathostenes is used to get prime numbers list.
     */
    private static String getPrimes(final Request request, final Response response) {
        // start the timer
        long start = System.currentTimeMillis();

        // we define a maximum value to the range to prevent DoS attacks
        final int MAX_POSSIBLE = 1000000;

        final String MALFORMED_REQUEST_MESSAGE = String.format("Malformed request. To get numbers primes in a range, you need to give the minimum and the maximum  (maximum < %d). For instance '/primes?min=20&max=50' or '/primes?min=20&max=50&algo=1' ", MAX_POSSIBLE);

        final int NUMBER_OF_GIVEN_PARAMETERS = request.queryParams().size(); // numbers of parameters given by the user


        // define the response headers
        response.type("application/json");
        buildResponseHttpHeaders(response);


        // check that the request is well formed (two values 'min' and 'max' given by the user)
        if (NUMBER_OF_GIVEN_PARAMETERS > 3) {
            // malformed request
            return new StandardResponse(MALFORMED_REQUEST_MESSAGE, response, 400).toJson();
        }

        // by default, the min is 0, the max is 100, the algo chosen is "Sieve of Erathostenes with for loops"
        int min = 0;
        int max = 100;
        int algoChosen = 4;

        // if the user gave the required information, get them :
        if (request.queryParams().contains("min")) {
            min = Integer.parseInt(request.queryMap().get("min").value());
        }
        if (request.queryParams().contains("max")) {
            max = Integer.parseInt(request.queryMap().get("max").value());
            // check that min < max < MAX_POSSIBLE. Errors can happened when no min has been given or that the user made a mistake
            if (max > MAX_POSSIBLE || min > max) {
                return new StandardResponse(MALFORMED_REQUEST_MESSAGE, response, 400).toJson();
            }
        }
        if (request.queryParams().contains("algo")) {
            algoChosen = Integer.parseInt(request.queryMap().get("algo").value());
        }


        // get the list of prime numbers in the defined range
        List<Integer> res = PrimeNumberCalculator.getPrimeNumbers(algoChosen, min, max);
        long timeElapsed = System.currentTimeMillis() - start; // time elapsed in milliseconds

        // record the request and some of the answer in a database
        AUDIT.recordRequest(algoChosen, min, max, res, request.ip(), timeElapsed);

        // return a formated response
        return new StandardResponse(res).toJson();
    }


    /** Give to the user a description of the application and how to use it. */
    private static String giveAppliDescription(final Request request, final Response response) {
        response.type("text/html;charset=utf-8");
        buildResponseHttpHeaders(response);

        return "<h1>Prime number generator</h1>" +
                " <p>This tool helps you to get primes number in a range.</p> " +
                "<p>To do so, use the URL: '/primes?min=22&max=50' where the min and the max defines the range," +
                " optionnaly the algorithm chosen: '/primes?min=22&max=50&algo=1' where algo can be:</p>" +
                "<ul>" +
                "<li>Brute force algorithm using for loops</li>" +
                "<li>Brute force algorithm using IntStreams</li>" +
                "<li>Brute force algorithm using IntStreams and multiple threads</li>" +
                "<li>Sieve of Erathostenes using for loops</li>" +
                "<li>Sieve of Erathostenes using IntStreams</li>" +
                "<li>Sieve of Erathostenes using IntStreams and multiple threads</li>" +
                "</ul>" +
                "If no range is given,  the prime numbers that you will be given will be between 0 and 100. If no algorithm is given, the sieve of erathostenes will be used.</p>";
    }




}