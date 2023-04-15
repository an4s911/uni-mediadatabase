class Music extends Media {
    private String artist;
    private int numberOfSongs;

    public Music(String title, String location, int year, String category, String artist, int numberOfSongs) {
        super("Music", title, location, year, category);
        this.artist = artist;
        this.numberOfSongs = numberOfSongs;
    }

    public String toString() {
        return "Music{" + super.toString() + ", artist = " + artist + ", numberOfSongs = " + numberOfSongs + "}";
    }

}