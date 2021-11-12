package comp3607.project;

public class Student{
    private String participantID;
    private String name;
    private String studentID;
    private String email;
    private String status;
    private String grade;
    private String maxGrade;
    private String changeGrade;
    private String dayModified;
    private String dateModified;
    private String timeModified;
    private String feedback;
    private String[] assignments;

    public Student(String participantID, String name, String studentID, String email, String status, String grade, String maxGrade, String changeGrade, String dayModified, String dateModified, String timeModified, String feedback){
        this.participantID = participantID;
        this.name = name;
        this.studentID = studentID;
        this.email = email;
        this.status = status;
        this.grade = grade;
        this.maxGrade = maxGrade;
        this.changeGrade = changeGrade;
        this.dayModified = dayModified;
        this.dateModified = dateModified;
        this.timeModified = timeModified;
        this.feedback = feedback; 
    }

    public String toString() {
        String details = "Participant ID: " + this.participantID;
        details += " Name: "  + this.name;
        details += " Student ID: " + this.studentID;
        details += " Email: " + this.email;
        details += " Status: " + this.status;
        details += " Grade: " + this.grade;
        details += " Maximum Grade: " + this.maxGrade;
        details += " Grade can be changed: " + this.changeGrade;
        details += " Last Modified: " + this.dayModified + " " + this.dateModified + " " + this.timeModified;
        details += " Feedback comments: " + this.feedback;

        return details;
    }
}
