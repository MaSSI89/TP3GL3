import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.*;



public class LinkedListTest {
    private LinkedList list;
    

    @Before
    public void createLinkedList(){
        list = new LinkedList();
        System.out.println("linked list Created");
    }

    @After
    public void deleteList (){
        list = null;
        System.out.println("List deleted");
    }

    @Test
    public void testIsEmpty() {
        assertTrue("Liste vide au debut", list.isEmpty());
        list.insertHead(4);
        assertFalse("List Not Empty", list.isEmpty());
    }

    @Test
    public void testGettHead() {
        assertEquals("EMpty List No HEAD", null,list.getHead());
        list.insertHead(5);
        assertEquals(5, list.getHead());
    }

    @Test
    public void insertHead() {
        list.insertHead(5);
        assertEquals("should return 5", 5, list.getHead());
        list.insertHead(8);
        assertEquals("should return 8", 8,list.getHead());
    }

    @Test
    public void testgetTail (){
        assertTrue("New List Tail Empty", list.getTail().isEmpty());
        list.insertHead(3);
        assertTrue(list.getTail().isEmpty());
        list.insertHead(4);
        list.insertHead(5);
        list.insertHead(6);
        assertFalse("should return a list with elements in it",list.getTail().isEmpty());
        assertEquals(5, list.getTail().getHead());
        assertFalse("list should be empty",list.isEmpty());
        
    }

    @Test
    public void testIterator (){
        LinkedList.Iterator iterator = list.iterator();
        assertFalse("List empty at first creation",iterator.hasNext());
        assertNull("SHould return Null at first", iterator.next());
        
        list.insertHead(4);
        list.insertHead(5);

        iterator = list.iterator();

        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertFalse("SHould return Flase , end of list", iterator.hasNext());

        iterator = list.iterator();
        // assertTrue("SHould return True", iterator.hasNext());
        assertEquals("should return 5", 5, iterator.next());
        assertEquals( 4, iterator.next());
        assertNull("End of list return Null", iterator.next());
    }

}
