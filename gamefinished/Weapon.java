import java.util.Random;

public class Weapon{
    private String name;
    private Subject subject;
    private String description;
    private int level;
    private int damage;
    private int useScore;//How many time you can't use the weapon before next use
    private int rarety;//How rare the weapon is, 1 = common, 2 = uncommon, 3 = rare, 4 = epic, 5 = legendary
    private boolean found;

    public Weapon(String newName, Subject newSubject, String newDescription, int newLevel, int newDamage, int newUseScore, int newRarety, boolean newFound){
        name = newName;
        subject = newSubject;
        description = newDescription;
        level = newLevel;
        damage = newDamage;
        useScore = newUseScore;
        rarety = newRarety;
        found = newFound;
    }
    public void setName (String changedName){ name = changedName;}

    public void setSubject (Subject changedSubject){ subject = changedSubject; }

    public void setDescription (String changedDescription){ description = changedDescription; }

    public void setLevel(int changedLevel) { level = changedLevel; }

    public void setDamage (int changedDamage){ damage = changedDamage;}

    public void setUseScore (int changedUseScore){ useScore = changedUseScore; }

    public void setRarety (int changedRarety){ rarety = changedRarety; }

    public void setFound(boolean changedFound){found = changedFound;}

    public String getName() {return name;}

    public Subject getSubject() {return subject; }

    public String getDescription() {return description; }

    public int getLevel() {return level; }

    public int getDamage() {return damage;}

    public int getUseScore() {return useScore; }

    public int getRarety() {return rarety; }

    public boolean getFound(){return found;}

    public int calcDamage(Weapon weapon, Character player){
        int levelweapon = weapon.level;
        int damageweapon = weapon.damage;
        int levelplayer = player.getLevel();
        Subject bosssubject = player.getInFightWith().getSubject();
        Subject yoursubject = player.getSubject();
        double subjectMultiplier = 1;

        if (yoursubject.getName().equals("Maths")){
            if (bosssubject.getName().equals("Languages")){subjectMultiplier = 1.2;}
            else if (bosssubject.getName().equals("Artmusic")){subjectMultiplier = 0.8;}
        } else if (yoursubject.getName().equals("Languages")){
            if (bosssubject.getName().equals("Maths")){subjectMultiplier = 0.8;}
            else if (bosssubject.getName().equals("Social")){subjectMultiplier = 1.2;}
        } else if (yoursubject.getName().equals("Social")){
            if (bosssubject.getName().equals("Languages")){subjectMultiplier = 0.8;}
            else if (bosssubject.getName().equals("Science")){subjectMultiplier = 1.2;}
        } else if (yoursubject.getName().equals("Science")){
            if (bosssubject.getName().equals("Social")){subjectMultiplier = 0.8;}
            else if (bosssubject.getName().equals("Artmusic")){subjectMultiplier = 1.2;}
        } else if (yoursubject.getName().equals("Artmusic")){
            if (bosssubject.getName().equals("Maths")){subjectMultiplier = 1.2;}
            else if (bosssubject.getName().equals("Science")){subjectMultiplier = 0.8;}
        } else {System.out.println("You somehow have default Subject");}

        Random r = new Random();
        double randomValue = 0.95 + (1.05 - 0.95) * r.nextDouble();

        double currentDamage = (damageweapon * 3 + levelweapon * 2 + levelplayer * 2) * subjectMultiplier * randomValue;

        return (int) Math.round(currentDamage);
    }

    public static Weapon[] getAllWeapons() {
        return new Weapon[] {chalk, waterbottle, bell, hallpass, fireextinguisher, firealarm, question, yapping, forgottenhomework, tilting, overheadprojector, presentation, sicknote, phone, yesnoormaybe,
            triangle, pythagoras, nullstelle, polynomial, derivative, complex, euler, proof,
            grammar, literature, dictionary, analysis, interpretation, gerundium, nativespeaker, shakespeare,
            globe, ballotpaper, populationpyramid, demonstration, colonialism, grundgesetz, ww2, stasimethod,
            atom, erlenmeyer, microscope, octetrule, photosynthesis, newtonslaws, evolution, relativity,
            paintbrush, musickey, triplet, improvisation, monalisa, abstractart, symphony, C418};
    }

