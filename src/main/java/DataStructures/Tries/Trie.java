package DataStructures.Tries;

import java.util.ArrayList;

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode('&');
    }

    public void addString(String s) {
        if (s == null || s.length() < 1)
            return;

        TrieNode cur = root;
        for (char ch : (s + "$").toCharArray()) {
            ArrayList<TrieNode> listNodes = cur.getChildren();

            boolean isMatchOK = false;
            for (TrieNode node : listNodes) {
                if (node.getValue() == ch) {
                    isMatchOK = true;
                    cur = node;
                    break;
                }
            }

            if (!isMatchOK) {
                listNodes.add(new TrieNode(ch));
                cur = listNodes.get(listNodes.size()-1);
            }
        }
    }

    public boolean hasString(String s) {

        TrieNode cur = root;
        for (char ch : (s + "$").toCharArray()) {
            ArrayList<TrieNode> listNodes = cur.getChildren();

            boolean isMatchOK = false;
            for (TrieNode node : listNodes) {
                if (node.getValue() == ch) {
                    isMatchOK = true;
                    cur = node;
                    break;
                }
            }

            if (!isMatchOK)
                return false;
        }
        return true;
    }

    public boolean removeString(String s) {

        TrieNode cur = root;
        ArrayList<TrieNode> listToBePurged = new ArrayList<>();
        int nodeIdxToBePurged = -1;

        for (char ch :  (s + "$").toCharArray()) {
            ArrayList<TrieNode> listNodes = cur.getChildren();
            boolean isMatchOK = false;

            for (int i =0; i< listNodes.size(); i++) {
                if (listNodes.get(i).getValue() == ch) {
                    isMatchOK = true;
                    if (listNodes.get(i).getChildren() != null &&
                            listNodes.get(i).getChildren().size() <= 1 &&
                            listNodes.size() >1) {

                        nodeIdxToBePurged = i;
                        listToBePurged = listNodes;
                    }
                    cur = listNodes.get(i);
                    break;
                }
            }

            if (!isMatchOK)
                return false;
        }

        listToBePurged.remove(nodeIdxToBePurged);
        return true;
    }

    private class TrieNode {

        private ArrayList<TrieNode> childTrieNodes;
        private char value;

        public TrieNode(char value) {
            childTrieNodes = new ArrayList<>();
            this.value = value;
        }

        public ArrayList<TrieNode> getChildren() { return childTrieNodes; }
        public char getValue() { return value; }
    }
}
