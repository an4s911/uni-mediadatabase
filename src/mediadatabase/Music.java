import java.util.Scanner;

class Music extends Media {
    private String artist;
    private int numberOfSongs;

    public Music(String title, String location, int year, String category, String artist, int numberOfSongs) {
        super("Music", title, location, year, category);
        this.artist = artist;
        this.numberOfSongs = numberOfSongs;
    }

    @Override
    public void playMedia() {
        Scanner scIn = new Scanner(System.in);
        int choice;
        if (numberOfSongs > 1) {
            System.out.println("Which track do you want to play (Track 1 - " + numberOfSongs + ")?");
            choice = scIn.nextInt();
        } else {
            System.out.println("Do you want to play Track 1 (y/n)?");
            char playChoice = scIn.next().toLowerCase().charAt(0);
            if (playChoice == 'y') {
                choice = 1;
            } else {
                // else don't play Track
                scIn.close();
                return;
            }
        }

        scIn.close();
        System.out.println("Now playing: Track " + choice + " of " + getTitle());
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getNumberOfSongs() {
        return numberOfSongs;
    }

    public void setNumberOfSongs(int numberOfSongs) {
        this.numberOfSongs = numberOfSongs;
    }

    public String toString() {
        return "Music{" + super.toString() + ", artist = " + artist + ", numberOfSongs = " + numberOfSongs + "}";
    }

}