package markov_text_generator;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by alibin on 1/28/16.
 *
 */
public class TextGenerator {

    public TextGenerator(Random rnd) {
        this.rnd = rnd;
    }

    private Map<String, WordStat> wordStats = new HashMap<>();

    public void train(String text) {
        String[] words = text.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            WordStat wordStat = wordStats.get(word);
            if (wordStat == null) {
                wordStat = new WordStat(word);
                wordStats.put(word, wordStat);
            }
            if (i + 1 < words.length) {
                wordStat.addNext(words[i + 1]);
            }
        }
    }

    private Random rnd = new Random();

    private WordStat pickFirstRandomly() {
        return wordStats.get(wordStats.keySet().toArray()[rnd.nextInt(wordStats.size())]);
    }

    public String generate(Integer length) {
        return generate(length, true);
    }
    public String generate(Integer length, boolean exactLength) {
        if (wordStats.isEmpty()) {
            throw new IllegalStateException("Generator is not trained");
        }
        StringBuilder sb = new StringBuilder();
        WordStat currentWord = pickFirstRandomly();
        while (length > 0 && currentWord != null) {
            sb.append(' ');
            sb.append(currentWord.word);
            currentWord = pickNext(currentWord);
            if (currentWord == null && exactLength) {
                currentWord = pickFirstRandomly();
            }
            length--;
        }
        return sb.append('.').toString();
    }

    private WordStat pickNext(WordStat currentWord) {
        if (!currentWord.nextWords.isEmpty())
            return wordStats.get(currentWord.pickNext(rnd));
        return null;
    }

}
