import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.net.URL;
import java.util.concurrent.RecursiveTask;

public class SiteParser extends RecursiveTask<String> {

    private String url;

    public SiteParser(String url) {
        this.url = url;
    }

    @Override
    protected String compute() {

        if (Main.visitedUrls.contains(url)) {
            return null;
        }

        Main.visitedUrls.add(url);

        try {
            Thread.sleep(150);
            Document doc = Jsoup.parse(new URL(url), 0);

            Elements links = doc.select("a[href]");

            for (Element link : links) {
                String childUrl = link.absUrl("href");
                if (!Main.visitedUrls.contains(childUrl)) {
                    System.out.println(childUrl);
                    SiteParser task = new SiteParser(childUrl);
                    task.fork();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
