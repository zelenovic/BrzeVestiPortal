package framework;

public class Helper {

    public static int getRandomInteger() {
        return (int) (Math.random() * 1000);
    }
    
    public static String getRandomText() {
        return "milan-" + getRandomInteger();
    }

    public static String getRandomUrl() {
        return "http://".concat(getRandomText()).concat(".rs");
    }
}
