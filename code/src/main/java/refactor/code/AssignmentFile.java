

package refactor.code;

public class AssignmentFile extends FileFixingDialog {

    private String fileName;
    private String[] fileNameDelimited;

    public AssignmentFile(String fileName) {

        this.fileName = fileName;
        splitFileName();
    }

    
    public void splitFileName() {
        this.fileNameDelimited = fileName.split("[_ -.,\\s+]");
        // https://stackoverflow.com/questions/7899525/how-to-split-a-string-by-space
    }

    public String getFileName() {
        return fileName;
    }

    public String[] getDelimited() {
        return fileNameDelimited;
    }

    public String toString() {
        String detail = "";
        detail += "AssignmentFile has Recieved :" + fileName;
        return detail;
    }
}