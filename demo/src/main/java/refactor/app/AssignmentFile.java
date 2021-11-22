package refactor.app;

import java.util.*;

public class AssignmentFile extends FileFixingDialog{
    
    private String fileName = new String();
    private String[] fileNameDelimited;
    private String renamedFileName = new String();

    public AssignmentFile(String fileName) {
        this.fileName = fileName;
    }

    public void splitFileName() {
        this.fileNameDelimited = fileName.split("[_ -.,\\s+]");       //https://stackoverflow.com/questions/7899525/how-to-split-a-string-by-space
    }

    public String getFileName() {
        return fileName;
    }

    public String getRenamedFileName() {
        return renamedFileName;
    }

    public String[] getDelimited(){ 
        return fileNameDelimited;
    }
    
    

}