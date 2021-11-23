package refactor.code;

import java.nio.file.Path;
import java.util.*;

public class ExecuteMediator implements Observer {      //aka instigator

    FileFixingDialog fixer;
    public ExecuteMediator() {
        fixer = new FileFixingDialog();
    }

    public void update(String filename, Path path) {
        System.out.println("Concrete observer has recieved the file named: "+ filename);
        fixer.updateMediator(filename, path);

    }

}