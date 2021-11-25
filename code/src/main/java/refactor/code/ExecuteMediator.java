package refactor.code;

import java.nio.file.Path;

public class ExecuteMediator implements Observer {

    FileFixingDialog fixer;

    /**
     * 
     */
    public ExecuteMediator() {
        fixer = new FileFixingDialog();
    }

    /**
     * 
     */
    public void update(String filename, Path path) {
        fixer.updateMediator(filename, path);
    }

}