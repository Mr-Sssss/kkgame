public class Student{
    public String name;
    public String year;
    public String subject;
    public String description;

    public Student(String nameNeu, String yearNeu, String subjectNeu, String descriptionNeu){
        name = nameNeu;
        year = yearNeu;
        subject = subjectNeu;
        description = descriptionNeu; 
    }
   
   private void changename (String changedname){
     name = changedname;
   }
   
   private void changeyear (String changedyear){
     year = changedyear;
   }
   
   private void changesubject (String changedsubject){
     name = changedsubject;
   }
   
   private void changedescription (String changeddescription){
     name = changeddescription;
   }
}