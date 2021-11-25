package refactor.code;

import java.nio.file.Path;

public interface Mediator {

    /***
     * Triggers the update method for the mediator
     * @param filename original file that was submitted
     * @param path the path to the file that was submitted
     */
    public void updateMediator(String fileName, Path path);

}