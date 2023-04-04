import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;

public class Main {

    private static int maxDepth = 5;
    private static String url = "https://lenta.ru";

    public static final Set<String> visitedUrls = new HashSet<>();
    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new SiteParser(url));

    }
}
