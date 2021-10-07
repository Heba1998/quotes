package quotes;

public class Quotes {
    private String author;
    private String text;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "\nQuotes{" +
                "\nauthor:'" + author + '\'' +
                "\n text:'" + text + '\'' +'\n'+
                '}';
    }
}
