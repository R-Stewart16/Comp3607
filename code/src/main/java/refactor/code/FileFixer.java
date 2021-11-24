package refactor.code;

public class FileFixer {

    public static void main(String[] args) {
        System.out.println("Hello is this working");

        ExecuteMediator newObserver = new ExecuteMediator();
        FileToRename folder = new FileToRename();
        folder.attach(newObserver);
        //folder.initialCheck();
        folder.monitorDirectory();

        System.out.println("All functions ran");

    }

}