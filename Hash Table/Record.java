// Brett Stevenson
// Email: therealbrettstevenson@gmail.com
// Account: bstevens
// Assignment #5: Hash Table
// Date Modified: 03/23/2016
// Record.java (v1.4)
/* This class provides an Cloneable Interface for data types entered into the Hash Table. */
// Status: working/tested
//

public interface Record extends Cloneable {

    public Record clone();

    public int getID();

    public String getData();

    public String toString();
}