    //the 8 weapons of a subject in the order you get them from the bosses
    public static Weapon[] getSubjectWeapons(Subject subject) {
        if (subject == Subject.maths) {
            return new Weapon[] {triangle, pythagoras, nullstelle, polynomial, derivative, complex, euler, proof};
        } else if (subject == Subject.languages) {
            return new Weapon[] {grammar, literature, dictionary, analysis, interpretation, gerundium, nativespeaker, shakespeare};
        } else if (subject == Subject.social) {
            return new Weapon[] {globe, ballotpaper, populationpyramid, demonstration, colonialism, grundgesetz, ww2, stasimethod};
        } else if (subject == Subject.science) {
            return new Weapon[] {atom, erlenmeyer, microscope, octetrule, photosynthesis, newtonslaws, evolution, relativity};
        } else if (subject == Subject.artmusic) {
            return new Weapon[] {paintbrush, musickey, triplet, improvisation, monalisa, abstractart, symphony, C418};
        }
        return new Weapon[0];
    }

    public static Weapon chalk = new Weapon("Chalk", Subject.neutral, "A simple piece of chalk, capable of creating truly terrifying sounds, that rupture your eardrums.", 1, 1, 1, 1, false);
    public static Weapon waterbottle = new Weapon("Waterbottle", Subject.neutral, "A simple water bottle, containing liters of water for splashing your opponents.", 1, 1, 2, 1, false);
    public static Weapon bell = new Weapon("Bell", Subject.neutral, "The school bell. An ancient artifact, always causing beef between students and teachers, over who ends the lessons.", 1, 2, 2, 1, false);
    public static Weapon hallpass = new Weapon("Hall Pass", Subject.neutral, "The holy hall pass, an object capable of granting temporary freedom from class and enabling one to go to the toilet.", 1, 2, 2, 2, false);
    public static Weapon fireextinguisher = new Weapon("Fire Extinguisher", Subject.neutral, "A simple fire extinguisher", 1, 3, 2, 2, false);
    public static Weapon firealarm = new Weapon("Fire Alarm", Subject.neutral, "A simple fire alarm, its power is creating the perfect distraction from class.", 1, 3, 3, 2, false);
    public static Weapon question = new Weapon("Question", Subject.neutral, "A question making the teacher question all his knowledge, just by pure stupidity.", 1, 4, 2, 2, false);
    public static Weapon yapping = new Weapon("Yapping", Subject.neutral, "This is just some thing, that is really cool and strong and it is just yapping stuff and yeah", 1, 5, 4, 3, false);
    public static Weapon forgottenhomework = new Weapon("Forgotten Homework", Subject.neutral, "Ohh I forgot the description, sorry.", 1, 5, 4, 3, false);
    public static Weapon tilting = new Weapon("Tilting", Subject.neutral, "A simple tilting on your chair and the teacher again tells you a story of some student that broke their head or something.", 1, 6, 3, 3, false);
    public static Weapon overheadprojector = new Weapon("Overhead Projector", Subject.neutral, "A simple overhead projector", 1, 6, 6, 3, false);
    public static Weapon presentation = new Weapon("Presentation", Subject.neutral, "A presentation so long and so dumb that the teacher just ragequits", 1, 6, 4, 4, false);
    public static Weapon sicknote = new Weapon("Sick Note", Subject.neutral, "I can't finish this description, I was sick.", 1, 7, 5, 4, false);
    public static Weapon phone = new Weapon("Phone", Subject.neutral, "You use your phone in school and the teacher gets really mad.", 1, 8, 5, 4, false);
    public static Weapon yesnoormaybe = new Weapon("Yes/No/Maybe Letter", Subject.neutral, "Do you want to be together with me: Yes, No, Maybe", 1, 10, 8, 5, false);

