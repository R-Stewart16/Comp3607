package refactor.code;

public class FileFixer {

    public static void main(String[] args) {
        System.out.println("Please add files to the folder called 'FilesToRename' ");

        Observer newObserver = new ExecuteMediator();
        FolderDirectory folder = new FileToRename();
        folder.attach(newObserver);
        folder.monitorDirectory();

        System.out.println("All functions ran");

    }

}