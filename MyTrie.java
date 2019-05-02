

import java.util.ArrayList;
import java.util.Iterator;

public class MyTrie {
    
    boolean isWord;
    int size;
    MyTrie[] children;
    static final int cap = 26;
    
    public MyTrie(){
	isWord = false;
	size = 0;
	children = new MyTrie[cap]; 
    }
    public int size() {
	return size;
    }
    /**
     * Return true if and only if the trie contains the empty string. 
     * (This method just returns the isWord flag in the root of the Trie.)
     * Actually I don't know about this.
     * @return
     */
    public boolean containsEmptyString() {
	return this.isWord;
    }
    /**
     * Return true if the trie contains the given string, false otherwise.
     * This should use recursion (on the Trie children).
     * @param string
     * @return
     */
    public boolean contains(String string) {
	int index = string.substring(0,1).hashCode()-"a".hashCode();
	if(this.children[index]== null) {
	    return false;
	}
	if(string.length()>1) {
	    children[index].contains(string.substring(1));
	}
	if(children[index].isWord == true) {
	    return true;
	}
	return false;
    }
    /**
     * Return true if the trie contains the edges represented by prefix, false otherwise. 
     * Note that this is not checking isWord values, just existence of the appropriate children. 
     * As soon as one of the expected children is not present, return false.
     * This should use recursion (on the Trie children).
     * @param prefix
     * @return
     */
    public boolean containsPrefix(String prefix) {
	int index = prefix.substring(0,1).hashCode()-"a".hashCode();
	if(this.children[index]== null) {
	    return false;
	}
	
	if(prefix.length()>1) {
	    children[index].containsPrefix(prefix.substring(1));
	}
	return true;
    }
    /**
     * Insert string in the trie, if it is not already present. 
     * Return true if and only if the trie is modified by this operation. 
     * You may need to update size as well.
     * This should use recursion (on the Trie children).

     * @param string
     * @return
     */
    public boolean add(String string) {
	int index = string.substring(0,1).hashCode()-"a".hashCode();
	if(this.children[index]== null) {
	    MyTrie newLetter = new MyTrie();
	    children[index] = newLetter;
	}
	if(string.length()>1) {
	    children[index].add(string.substring(1));
	}
	if (children[index].isWord == true) {
	    return false;
	}
	children[index].isWord = true;
	size ++;
	return true;
    }
    /**
     * Return true if the trie contains no strings, false otherwise.
     * @return
     */
    public boolean isEmpty() {
	return size == 0;
    }
    /**
     * Return a string representation of the set of strings contained in the trie.
     * Hint: Use the private method toList() described below; this should get you 
     * an arrayList of the strings in the Trie; you can then just return the result
     * of this arrayList's toString method.
     * @return
     */
    public String toString() {
	return this.toList().toString();
    }
    /**
     * Genereate an iterator over all the strings in the trie.
     * Hint: Lists have an iterator() method that produces what you need! 
     * Use your toList method to get you the list you desire.
     * @return
     */
    public Iterator<String> iterator(){
	return this.toList().iterator();
    }
    /**
     * Return a List of strings contained in the trie in alphabetical order.
     * Hint: Use a recursive helper method with a prefix string as an argument 
     * (probably with a second argument to store the results). 
     * You may have to think about this one for awhile, so give it some time. 
     * Build the method up incrementally. It won't necessarily be long (my implementation is 13 lines, 
     * and some of those are only squirrely braces), but it may take you a few tries. Ha ha, tries.
     * @return
     */
    
    private String help(String prefix, String result) {
	int index = prefix.substring(0,1).hashCode()-"a".hashCode();
	if(prefix.length()>1) {
	    children[index].help(prefix.substring(1),result);
	}else {
	    for(int i = 0; i<cap; i++) {
		    if(children[i] != null) {
			result = result + Character.toString((char)(i + "a".hashCode()));
		    }
		    children[index].help(result,result);
		    
	    }
	}
	return result;
    }
    
    private ArrayList<String> toList(){
	ArrayList<String> novel = new ArrayList<String>();
	for(int i = 0; i<cap; i++) {
	    if(children[i] != null) {
		String c = Character.toString((char)(i + "a".hashCode()));
		novel.add(help(c,c));
	    }
	}
	return novel;
    }
}
