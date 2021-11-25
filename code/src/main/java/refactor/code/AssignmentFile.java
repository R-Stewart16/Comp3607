

package refactor.code;

public class AssignmentFile extends FileFixingDialog {

    private String fileName;
    private String[] fileNameDelimited;

    /**
     * Initializes the assignment file with the filename
     * @param fileName the file name of the submitted assignment file
     */
    public AssignmentFile(String fileName) {

        this.fileName = fileName;
        splitFileName();
    }

     
    /***
     * Method breaks the file name into smaller substrings by splitting on the delimiters: _ , - . and whitespaces
     */
    public void splitFileName() {
        this.fileNameDelimited = fileName.split("[_ -.,\\s+]");
        // https://stackoverflow.com/questions/7899525/how-to-split-a-string-by-space
    }

    /**
     * returns the file name
     * @return
     */
    public String getFileName() {
        return fileName;
    }


    /**
     * Returns the delimited version of the file name.
     * @return the delimited version of the file name
     */
    public String[] getDelimited() {
        return fileNameDelimited;
    }


    /***
     * Outputs details about the assignment file
     */
    public String toString() {
        String detail = "";
        detail += "AssignmentFile has Recieved :" + fileName;
        return detail;
    }
}