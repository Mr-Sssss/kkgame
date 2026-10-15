public class Number extends Item {
    private int damageBoostPercent;

    public Number(String newName, Subject newSubject, String newDescription, int newRarity, int newDamageBoostPercent) {
        super(newName, newSubject, newDescription, newRarity);
        damageBoostPercent = newDamageBoostPercent;
    }

    public int getDamageBoostPercent() {return damageBoostPercent;}
    public void setDamageBoostPercent(int damageBoostPercent) {this.damageBoostPercent = damageBoostPercent;}

    public static Number[] getAllNumbers() {
        return new Number[] {one, zeropowerzero, pi, e, i};
    }

    public static Number one = new Number("1", Subject.maths,"This number will boost your damage by 5%", 1, 5);
    public static Number zeropowerzero = new Number("0^0", Subject.maths, "This number will boost your damage by 10%", 2, 10);
    public static Number pi = new Number("3.14159", Subject.maths, "This number will boost your damage by 15%", 3, 15);
    public static Number e = new Number("2.71828", Subject.maths, "This number will boost your damage by 20%", 4, 20);
    public static Number i = new Number("sqrt(-1)", Subject.maths, "This number will boost your damage by 25%", 5, 25);
}