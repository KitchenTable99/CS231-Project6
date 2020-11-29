// Written by Caleb Bitting

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KeyValuePairTest {
	
	KeyValuePair<String, Double> pair;
	
	@BeforeEach
	void init() {
		pair = new KeyValuePair<String, Double>("Apple", 1.8);
	}

	@Test
	void constructorTest() {
		assertEquals(pair.getKey(), "Apple", "Key not key");
		assertEquals(pair.getValue(), 1.8, "Value not value");
	}
	
	@Test
	void mutatorTest() {
		pair.setValue(2.0);
		assertEquals(pair.getValue(), 2.0, "Cannot change value");
	}
	
	@Test
	void toStringTest() {
		assertEquals(pair.toString(), "<Apple, 1.8>", "toString method wrong");
	}
	
	@Test
	void equalsTest() {
		KeyValuePair<String, Double> sameKey, sameValue, same, different;
		sameKey = new KeyValuePair<String, Double>("Apple", 1.9);
		sameValue = new KeyValuePair<String, Double>("Orange", 1.8);
		same = new KeyValuePair<String, Double>("Apple", 1.8);
		different = new KeyValuePair<String, Double>("Orange", 1.9);
		assertFalse(pair.equals(sameKey), "same key different value was the same");
		assertFalse(pair.equals(sameValue), "different key same value was the same");
		assertTrue(pair.equals(same), "the same was different");
		assertFalse(pair.equals(different), "something entirely different was the same");
	}

}
