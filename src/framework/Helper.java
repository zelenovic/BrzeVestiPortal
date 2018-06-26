package framework;

public class Helper {

    public static int getRandomInteger() {
        return (int) (Math.random() * 1000);
    }
    
    public static int getRandomInteger(int range) {
        return (int) (Math.random() * range);
    }
    
    public static String getRandomText() {
        return "milomir-" + getRandomInteger();
    }

    public static String getRandomUrl() {
        return "http://".concat(getRandomText()).concat(".rs");
    }
}