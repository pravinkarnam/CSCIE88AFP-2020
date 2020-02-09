package cscie88a.hw2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

class AllAnimalTests {

	private Cat sneaky;
	private Dog bolt;

	@BeforeEach
	void setUp() throws Exception {
		sneaky = new Cat("Sneaky", "blue", "gray");
		bolt = new Dog("Bolt", "brown", "whity");
	}

	//Modified by Praveen
	@Test
	void testTakeMedicine() {
		assertEquals(ActionResult.SUCCESS , bolt.takeMedicine(true));
		assertEquals(ActionResult.FAILURE, bolt.takeMedicine(false));
		assertEquals(ActionResult.FAILURE, sneaky.takeMedicine(true));
		assertEquals(ActionResult.FAILURE, sneaky.takeMedicine(false));
	}
	//Added by Praveen
	@Test
	public void testPlayWithToy(){
		Toy squeakyToy = new Toy();
		assertEquals(ActionResult.SUCCESS, sneaky.playWithToy(squeakyToy));
		Toy notSqueakyToy = new Toy(false, true, true);
		assertEquals(ActionResult.FAILURE, sneaky.playWithToy(notSqueakyToy));
		assertEquals(ActionResult.SUCCESS, bolt.playWithToy(squeakyToy));
		assertEquals(ActionResult.SUCCESS, bolt.playWithToy(notSqueakyToy));
	}

	//Added by Praveen
	@Test
	public void testWhoAreYou(){
		System.out.println( "Calling from cat instance : "+ sneaky.whoAreYou());
		System.out.println( "Calling from dog instance : "+ bolt.whoAreYou());
	}

	//Added by Praveen
	@Test
	public void testPlayWithMeForHedgehog(){
		Hedgehog hhog = new Hedgehog("hoggy", "green", "brown");
		assertEquals(ActionResult.FAILURE, hhog.playWithMe(sneaky));
		assertEquals(ActionResult.FAILURE, hhog.playWithMe(bolt));
	}

	@Test
	public void testSayHi() {
		String humanName = "Marina";
		sneaky.sayHiToHuman(humanName);
		bolt.sayHiToHuman(humanName);
	}

	@Test
	public void testAbstractClassCreation() {
		// demo error creating AbstractAnimal directly
		// will NOT compile
		//AbstractAnimal unknownAnimal = new AbstractAnimal();
	}
	
	@Test
	public void testDoTrick() {
		ActionResult result = sneaky.doTrick("sit");
		assertEquals(ActionResult.FAILURE, result);

		result = bolt.doTrick("sit");
		assertEquals(ActionResult.SUCCESS, result);
	}

	@Test
	public void testDoTrickForTreat() {
		ActionResult result = sneaky.doTrickForTreat("sit", "yummyTreat");
		assertEquals(ActionResult.FAILURE, result);

		result = bolt.doTrickForTreat("sit", "yummyTreat");
		assertEquals(ActionResult.SUCCESS, result);
	}

	@Test 
	public void testPlayWithMe() {
		// unfriendly cat will not play with anyone
		sneaky.setFriendly(false);
		ActionResult result = sneaky.playWithMe(bolt);
		assertEquals(ActionResult.FAILURE, result);
		
		// a friendly cat will play with others
		sneaky.setFriendly(true);
		result = sneaky.playWithMe(bolt);
		assertEquals(ActionResult.SUCCESS, result);
		
		// dog will play with anybody, always
		result = bolt.playWithMe(sneaky);
		assertEquals(ActionResult.SUCCESS, result);
	}
}
