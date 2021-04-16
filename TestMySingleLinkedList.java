package lab3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class TestMySingleLinkedList 
{
  private MySingleLinkedList<Integer> empty ;
  private MySingleLinkedList<Integer> one ;
  private MySingleLinkedList<Integer> several ;

  @Before
  public void setUp()
  {
    empty = new MySingleLinkedList<Integer>() ;
    one = new MySingleLinkedList<Integer>() ;
    one.addFirst(0);
    several = new MySingleLinkedList<Integer>() ;
    several.addFirst(2) ;
    several.addFirst(1) ;
    several.addFirst(0) ;
  }
  
  @Test(expected = NoSuchElementException.class)
  public void testGetFirstException() {
	  empty.getFirst();
  }

  @Test
  public void testGetFirst()  {
	 
	assertEquals(new Integer(0),one.getFirst()) ;
    assertEquals(new Integer(0),several.getFirst()) ;
  }

  @Test
  public void testGetLast()  {
	 
	assertEquals(new Integer(0),one.getLast()) ;
    assertEquals(new Integer(2),several.getLast()) ;
  }
  
  @Test
  public void testContain()  {
	 
	assertTrue(one.contains(0)) ;
	assertTrue(several.contains(0)) ;
	assertTrue(several.contains(1)) ;
	assertTrue(several.contains(2)) ;
  }
  
  
  @Test
  public void testget()
  {
	  assertEquals(new Integer(0), several.get(0));
	  assertEquals(new Integer(1), several.get(1));
	  assertEquals(new Integer(2), several.get(2));	  
  }
    
  @Test(timeout = 100)
  public void testcountApperance()
  {
	  several.addFirst(2) ; 
	  assertEquals(2, several.countApperance(2));	  
	  assertEquals(1, several.countApperance(1));	  
  }
 
  
  @Test(timeout = 100)
  public void testRemove()
  {
	 assertTrue(several.contains(2));
	 assertTrue(several.contains(1));
	 several.remove(1);
	 several.remove(2);
	 assertFalse(several.contains(1));
	 assertFalse(several.contains(2));
  }
  
  @Test(timeout = 100)
  public void testRemoveAll()
  {
	 assertFalse(several.contains(3));
	 several.addFirst(2) ; 
	 assertTrue(several.contains(2));
	 several.removeAll(2);
	 assertFalse(several.contains(2));
  }
  
 
  //=================== Uncomment the following test cases for Extra Credit Exercises ========================
  
  
  @Test(timeout = 100)
  public void testinsertBefore()
  {
	  several.insertBefore(0, 20);
	  assertEquals(new Integer(20), several.getFirst());	  
  }
     
  
  
  @Test(timeout = 100)
  public void testReverse()
  {
	  several.reverse();
	  assertEquals(new Integer(2), several.getFirst());
	  assertEquals(new Integer(1), several.get(1));
	  assertEquals(new Integer(0), several.getLast());
  }
  
 
}