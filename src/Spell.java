import java.util.Random;
public class Spell {

    //    Accessible static lists

    protected static String[] spellTargetsArray = {
//            Defines valid targets to be assigned in spell parameters for spells which are not AoE spells.
//            Caster will only affect the caster of the spell, single target will affect any OTHER creature not
//            including the caster, and Multiple will randomize any creature, including possibly the caster.
            "Caster", "Single Target", "Multiple"
    };

    protected static String[] spellDescriptionsArray = {

//            index 0
            "A 30' x 30' x 30' cube of noxious gas emanates from the item, causing every creature within range to " +
                    " succeed on a CON save DC 13 or spend the turn vomiting.",

            //            index 1
            "The affected creature grows bat wings that gives them 20' flying movement for 1d6 turns",

            //            index 2
            "The affected creature grows to 20' tall & has a STR of 25 for 1d6 turns",

            //            index 3
            "The affected creature shrinks to 6 inches tall and has its move reduced to 5' for 1d6 turns.  During the" +
                    " spell's duration, the creature has an AC of 19 and a STR of 2, and cannot be heard unless the " +
                    " creature trying to understand it gets within 1 foot of the affected creature.",

            //            index 4
            "Run the randomizer twice and take both effects.",

            //            index 5
            "The affected creature must succeed a spell save DC 13 or be held in place by magical, glowing purple" +
                    " chains that shoot up from the ground and immobilize it for the next turn.  While immobilized, the" +
                    " creature cannot make any attack or take any action other than bonus actions that do not involve" +
                    " movement.",

            //            index 6
            "The affected creature is flung suddenly and violently upwards and backwards from the direction they were" +
                    " headed or facing after ending their last movement.  A loud 'YEET!' can be heard from 300 yards " +
                    " emanating from the source of the spell.  The creature takes 2d10 damage from the concussive" +
                    " force and is propelled 30' up and 60' backwards.  If the spell causes them to hit any solid " +
                    " object such as a tree or wall, they take an additional d10.  Fall damage from a cliff etc. " +
                    " also applies.",

            //            index 7
            "Summons 1d4 random CR1 monsters in the immediate vicinity of the caster, who are absolutely obedient to" +
                    " the summoner and will remain present until killed or 24 hours, whichever is sooner.",

            //            index 8
            "A cloud of fog appears suddenly centered around the caster, and obscures any vision - including darkvision" +
                    "- beyond 5' away from anyone inside.  The cloud is a 100' x 100' x 100' cube and will remain" +
                    " for 1d4 turns, or until it is magically dispelled.",

            //            index 9
            "Dispel all magical effects currently on the battlefield.",

            //            index 10
            "The affected creature gains resistance to all physical attacks for 1d6 turns",

            //            index 11
            "The affected creature gains resistance to all magical attacks for 1d6 turns",

            //            index 12
            "The affected creature is surrounded by glowing red geometrical patterns and symbols, guiding any attacks" +
                    " made against it for the next round.  All attacks against the marked creature during that round" +
                    " are made with advantage.",

            //            index 13
            "With an angelic chorus, the clouds part and a golden beam of sunshine delivers the Holy Hand Grenade of" +
                    "Antioch to the caster's hands.  On their next turn, the caster may throw the Holy Hand Grenade" +
                    " up to 30' as an action, using an Athletics check.  The grenade will deal up to 2d10 piercing " +
                    " damage, in addition to a d10 of radiant damage, within a 15' radius sphere.  Reduce damage by 1" +
                    " for every point below the target's AC that was scored on the Athletics roll.",

            //            index 14
            "The affected creature must make a spell save DC 14 or be put to sleep for 1d6 turns.",

            //            index 15
            "The affected creature begins to uncontrollably sneeze multicolored fireworks that shoot off in every" +
                    " direction.  For the next turn, every creature within a 60' radius of the affected creature " +
                    " must make a DEX save DC 12 or be struck by a firework, taking 1d4 fire damage.",

            //            index 16
            "The caster shoots a fireball from their outstretched hand and toward whatever creature they were targeting" +
                    " - dealing 4d6 fire damage to every creature within a 20' radius of the impact point.  On a " +
                    " successful spell save DC 13, creatures will take 1/2 damage.",

            //            index 17
            "The caster opens their mouth unnaturally wide and starts taking in massive amounts of air, causing the " +
                    "nearest size Medium or smaller creature directly in front of them to be sucked into their mouth." +
                    " The caster can then hold them for a maximum of 4 turns before they must be spit out with great" +
                    " force, causing 1d8 bludgeoning damage and sending them hurtling 15' in any direction the caster" +
                    " chooses.  While the creature is in the caster's mouth, the caster cannot perform any action" +
                    " except to move, and cannot maintain spell concentration.  The swallowed creature also cannot " +
                    "take any actions.",


    };

    protected static int[] maxTurns = {
            1, // index 0
            6, // index 1
            6, // index 2
            6, // index 3
            0, // index 4
            1, // index 5
            1, // index 6
            999, // index 7
            4, // index 8
            6, // index 9
            6, // index 10
            1, // index 11
            0, // index 12
            6, // index 13
            1, // index 14
            1, // index 15
            1,  // index 16
            4  // index 17
    };

    protected static boolean[] isAreaSpell = {
/*          Array holds a boolean value corresponding to the same spell at the index within spellArrayIndex.  If true,
            this indicates an area effect spell which cannot be assigned a random target value from the spellTargets
            array.  If false, this can be assigned any valid target within the assignSpellParameters method.
*/
            true,  // index 0
            false,  // index 1
            false,  // index 2
            false,  // index 3
            false,  // index 4
            false,  // index 5
            false,  // index 6
            true,  // index 7
            true,  // index 8
            true,  // index 9
            false,  // index 10
            false,  // index 11
            false,  // index 12
            true,  // index 13
            false,  // index 14
            true, // index 15
            true, // index 16
            false,  // index 17
    };

    //    Instance variables
    private String target;
    private String duration;
    private String range;

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
/*      First, take the spellArrayIndex and use it to check the areaSpells array and singleTargetSpells array.  This
*           filters out spells which cannot have multiple targets.
* */
        if (isAreaSpell[spellArrayIndex - 1]) {
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
        if (maxTurns[spellArrayIndex - 1] == 0) {
            this.duration = "N/A";
        }
        else if (maxTurns[spellArrayIndex - 1] == 999) {
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
