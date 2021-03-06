

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

class MyTrieTest {

    @Test
    void testMyTrie() {
	MyTrie test = new MyTrie();
    }

    @Test
    void testSize() {
	MyTrie test = new MyTrie();
	test.add("love");
	assertEquals(1,test.size());
	test.add("who");
	assertEquals(2,test.size());
	test.add("lofi");
	assertEquals(3,test.size());
    }

    @Test
    void testContainsEmptyString() {
	MyTrie test = new MyTrie();
	assertFalse(test.containsEmptyString());
    }

    @Test
    void testContains() {
	MyTrie test = new MyTrie();
	assertTrue(test.add("love"));
	assertTrue(test.contains("love"));
	assertFalse(test.contains("lo"));
    }

    @Test
    void testContainsPrefix() {
	MyTrie test = new MyTrie();
	test.add("love");
	test.add("who");
	assertTrue(test.containsPrefix("lo"));
	assertFalse(test.containsPrefix("wo"));
	assertTrue(test.containsPrefix("wh"));
	
    }

    @Test
    void testAdd() {
	MyTrie test = new MyTrie();
	assertTrue(test.add("love"));
	assertEquals(1,test.size());
	assertFalse(test.add("love"));
	assertTrue(test.add("who"));
	assertEquals(2,test.size());
	assertTrue(test.add("lofi"));
	assertEquals(3,test.size());
	assertTrue(test.add("lovely"));
	assertEquals(4,test.size());
    }

    @Test
    void testIsEmpty() {
	MyTrie test = new MyTrie();
	assertTrue(test.isEmpty());
	test.add("love");
	assertFalse(test.isEmpty());
    }

    @Test
    void testToString() {
	MyTrie test = new MyTrie();
	ArrayList<String> real = new ArrayList<String>();
	test.add("aa");
	test.add("aah");
	test.add("aas");
	test.add("lofi");
	real.add("lofi");
	real.add("love");
	real.add("lovely");
	real.add("who");
	System.out.println(test.toList());
	Iterator<String> realIte = real.iterator();
	Iterator<String> testIte = test.iterator();
	while(testIte.hasNext() && realIte.hasNext()) {
	    assertEquals(realIte.next(),testIte.next());
		assertEquals(realIte.next(),testIte.next()); 
	}
    }

    @Test
    void testIterator() {
	MyTrie test = new MyTrie();
	ArrayList<String> real = new ArrayList<String>();
	test.add("love");
	test.add("who");
	test.add("lovely");
	test.add("lofi");
	real.add("lofi");
	real.add("love");
	real.add("lovely");
	real.add("who");
	Iterator<String> realIte = real.iterator();
	Iterator<String> testIte = test.iterator();
	while(testIte.hasNext() && realIte.hasNext()) {
	    assertEquals(realIte.next(),testIte.next());
		assertEquals(realIte.next(),testIte.next()); 
	}
    }
    

}
