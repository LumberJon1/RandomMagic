import java.util.*;
public class Spell {


    //    Instance variables
    private String description;
    private String target;
    private String duration;
    private String range;
    private int maxTurns;
    private boolean isAreaSpell;

    //    No-args Constructor
    public Spell() {
//        Assigns a random index to use for spell parameters within the description array
        Random rand = new Random();
        int randomIndex = rand.nextInt(descriptionsArray.size());
        this.assignSpellParameters(randomIndex);

//        Describe the spell with the description for that index
        this.describe(randomIndex);
    }

//    Parameter constructor
    public Spell(String description, int maxTurns, boolean isAreaSpell) {
//        Used when generating static ArrayList
    }


//    Accessible static lists
    private static ArrayList<String> descriptionsArray = new ArrayList<>();
    private static ArrayList<Integer[]> parametersArray = new ArrayList<>();

    static {
//      Within the hashmap, the first value array index is the maxTurns.  The second index is the boolean value (0 or 1).
//      Where 0 is not an area spell, and 1 is an area spell.
        descriptionsArray.add("A 30' x 30' x 30' cube of noxious gas emanates from the item, causing every creature"+
                "\n within range to succeed on a CON save DC 13 or spend the turn vomiting.");
        parametersArray.add(new Integer[] {1, 1});

        descriptionsArray.add("The affected creature grows bat wings that gives them 20' flying movement" +
                        "\nfor 1d6 turns");
        parametersArray.add(new Integer[] {6, 0});

        descriptionsArray.add("The affected creature grows to 20' tall & has a STR of 25 for 1d6 turns");
        parametersArray.add(new Integer[] {6, 0});

        descriptionsArray.add("""
                        The affected creature shrinks to 6 inches tall and has its move reduced to 5' for
                        1d6 turns.  During the spell's duration, the creature has an AC of 19 and a STR of 2,
                        and cannot be heard unless the creature trying to understand it gets within
                        1 foot of the affected creature.
                        """);
        parametersArray.add(new Integer[] {1, 1});

        descriptionsArray.add("Run the randomizer twice and take both effects.");
        parametersArray.add(new Integer[] {0, 0});

        descriptionsArray.add("""
                        The affected creature must succeed a spell save DC 13 or be held in place by magical, glowing
                        purple chains that shoot up from the ground and immobilize it for the next turn.
                        While immobilized, the creature cannot make any attack or take any action other than
                        bonus actions that do not involve movement.
                        """);
        parametersArray.add(new Integer[] {1, 0});

        descriptionsArray.add("""
                        The affected creature is flung suddenly and violently upwards and backwards from the direction
                        they were headed or facing after ending their last movement.  A loud 'YEET!' can be heard
                        from 300 yards emanating from the source of the spell.  The creature takes 2d10 damage from
                        the concussive force and is propelled 30' up and 60' backwards.  If the spell causes them to
                        hit any solid object such as a tree or wall, they take an additional d10.  Fall damage from
                        a cliff, building, etc. also applies.
                        """);
        parametersArray.add(new Integer[] {0, 0});

        descriptionsArray.add("""
                        Summons 1d4 random CR1 monsters in the immediate vicinity of the caster, who are absolutely
                        obedient to the summoner and will remain present until killed or 24 hours, whichever is sooner.
                        """);
        parametersArray.add(new Integer[] {24, 1});

        descriptionsArray.add("""
                        A cloud of fog appears suddenly centered around the caster, and obscures any vision -
                        including darkvision - beyond 5' away from anyone inside.  The cloud is a 100' x 100' x 100'
                        cube and will remain for 1d4 turns, or until it is magically dispelled.""");
        parametersArray.add(new Integer[] {4, 1});

        descriptionsArray.add("Dispel all magical effects currently on the battlefield.");
        parametersArray.add(new Integer[] {0, 1});

        descriptionsArray.add("The affected creature gains resistance to all physical attacks for 1d6 turns");
        parametersArray.add(new Integer[] {6, 0});

        descriptionsArray.add("The affected creature gains resistance to all magical attacks for 1d6 turns");
        parametersArray.add(new Integer[] {6, 0});

        descriptionsArray.add("""
                        The affected creature begins to uncontrollably sneeze multicolored fireworks that shoot off in
                        every direction.  For the next 1d4 turns, every creature within a 60' radius of the affected
                        creature must make a DEX save DC 12 or be struck by a firework, taking 1d4 fire damage.
                        While the creature is affected by the spell, it may not take any action or move more than 5'
                        in any direction per turn.
                        """);
        parametersArray.add(new Integer[] {4, 1});

        descriptionsArray.add("""
                        The affected creature is surrounded by glowing red geometrical patterns and symbols, guiding
                        any attacks made against it for the next round.  All attacks against the marked creature
                        during that round are made with advantage.
                        """);
        parametersArray.add(new Integer[] {1, 0});

        descriptionsArray.add("""
                        With an angelic chorus, the clouds part and a golden beam of sunshine delivers the Holy
                        Hand Grenade of Antioch to the caster's hands.  On their next turn, the caster may throw the
                        Holy Hand Grenade up to 30' as an action, using an Athletics check.  The grenade will deal up
                        to 2d10 piercing damage, in addition to a d10 of radiant damage, within a 15' radius sphere.
                        If the thrower fails the Athletics check, reduce damage by 2 for every point below the
                        success number.
                        """);
        parametersArray.add(new Integer[] {0, 1});

        descriptionsArray.add("The affected creature must make a spell save DC 14 or be put to sleep for 1d6 turns.");
        parametersArray.add(new Integer[] {6, 0});

        descriptionsArray.add("""
                        The caster shoots a fireball from their outstretched hand and toward whatever creature they
                        were targeting, dealing 4d6 fire damage to every creature within a 20' radius of the
                        impact point.  On a successful spell save DC 13, creatures will take 1/2 damage.
                        """);
        parametersArray.add(new Integer[] {0, 1});

        descriptionsArray.add("""
                        The caster opens their mouth unnaturally wide and starts taking in massive amounts of air,
                        causing the nearest size Medium or smaller creature directly in front of them to be sucked
                        into their mouth (max range 15'). The caster can then hold them for a maximum of 4 turns before
                        they must be spit out with great force, causing 1d8 bludgeoning damage and sending them
                        hurtling 15' in any direction the caster chooses.  While the creature is in the caster's mouth,
                        the caster cannot perform any action except to move, and cannot maintain spell concentration.
                        The swallowed creature also cannot take any actions.
                        """);
        parametersArray.add(new Integer[] {4, 0});

}

