public class Teacher{
    public String name;
    public String subject;
    public String description;
    public int health;
    public int strictness;
    public String attack;
    public int level;

    public Teacher(String newName, String newSubject, String newDescription, int newHealth, int newStrictness, String newAttack, int newLevel){
        name = newName;
        subject = newSubject;
        description = newDescription;
        health = newHealth;
        strictness = newStrictness;
        attack = newAttack;
        level = newLevel;
        
    }
    
    private void changeName (String changedName){
      name = changedName;
      }
      
    public void changeSubject(String changedSubject) {
        subject = changedSubject;
    }
    
    public void changeDescription(String changedDescription) {
        description = changedDescription;
    }
    
    public void changeAttack(String changedAttack) {
        attack = changedAttack;
    }
    
    public void changeHealth(int changedHealth) {
        health = changedHealth;
    }
    
    public void changeStrictness(int changedStrictness) {
        strictness = changedStrictness;
    }
    
    public void changeLevel(int changedLevel) {
        level = changedLevel;
    }
    
  }
    

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