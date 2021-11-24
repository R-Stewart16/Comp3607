package refactor.code;

import java.nio.file.Path;

public interface Observer {

    public void update(String filename, Path path);

}