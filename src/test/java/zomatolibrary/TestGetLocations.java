package zomatolibrary;

import org.testng.annotations.Test;

public class TestGetLocations extends zomatolibrary.BaseLibrary {

    @Test
    public void TestGetLocations() throws Exception {
        getLocations("Dublin");
    }
}
