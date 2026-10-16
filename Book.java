//Books are Items that can reduce the cooldowns of all weapons during a fight by n.

public class Book extends Item {
    private final int cooldownReduction;

    public Book(String newName, Subject newSubject, String newDescription, int newRarity, int newCooldownReduction) {
        super(newName, newSubject, newDescription, newRarity);
        this.cooldownReduction = newCooldownReduction;
    }
    public int getCooldownReduction() {
        return cooldownReduction;
    }

    public static Book[] getAllBooks() {
        return new Book[] {periodicTable, spanischdisctionary, oxford, duden, Faust, tafelwerk};
    }

    public static Book periodicTable = new Book("Periodic Table", Subject.science, "Reduces all weapon cooldowns by 1", 1, 1);
    public static Book spanischdisctionary = new Book("Spanish Dictionary", Subject.languages, "Reduces all weapon cooldowns by 2", 1, 2);
    public static Book oxford = new Book("Oxford Dictionary", Subject.languages, "Reduces all weapon cooldowns by 3", 2, 3);
    public static Book duden = new Book("Duden German Dictionary", Subject.languages, "Reduces all weapon cooldowns by 4", 3, 4);
    public static Book Faust = new Book("Faust 1 by Goethe", Subject.languages, "Reduces all weapon cooldowns by 5", 4, 5);
    public static Book tafelwerk = new Book("A Formula Book for School", Subject.maths, "Reduces all weapon cooldowns by 6", 4, 6);
}