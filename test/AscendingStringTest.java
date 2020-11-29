// Written by Caleb Bitting

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AscendingStringTest {

	AscendingString comparator;
	
	@BeforeEach
	void init() {
		comparator = new AscendingString();
	}
	
	@Test
	void compareTest() {
		assertEquals(comparator.compare("apple", "banana"), -1);
		assertEquals(comparator.compare("banana", "apple"), 1);
		assertEquals(comparator.compare("happy", "12345"), 0);
	}

}
