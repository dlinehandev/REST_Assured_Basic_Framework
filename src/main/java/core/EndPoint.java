package core;

public interface EndPoint {
    String getRestMethodPath();
    String getHostUrl();
    HTTPMethod getRestHttpMethodType();
    ParametersType getRestParametersType();

}