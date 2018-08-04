package RestApi;

import com.google.gson.Gson;
import spark.Response;

/** This class defines a standard for responses sent to users.
 * For now, a response contains a message if an error occured, some data otherwise.
 * It also provides a method to set responses HTTP headers.
 */
class StandardResponse {

    private String message;
    private String data;


    /** Create a standard response when an error occured: a message is given to the user,
     * and the http status code is changed depending on the error: malformed request etc.
     * @param message: the message to send to the user
     * @param response: the response that will be send to the user
     * @param statusCode: the HTTP status code
     */
    StandardResponse(String message, Response response, int statusCode) {
        // set the HTTP status code
        response.status(statusCode);
        this.message = message;

    }

    /** Create a standard response when everything worked.
     * The data to send is send as a JSON object
     *
     * @param data: the data to send to the user
     */
    StandardResponse(Object data) {
       final Gson gson = new Gson();
       this.data = gson.toJson(data);
    }

    /** Convert the response to JSON */
    String toJson() {
        return new Gson().toJson(this);
    }

}
