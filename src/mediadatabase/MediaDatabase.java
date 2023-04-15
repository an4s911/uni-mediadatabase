/** The interface for the media database.
 */

public interface MediaDatabase {


  /** Look up an entry by title.
      @param title The title to look up
      @return The Media object if found, null otherwise
   */
  public Media lookupByTitle(String title);


  /** Add an entry.
      @param newMedia The Media object to be added
      @return none
   */
  public void addEntry(Media newMedia);

  
  /** Print out a numbered list of media contained in the database. 
      For each media object, display its type and title only.
      @param None.
      @return None.
   */
  public void listAllMedia();
  
  
  /** Print out a numbered list of media of the given type 
      (“music”, “movie”, “audiobook”, “ebook”). 
      For each media object, display its title only. 
      Display an error message if the given type is not a valid type.
      @param None.
      @return None.
   */
  public void listMediaByType(String type); 

}
