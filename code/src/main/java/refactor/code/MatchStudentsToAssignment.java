package refactor.code;

import java.util.*;

public class MatchStudentsToAssignment {

    public MatchStudentsToAssignment() {
    }

    private boolean subStringSearch(ArrayList<String> studentIdentificationMarkers, String fileName) {
        int startingIndex;
        for (String s: studentIdentificationMarkers) {

            startingIndex = fileName.indexOf(s);
            if (startingIndex > 0){
                return true;
            }           
        }
        return false;

    }

    public boolean match(ArrayList<String> studentIdentificationMarkers, String[] delimitedFileName, String fileName) {

        for (int i = 0; i < delimitedFileName.length; i++) {

            for (String id : studentIdentificationMarkers) {

                if (delimitedFileName[i].equals(id)  /*|| subStringSearch(studentIdentificationMarkers, fileName)*/ ) {
                    return true;
                }
            }
        }
        return false;
    }

}