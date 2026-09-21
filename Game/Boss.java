public class Boss{
    public String name;
    public String subject;
    public String description;
    public int health;
    public String attack;
    public int damage;
    public int level;

    public Boss(String newName, String newSubject, String newDescription, int newHealth, String newAttack, int newDamage, int newLevel){
        name = newName;
        subject = newSubject;
        description = newDescription;
        health = newHealth;
        attack = newAttack;
        damage = newDamage;
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
    
    private void changeLevel(int changedLevel) {
        level = changedLevel;
    }
    
  }

  Boss derLoewe = new Boss("Der Löwe", "Mathe", "", 1000, "Der Löwe müllt dich mit komplizierten Gleichungen und Beweisen zu, die du nicht verstehst. Dadurch wird deine Ehre als Schüler des Kollwitz-Käthe-Gymnasiums verletzt", 10, 10);
  Boss herrDamny = new Boss("Herr Damny", "Nawi", "", 800, "", 6, 8);
  Boss frauBurger = new Boss("Frau Burger", "Sprache", "", 700, "", 7, 8);
  Boss herrKreuter = new Boss("Herr Kreuter", "Informatik", "", 600, "", 6, 5);
  Boss herLunke = new Boss("HerLunke", "Gewi", "", 500, "", 5, 5);
  Boss frauStockroh = new Boss("Frau Stockroh", "Kunstmusik", "", 400, "", 4, 4);
