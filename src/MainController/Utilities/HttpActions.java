package MainController.Utilities;

import java.net.HttpURLConnection;
import java.net.URL;

/*
MainController.Utilities.HttpActions.getURL();
MainController.Utilities.HttpActions.getHttpURLConnection();
MainController.Utilities.HttpActions.getResponseCode();
MainController.Utilities.HttpActions.getResponseMessage();
MainController.Utilities.HttpActions.getResponseCodeStringFromURLString();
*/

public class HttpActions {

    public static URL getURL (String myPath) {
        try {
            return new URL(myPath);
        }
        catch (Exception e){
            return null;
        }
    }

    public static HttpURLConnection getHttpURLConnection (URL myURL) {
        try {
            return (HttpURLConnection)myURL.openConnection();
        }
        catch (Exception e){
            return null;
        }
    }

    public static int getResponseCode (HttpURLConnection myHttpURLConnection) {
        try {
            myHttpURLConnection.setRequestMethod ("GET");
            myHttpURLConnection.connect();
            return myHttpURLConnection.getResponseCode();
        }
        catch (Exception e){
            return 0;
        }
    }

    public static String getResponseMessage (HttpURLConnection myHttpURLConnection) {
        String myResponseMessage = null;
        try {
            myHttpURLConnection.setRequestMethod ("GET");
            myHttpURLConnection.connect();
        }
        catch (Exception e){
            //empty
        }
        try {
            myResponseMessage = myHttpURLConnection.getResponseMessage();
        }
        catch (Exception e) {
            //empty
        }
        return myResponseMessage;
    }

    public static String getResponseCodeStringFromURLString (String myURLString) {
        String myResponseCodeString = "";
        if (myURLString != null && myURLString.length() > 0) {
            URL myURL = getURL(myURLString);
            String dataMessage = "\nmyURL ::" + myURL;
            Log.log(dataMessage);

            HttpURLConnection myHttpURLConnection =getHttpURLConnection(myURL);
            if (myHttpURLConnection != null) {
                int myResponseCode = getResponseCode(myHttpURLConnection);
                myResponseCodeString = Integer.toString(myResponseCode);
            }
        }
        return myResponseCodeString;
    }

}
