import java.util.ArrayList;

class MyMediaDatabase implements MediaDatabase {

    private ArrayList<Media> mediaList;

    public MyMediaDatabase() {
        mediaList = new ArrayList<>();
    }

    @Override
    public Media lookupByTitle(String title) {
        for (int i = 0; i < mediaList.size(); i++) {
            Media currMedia = mediaList.get(i);
            if (currMedia.getTitle().equals(title)) {
                return currMedia;
            }
        }

        return null;
    }

    @Override
    public void addEntry(Media newMedia) {
        boolean exists = false;
        for (int i = 0; i < mediaList.size(); i++) {
            Media currMedia = mediaList.get(i);
            if (currMedia.getTitle().equals(newMedia.getTitle())) {
                exists = true;
            }
        }

        if (!exists) {
            mediaList.add(newMedia);
            System.out.println("Media added successfully");
        } else {
            System.out.println("Media with that title " + newMedia.getTitle() + " already exists!");
        }
    }

    @Override
    public void listAllMedia() {
        for (int i = 0; i < mediaList.size(); i++) {
            Media currMedia = mediaList.get(i);
            System.out.println(currMedia.getType() + ": " + currMedia.getTitle());
        }
    }

    @Override
    public void listMediaByType(String type) {
        for (int i = 0; i < mediaList.size(); i++) {
            Media currMedia = mediaList.get(i);
            if (currMedia.getType().equals(type)) {
                System.out.println(currMedia);
            }
        }
    }

}