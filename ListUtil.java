package hw5;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;

import java.util.*;
import java.util.function.Predicate;

public class ListUtil {
	public static <E> ArrayList<E> merge(Collection<? extends E> c1, Collection <? extends E> c2) {
		//merge returns an ArrayList<E> that contains all elements of c1 and c2. use addAll method of List<E?
		ArrayList<E> merged = new ArrayList<E>();
		merged.addAll(c1);
		merged.addAll(c2);

		return merged;		 
	}

	public static <E> ArrayList<E> select(Collection<? extends E> coll, Predicate<? super E> pred) {
		//returns an ArrayList<E> that contains all elements 
		//of coll for which pred.test(..) evalulates to be true
		ArrayList<E> predTrue = new ArrayList<E>();

		//go through coll and see if pred.test is true for that eleemnt 
		for (E s: coll) {
			if (pred.test(s))
				predTrue.add(s);
		}

		return predTrue;
	}

}