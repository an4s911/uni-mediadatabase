class Movie extends Media {
    private String director;
    private int playingTime;

    public Movie(String title, String location, int year, String category, String director, int playingTime) {
        super("Movie", title, location, year, category);
        this.director = director;

        this.playingTime = playingTime;
    }

    @Override
    public void playMedia() {
        System.out.println("Now playing: " + getTitle());
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getPlayingTime() {
        return playingTime;
    }

    public void setPlayingTime(int playingTime) {
        this.playingTime = playingTime;
    }

    public String toString() {
        return "Movie{" + super.toString() + ", director=" + director + ", playingTime=" + playingTime + "}";
    }

}