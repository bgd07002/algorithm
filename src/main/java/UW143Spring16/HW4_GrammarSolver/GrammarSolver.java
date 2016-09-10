package UW143Spring16.HW4_GrammarSolver;

import java.io.*;
import java.util.*;

/**
 * Implementation of Barkus-Naur Form (BNF).
 * non-terminal ::= rule|rule|rule|...|rule
 * Any token that ever appears on the left side of ::= is considered non-terminal.
 */
public class GrammarSolver {

    private final String GRAMMAR_FILE = "GrammarBNFRules.txt";
    private Map<String, String[]> grammarSet;

    public Map<String, String[]> getGrammarSet() {
        return grammarSet;
    }

    public GrammarSolver() throws IOException {
        loadGrammarFromFile();
    }

    public String grammarTemplate(String nonTerminal) {
        if (!grammarSet.containsKey(nonTerminal))
            throw new IllegalArgumentException("Non-terminal doesn't exist on Grammar file");

        StringBuilder sb = new StringBuilder();
        sb = grammarTemplateHelper(nonTerminal, sb);
        return sb.toString().trim();
    }

    private StringBuilder grammarTemplateHelper(String nonTerminal, StringBuilder sb) {
        String[] nonTerminalSet = grammarSet.get(nonTerminal);
        //Pick a random element
        int rnd = new Random().nextInt(nonTerminalSet.length);

        //Find out if it is a new non-terminal or just a word
        if (nonTerminalSet[rnd].contains(">") && nonTerminalSet[rnd].contains("<")) {
            String[] nonTerminalBranches = nonTerminalSet[rnd].trim().replace("<","").replace(">","").split(" ");
            for (String aBranch : nonTerminalBranches) {
                sb = grammarTemplateHelper(aBranch, sb);
            }
        } else { //Those are words
            sb.append(nonTerminalSet[rnd].trim()).append(" ");
        }
        return sb;
    }

    /**
     * Method for read the file and return as Map<String, List<String>>
     */
    private void loadGrammarFromFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(GRAMMAR_FILE).getFile());

        String key;
        String[] valueSet;
        grammarSet = new LinkedHashMap<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                key = line.substring(0, line.indexOf("::=")).trim().replace("<","").replace(">","");
                valueSet = line.substring(line.indexOf("=")+1).split("\\|");
                grammarSet.put(key, valueSet);
            }
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
