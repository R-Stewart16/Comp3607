package refactor.code;

import java.nio.file.Path;

public class ExecuteMediator implements Observer {

    FileFixingDialog fileFixingDialog;

    /**
     * 
     */
    public ExecuteMediator() {
        fileFixingDialog = new FileFixingDialog();
    }

    /***
     * 
     */
    public void update(String fileName, Path path) {
        fileFixingDialog.updateMediator(fileName, path);
    }

}