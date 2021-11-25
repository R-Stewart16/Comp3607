package refactor.code;

import java.nio.file.Path;

public class ExecuteMediator implements Observer {

    FileFixingDialog fileFixingDialog;

    /**
     * This constructor creates a concrete mediator
     */
    public ExecuteMediator() {
        fileFixingDialog = new FileFixingDialog();
    }

    /***
     * Updates the concrete mediator of the changes in the FilesToRename folder
     */
    public void update(String fileName, Path path) {
        fileFixingDialog.updateMediator(fileName, path);
    }

}