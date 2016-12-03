// Brett Stevenson
// Email: BStevensonDev@gmail.com
// Hash Table
// Date Modified: 03/23/2016
// Entry.java (v1.4)
/* This class contains a custom data type to be stored in the Hash Table, which implements
   the Record interface. */
// Status: working/tested


public class Entry implements Record {

    private int key;
    private String data;

    public Entry(int newKey, String newData) {  // constructor
        this.key = newKey;
        this.data = newData;
    }

    @Override
    public Record clone() {
        //Record recordClone = new Rec(getID(), getData());
        return new Entry(getID(), getData());
    }

    @Override
    public int getID() { return this.key; }

    @Override
    public String getData() { return this.data; }

    @Override
    public String toString() {  // Overrides toString method for printing Entries
        return String.format("%09d", getID()) + getData();
    }
}