    public static Weapon triangle = new Weapon("Triangle", Subject.maths, "A simple triangle", 3, 2, 1, 1, true);
    public static Weapon pythagoras = new Weapon("Pythagoras", Subject.maths, "a² + b² = c²", 4, 3, 2, 1, true);
    public static Weapon nullstelle = new Weapon("Root", Subject.maths, "A root is a point where a function equals zero.", 5, 4, 3, 2, true);
    public static Weapon polynomial = new Weapon("Polynomial", Subject.maths, "A polynomial is an expression consisting of variables and coefficients, combined using addition, subtraction, multiplication, and non-negative integer exponents.", 6, 5, 1, 2, true);
    public static Weapon derivative = new Weapon("Derivative", Subject.maths, "The derivative of a function measures how the function's output changes as its input changes.", 7, 5, 3, 3, true);
    public static Weapon complex = new Weapon("Complex Number", Subject.maths, "A complex number is a number that can be expressed in the form a + bi, where a and b are real numbers and i is the imaginary unit.", 8, 6, 4, 3, true);
    public static Weapon euler = new Weapon("Euler", Subject.maths, "Euler's formula states that e^(ix) = cos(x) + i*sin(x), where e is the base of the natural logarithm, i is the imaginary unit, and x is a real number.", 9, 7, 4, 4, true);
    public static Weapon proof = new Weapon("Proof", Subject.maths, "A proof is a logical argument that demonstrates the truth of a mathematical statement.", 10, 8, 5, 5, true);

    public static Weapon grammar = new Weapon("Grammar", Subject.languages, "Grammar is the set of rules that govern the structure and usage of a language.", 3, 2, 1, 1, true);
    public static Weapon literature = new Weapon("Literature", Subject.languages, "Literature is any written work that has artistic or intellectual value.", 4, 3, 2, 1, true);
    public static Weapon dictionary = new Weapon("Dictionary", Subject.languages, "A dictionary is a reference book that provides definitions, meanings, and explanations of words in a particular language.", 5, 4, 3, 2, true);
    public static Weapon analysis = new Weapon("Analysis", Subject.languages, "Analysis is the process of examining and interpreting information to understand its meaning and significance.", 6, 5, 1, 2, true);
    public static Weapon interpretation = new Weapon("Interpretation", Subject.languages, "Interpretation is the act of explaining or providing meaning to something, such as a text, event, or situation.", 7, 5, 3, 3, true);
    public static Weapon gerundium = new Weapon("Gerund", Subject.languages, "The gerund is a verb form that functions as a noun and ends in -ing in English.", 8, 6, 4, 3, true);
    public static Weapon nativespeaker = new Weapon("Native Speaker", Subject.languages, "A native speaker is someone who speaks a language as their first language.", 9, 7, 4, 4, true);
    public static Weapon shakespeare = new Weapon("Shakespeare", Subject.languages, "William Shakespeare was an English playwright, poet, and actor, widely regarded as one of the greatest writers in the English language.", 10, 8, 5, 5, true);

    public static Weapon globe = new Weapon("Globe", Subject.social, "A globe is a spherical representation of the Earth, showing its continents, oceans, and countries.", 3, 2, 1, 1, true);
    public static Weapon ballotpaper = new Weapon("Ballot Paper", Subject.social, "A ballot paper is a piece of paper used to cast votes in an election.", 4, 3, 2, 1, true);
    public static Weapon populationpyramid = new Weapon("Population Pyramid", Subject.social, "A population pyramid is a graphical representation of the age and sex distribution of a population.", 5, 4, 3, 2, true);
    public static Weapon demonstration = new Weapon("Demonstration", Subject.social, "A demonstration is a public gathering of people to express their opinions or advocate for a cause.", 6, 5, 1, 2, true);
    public static Weapon colonialism = new Weapon("Colonialism", Subject.social, "Colonialism is the practice of acquiring and maintaining colonies or territories by a more powerful country.", 7, 5, 3, 3, true);
    public static Weapon grundgesetz = new Weapon("Grundgesetz", Subject.social, "The Grundgesetz is the German constitution, which outlines the fundamental rights and principles of the country.", 8, 6, 4, 3, true);
    public static Weapon ww2 = new Weapon("World War II", Subject.social, "World War II was a global conflict that lasted from 1939 to 1945, involving many countries and resulting in significant loss of life and destruction.", 9, 7, 4, 4, true);
    public static Weapon stasimethod = new Weapon("Stasimethod", Subject.social, "That's a Stasi method", 10, 8, 5, 5, true);

