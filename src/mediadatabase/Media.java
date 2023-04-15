abstract class Media {
    private String type; // Could be "movie" or "music"
    private String title; // name of the media
    private String location; // filename or URL of the media
    private int year; // year it was released
    private String category; // genre

    public Media(String type, String title, String location, int year, String category) {
        this.type = type;
        this.title = title;
        this.location = location;
        this.year = year;
        this.category = category;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public abstract void playMedia();

    public String toString() {
        return "Media{type = " + type + ", title = " + title + ", location = " + location + ", year = " + year
                + ", category = " + category + "}";
    }
}