package markov_text_generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by alibin on 1/28/16.
 */
public class WordStat {
    String word;
    List<String> nextWords = new ArrayList<>();

    public WordStat(String word) {
        this.word = word;
    }

    public void addNext(String word) {
        nextWords.add(word);
    }

    public String pickNext(Random rnd) {
        if (!nextWords.isEmpty())
            return nextWords.get(rnd.nextInt(nextWords.size()));
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WordStat wordStat = (WordStat) o;

        if (!word.equals(wordStat.word)) return false;
        return nextWords != null ? nextWords.equals(wordStat.nextWords) : wordStat.nextWords == null;

    }

    @Override
    public int hashCode() {
        int result = word.hashCode();
        result = 31 * result + (nextWords != null ? nextWords.hashCode() : 0);
        return result;
    }
}
