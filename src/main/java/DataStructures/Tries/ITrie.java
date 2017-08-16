package DataStructures.Tries;

public interface ITrie {
    void addString(String s);
    boolean hasString(String s);
    boolean removeString(String s);
    String allStrings();
    String prefixMatches(String prefix);
}


