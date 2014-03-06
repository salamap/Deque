import java.util.NoSuchElementException;
import java.util.Iterator;

public class Deque<Item> implements Iterable<Item>
{
    private Node<Item> head;
    private Node<Item> tail;
    private int size;
    
    private static class Node<Item>
    {
    	private Item data;
    	private Node<Item> next;
    	private Node<Item> prev;
    }
	
    public Deque() 
    {
	    this.head = null;
	    this.tail = null;
	    this.size = 0;
    }
	
    public boolean isEmpty()
    {
    	return size == 0;
    }
	
	public int size()
    {
	    return size;
	}
	
	public void addFirst(Item item)
	{
		if (item == null)
		{
			throw new NullPointerException();
		}
		if (!isEmpty())
		{
			head.prev = new Node<Item>();
			head.prev.data = item;
			head.prev.prev = null;
			head.prev.next = head;
			head = head.prev;
		}
		else
		{
			head = new Node<Item>();
			head.data = item;
			head.next = null;
			head.prev = null;
			tail = head;
		}
        size++;
        return;
	}
	
	public void addLast(Item item)
	{
		if (item == null)
		{
			throw new NullPointerException();
		}
		if (!isEmpty())
		{
			tail.next = new Node<Item>();
			tail.next.data = item;
			tail.next.next = null;
			tail.next.prev = tail;
			tail = tail.next;
		}
		else
		{
			tail = new Node<Item>();
			tail.data = item;
			tail.next = null;
			tail.prev = null;
			head = tail;
		}
		size++;
		return;
	}
	
	public Item removeFirst()
	{
		if (isEmpty())
		{
			throw new NoSuchElementException();
		}
		Item removed = head.data;
		head = head.next;
		size--;
		if (!isEmpty())
		{
			head.prev = null;
		}
		else
		{
			tail = null;
		}
		return removed;
	}
	
	public Item removeLast()
	{
		Item removed;
		if (isEmpty())
		{
			throw new NoSuchElementException();
		}
		removed = tail.data;
		tail = tail.prev;
		size--;
		if (!isEmpty())
		{
			tail.next = null;
		}
		else
		{
			head = null;
		}
		return removed;
	}
    
    @Override
	public Iterator<Item> iterator()
	{
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>
	{
        private Node<Item> current = head;
        
		@Override
		public boolean hasNext()
		{
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			if (!hasNext())
			{
                throw new NoSuchElementException();
            }
			Item item = current.data;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}
		
	}

	public static void main(String[] args) {
    // TODO Auto-generated method stub
		Deque<String> q = new Deque<String>();
		StdOut.println("Current size " + q.size());
		String[] input = {"to", "be", "or", "not", "to", "be"};
		for (String s : input)
		{
		    q.addLast(s);	
		}
		StdOut.println("Current size " + q.size());
		Iterator<String> i = q.iterator();
		while (i.hasNext())
		{
			String s = i.next();
			StdOut.println(s);
		}
		StdOut.println();
		while (!q.isEmpty())
		{
				StdOut.println(q.removeLast());
				StdOut.println("Current size " + q.size());
		}
    }
}
