package UW143Spring16.HW4_GrammarSolver;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashSet;

public class GrammarSolverTest {

    @Test
    public void grammarSolverTest() throws IOException {
        GrammarSolver g = new GrammarSolver();
        String nonTerminal = "s";
        String sentence = g.grammarTemplate(nonTerminal);
        System.out.println("Sentence: " + sentence);

        //Construct the pool for sentences
        HashSet<String> set = new HashSet<>();
        for (int i =0; i < 50000; i++) {
            set.add(g.grammarTemplate(nonTerminal));
        }
        System.out.println("Number of elements in the HashSet: " + set.size());
        Assert.assertEquals(true, sentence.matches("[a-zA-Z]+(\\s+[a-zA-Z]+)*"));
        Assert.assertEquals(true, set.contains(sentence));
    }
}
