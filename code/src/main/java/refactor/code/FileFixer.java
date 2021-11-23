package refactor.code;

public class FileFixer {

    public static void main(String[] args) {
        System.out.println("Hello is this working");

        FileFixingDialog fixer = new FileFixingDialog();
        //System.out.println(fixer.getStudents().toString());

        ExecuteMediator newObserver = new ExecuteMediator();
        FileToRename folder = new FileToRename();
        folder.attach(newObserver);
        folder.monitorDirectory();

        System.out.println("All functions ran");

    }

}