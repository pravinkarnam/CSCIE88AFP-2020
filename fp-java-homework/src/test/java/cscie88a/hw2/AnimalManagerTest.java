package cscie88a.hw2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnimalManagerTest {

	private Cat sneaky;
	private Dog bolt;
	String trickName = "sit";
	
	@BeforeEach
	void setUp() throws Exception {
		sneaky = new Cat("Sneaky", "blue", "gray");
		bolt = new Dog("Bolt", "brown", "whity");
	}

	@Test
	public void testDoTrick() {
		ActionResult result = AnimalManager.trainForTricks(sneaky, trickName);
		assertEquals(ActionResult.FAILURE, result);

		result = AnimalManager.trainForTricks(bolt, trickName);
		assertEquals(ActionResult.SUCCESS, result);
	}

	@Test
	public void testDoTrick_anonimous_from_interface() {
		ActionResult result = AnimalManager.trainForTricks(
				new ITrainable() {
					public ActionResult doTrick(String trickName) {
						System.out.println("I always do tricks!");
						return ActionResult.SUCCESS;
					}
				},
				trickName);
		assertEquals(ActionResult.SUCCESS, result);
	}

	@Test 
	public void testSetupPlaydate() {
		// unfriendly cat will not play with anyone
		sneaky.setFriendly(false);
		ActionResult result = AnimalManager.setupPlaydate(sneaky, bolt);
		assertEquals(ActionResult.FAILURE, result);
		
		// a friendly cat will play with others
		sneaky.setFriendly(true);
		result = AnimalManager.setupPlaydate(sneaky, bolt);
		assertEquals(ActionResult.SUCCESS, result);
		
		// dog will play with anybody, always
		result = AnimalManager.setupPlaydate(bolt, sneaky);
		assertEquals(ActionResult.SUCCESS, result);
	}

	@Test 
	public void testSetupPlaydate_anonimous_class() {
		// lets create a Special cat who will play with the dog 
		// regardless of being friendly or not
		ActionResult result = AnimalManager.setupPlaydate(
				new Cat() {
					public ActionResult playWithMe(AbstractAnimal aFriend) {
						if (isFriendly) {
							System.out.println(name + " says: I'm friendly, I am playing with " + 
									aFriend.getName());
						} else {
							System.out.println(name + " says: I'm NOT friendly, but still playing with " + 
									aFriend.getName());
						}
						return ActionResult.SUCCESS;
					} 
				}, 
				bolt);
		assertEquals(ActionResult.SUCCESS, result);		
	}

	//Added by Praveen
	@Test
	public void testTrainForSuperTricks(){
		ActionResult dogResult = AnimalManager.trainForSuperTrick(bolt,trickName);
		assertEquals(ActionResult.FAILURE, dogResult);
		ActionResult catResult = AnimalManager.trainForSuperTrick(sneaky,trickName);
		assertEquals(ActionResult.FAILURE, catResult);
	}

	//Added by Praveen
	@Test
	public void testTrainForSuperTricks_anonymous(){
		ActionResult result = AnimalManager.trainForSuperTrick(
				new ITrainable(){
			@Override
			public ActionResult doSuperTrick(String trickName){
				System.out.println("Let me play a super trick for you");
				return ActionResult.SUCCESS;
			}
			@Override
			public ActionResult doTrick(String trickName){
				System.out.println("Iam not falling for your trick: " + trickName);
				return ActionResult.FAILURE;
			}
		}, trickName);
		assertEquals(ActionResult.SUCCESS, result);
	}

}
