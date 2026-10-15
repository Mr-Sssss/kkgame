
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

    public static Boss[] getAllBosses() {
        return new Boss[] {frauStockroh, herLunke, frauBurger, herrDamny, derLoewe, herrKreuter};
    }

    public int calculateBossDamage(Boss boss, Character player) {
        double bossLevel = boss.getLevel();
        double bossDamage = boss.getDamage();
        double playerLevel = player.getLevel();

        double playerLevelMultiplier = 1.0 - (playerLevel * 0.03);

        Subject bosssubject = player.getInFightWith().getSubject();
        Subject yoursubject = player.getSubject();
        double subjectMultiplier = 1;

        if (yoursubject.getName().equals("Maths")){
            if (bosssubject.getName().equals("Languages")){subjectMultiplier = 0.8;}
            else if (bosssubject.getName().equals("Artmusic")){subjectMultiplier = 1.2;}
        } else if (yoursubject.getName().equals("Languages")){
            if (bosssubject.getName().equals("Maths")){subjectMultiplier = 1.2;}
            else if (bosssubject.getName().equals("Social")){subjectMultiplier = 0.8;}
        } else if (yoursubject.getName().equals("Social")){
            if (bosssubject.getName().equals("Languages")){subjectMultiplier = 1.2;}
            else if (bosssubject.getName().equals("Science")){subjectMultiplier = 0.8;}
        } else if (yoursubject.getName().equals("Science")){
            if (bosssubject.getName().equals("Social")){subjectMultiplier = 1.2;}
            else if (bosssubject.getName().equals("Artmusic")){subjectMultiplier = 0.8;}
        } else if (yoursubject.getName().equals("Artmusic")){
            if (bosssubject.getName().equals("Maths")){subjectMultiplier = 0.8;}
            else if (bosssubject.getName().equals("Science")){subjectMultiplier = 1.2;}
        } else {System.out.println("You somehow have default Subject");}

        double random = 0.95 + Math.random() * 0.10;

        double damage = (bossLevel * 0.8 + bossDamage * 2.0)
                * playerLevelMultiplier
                * subjectMultiplier
                * random;

        return (int) Math.round(damage);
    }

    public static Boss derLoewe = new Boss("Der Löwe", Subject.maths, "Der Löwe trash talks to you with complex equations and proofs you don't understand. You start to hate maths so bad, that you can't even look at a math problem without feeling nauseous.", 600, "", 10, 10);
    public static Boss herrDamny = new Boss("Herr Damny", Subject.science, "Herr Damny gives you work so hard that you feel like you're drowning in it. This makes you forget your inner self.", 420, "", 6, 8);
    public static Boss frauBurger = new Boss("Frau Burger", Subject.languages, "Frau Burger speaks to you in a language you don't understand. From pure confusion you even forget how to speak in your native language.", 300, "", 7, 8);
    public static Boss herrKreuter = new Boss("Herr Kreuter", Subject.maths, "Herr Kreuter lectures you on assembly language. Your entire concept of computers is broken because of him.", 300, "", 6, 5);
    public static Boss herLunke = new Boss("HerLunke", Subject.social, "HerLunke chats with you about social issues and the world economy. This makes you broken so badly you start to gamble and lose everything.", 240, "", 5, 5);
    public static Boss frauStockroh = new Boss("Frau Stockroh", Subject.artmusic, "Frau Stockroh plays music so bad, that it makes your ears bleed. This makes you deaf forever.", 120, "", 4, 4);

}
