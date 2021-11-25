package refactor.code;

//import java.nio.file.Path;

public interface FolderDirectory {
    
    /***
     *  Notifies the attached observers
     */
    public void notifyObserver();

    /**
     * adds observer
     * @param o the observer object
     */
    public void attach(Observer o);


    /***
     * removes observer
     * @param o the observer object
     */
    public void detach(Observer o);


    /***
     * monitors the directory for any created files
     */
    public void monitorDirectory();

}