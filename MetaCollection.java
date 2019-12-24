package hw5;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MetaCollection<E> extends AbstractCollection<E> {
	//keep reference added collections in this list
	private final ArrayList<Collection<E>> collectionList = new ArrayList<Collection<E>>();
	//is the only Collection<T> you may use as a field. 
	//In particular, you may not create additional Collection<E>s.
	  
	//A JoinedIter instance iterates through all Es of the Collection<E>s the MetaCollection<E> consists of.
	private class JoinedIter implements Iterator<E> {
		private int itrCounter = 0;
		private Iterator<E> bigItr;
		//private Iterator<Collection<E>> collectionItr;
		private int index = 0; //for getter

		private JoinedIter() {
			index = 0; //set index to zero 
			bigItr = collectionList.get(0).iterator(); //grab first element 
		}
		public boolean hasNext() {
			return itrCounter < size();
		}
		public E next() {
			if(!bigItr.hasNext()) {
				index = index + 1; //incremen t
				bigItr = collectionList.get(index).iterator(); //grab element at index
			}
			itrCounter++;
			return bigItr.next();
		}
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	public MetaCollection(Collection<E>... c_arr) {
		for (Collection<E> i : c_arr)
			collectionList.add(i);
	}
	  
	public void addCollection(Collection<E> coll) {
	    collectionList.add(coll);
	}
	  
	@Override
	public Iterator<E> iterator() {
	    return new JoinedIter();
	}

	@Override
	public int size() {
		int size = 0;
		for(Collection<E> i : collectionList) {
			//first sum individual list
			//get index value for each value in 
			//add to overall total
			size = size + i.size();
		}
		return size;

	}

}