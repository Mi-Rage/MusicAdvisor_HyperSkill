package advisor;

public class Main {
    public static void main(String[] args) {

        if (args.length > 1 && args[0].equals("-access")) {
            Authorisation.SERVER_PATH = args[1];
        }

        Advisor advisor = new Advisor();
        advisor.start();
    }
}
