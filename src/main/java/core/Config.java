package core;

import java.util.HashMap;

public class Config {
    public static String ENV = "DEV";//  = System.getenv("testEnv");
    public static HashMap zomatoUserKey = new HashMap() {{put("api_key", "fe5649edfa04612b6fb32906b88d2bf6");}};
}
