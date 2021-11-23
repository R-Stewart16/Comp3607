package refactor.code;

import java.nio.file.Path;
import java.util.*;

public interface Mediator {
    
    public void updateMediator(String filename, Path path);
    public void notify(Object sender, Object event);

}