package advisor;

import java.util.Scanner;

/**
 * Advisor class. Here is the interface for communicating with the user.
 */
public class Advisor {

    public void start() {

        Service service = new Service();
        PrintPage printPage = new PrintPage(Main.PAGE);
        Scanner scanner = new Scanner(System.in);
        String[] query = scanner.nextLine().split(" ");
        while (!query[0].equals("exit")) {
            switch (query[0]) {
                case ("auth"):
                    service.setAuthorization();
                    break;
                case ("new"):
                    printPage.print(service.getReleases());
                    break;
                case ("featured"):
                    printPage.print(service.getFeatured());
                    break;
                case ("categories"):
                    printPage.print(service.getCategories());
                    break;
                case ("playlists"):
                    StringBuilder category = new StringBuilder();
                    for(int i = 1; i < query.length; i++){
                        category.append(query[i]).append(" ");
                    }
                    printPage.print(service.getPlaylists(category.toString().trim()));
                    break;
                case ("next"):
                    printPage.printNext();
                    break;
                case ("prev"):
                    printPage.printPrev();
                    break;
            }
            query = scanner.nextLine().split(" ");
        }
    }
}