    protected static String[] spellTargetsArray = {
//            Defines valid targets to be assigned in spell parameters for spells which are not AoE spells.
//            Caster will only affect the caster of the spell, single target will affect any OTHER creature not
//            including the caster, and Multiple will randomize any creature, including possibly the caster.
            "Caster", "Single Target", "Multiple"
    };



//    Methods...

    //    describe method
    public String describe(int spellArrayIndex) {

        String description = "Target: " + this.target + "\nDuration: " + this.duration + "\nRange: " + this.range +
                "\n---------\n"+descriptionsArray.get(spellArrayIndex);

        System.out.println(description);
        return description;
    }

    public void assignSpellParameters(int spellArrayIndex) {
/*      First, take the spellArrayIndex and use it to check the areaSpells array and singleTargetSpells array.  This
*           filters out spells which cannot have multiple targets.
* */
        Integer[] spellValues;
        spellValues = parametersArray.get(spellArrayIndex);

        if (spellValues[1] == 1) {
            this.range = "Area";
            this.target = "All creatures within spell area";
        }

        else {
//            define a random assignment of target(s) from the spellTargets array
            Random rand = new Random();
            int randIndex = rand.nextInt(spellTargetsArray.length);

//            Assign target accordingly
            if (spellTargetsArray[randIndex] == "Multiple") {
                int randomRoll = rand.nextInt(2, 8);
                this.target = "Multiple (up to "+randomRoll+")";
            }
            this.target = spellTargetsArray[randIndex];
            this.range = "Affected creature(s)";

        }
//        Assign duration, with the notable edge cases
        if (spellValues[0] == 0) {
            this.duration = "Instantaneous";
        }
        else if (spellValues[0] == 24) {
            this.duration = "24 hours";
        }
        else {
//            generate a random value between 1 and the stated maxTurns for that spell
            Random rand = new Random();
            int chosenRoll = rand.nextInt(1, 4);
            if (chosenRoll == 1) {
                this.duration = chosenRoll+" turn";
            }
            else {
                this.duration = chosenRoll+" turns";
            }
        }

//        Lastly, override any necessary target parameters based on particular spells
        switch(spellArrayIndex) {
            case 13:
                this.target = "Caster";
                break;
            case 17:
                this.target = "Single Target";
                break;

            default:
                break;
        }
    }

    public static void main(String[] args) {

        Spell newSpell = new Spell();


    }
}
