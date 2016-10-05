package service;

/**
 * Created by Mars on 02.10.2016.
 */
public class Utils {

    public static long pagination(long listSize, int resultsOnPage) {
        long pages = 0;
        if (listSize / resultsOnPage > 0) {
            pages = listSize / resultsOnPage;
            if (listSize % resultsOnPage != 0) pages++;
        }
        return pages;
    }

    public static String searchQuery(String query) {
        return query.replaceAll("(\\+)+", " ").toLowerCase();
    }

    public static int firstResultToPage(int resultsOnPage, int page) {
        return resultsOnPage * (page - 1);
    }
}
