package refactor.app;


import java.nio.file.Path;
import java.util.*;

public interface FolderDirectory {

    public void notifyObserver();
    public void attach(Observer o);
    public void detach(Observer o);
    public void monitorDirectory();
    public Path getPath();

}