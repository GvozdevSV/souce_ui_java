package constants;

import io.github.cdimascio.dotenv.Dotenv;



public class Constant {
    public static class TimeoutVariable {
        public static final int IMPLICIT_WAIT = 4;
        public static final int EXPLICIT_WAIT = 10;
    }
    public static class Urls {
        public static final String BASE_URL = "https://www.saucedemo.com/";
    }
    public static class StandardUser {
        static Dotenv dotenv = Dotenv.load();
        public static final String STANDARD_PASSWORD = dotenv.get("PASSWORD");
    }
}
