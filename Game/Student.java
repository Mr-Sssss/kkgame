public static class Student{
    public String name;
    public String year;
    public String subject;
    public String description;

    public Student(String newName, String newYear, String newSubject, String newDescription){
        name = newName;
        year = newYear;
        subject = newSubject;
        description = newDescription;
    }

    private void changeName (String changedName){ name = changedName;}

    private void changeYear (String changedYear){ year = changedYear;}

    private void changeSubject (String changedSubject){ name = changedSubject; }

    private void changeDescription (String changedDescription){ name = changedDescription; }
}