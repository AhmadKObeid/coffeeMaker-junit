package edu.ncsu.csc326.coffeemaker;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RecipeTest{

	private Recipe testRecipe;
	
   /**
    * Setup and Teardown Functions
    */
    @Before
    public void setUp(){
        testRecipe = new Recipe();
        System.out.println("Create Recipe Object");
    }

    @After
    public void tearDown(){
        testRecipe = null;
    }
    
   /**
    * Tests For All GET Functions
    */
    @Test
    public void getAmtChocolateTest() throws RecipeException{
        System.out.println("getAmtChoclateTest");
    	testRecipe.setAmtChocolate("10");
    	assertEquals(10,testRecipe.getAmtChocolate());
    }
    
    @Test
    public void getAmtCoffeeTest() throws RecipeException{
        System.out.println("getAmtCoffeTest");
    	testRecipe.setAmtCoffee("3");
    	assertEquals(3,testRecipe.getAmtCoffee());
    }
    
    @Test
    public void getAmtMilkTest() throws RecipeException{
        System.out.println("getAmtMilkTest");
    	testRecipe.setAmtMilk("5");
    	assertEquals(5,testRecipe.getAmtMilk());
    }
    
    @Test
    public void getAmtSugarTest() throws RecipeException{
        System.out.println("getAmtSugarTest");
    	testRecipe.setAmtSugar("6");
    	assertEquals(6,testRecipe.getAmtSugar());
    }
    
    @Test
    public void getNameTest() throws RecipeException{
        System.out.println("getNameTest");
    	testRecipe.setName("test");
    	assertEquals("test",testRecipe.getName());
    }
    
    @Test
    public void getPriceTest() throws RecipeException{
        System.out.println("getPriceTest");
    	testRecipe.setPrice("100");
    	assertEquals(100,testRecipe.getPrice());
    }
    
    
   /**
    * Test For All SET Functions
    */
    @Test
    public void setAmtChocolateTest(){ 
        System.out.println("setAmntChoclateTest");
        
        //Test for null input values
        System.out.println("  - Null Value Test");       
        try{
            testRecipe.setName("test-Recipe");
            testRecipe.setAmtChocolate("");

            assertNotNull(testRecipe.getAmtChocolate());
            assertEquals(0,testRecipe.getAmtChocolate());
        }
        catch(RecipeException e){
            assertTrue("Units of chocolate must be a positive integer",testRecipe.getAmtChocolate()<=0);
        }
        
        //Test for string literals as input
        System.out.println("  - String Literal Test");       
        try{
            testRecipe.setAmtChocolate("ten");
            assertNull(testRecipe.getAmtChocolate());

        }
        catch(RecipeException e){
            assertTrue("Units of chocolate must be a positive integer",testRecipe.getAmtChocolate()<=0);
        }
        
        //Test for negative input values
        System.out.println("  - Negative Number Test");       
        try{
            testRecipe.setAmtChocolate("-1");

            assertNotNull(testRecipe.getAmtChocolate());
            assertEquals(0,testRecipe.getAmtChocolate());
        }
        catch(RecipeException e){
            assertTrue("Units of chocolate must be a positive integer",testRecipe.getAmtChocolate()<=0);
        }
        
        //Test for positive non-integer input values
        System.out.println("  - Positive non-integer Test");       
        try{
            testRecipe.setAmtChocolate("3/4");

            assertNotNull(testRecipe.getAmtChocolate());
            assertEquals(0,testRecipe.getAmtChocolate());
        }
        catch(RecipeException e){
            assertTrue("Units of chocolate must be a positive integer",testRecipe.getAmtChocolate()<=0);
        }
        
        //Test for positive integer input values
        System.out.println("  - Positive Integer Test");       
        try{
            testRecipe.setAmtChocolate("1");
            
            assertNotNull(testRecipe.getAmtChocolate());
            assertEquals(1,testRecipe.getAmtChocolate());
        }
        catch(RecipeException e){
            assertTrue("Units of chocolate must be a positive integer",testRecipe.getAmtChocolate()<=0);
        }
    }
    
    @Test
    public void setAmtCoffeeTest(){
        System.out.println("setAmtCoffeeTest");
        
        System.out.println("  - Null Value Test");
        try{  //Test for null input values
            testRecipe.setName("test-Recipe");
            testRecipe.setAmtCoffee("");

            assertNotNull(testRecipe.getAmtCoffee());
            assertEquals(0,testRecipe.getAmtCoffee());
        }
        catch(RecipeException e){
            assertTrue("Units of chocolate must be a positive integer",testRecipe.getAmtCoffee()<=0);
        }

        System.out.println("  - String Literal Test");
        try{
            //Test for string literals as input
            testRecipe.setAmtCoffee("ten");

            assertNull(testRecipe.getAmtCoffee());

        }
        catch(RecipeException e){
            assertTrue("Units of chocolate must be a positive integer",testRecipe.getAmtCoffee()<=0);
        }
        
        System.out.println("  - Negative Number Test");
        try{
            //Test for negative input values
            testRecipe.setAmtCoffee("-1");

            assertNotNull(testRecipe.getAmtCoffee());
            assertEquals(0,testRecipe.getAmtCoffee());
        }
        catch(RecipeException e){
            assertTrue("Units of chocolate must be a positive integer",testRecipe.getAmtCoffee()<=0);
        }

        System.out.println("  - Positive Non-integer Test");
        try{
            //Test for positive non-integer input values
            testRecipe.setAmtCoffee("3/4");

            assertNotNull(testRecipe.getAmtCoffee());
            assertEquals(0,testRecipe.getAmtCoffee());
        }
        catch(RecipeException e){
            assertTrue("Units of chocolate must be a positive integer",testRecipe.getAmtCoffee()<=0);
        }

        System.out.println("  - Positive Integer Test");
        try{
            //Test for positive integer input values
            testRecipe.setAmtCoffee("1");

            assertEquals(1,testRecipe.getAmtCoffee());

            assertTrue(testRecipe.getAmtCoffee()>0);

        }
        catch(RecipeException e){
            assertTrue("Units of chocolate must be a positive integer",testRecipe.getAmtCoffee()<=0);
        }
    }
    
    @Test
    public void setAmtSugarTest(){
        System.out.println("setAmtSugarTest");
        
        System.out.println("  - Null Value Test");
        try{  //Test for null input values
            testRecipe.setName("test-Recipe");
            testRecipe.setAmtSugar("");

            assertNotNull(testRecipe.getAmtSugar());
            assertEquals(0,testRecipe.getAmtSugar());
        }
        catch(RecipeException e){
            assertTrue("Units of chocolate must be a positive integer",testRecipe.getAmtSugar()<=0);
        }

        System.out.println("  - String Literal Test");
        try{
            //Test for string literals as input
            testRecipe.setAmtSugar("ten");

            assertNull(testRecipe.getAmtSugar());

        }
        catch(RecipeException e){
            assertTrue("Units of chocolate must be a positive integer",testRecipe.getAmtSugar()<=0);
        }
        
        System.out.println("  - Negative Number Test");
        try{
            //Test for negative input values
            testRecipe.setAmtSugar("-1");

            assertNotNull(testRecipe.getAmtSugar());
            assertEquals(0,testRecipe.getAmtSugar());
        }
        catch(RecipeException e){
            assertTrue("Units of chocolate must be a positive integer",testRecipe.getAmtSugar()<=0);
        }

        System.out.println("  - Positive Non-integer Test");
        try{
            //Test for positive non-integer input values
            testRecipe.setAmtSugar("3/4");

            assertNotNull(testRecipe.getAmtSugar());
            assertEquals(0,testRecipe.getAmtSugar());
        }
        catch(RecipeException e){
            assertTrue("Units of chocolate must be a positive integer",testRecipe.getAmtSugar()<=0);
        }

        System.out.println("  - Positive Integer Test");
        try{
            //Test for positive integer input values
            testRecipe.setAmtSugar("1");

            assertEquals(1,testRecipe.getAmtSugar());

            assertTrue(testRecipe.getAmtSugar()>0);

        }
        catch(RecipeException e){
            assertTrue("Units of chocolate must be a positive integer",testRecipe.getAmtSugar()<=0);
        }
    }

    @Test
    public void setAmtMilkTest(){
        System.out.println("setAmtMilkTest");
        
        System.out.println("  - Null Value Test");
        try{  //Test for null input values
            testRecipe.setName("test-Recipe");
            testRecipe.setAmtMilk("");

            assertNotNull(testRecipe.getAmtMilk());
            assertEquals(0,testRecipe.getAmtMilk());
        }
        catch(RecipeException e){
            assertTrue("Units of chocolate must be a positive integer",testRecipe.getAmtMilk()<=0);
        }

        System.out.println("  - String Literal Test");
        try{
            //Test for string literals as input
            testRecipe.setAmtMilk("ten");

            assertNull(testRecipe.getAmtMilk());

        }
        catch(RecipeException e){
            assertTrue("Units of chocolate must be a positive integer",testRecipe.getAmtMilk()<=0);
        }
        
        System.out.println("  - Negative Number Test");
        try{
            //Test for negative input values
            testRecipe.setAmtMilk("-1");

            assertNotNull(testRecipe.getAmtMilk());
            assertEquals(0,testRecipe.getAmtMilk());
        }
        catch(RecipeException e){
            assertTrue("Units of chocolate must be a positive integer",testRecipe.getAmtMilk()<=0);
        }

        System.out.println("  - Positive Non-integer Test");
        try{
            //Test for positive non-integer input values
            testRecipe.setAmtMilk("3/4");

            assertNotNull(testRecipe.getAmtMilk());
            assertEquals(0,testRecipe.getAmtMilk());
        }
        catch(RecipeException e){
            assertTrue("Units of chocolate must be a positive integer",testRecipe.getAmtMilk()<=0);
        }

        System.out.println("  - Positive Integer Test");
        try{
            //Test for positive integer input values
            testRecipe.setAmtMilk("1");

            assertEquals(1,testRecipe.getAmtMilk());

            assertTrue(testRecipe.getAmtMilk()>0);

        }
        catch(RecipeException e){
            assertTrue("Units of chocolate must be a positive integer",testRecipe.getAmtMilk()<=0);
        }
    }

    @Test
    public void setPriceTest(){
        System.out.println("setPriceTest");
        
        System.out.println("  - Null Value Test");
        try{  //Test for null input values
            testRecipe.setName("test-Recipe");
            testRecipe.setPrice("");

            assertNotNull(testRecipe.getPrice());
            assertEquals(0,testRecipe.getPrice());
        }
        catch(RecipeException e){
            assertTrue("Units of chocolate must be a positive integer",testRecipe.getPrice()<=0);
        }

        System.out.println("  - String Literal Test");
        try{
            //Test for string literals as input
            testRecipe.setPrice("ten");

            assertNull(testRecipe.getPrice());

        }
        catch(RecipeException e){
            assertTrue("Units of chocolate must be a positive integer",testRecipe.getPrice()<=0);
        }
        
        System.out.println("  - Negative Number Test");
        try{
            //Test for negative input values
            testRecipe.setPrice("-1");

            assertNotNull(testRecipe.getPrice());
            assertEquals(0,testRecipe.getPrice());
        }
        catch(RecipeException e){
            assertTrue("Units of chocolate must be a positive integer",testRecipe.getPrice()<=0);
        }

        System.out.println("  - Positive Non-integer Test");
        try{
            //Test for positive non-integer input values
            testRecipe.setPrice("3/4");

            assertNotNull(testRecipe.getPrice());
            assertEquals(0,testRecipe.getPrice());
        }
        catch(RecipeException e){
            assertTrue("Units of chocolate must be a positive integer",testRecipe.getPrice()<=0);
        }

        System.out.println("  - Positive Integer Test");
        try{
            //Test for positive integer input values
            testRecipe.setPrice("1");

            assertEquals(1,testRecipe.getPrice());

            assertTrue(testRecipe.getPrice()>0);

        }
        catch(RecipeException e){
            assertTrue("Units of chocolate must be a positive integer",testRecipe.getPrice()<=0);
        }
    }

    @Test
    public void setNameTest(){
        System.out.println("setNameTest");
        
        //Test for Empty String Inputs
        System.out.println("  - Empty String Test");
        testRecipe.setName("");
        assertNotNull(testRecipe.getName());
        assertEquals("",testRecipe.getName());

        //Test for null input values
        System.out.println("  - Null Test");
        testRecipe.setName(null);
        assertNotNull(testRecipe.getName());
        assertEquals("",testRecipe.getName());

        //Test for valid string input values
        System.out.println("  - Regular String Test");
        testRecipe.setName("test@Regular");
        assertNotNull(testRecipe.getName());
        assertEquals("test@Regular",testRecipe.getName());
    }

    
   /**
    * Test For Equal Function
    */
    @Test
    public void equalsTest(){
    	
        System.out.println("equalsTest");
        
        //Compare different objects of the same kind
        System.out.println("  - Compare Objects");
        Recipe testRecipe2 = new Recipe();
        assertTrue(testRecipe.equals(testRecipe2)); //Since both will  be instances will have the same name.
        
        System.out.println("  - Compare Objects with diffrent Name Attribute");
        testRecipe.setName("B1");
        assertFalse(testRecipe.equals(testRecipe2)); //Now one of the objects has a default constructor specified name.

        System.out.println("  - Compare Null value to Vaild String");
        try{
            testRecipe2.setName(null); //check for when one object name is null while the other is a valid string.
            testRecipe2.setPrice("3");
            assertFalse(testRecipe.equals(testRecipe2));
        }
        catch(RecipeException e){
            assertTrue("Input for price needs to be a positive integer",testRecipe2.getPrice()<0);
            assertNull(testRecipe2.getName());
        }

    }
}

