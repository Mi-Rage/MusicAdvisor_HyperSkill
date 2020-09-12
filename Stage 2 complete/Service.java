package advisor;

public class Service {
    boolean authorization = false;
    String releases = "Mountains [Sia, Diplo, Labrinth]\n" +
            "Runaway [Lil Peep]\n" +
            "The Greatest Show [Panic! At The Disco]\n" +
            "All Out Life [Slipknot]";
    String featured = "Mellow Morning\n" +
            "Wake Up and Smell the Coffee\n" +
            "Monday Motivation\n" +
            "Songs to Sing in the Shower";
    String categories = "Top Lists\n" +
            "Pop\n" +
            "Mood\n" +
            "Latin";
    String playlists = "Walk Like A Badass  \n" +
            "Rage Beats  \n" +
            "Arab Mood Booster  \n" +
            "Sunday Stroll";

    public String setAuthorization(boolean authorization) {
        this.authorization = authorization;
        return "---SUCCESS---";
    }

    public String getReleases() {
        if (authorization) {
            return "---NEW RELEASES---\n" + releases;
        } else {
            return "Please, provide access for application.";
        }
    }

    public String getFeatured() {
        if (authorization) {
            return "---FEATURED---\n" + featured;
        } else {
            return "Please, provide access for application.";
        }
    }

    public String getCategories() {
        if (authorization) {
            return "---CATEGORIES---\n" + categories;
        } else {
            return "Please, provide access for application.";
        }
    }

    public String getPlaylists() {
        if (authorization) {
            return "---MOOD PLAYLISTS---\n" + playlists;
        } else {
            return "Please, provide access for application.";
        }
    }
}
