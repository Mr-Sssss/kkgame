public class Number extends Item{
    
    public Number(String newName, Subject newSubject, String newDescription, int newRarity){
        super(newName, newSubject, newDescription, newRarity);
    }

    //Numbers can only be found in floor 3. Numbers will boost your damage by a certain percentage.
    public static Number one = new Number("1", Subject.maths, "This number will boost your damage by 5%", 1);
    public static Number zeropowerzero = new Number("0^0", Subject.maths, "This number will boost your damage by 10%", 2);
    public static Number pi = new Number("3,14159", Subject.maths, "This number will boost your damage by 15%", 3);
    public static Number e = new Number("2,71828", Subject.maths, "This number will boost your damage by 20%", 4);
    public static Number i = new Number("sqrt(-1)", Subject.maths, "This number will boost your damage by 25%", 5);
    
}
