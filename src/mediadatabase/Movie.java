class Movie extends Media {
    private String director;
    private int playingTime;

    public Movie(String title, String location, int year, String category, String director, int playingTime) {
        super("Movie", title, location, year, category);
        this.director = director;
        this.playingTime = playingTime;
    }

}