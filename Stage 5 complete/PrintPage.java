package advisor;

/**
 * Information output update class
 */
public class PrintPage {
    String[] output;  // array of update date
    int objectOnPage; // number of objects per page
    int totalPages;   // total number of pages
    int currentPage;  // current print page
    int startObject;  // initial array object on the current page
    int endObject;    // end object of the array on the current page

    /**
     * Object constructor that defines the number of objects on the page
     * @param _onPage - int, param from argument Main class
     */
    public PrintPage(int _onPage){
        objectOnPage = _onPage;
    }

    /**
     * Method for printing the first page of data
     * @param _data - String, source data for conversion and printing
     */
    public void print(String _data) {
        currentPage = 0;
        startObject = 0;
        endObject = 0;
        output = _data.split("\n\n");
        if (output.length % objectOnPage > 0) {
            totalPages = output.length / objectOnPage + 1;
        } else {
            totalPages = output.length / objectOnPage;
        }
        currentPage = 1;
        for (int i = 0; i < objectOnPage; i++) {
            System.out.println(output[i]);
        }
        System.out.printf("---PAGE %d OF %d---\n", currentPage, totalPages);
    }

    /**
     * Method for printing the next page
     */
    public void printNext(){
        if (currentPage + 1 < totalPages) {
            startObject = objectOnPage * currentPage;
            endObject = startObject + objectOnPage;
        } else if (currentPage + 1 == totalPages) {
            startObject = objectOnPage * currentPage;
            if (output.length % objectOnPage > 0) {
                endObject = startObject + output.length % objectOnPage;
            } else {
                endObject = startObject + objectOnPage;
            }
        } else {
            System.out.println("No more pages");
            return;
        }
        for (int i = startObject ; i < endObject; i++) {
            System.out.println(output[i] + "\n");
        }
        currentPage++;
        System.out.printf("---PAGE %d OF %d---\n", currentPage, totalPages);
    }

    /**
     * Method for printing the previous page
     */
    public void printPrev() {
        currentPage--;
        if (currentPage > 0) {
            startObject = startObject - objectOnPage;
            endObject = startObject + objectOnPage;
            for (int i = startObject; i < endObject; i++) {
                System.out.println(output[i] + "\n");
            }
            System.out.printf("---PAGE %d OF %d---\n", currentPage, totalPages);
        } else {
            currentPage++;
            System.out.println("No more pages");
        }
    }
}
