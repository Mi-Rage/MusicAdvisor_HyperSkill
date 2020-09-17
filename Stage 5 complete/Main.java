package advisor;

/**
 * The main class run.
 * Here we define the necessary variables based on the startup arguments.
 */
public class Main {
    static String SERVER_PATH; // path to the server to connect
    static String RESOURCE;    // path to the api
    static int PAGE;           // number of objects on the output page

    public static void main(String[] args) {

        if (args.length > 0) {
            if (args[0].equals("-access")) {
                SERVER_PATH = args[1];
            }
            if (args[2].equals("-resource")) {
                RESOURCE = args[3];
            }
            if (args[4].equals("-page")) {
                PAGE = Integer.parseInt(args[5]);
            }
        } else {
            SERVER_PATH = "https://accounts.spotify.com";
            RESOURCE = "https://api.spotify.com";
            PAGE = 5;
        }

        Advisor advisor = new Advisor();
        advisor.start();
    }
}
