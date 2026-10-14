public class Book extends Item{

    public Book(String newName, Subject newSubject, String newDescription, int newRarity){
        super(newName, newSubject, newDescription, newRarity);
    }

    //Books can only be found in floor 1. Books can decrease or increase the UseScore.
    public static Book periodicTable = new Book("Periodic Table", Subject.science, "This will increase your UseScore for every Weapon by 1", 1);
    public static Book spanischdisctionary = new Book("Spanisch Disctionary", Subject.languages, "This book will increase your UseScore for every Weapon by 2", 1);
    public static Book oxford = new Book("Oxford Dictionary", Subject.languages, "This book will increase your UseScore for every Weapon by 3", 2);
    public static Book duden = new Book("Duden German Dictionary", Subject.languages, "This book will increase your UseScore for every Weapon by 4", 3);
    public static Book Faust = new Book("Faust 1 by Goethe", Subject.languages, "This book will increase your UseScore for every Weapon by 5", 4);
    public static Book tafelwerk = new Book("A Tafelwerk for School", Subject.maths, "This book will increase your UseScore for every Weapon by 6", 4);    
}
