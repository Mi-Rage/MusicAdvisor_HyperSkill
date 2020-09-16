package advisor;

public class Main {
    static String SERVER_PATH;
    static String RESOURCE;
    public static void main(String[] args) {

        if (args.length > 0) {
            if (args[0].equals("-access")) {
                SERVER_PATH = args[1];
            }
            if (args[2].equals("-resource")) {
                RESOURCE = args[3];
            }
        } else {
            SERVER_PATH = "https://accounts.spotify.com";
            RESOURCE = "https://api.spotify.com";
        }

        Advisor advisor = new Advisor();
        advisor.start();
    }
}
