// Written by Caleb Bitting
// Project06
// WordCountere class

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WordCounter {
	
	private BSTMap<String, Integer> map;
	
	public WordCounter() {
		map = new BSTMap<String, Integer>();
	}
	
	/**
	 * @param word to check against the 20 most popular words
	 * @return boolean representing if the word passed is among the most popular or not
	 */
	private static boolean noNoWord(String word) {
		boolean toReturn = false;
		String[] noNoWords = new String[] {"the", "be", "to", "of", "and", "a", "in", "that", "have", "i", "it", "for", "not", "on", "with", "he", "as", "you", "do", "at"};
		for (String s : noNoWords) {
			if (s.equals(word)) {
				toReturn = true;
			}
		}
		return toReturn;
	}
	
	/**
	 * @param filename is a string pointing to a file to read 
	 */
	public void analyze(String filename) {
		
		try {
		// set up objects
    	FileReader reader = new FileReader(filename);
    	BufferedReader bufferedReader = new BufferedReader(reader);

    	// go through each line
    	String line = bufferedReader.readLine();
    	while (line != null) {
    		// split by any non letter character
    		String[] words = line.split("[^a-zA-Z0-9']");
    		// remove spaces
    	    for (int i = 0; i < words.length; i++) {
    	        String word = words[i].trim().toLowerCase();
    	        // only consider actual letters and not the 20 most popular words
    	        if (word.length() > 0 && !WordCounter.noNoWord(word)) {
    	        	// if word already present
    	        	if (map.containsKey(word)) {
    	        		int currentValue = map.get(word);
    	        		map.put(word, currentValue + 1);
    	        	} else {
	        		// if new word 
    	        		map.put(word, 1);
    	        	}
    	        }
    	    }
    		line = bufferedReader.readLine();
    	}
    	// close reader
    	bufferedReader.close();
		} catch (IOException e) {
			;
		}
	}
	
	/**
	 * @return the BSTMap object
	 */
	public BSTMap<String, Integer> getMap() {
		return map;
	}
	
	/**
	 * @return the number of words in the read file
	 */
	public int getWordCount() {
		// in order to deal with reading in values greater than 1
		ArrayList<Integer> values = map.values();
		int total = 0;
		for (int i : values) {
			total += i;
		}
		return total;
	}
	
	/**
	 * @return the number of unique words in the read file
	 */
	public int getUniqueWordCount() {
		ArrayList<String> words = map.keySet();
		return words.size();
	}
	
	/**
	 * @param word is the word to search for
	 * @return the number of times that word was present in the read file
	 */
	public int getCount(String word) {
		return map.get(word);
	}
	
	/**
	 * @param word is the word to search for
	 * @return percent of the total words that the searched word comprises
	 */
	public double getFrequency(String word) {
		double size = this.getWordCount();
		double wordCount = this.getCount(word);
		return wordCount/size;
	}
	
	/**
	 * @param filename is the name of which to write the entryset to
	 */
	public void writeFile(String filename) {
		try {	      
		    // creates a FileWriter Object
	        FileWriter writer = new FileWriter(filename); 
		    
		    // Writes the content to the file
		    writer.write(map.entrySet().toString()); 
		    writer.close();
		} catch (IOException e){
			;
		}
	}
	
	/**
	 * @param input is a string to strip character from
	 * @param strip is a string of characters to strip
	 * @return input stripped of characters in strip
	 */
	private static String stripChars(String input, String strip) {
	    StringBuilder result = new StringBuilder();
	    for (char c : input.toCharArray()) {
	        if (strip.indexOf(c) == -1) {
	            result.append(c);
	        }
	    }
	    return result.toString();
	}
	
	/**
	 * @param filename is a string pointing to a file that is the output of writeFile
	 */
	public void readWordCountFile(String filename) {
		try {
			FileReader reader = new FileReader(filename);
	    	BufferedReader bufferedReader = new BufferedReader(reader);
	
	    	// read line
	    	String line = bufferedReader.readLine();
    		// split by commas
    		String[] words = line.split(",");
    		// remove all characters that aren't what we care about
    		for (int i = 0; i < words.length; i++) {
    			words[i] = WordCounter.stripChars(words[i], "[< >]"); 
    		}
    		// separate into words and counts
    		ArrayList<String> actualWords = new ArrayList<String>();
    		ArrayList<String> counts =  new ArrayList<String>();
    		for (int i = 0; i < words.length; i++) {	    			
    			if (i%2 == 0) {
    				actualWords.add(words[i]);
    			} else {
    				counts.add(words[i]);
    			}
    		}
    		// close reader
    		bufferedReader.close();
    		// iterate over both ArrayLists adding the nodes with their count
    		for (int i = 0; i < actualWords.size(); i++) {
    			String word = actualWords.get(i);
    			Integer count = Integer.parseInt(counts.get(i));
				map.put(word, count);
    		}
		} catch (IOException e) {
			;
		}
	}
	
	public static void main(String[] args) {
//		for (int i = 0; i < 8; i++) {
//			WordCounter counter = new WordCounter();
//			long start = System.currentTimeMillis();
//			counter.analyze(args[i]);
//			long end = System.currentTimeMillis();
//			System.out.println(end - start);
//			counter.writeFile(args[i + 8]);
//		}
		// the above uses 8 files in the command line
		
//		WordCounter counter = new WordCounter();
//		long start = System.currentTimeMillis();
//		counter.analyze(args[0]);
//		long end = System.currentTimeMillis();
//		System.out.println(end - start);
//		counter.writeFile(args[1]);
		// the above uses one file in the command line
		
		for (int i = 2008; i < 2016; i++) {
			WordCounter counter = new WordCounter();
			String foo = "BST" + i + ".txt";
			counter.readWordCountFile(foo);
			System.out.println(i);
			System.out.println("total: " + counter.getWordCount());
			System.out.println("unique: " + counter.getUniqueWordCount() +"\n");
		}
		//  the above uses the way I named things to output the necessary items
		
	}
	
}
