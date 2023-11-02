import java.util.Random;
public class Spell {

//    Accessible static lists
    protected static String[] spellDescriptionsArray = {
        "Does a certain thing",
        "Does a different certain thing"
    };

//    Instance variables
    private String target;
    private String duration;
    private int range;

//    Constructor
    public Spell() {
//        Assigns a random index to use for spell parameters within the description array
        Random rand = new Random();
        int randomIndex = rand.nextInt(spellDescriptionsArray.length);
        this.assignSpellParameters(randomIndex);

//        Describe the spell with the description for that index
        this.describe(randomIndex);
    }


//    describe method
    public String describe(int spellArrayIndex) {

        String description = "Target: "+this.target+"\nDuration: "+this.duration+"\nRange: "+this.range+"\n---------\n";
        description = description.concat(spellDescriptionsArray[spellArrayIndex]);
        System.out.println(description);
        return description;
    }

    public void assignSpellParameters(int spellArrayIndex) {
//        Check the entry within the spell array at index spellArrayIndex
//        See whether that item contains certain substrings
//        Use those substrings to inform items like target and duration, as well as # creatures affected


    }

    public static void main(String[] args) {

        Spell newSpell = new Spell();
        }

    }