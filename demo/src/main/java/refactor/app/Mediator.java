package refactor.app;


import java.util.*;

public interface Mediator {
 

    /**
     * @param sender 
     * @param event 
     * @return
     */
    public void notify(Object sender, Object event);

}