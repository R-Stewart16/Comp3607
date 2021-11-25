package refactor.code;

import java.nio.file.Path;

public interface Observer {

    /**
     * Triggers the update method in the mediator
     * @param filename the name of the file to rename 
     * @param path the path of the file to rename
     */
    public void update(String filename, Path path);

}