package Services;

import DAOs.DataDAO;

public class AppService {
    private static DataDAO data;

    public static DataDAO getData() {
        return data;
    }

    public static void setData(DataDAO d) {
        data = d;
    }
}
