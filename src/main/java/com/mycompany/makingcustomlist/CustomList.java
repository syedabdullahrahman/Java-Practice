package com.mycompany.makingcustomlist;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

import org.junit.jupiter.params.shadow.com.univocity.parsers.common.fields.FieldIndexSelector;

/**
*
* @author Abdullah
*/

public class CustomList<E> {

	/** Denoting the current size */
	private int size;
	
	/** Pointing to the next element 
	 * and also denoting the current size of List*/
	private int nextElement;
	
	/** Data holder for CustomList */
	private Object[] array;
	
	
	/** The amount of space that will be  further allocated */
	private final int INCREMENT = 5;

	/**
	 * Initializing the CustomList with initial memory allocation for 5 elements
	 * next element poinint to ) index
	 * */
    public CustomList() {
        size = 5;
        nextElement = 0;
        array = new Object[size];
    }

    public CustomList<E> add(E e) {
        // TODO Auto-generated method stub
        if (nextElement == size) {
            reallocation(INCREMENT);
        }
        array[nextElement] = e;
        nextElement++;
        return this;
    }
    
    public Object get(int pos) {
        if (pos < 0) {
            return NullPointerException.class;
        } else if (pos > nextElement) {
            return ArrayIndexOutOfBoundsException.class;
        } else {
            return array[pos];
        }
    }

    /**
     * nextElement pointing the size of the list
     */
    public int size() {
        return nextElement;
    }

    public CustomList<E> addAll(Collection<? extends E> c) {
    	/**
    	 * Need some more space. Thst's why calculating how much memory needed 
    	 * Then allocating it 
    	 * 
    	 * */
        if (c.size() + nextElement > size) {
            reallocation(c.size() + nextElement - size);
        }
        System.arraycopy(c.toArray(), 0, array, this.size(), c.size());
        
        /**
         * Incrementing the size which is also the nextElement pointer 
         * 
         * */
        nextElement += c.size();
        return this;
    }

    /**
     *	Reallocating memory for space shortage 
     */
    
    private boolean reallocation(int increment) {
        size += increment;
        array = Arrays.copyOf(array, size);
        return true;
    }

    public Object remove(E object) {
    	int pos = find(object);
        if (pos < 0) {
            return NullPointerException.class;
        } else if (pos > nextElement) {
            return ArrayIndexOutOfBoundsException.class;
        } 
        else if(pos==-1) {
			
		}else {
            System.arraycopy(array, pos + 1, array, pos, nextElement-pos-1);
            nextElement--;
            array[nextElement]=null;
        }
        return true;
    }
    /**
     * Find the object in CustomList and return the position of that object
     * */
	public int find(E object) {
		int pos = -1;
		for(int i=0;i<nextElement;i++)
			if(array[i].equals(object)) return pos;
		return pos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + INCREMENT;
		result = prime * result + Arrays.hashCode(array);
		result = prime * result + nextElement;
		result = prime * result + size;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomList<?> other = (CustomList<?>) obj;
		if (INCREMENT != other.INCREMENT)
			return false;
		if (!Arrays.equals(array, other.array))
			return false;
		if (nextElement != other.nextElement)
			return false;
		return true;
	}

	public void clear() {
        /**
         *  Need to prepare another method for allocation
		*/
        nextElement = 0;
        size = 5 ;
        array = (E[]) new Object[5];
    }

	@Override
	public String toString() {
		return "CustomList [size=" + size + ", nextElement=" + nextElement + ", array=" + Arrays.toString(array)
				+ ", INCREMENT=" + INCREMENT + "]";
	}

	public boolean isEmpty() {
        return nextElement==0;
    }
}
