import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Main {


    private final static String SITE_URL = "https://skillbox.ru";
    private static List<String> mapLinks = new ArrayList<>();


    public static final HashSet<String> visitedUrls = new HashSet<>();
    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new SiteParser(SITE_URL, SITE_URL));


        for (Link link : SiteParser.linksList) {
            System.out.println(link.getText());
        }

    }
}
