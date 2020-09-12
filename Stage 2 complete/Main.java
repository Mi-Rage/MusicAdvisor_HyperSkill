package advisor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        Scanner scanner = new Scanner(System.in);
        String query = scanner.nextLine();
        while(!query.equals("exit")) {
            switch (query) {
                case("auth"):
                    System.out.println("https://accounts.spotify.com/authorize?client_id=67da7afe4b20443ca01445b1a0a75d6b&redirect_uri=http://localhost:8080&response_type=code");
                    System.out.println(service.setAuthorization(true));
                    break;
                case ("new"):
                    System.out.println(service.getReleases());
                    break;
                case ("featured"):
                    System.out.println(service.getFeatured());
                    break;
                case ("categories"):
                    System.out.println(service.getCategories());
                    break;
                case ("playlists Mood"):
                    System.out.println(service.getPlaylists());
                    break;
            }
            query = scanner.nextLine();
        }
        service.setAuthorization(false);
        System.out.println("---GOODBYE!---");
    }
}
