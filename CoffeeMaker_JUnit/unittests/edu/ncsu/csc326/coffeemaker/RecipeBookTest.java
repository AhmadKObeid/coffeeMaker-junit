package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RecipeBookTest {

	private Recipe r1;
	private Recipe r2;
	private Recipe r3;
	RecipeBook recipeBook;

	@Before
	public void setUp() throws Exception
	{
		recipeBook = new RecipeBook();
		//Set up for r1
		r1 = new Recipe();
		r1.setName("Recipe_1");
		r1.setAmtChocolate("1");
		r1.setAmtCoffee("2");
		r1.setAmtMilk("3");
		r1.setAmtSugar("4");
		r1.setPrice("5");
		
		//Set up for r2
		r2 = new Recipe();
		r2.setName("Recipe_2");
		r2.setAmtChocolate("6");
		r2.setAmtCoffee("7");
		r2.setAmtMilk("8");
		r2.setAmtSugar("9");
		r2.setPrice("10");
		
		//Set up for r3
		r3 = new Recipe();
		r3.setName("Recipe_3");
		r3.setAmtChocolate("11");
		r3.setAmtCoffee("12");
		r3.setAmtMilk("13");
		r3.setAmtSugar("14");
		r3.setPrice("15");
				
	}

	@After
	public void tearDown() throws Exception
	{
		recipeBook = null;
	}
	
   /**
	* Test For GET Recipe 
	*/
	
	@Test 
	public void getRecipeSucceedsTest()
	{
		assertTrue(recipeBook.getRecipes() instanceof Recipe []);
	}
	
   /**
	* Tests For Add Recipe Use Cases
	*/
	
	//Checks to see if recipe was added successfully 
	@Test
	public void addRecipeSucceedsTest()
	{
		assertTrue(recipeBook.addRecipe(r2));
		assertEquals("Recipe_2", recipeBook.getRecipes()[0].getName());
		assertEquals(6,recipeBook.getRecipes()[0].getAmtChocolate());
		assertEquals(7,recipeBook.getRecipes()[0].getAmtCoffee());
		assertEquals(8,recipeBook.getRecipes()[0].getAmtMilk());
		assertEquals(9,recipeBook.getRecipes()[0].getAmtSugar());
		assertEquals(10,recipeBook.getRecipes()[0].getPrice());
	}
	
	//Checks that a recipe cannot be added if it is null or empty obj	 
	@Test
	public void addRecipeFailsTest()
	{
		Recipe recipe = null;
		assertFalse(recipeBook.addRecipe(recipe));
		recipe = new Recipe();
		assertFalse(recipeBook.addRecipe(recipe));
	}
	
	//Tests whether addRecipe allows duplicte Recipes
	@Test
	public void addSameRecipeFailsTest()
	{
		//recipeBook = new RecipeBook();
		recipeBook.addRecipe(r1);
		//try to add the recipe again
		assertFalse(recipeBook.addRecipe(r1));
	}

	//Tests whether a recipe is added in the first available position after delete 
	@Test
	public void addRecipeAtFirstAvailablePositionTest()
	{
		recipeBook.addRecipe(r1);
		recipeBook.addRecipe(r2);
		recipeBook.deleteRecipe(0);
		recipeBook.addRecipe(r3);
		assertTrue(r3.equals(recipeBook.getRecipes()[0]));
	}
	
   /**
	* Tests For DELETE Recipe Use Cases
	*/
	
	//Tests that the position for deleting a recipe is set to null following delete
	@Test
	public void deleteRecipeSetToNullTest()
	{
		recipeBook.addRecipe(r1);
		recipeBook.addRecipe(r2);
		recipeBook.addRecipe(r3);
		recipeBook.deleteRecipe(0);
		assertTrue(recipeBook.getRecipes()[0] == null);
	}
		
	//Successfully delete a recipe 
	@Test
	public void deleteRecipeSuccessTest()
	{
		recipeBook.addRecipe(r1);
		String deleted = recipeBook.deleteRecipe(0);
		assertEquals("Recipe_1",deleted);
	}
	
	//Delete a recipe that does not exist
	@Test
	public void deleteRecipeNotFoundTest()
	{
		recipeBook.addRecipe(r1);
		assertEquals(null, recipeBook.deleteRecipe(1));
	}
	
   /**
	* Tests For EDIT Recipe Use Cases
	*/
	
	//Successfully Edit a recipe
	@Test
	public void editRecipeSuccessTest()
	{
		recipeBook.addRecipe(r1);
		assertEquals("Recipe_1",recipeBook.editRecipe(0, r2));
		assertEquals("Recipe_2", recipeBook.getRecipes()[0].getName());
		assertEquals(6,recipeBook.getRecipes()[0].getAmtChocolate());
		assertEquals(7,recipeBook.getRecipes()[0].getAmtCoffee());
		assertEquals(8,recipeBook.getRecipes()[0].getAmtMilk());
		assertEquals(9,recipeBook.getRecipes()[0].getAmtSugar());
		assertEquals(10,recipeBook.getRecipes()[0].getPrice());
	}
	

	//Edit a recipe that does not exist
	@Test 
	public void editRecipeNotFoundTest()
	{
		recipeBook.addRecipe(r1);
		assertEquals(null,recipeBook.editRecipe(1, r2) );
	}

}
