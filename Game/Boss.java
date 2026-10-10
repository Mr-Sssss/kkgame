public class Boss{
    private String name;
    private Subject subject;
    private String description;
    private int health;
    private String attack;
    private int damage;
    private int level;

    public Boss(String newName, Subject newSubject, String newDescription, int newHealth, String newAttack, int newDamage, int newLevel){
        name = newName;
        subject = newSubject;
        description = newDescription;
        health = newHealth;
        attack = newAttack;
        damage = newDamage;
        level = newLevel;

    }

    public void setName (String changedName){
        name = changedName;
    }

    public void setSubject(Subject changedSubject) {
        subject = changedSubject;
    }

    public void setDescription(String changedDescription) {
        description = changedDescription;
    }

    public void setHealth(int changedHealth) {
        health = changedHealth;
    }

    public void setAttack(String changedAttack) {
        attack = changedAttack;
    }

    public void setDamage(int changedDamage){damage = changedDamage;}

    public void setLevel(int changedLevel) {level = changedLevel;}

    public String getName(){return name;}

    public Subject getSubject(){return subject;}

    public String getDescription(){return description;}

    public int getHealth(){return health;}

    public String getAttack(){return attack;}

    public int getDamage(){return damage;}

    public int getLevel(){return level;}

    Boss derLoewe = new Boss("Der Löwe", Subject.maths, "", 1000, "Der Löwe müllt dich mit komplizierten Gleichungen und Beweisen zu, die du nicht verstehst. Dadurch wird deine Ehre als Schüler des Kollwitz-Käthe-Gymnasiums verletzt", 10, 10);
    Boss herrDamny = new Boss("Herr Damny", Subject.science, "", 800, "", 6, 8);
    Boss frauBurger = new Boss("Frau Burger", Subject.languages, "", 700, "", 7, 8);
    Boss herrKreuter = new Boss("Herr Kreuter", Subject.maths, "", 600, "", 6, 5);
    Boss herLunke = new Boss("HerLunke", Subject.social, "", 500, "", 5, 5);
    Boss frauStockroh = new Boss("Frau Stockroh", Subject.artmusic, "", 400, "", 4, 4);

}
