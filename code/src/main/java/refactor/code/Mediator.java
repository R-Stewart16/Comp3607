package refactor.code;

import java.util.*;

public interface Mediator {
    
    public void updateMediator(String filename);
    public void notify(Object sender, Object event);

}