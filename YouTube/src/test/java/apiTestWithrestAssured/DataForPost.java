package apiTestWithrestAssured;

import org.testng.annotations.DataProvider;

public class DataForPost {


    @DataProvider(name="DataForPost")
    public Object[][] dataForPost() {
//        Object[][] data = new Object[2][3];
//        data[0][0] = "ally";
//        data[0][1] = "button";
//        data[0][2] = 1;
//
//        data[1][0] = "belly";
//        data[1][1] = "sutton";
//        data[1][2] = 2;
//
//        return data;

        return new Object[][]{
                {"Graham", "Bell", 1},
                {"Henry", "Ford", 2}
        };
    }

    @DataProvider(name="DeleteData")
    public Object[] dataForDelete() {
        return new Object[] {
                10,11
        };
    }
}
