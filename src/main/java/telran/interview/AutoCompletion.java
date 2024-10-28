package telran.interview;

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class AutoCompletion {

    private Set<String> wordsSet;

    public AutoCompletion(){
        wordsSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
    }

	public boolean addWord(String word) {
        return wordsSet.add(word);
	}

	public String [] getVariants(String prefix) {
        String start = prefix.toLowerCase();
        String end = prefix.toLowerCase() + Character.MAX_VALUE;

        NavigableSet<String> subset = ((TreeSet<String>) wordsSet).subSet(start, true, end, true);
        return subset.toArray(new String[0]);
	}
}
