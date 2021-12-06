import fr.western.models.*;

import java.util.Scanner;

public class Story {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome in Reverso Mundo >:D");

        System.out.println("\nQue veux-tu tester ?"
                + "(all/human/sir/brigand/cowgirl/super/"
                + "barwoman/sheriff/sheriff-cowgirl/"
                + "ripoux/sir-brigand/native)");
        String answer = scanner.next().toLowerCase();

        switch (answer) {
            case "human":
                testHuman();
                break;
            case "sir":
                testSir();
                break;
            case "brigand":
                testBrigand();
                break;
            case "cowgirl":
                testCowgirl();
                break;
            case "super":
                testSuper();
                break;
            case "barwoman":
                testBarwoman();
                break;
            case "sheriff":
                testSheriff();
                break;
            case "sheriff-cowgirl":
                testSheriffAsCowgirl();
                break;
            case "ripoux":
                testRipoux();
                break;
            case "sir-brigand":
                testSirBrigand();
                break;
            case "native":
                testNative();
                break;
            default:
            case "all":
                testHuman();
                testSir();
                testBrigand();
                testCowgirl();
                testSuper();
                testBarwoman();
                testSheriff();
                testRipoux();
                break;
        }
    }

    private static void testHuman() {
        System.out.println("\n");
        Human boris = new Human("Boris");
        boris.talk("coucou");
        boris.introduceSelf();
        boris.drink();
    }

    private static void testSir() {
        System.out.println("\n");
        Sir luke = new Sir("Lucky Luke");
        Sir rosario = new Sir("Rosario DelMundo", "rose");
        Sir tom = new Sir("Tom Sawyer", false);
        Sir voldemort = new Sir("Tom Jedusor", "noire", true);
        System.out.println(luke + "\n" + rosario + "\n" + tom + "\n" + voldemort);

        System.out.println("La robe de " + luke.getName() + " est " + luke.getDressColor());
        luke.setDressColor("verte");

        rosario.getKidnapped();
    }

    private static void testBrigand() {
        System.out.println("\n");
        Brigand joy = new Brigand("Joy Dalton");
        Brigand will = new Brigand("Will Dalton", "cool");
        Brigand jackie = new Brigand("Jackie Dalton", 300);
        Brigand averell = new Brigand("Averell Dalton", "gentil", 50, true);

        Brigand miaouss = new Brigand("Miaouss Team Rocket", true);

        System.out.println(joy + "\n" + will + "\n" + jackie + "\n" + averell + "\n" + miaouss);

        System.out.println(joy.getName());

        Brigand janet = new Brigand("Calamity Janet", 1000);
        Sir sacha = new Sir("Sacha Ketchum");
        Cowgirl jessie = new Cowgirl("Jessie James");
        System.out.println("Pour la tête de Jessie : " + janet.getReward() + " $");
        janet.kidnap(sacha);
        janet.getCapturedBy(jessie);
    }

    private static void testCowgirl() {
        System.out.println("\n");
        Cowgirl jessie = new Cowgirl("Jessie James");
        Cowgirl lucy = new Cowgirl("Lucy Luke", 100);
        Cowgirl james = new Cowgirl("James Jessie", "charismatique");

        System.out.println(jessie + "\n" + lucy + "\n" + james);

        System.out.println("\n");
        Brigand janet = new Brigand("Calamity Janet", 1000);
        Sir sacha = new Sir("Sacha Ketchum");
        janet.kidnap(sacha);

        lucy.shootOn(janet);
        lucy.free(sacha);
    }


    private static void testSuper() {
        Sir arthur = new Sir("Arthur Conan Doyle");
        Brigand janet = new Brigand("Calamity Janet");
        Cowgirl lucy = new Cowgirl("Lucy Luke");

        arthur.introduceSelf();
        janet.introduceSelf();
        lucy.introduceSelf();
    }

    private static void testBarwoman() {
        Barwoman moe = new Barwoman("Molly \"Moe\"");
        Cowgirl lucy = new Cowgirl("Lucy Luke");
        Sir arthur = new Sir("Arthur Conan Doyle");
        Brigand janet = new Brigand("Calamity Janet");

        moe.getBarName();
        moe.introduceSelf();
        moe.serve(lucy);
        moe.serve(arthur);
        moe.serve(janet);
    }

    private static void testSheriff() {
        Sheriff clarice = new Sheriff("Clarice Starling");
        Brigand janet = new Brigand("Calamity Janet");

        clarice.introduceSelf();
        clarice.setBountyOn(janet, 250);
        clarice.shootOn(janet);
        clarice.arrest(janet);
        clarice.introduceSelf();
    }

    private static void testSheriffAsCowgirl() {
        Cowgirl cleo = new Sheriff("Cleo Ghostville", 100, 50);
        Sheriff sheriffCleo = (Sheriff) cleo; // downcasting
        Brigand janet = new Brigand("Calamity Janet");

        cleo.introduceSelf(); // uses Sheriff.introduceSelf() still
        sheriffCleo.introduceSelf();

        sheriffCleo.setBountyOn(janet, 250); // impossible for cleo
        sheriffCleo.arrest(janet); // impossible for cleo
    }

    ;

    private static void testRipoux() {
        CrookedCop matilda = new CrookedCop("Matilda");
        Sheriff clarice = new Sheriff("Clarice Starling");
        Brigand janet = new Brigand("Calamity Janet");
        Sir jeanMichiel = new Sir("Chiant-Michiel Blanchier", true);
        Sir arthur = new Sir("Arthur Conan Doyle");

        matilda.introduceSelf();

        // Is Cowgirl
        janet.kidnap(jeanMichiel);
        matilda.free(jeanMichiel);

        // Is Sheriff
        matilda.setBountyOn(janet, 50);
        matilda.arrest(janet);

        // Is Outlaw
        matilda.kidnap(arthur);
        clarice.setBountyOn(matilda, 500);
        clarice.arrest(matilda);
    }

    private static void testSirBrigand() {
        SirBrigand john = new SirBrigand("Calamity John", "grise");
        Cowgirl lucy = new Cowgirl("Lucy Luke");
        Sheriff clarice = new Sheriff("Clarice Starling");
        Brigand janet = new Brigand("Calamity Janet");
        Sir arthur = new Sir("Arthur Conan Doyle", "verte");

        // Is Sir
        john.introduceSelf();
        janet.kidnap(john);
        lucy.shootOn(janet);
        lucy.free(john);
        john.setDressColor("noire");

        // Is Outlaw
        arthur.introduceSelf();
        john.kidnap(arthur);
        clarice.setBountyOn(john, 350);
        clarice.shootOn(john);
        clarice.arrest(john);
    }

    private static void testNative() {
        Native matoaka = new Native("Matoaka Amonute", 2);

        Sir arthur = new Sir("Arthur Conan Doyle", "verte");
        Cowgirl lucy = new Cowgirl("Lucy Luke");
        Brigand janet = new Brigand("Calamity Janet");

        matoaka.introduceSelf();
        matoaka.scalp(arthur);
        matoaka.scalp(lucy);
        matoaka.scalp(janet);

        matoaka.introduceSelf();
    }
}
