public class Teacher{
    public String subject;
    public int health;
    public int level;

    public Teacher(String newSubject, int newHealth, int newLevel){
        subject = newSubject;
        health = newHealth;
        level = newLevel;
        
    }
      
    private void changeSubject(String changedSubject) {
        subject = changedSubject;
    }
    
    private void changeHealth(int changedHealth) {
        health = changedHealth;
    }
    
    private void changeLevel(int changedLevel) {
        level = changedLevel;
    }
    
  }