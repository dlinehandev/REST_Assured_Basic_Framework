package core;

import java.util.HashMap;
import core.ParametersType;

public class APIMethod implements EndPoint {

    private String hostUrl;
    private String methodName;
    private HTTPMethod httpMethod;
    private HashMap<String, String> params = new HashMap<>();
    private ParametersType reqParamType = ParametersType.JSON;
    private String methodUrlWithParam;

    public APIMethod(String hostUrl, String methodName, HTTPMethod httpMethod, ParametersType paramtype) {
        if(methodName.contains("@@param")){
            this.methodUrlWithParam = methodName;
        }
        else {
            this.methodName = methodName;
        }
        this.httpMethod = httpMethod;
        this.reqParamType = paramtype;
        this.hostUrl = hostUrl;
    }

    public APIMethod(String hostUrl, String methodName, HTTPMethod httpMethod) {
        if(methodName.contains("@@param")){
            this.methodUrlWithParam = methodName;
        }
        else {
            this.methodName = methodName;
        }
        this.httpMethod = httpMethod;
        this.hostUrl = hostUrl;
    }

    public void addMethodParam(String param) {
        if(this.methodUrlWithParam.contains("@@param")){
            this.methodName = this.methodUrlWithParam;
            this.methodName = this.methodName.replaceFirst("@@param", param);
        }
    }

    public String getRestMethodPath() {
        return methodName;
    }

    public String getHostUrl() {
        return hostUrl;
    }

    public HTTPMethod getRestHttpMethodType() {
        return httpMethod;
    }

    public ParametersType getRestParametersType() {
        return reqParamType;
    }
}
