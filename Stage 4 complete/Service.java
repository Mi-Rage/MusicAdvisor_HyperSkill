package advisor;

/**
 * The engine of the advisor. Here are all the methods of work.
 */
public class Service {
    boolean isAuthorised = false;
    GetContent getContent = new GetContent();


    /**
     * Getting authorization and setting the authorization flag
     */
    public void setAuthorization() {
        Authorisation authorisation = new Authorisation();
        authorisation.getAccessCode();
        authorisation.getAccessToken();
        this.isAuthorised = true;
    }

    /**
     * Getting releases from site
     * @return - String, formatted output data
     */
    public String getReleases() {
        if (isAuthorised) {
            return getContent.getNews();
        } else {
            return "Please, provide access for application.";
        }
    }

    /**
     * Getting featured from site
     * @return - String, formatted output data
     */
    public String getFeatured() {
        if (isAuthorised) {
            return getContent.getFeatured();
        } else {
            return "Please, provide access for application.";
        }
    }

    /**
     * Getting categories from site
     * @return - String, formatted output data
     */
    public String getCategories() {
        if (isAuthorised) {
            return getContent.getCategories();
        } else {
            return "Please, provide access for application.";
        }
    }

    /**
     * Getting playlist for category NAME
     * @param _C_NAME - String, name of category, not id!
     * @return - String, formatted output data
     */
    public String getPlaylists(String _C_NAME) {
        if (isAuthorised) {
            return getContent.getPlaylist(_C_NAME);
        } else {
            return "Please, provide access for application.";
        }
    }
}
