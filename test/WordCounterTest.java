// Written by Caleb Bitting

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordCounterTest {
	
	WordCounter counter;
	
	@BeforeEach
	void init() {
		counter = new WordCounter();
		counter.analyze("/Users/cbitting/eclipse-workspace/Project06/test/counttest.txt");		
	}
	
	@Test
	void analyzeTest() {
		assertEquals("[<was, 4>, <best, 1>, <age, 2>, <times, 2>, <foolishness, 1>, <worst, 1>, <wisdom, 1>]", counter.getMap().entrySet().toString()); // debug it yourself
		// should be [<was, 4>, <best, 1>, <age, 2>, <times, 2>, <foolishness, 1>, <worst, 1>, <wisdom, 1>]
	}
	
	@Test
	void getterTests() {
		assertEquals(7, counter.getUniqueWordCount(), "Unique words");
		assertEquals(12, counter.getWordCount(), "Total words");
		assertEquals(4, counter.getCount("was"), "Count of the word 'was'");
		assertEquals(1, counter.getCount("best"), "Count of the word 'best'");
		assertEquals(1./3., counter.getFrequency("was"), "Frequency of the word 'was'");
		assertEquals(1./12., counter.getFrequency("best"), "Frequency of the word 'best'");
	}
	
	@Test
	void writeFileTest() {
		counter.writeFile("test.txt");
		// check that a file was written in the project directory
	}
	

}
