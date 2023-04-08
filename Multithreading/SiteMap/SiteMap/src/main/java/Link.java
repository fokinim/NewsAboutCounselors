import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Link {
    int depth;
    String text;
    String mother;
    String page;

    public Link(int depth, String text, String mother, String page) {
        this.depth = depth;
        this.text = text;
        this.mother = mother;
        this.page = page;
    }


}
