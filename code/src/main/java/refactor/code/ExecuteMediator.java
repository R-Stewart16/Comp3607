package refactor.code;

import java.util.*;

public class ExecuteMediator implements Observer { // aka instigator

    public ExecuteMediator() {// instigator
    }

    public void update(String filename) {
        System.out.println("Concrete observer has recieved the file named: " + filename);
    }

}