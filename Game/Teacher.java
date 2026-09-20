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
      
    private void changeSubject(String changedSubject) {
        subject = changedSubject;
    }
    
    private void changeDescription(String changedDescription) {
        description = changedDescription;
    }
    
    private void changeAttack(String changedAttack) {
        attack = changedAttack;
    }
    
    private void changeHealth(int changedHealth) {
        health = changedHealth;
    }
    
    private void changeStrictness(int changedStrictness) {
        strictness = changedStrictness;
    }
    
    private void changeLevel(int changedLevel) {
        level = changedLevel;
    }
    
  }