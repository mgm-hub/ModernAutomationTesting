package MainController.CommandAPI;


import java.util.Arrays;
import java.util.List;

/*
ApiList.apiListHasMethod(myApiMethodName);
*/

public class ApiList {

    private static String[] API_ARRAY = {
            "clickElement",
            "elementIsVisible"
    };

    private final static List<String> API_LIST = Arrays.asList(API_ARRAY);

    public static boolean apiListHasMethod(String myApiMethodName) {
        return API_LIST.contains(myApiMethodName);
    }

}
