// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Spell {

//    Accessible static list
    protected static String[] spellNamesArray = {
        "Spell 1",
        "Spell 2"
    };

    protected static String[] spellDescriptionsArray = {
        "Does a certain thing",
        "Does a different certain thing"
    };

//    Instance variables
    private String target;
    private String duration;
    private int range;

//    Constructor


//    describe method
    public String describe() {

        String description = "Target: "+this.target+"\nDuration: "+this.duration+"\nRange: "+this.range+"\n---------\n";
        return description;
    }

    public static void main(String[] args) {


        }

    }