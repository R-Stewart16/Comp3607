package refactor.code;

import java.nio.file.Path;
import java.util.*;

public interface Observer {

    public void update(String filename, Path path);

}