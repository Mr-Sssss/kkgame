public class Potion extends Item {
    
    public Potion(String newName, Subject newSubject, String newDescription, int newRarity){
        super(newName, newSubject, newDescription, newRarity);
    }

    //Potions can only be found  in floor 2. They either heal or make you sick.
    public static Potion mysterypotion = new Potion("Mystery Potion", Subject.science, "This potion can heal you up to 65% or lose up to 35% of your health", 4);
    public static Potion cola = new Potion("Cola", Subject.science, "This cola will heal you 10%", 1);
    public static Potion beer = new Potion("Beer", Subject.science, "This beer will heal you 20%", 2);
    public static Potion wine = new Potion("Wine", Subject.science, "This wine will heal you 30%", 3);
    public static Potion redbullzero = new Potion("Red Bull gives you wiiiiiiings", Subject.science, "This redbull will heal you 40%", 4);
    public static Potion vodka = new Potion("Vodka", Subject.science, "This vodka will heal you 50%", 4);
    public static Potion gerolsteiner = new Potion("Gerolsteiner", Subject.science, "This gerolsteiner water will make you lose 10% of your health", 2);
    public static Potion prime = new Potion("Prime", Subject.science, "This prime will make you lose 20% of your health", 3);
}
