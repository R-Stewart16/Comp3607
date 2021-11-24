package refactor.code;

//import java.nio.file.Path;

public interface FolderDirectory {

    public void notifyObserver();

    public void attach(Observer o);

    public void detach(Observer o);

    public void monitorDirectory();
    // p ublic Path getPath();

}