package refactor.app;

import java.util.*;

public interface FolderDirectory {

    public void notifyObserver();
    public void attach();
    public void detach();
    public void monitorDirectory();
    public void getPath();

}