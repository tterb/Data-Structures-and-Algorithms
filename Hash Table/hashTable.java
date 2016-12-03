// Brett Stevenson
// Email: BStevensonDev@gmail.com
// Hash Table
// Date Modified: 03/23/2016
// HashTable.java (v1.4)
/* This class contains a Hash Table implementation which stores Records. This implementation
   utilizes the multiplication method for hashing, and resolves collisions within the table
   using the chaining method. */
// Status: working/tested


import java.util.ArrayList;


public class HashTable {

    private int size = 100;  // default hash table size
    private ArrayList<ArrayList<Record>> table = new ArrayList<>();

    public hashTable() {   // default constructor
        for(int i = 0; i < size; i++)
            table.add(new ArrayList<>());
    }

    public hashTable(int n) {  // overloaded constructor
        size = n;  // input size
        for(int i = 0; i < size; i++)
            table.add(new ArrayList<>());   // creates the correct amount of ArrayLists for the table
    }

    public void insert(Record rec) {  // inserts the given Record into the hash table
        Record newEntry = rec.clone(); // clone to prevent privacy leak
        int hashKey = hash(newEntry);
        table.get(hashKey).add(newEntry);
    }


    public void delete(int key) {  // If found, deletes the first Record at with the given key
        if (find(key) != null) {
            table.get(hash(key)).remove(0);
            System.out.println("Your data has been deleted");
        }
    }


    public Record search(int key) {  // If found, returns the Record with the given key
//        Record rec = find(key);
        return find(key);
    }


    private Record find(int key) {  // finds the Record with the given key within the hash table
        int hashKey = hash(key);
        int size = table.get(hashKey).size();
        for(int i = 0; i < size; i++) {
            if (table.get(hashKey).get(i).getID() == key)
                return table.get(hashKey).get(i);
        }
        System.out.println("The key \"" + key + "\"" + " was not found in the table");
        return null;
//        if(table.get(hashKey).size() > 0) {
//            return table.get(hashKey).get(0);
//        } else {
//            System.out.println("The key \"" + key + "\"" + " was not found in the table");
//            return null;
//        }
    }


    private int hash(Record rec) {  // generates a unique index for the Record
        double constant = (Math.sqrt(5) - 1)/2;
        int hashKey = (int) (table.size() * ((rec.getID() * constant) - Math.floor(rec.getID() * constant)));
        return hashKey;
    }


    private int hash(int key) {  // overloaded hash method (used by find())
        double constant = (Math.sqrt(5) - 1)/2;
        int hashKey = (int) (table.size() * ((key * constant) - Math.floor(key * constant)));
        return hashKey;
    }


    public void clear() {  // clears all Records from the hash table
        for(ArrayList<Record> list : table) {
            list.clear();
        }
    }

    public String toString() {  // overloads the table's toString() to format saved hash table
        StringBuilder sb = new StringBuilder();
        for(ArrayList<Record> list : table)
            for(Record rec : list) {
                sb.append(rec);
                sb.append("\n");
            }
        return sb.toString();
    }
}
