package cscie88a.hw2;

public class Hedgehog  extends AbstractAnimal implements ITrainable{

    public static String greeting = "Hello human";

    public Hedgehog(){}

    public Hedgehog(String name, String eyeColor, String bodyColor){
        super(name, eyeColor, bodyColor);
    }

    @Override
    public void sayHiToHuman(String humanName) {
        System.out.println(greeting);

    }

    @Override
    public ActionResult playWithMe(AbstractAnimal aFriend) {
        System.out.println("Sorry " + aFriend.getName() + ", I am not in a mood to play. Your's: " + name);
        return ActionResult.FAILURE;
    }

    @Override
    public ActionResult playWithToy(Toy toy) {
        System.out.println("Iam loving this toy. It's features are: " + toy.toString());
        return ActionResult.SUCCESS;
    }

    @Override
    public ActionResult doTrick(String trickName) {
        System.out.println(name + " says: I LOVE doing tricks! I'm doing " + trickName + " now!");
        return ActionResult.SUCCESS;
    }
}
