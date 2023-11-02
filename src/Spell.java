import java.util.Random;
public class Spell {

    //    Accessible static lists
    protected static String[] spellDescriptionsArray = {
            "A 30' x 30' x 30' cube of noxious gas emanates from the item, causing every creature within range to " +
                    "succeed on a CON save DC 13 or spend the turn vomiting.",

            "The affected creature grows bat wings that gives them 20' flying movement for 1d6 turns",

            "The affected creature grows to 20' tall & has a STR of 25 for 1d6 turns",

            "The affected creature shrinks to 6 inches tall and has its move reduced to 5' for 1d6 turns.  During the" +
                    "spell's duration, the creature has an AC of 19 and a STR of 2, and cannot be heard unless the " +
                    "creature trying to understand it gets within 1 foot of the affected creature.",

            "Run the randomizer twice and take both effects.",

            "The affected creature must succeed a spell save DC 13 or be held in place by magical, glowing purple" +
                    "chains that shoot up from the ground and immobilize it for the next turn.  While immobilized, the" +
                    "creature cannot make any attack or take any action other than bonus actions that do not involve" +
                    "movement.",

            "The affected creature is flung suddenly and violently upwards and backwards from the direction they were" +
                    "headed or facing after ending their last movement.  A loud 'YEET!' can be heard from 300 yards " +
                    "emanating from the source of the spell.  The creature takes 2d10 damage from the concussive" +
                    "force and is propelled 30' up and 60' backwards.  If the spell causes them to hit any solid " +
                    "object such as a tree or wall, they take an additional d10.  Fall damage from a cliff etc. " +
                    "also applies.",

            "Summons 1d4 random CR1 monsters in the immediate vicinity of the caster, who are absolutely obedient to" +
                    "the summoner and will remain present until killed or 24 hours, whichever is sooner.",

            "A cloud of fog appears suddenly centered around the caster, and obscures any vision - including darkvision" +
                    "- beyond 5' away from anyone inside.  The cloud is a 100' x 100' x 100' cube and will remain" +
                    "for 1d4 turns, or until it is magically dispelled.",

            "Dispel all magical effects currently on the battlefield.",

            "The affected creature gains resistance to physical attacks for 1d6 turns",

            "The affected creature gains resistance to all magical attacks for 1d6 turns"
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

        String description = "Target: " + this.target + "\nDuration: " + this.duration + "\nRange: " + this.range + "\n---------\n";
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
