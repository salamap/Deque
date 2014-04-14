Deque
=====
This is a generic data type for a deque and a randomized queue, implemented using arrays and linked lists.

Dequeue. A double-ended queue or deque (pronounced "deck") is a generalization of a stack and a queue that supports inserting and removing items from either the front or the back of the data structure

The API:
public class Deque<Item> implements Iterable<Item> {
   public Deque()                           // construct an empty deque
   public boolean isEmpty()                 // is the deque empty?
   public int size()                        // return the number of items on the deque
   public void addFirst(Item item)          // insert the item at the front
   public void addLast(Item item)           // insert the item at the end
   public Item removeFirst()                // delete and return the item at the front
   public Item removeLast()                 // delete and return the item at the end
   public Iterator<Item> iterator()         // return an iterator over items in order from front to end
   public static void main(String[] args)   // unit testing
}

Throws a NullPointerException if the client attempts to add a null item; throws a java.util.NoSuchElementException if the client attempts to remove an item from an empty deque; throws an UnsupportedOperationException if the client calls the remove() method in the iterator; throws a java.util.NoSuchElementException if the client calls the next() method in the iterator and there are no more items to return.

The implementation supports each deque operation in constant worst-case time and uses space proportional to the number of items currently in the deque. Additionally, the iterator implementation supports the operations next() and hasNext() (plus construction) in constant worst-case time and use a constant amount of extra space per iterator.

Randomized queue. A randomized queue is similar to a stack or queue, except that the item removed is chosen uniformly at random from items in the data structure.

The API:
public class RandomizedQueue<Item> implements Iterable<Item> {
   public RandomizedQueue()                 // construct an empty randomized queue
   public boolean isEmpty()                 // is the queue empty?
   public int size()                        // return the number of items on the queue
   public void enqueue(Item item)           // add the item
   public Item dequeue()                    // delete and return a random item
   public Item sample()                     // return (but do not delete) a random item
   public Iterator<Item> iterator()         // return an independent iterator over items in random order
   public static void main(String[] args)   // unit testing
}

Throws a NullPointerException if the client attempts to add a null item; throws a java.util.NoSuchElementException if the client attempts to sample or dequeue an item from an empty randomized queue; throws an UnsupportedOperationException if the client calls the remove() method in the iterator; throws a java.util.NoSuchElementException if the client calls the next() method in the iterator and there are no more items to return.

The implementation supports each randomized queue operation (besides creating an iterator) in constant amortized time and uses space proportional to the number of items currently in the queue. That is, any sequence of M randomized queue operations (starting from an empty queue) should take at most cM steps in the worst case, for some constant c. Additionally, the iterator implementation supports construction in time linear in the number of items and it supports the operations next() and hasNext() in constant worst-case time. The order of two or more iterators to the same randomized queue are mutually independent; each iterator maintains its own random order.
