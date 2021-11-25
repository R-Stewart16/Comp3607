package refactor.code;

//import java.nio.file.Path;

public interface FolderDirectory {
    
    /***
     * 
     */
    public void notifyObserver();

    /**
     * 
     * @param o the observer object
     */
    public void attach(Observer o);


    /***
     * 
     * @param o the observer object
     */
    public void detach(Observer o);


    /***
     * monitors the directory for any created files
     */
    public void monitorDirectory();

}