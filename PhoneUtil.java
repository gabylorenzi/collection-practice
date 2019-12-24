package hw5;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;

import java.math.BigInteger;
import java.util.*;
import java.util.function.Predicate;

public class PhoneUtil {
	public static void prependOne(Map<String,BigInteger> m) {
		//map m is a phone book representation 
		//maps strings (names) to bigIntegers (phone numbers)

		//must go through every person in the phone book 
		//and add a one to the front of their phone numebr
		BigInteger tempNumber;
		String tempString;
		Long long1;
		for (Map.Entry<String, BigInteger> entry: m.entrySet()) {
			//go through every person in the phone book and get their phone number
			tempNumber = entry.getValue();
			//change it to a string
			tempString = String.valueOf(tempNumber);
			//concatenate 1
			tempString = "1" + tempString;
			//make new bigInt from string
			BigInteger bigIntString = new BigInteger(tempString);
			//replace value in map
			m.replace(entry.getKey(), tempNumber, bigIntString);
		}
	}
}