    public static Weapon atom = new Weapon("Atom", Subject.science, "An atom is the smallest unit of an element that retains the properties of that element.", 3, 2, 1, 1, true);
    public static Weapon erlenmeyer = new Weapon("Erlenmeyer Flask", Subject.science, "An Erlenmeyer flask is a type of laboratory glassware with a conical shape and a narrow neck, used for mixing and storing liquids.", 4, 3, 2, 1, true);
    public static Weapon microscope = new Weapon("Microscope", Subject.science, "A microscope is an instrument used to magnify and observe small objects or organisms that are not visible to the naked eye.", 5, 4, 3, 2, true);
    public static Weapon octetrule = new Weapon("Octet Rule", Subject.science, "The octet rule states that atoms tend to gain, lose, or share electrons in order to achieve a stable configuration of eight valence electrons.", 6, 5, 1, 2, true);
    public static Weapon photosynthesis = new Weapon("Photosynthesis", Subject.science, "Photosynthesis is the process by which green plants and some other organisms use sunlight to synthesize food from carbon dioxide and water.", 7, 5, 3, 3, true);
    public static Weapon newtonslaws = new Weapon("Newton's Laws", Subject.science, "Newton's laws of motion are three fundamental principles that describe the relationship between the motion of an object and the forces acting on it.", 8, 6, 4, 3, true);
    public static Weapon evolution = new Weapon("Evolution", Subject.science, "Evolution is the process by which different species of organisms develop and change over time through natural selection and genetic variation.", 9, 7, 4, 4, true);
    public static Weapon relativity = new Weapon("Relativity", Subject.science, "Relativity is a theory in physics that describes the relationship between space, time, and gravity, and how they are affected by the presence of matter and energy.", 10, 8, 5, 5, true);

    public static Weapon paintbrush = new Weapon("Paintbrush", Subject.artmusic, "A paintbrush is a tool used for applying paint or other substances to a surface.", 3, 2, 1, 1, true);
    public static Weapon musickey = new Weapon("Music Key", Subject.artmusic, "A music key is a symbol used in musical notation to represent the pitch and duration of a sound.", 4, 3, 2, 1, true);
    public static Weapon triplet = new Weapon("Triplet", Subject.artmusic, "A triplet is a group of three notes played in the time of two notes of the same value.", 5, 4, 3, 2, true);
    public static Weapon improvisation = new Weapon("Improvisation", Subject.artmusic, "Improvisation is the act of creating music spontaneously, often without prior preparation or notation.", 6, 5, 1, 2, true);
    public static Weapon monalisa = new Weapon("Mona Lisa", Subject.artmusic, "The Mona Lisa is a famous portrait painting by Leonardo da Vinci, known for its enigmatic smile and artistic mastery.", 7, 5, 3, 3, true);
    public static Weapon abstractart = new Weapon("Abstract Art", Subject.artmusic, "Abstract art is a style of visual art that does not attempt to represent an accurate depiction of visual reality, but instead uses shapes, colors, forms, and gestural marks to achieve its effect.", 8, 6, 4, 3, true);
    public static Weapon symphony = new Weapon("Symphony", Subject.artmusic, "A symphony is a large-scale musical composition typically written for an orchestra, consisting of multiple movements and showcasing a variety of musical themes and ideas.", 9, 7, 4, 4, true);
    public static Weapon C418 = new Weapon("C418", Subject.artmusic, "C418 is a German musician and composer known for creating the soundtrack for the popular video game Minecraft.", 10, 8, 5, 5, true);
}
