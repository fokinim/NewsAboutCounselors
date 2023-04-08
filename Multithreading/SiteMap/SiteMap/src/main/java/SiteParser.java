import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.net.URL;
import java.util.*;
import java.util.concurrent.RecursiveTask;

public class SiteParser extends RecursiveTask<String> {

    private String correctUrl;
    public static Set<Link> linksList = new HashSet<>();
    public static final String REGEX = "/";

    private String url;
    private String siteUrl;

    public SiteParser(String url, String siteUrl) {
        this.url = url;
        this.siteUrl = siteUrl;

    }

    @Override
    protected String compute() {

        List<SiteParser> taskList = new ArrayList<>();

        if (Main.visitedUrls.contains(url)) {
            return null;
        }

        Main.visitedUrls.add(url);

        try {
            Thread.sleep(100);
            Document doc = Jsoup.parse(new URL(url), 0);

            Elements links = doc.select("a[href]");

            for (Element link : links) {
                String childUrl = link.absUrl("href");

                boolean checkUrl = childUrl.length() > siteUrl.length()
                        && !Main.visitedUrls.contains(childUrl)
                        && childUrl.substring(0, siteUrl.length()).contains(siteUrl)
                        && !String.valueOf(childUrl.charAt(childUrl.length() - 4)).contains(".");

                if (checkUrl) {
                    correctUrl = childUrl;
                    SiteParser task = new SiteParser(childUrl, siteUrl);
                    task.fork();
                    taskList.add(task);

                }
            }

            for (SiteParser task : taskList) {
                String link = task.join();
                if(link != null) {

                    if (Objects.equals(String.valueOf(link.charAt(link.length() - 1)), "#")){
                        link = link.substring(0, link.length() - 2);
                    }
                    String[] splitLink = link.split(REGEX);
                    int depth = splitLink.length;

                    Link linkObject = new Link(depth, link, splitLink[depth-2], splitLink[depth-1]);

                    linksList.add(linkObject);
                }
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return correctUrl;
    }
}
