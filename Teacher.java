public class Teacher{
    public String name;
    public String subject;
    public String description;
    public int health;
    public int strictness;
    public String attack;
    public int level;

    public Teacher(String nameNeu, String subjectNeu, String descriptionNeu, int healthNeu, int strictnessNeu, String attackNeu, int levelNeu){
        name = nameNeu;
        subject = subjectNeu;
        description = descriptionNeu;
        health = healthNeu;
        strictness = strictnessNeu;
        attack = attackNeu;
        level = levelNeu;
        
    }
    
    private void changename (String changedname){
      name = changedname;
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
    
    
    Teacher1 = new Teacher("Max", "Mathe", "Ein strenger Lehrer", 100, 8, "Hausaufgaben", 5);


Teacher.changeName("Anna");
Teacher.changeSubject("Physik");
Teacher.changeHealth(90);
Teacher.changeLevel(6);

   