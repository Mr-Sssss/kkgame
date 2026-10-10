public class Student{
    private String name;
    private String year;
    private Subject subject;
    private String description;

    public Student(String newName, String newYear, Subject newSubject, String newDescription){
        name = newName;
        year = newYear;
        subject = newSubject;
        description = newDescription;
    }

    public void setName (String changedName){ name = changedName;}

    public void setYear (String changedYear){ year = changedYear;}

    public void setSubject(Subject changedSubject){ subject = changedSubject; }

    public void setDescription (String changedDescription){ description = changedDescription; }

    public String getName (){return name;}

    public String getYear (){return year;}

    public Subject getSubject(){return subject; }

    public String getDescription (){return description; }
}
