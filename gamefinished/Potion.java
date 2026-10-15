public class Potion extends Item {
    private final int healthPercent;
    private final boolean heals;
    public Potion(String newName, Subject newSubject, String newDescription, int newRarity, int newHealthPercent, boolean newHeals) {
        super(newName, newSubject, newDescription, newRarity);
        this.healthPercent = newHealthPercent;
        this.heals = newHeals;
    }
    public int getHealthPercent() {
        return healthPercent;
    }

    public boolean heals() {
        return heals;
    }

    public static Potion[] getAllPotions() {
        return new Potion[] {mysterypotion, cola, beer, wine, redbullzero, vodka, gerolsteiner, prime};
    }

    public static Potion mysterypotion = new Potion("Mystery Potion", Subject.science, "50% chance to heal up to 65% or lose up to 35% health", 4, 0, false);
    public static Potion cola = new Potion("Cola", Subject.science, "Heals 10% health", 1, 10, true);
    public static Potion beer = new Potion("Beer", Subject.science, "Heals 20% health", 2, 20, true);
    public static Potion wine = new Potion("Wine", Subject.science, "Heals 30% health", 3, 30, true);
    public static Potion redbullzero = new Potion("Red Bull gives you wiiiiiiings", Subject.science, "Heals 40% health", 4, 40, true);
    public static Potion vodka = new Potion("Vodka", Subject.science, "Heals 50% health", 4, 50, true);
    public static Potion gerolsteiner = new Potion("Gerolsteiner", Subject.science, "Removes 5% health", 2, 5, false);
    public static Potion prime = new Potion("Prime", Subject.science, "Removes 10% health", 3, 10, false);
}