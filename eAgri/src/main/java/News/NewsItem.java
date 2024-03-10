package News;

public class NewsItem {
    private int id;
    private String title;
    private String content;
    private String author;
    private String datePublished;
    private String category;
    private String imageBase64; // Change the type to String for base64-encoded image
    private String sourceUrl;

    // Constructors
    public NewsItem() {
    }

    public NewsItem(int id, String title, String content, String author, String datePublished,
                    String category, String imageBase64, String sourceUrl) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.datePublished = datePublished;
        this.category = category;
        this.imageBase64 = imageBase64;
        this.sourceUrl = sourceUrl;
    }

    // Getters and setters (you can generate these using your IDE)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }
}
