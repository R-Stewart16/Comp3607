package refactor.code;

import java.util.*;

public class MatchStudentsToAssignment {

    public MatchStudentsToAssignment() {
    }


    /***
     * Searches the names of a student through the filename of their submitted file to identify if forms of identification can be made
     * @param studentIdentificationMarkers  the names of the student
     * @param fileName the original filename of the submitted file
     * @return true if the student is found, false otherwise
     */
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

    /***
     * matches the student to a submitted assignment file based on the identifiers: participant ID, student ID, and email address
     * @param studentIdentificationMarkers  the strings that can be used to identify a student
     * @param delimitedFileName the delimited version of the file name
     * @param fileName the original filename of the submitted file
     * @return true if a student is matched to a file, false otherwise.
     */
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