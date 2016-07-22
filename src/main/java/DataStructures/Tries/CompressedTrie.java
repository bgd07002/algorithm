package DataStructures.Tries;


public class CompressedTrie extends Trie {

    private Trie trie;

    public CompressedTrie(Trie trie) {
        this.trie = trie;
        convertToCompressedTrie();
    }

    private void convertToCompressedTrie() {
        TrieNode root = trie.getRoot();
        for (TrieNode node : root.getChildren()) {
            if (node.getChildren() != null && node.getChildren().size() == 1)
                convertCompressedTrieHelper(node);
        }
    }

    private void convertCompressedTrieHelper(TrieNode parent) {

    }

    @Override
    public boolean hasString(String s) {
        return false;
    }

    @Override
    public boolean removeString(String s) {
        return false;
    }
}
