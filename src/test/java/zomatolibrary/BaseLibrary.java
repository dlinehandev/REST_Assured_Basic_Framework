package zomatolibrary;

import core.*;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseLibrary {

    private RestSession session;
    private static HashMap<String,Map> zomatoData;

    @BeforeTest
    public void initTest() throws Exception {
        Environments.load();
//        zomatoData =  Data.getData();
    }



    public HashMap<String, Map> getZomatoData(){
        return zomatoData;
    }

    public Response getLocations(String locationName) throws Exception {
        session = new RestSession();
        Map<String,String> param = new HashMap<>();
        param.put("query",locationName);
        Response resp = session.sendRequest(APIMethods.GET_LOCATIONS,Config.zomatoUserKey,param);
        return resp;
    }




    public int getURLResponse(String URL) throws Exception {
        URL url = new URL(URL);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int code = conn.getResponseCode();
        return code;
    }



}
