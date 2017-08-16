package DataStructures.Tries;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Trie implements ITrie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode('&');
    }

    public TrieNode getRoot() {
        return root;
    }

    @Override
    public void addString(String s) {
        s += "$";
        char[] sArr = s.toCharArray();
        TrieNode curNode = root;
        for (char c: sArr) {
            ArrayList<TrieNode> children = curNode.getChildren();
            TrieNode temp = null;
            for (TrieNode aChildNode : children) {
                if (aChildNode.getValue() == c) {
                    temp = aChildNode;
                    break;
                }
            }
            if (temp == null) {
                temp = new TrieNode(c, curNode);
                children.add(temp);
            }
            curNode = temp;
        }
    }

    @Override
    public boolean hasString(String s) {
        s += "$";
        char[] sArr = s.toCharArray();
        TrieNode cur = root;
        for (char c : sArr) {
            ArrayList<TrieNode> children = cur.getChildren();
            TrieNode temp = null;
            for (TrieNode aChild : children) {
                if (aChild.getValue() == c) {
                    temp = aChild;
                    break;
                }
            }

            if (temp == null)
                return false;
            cur = temp;
        }
        return true;
    }

    @Override
    public boolean removeString(String s) {
        s += "$";
        char[] sArr = s.toCharArray();
        TrieNode cur = root;
        for (char c: sArr) {
            ArrayList<TrieNode> children = cur.getChildren();
            TrieNode temp = null;
            for (TrieNode aChild: children) {
                if (aChild.getValue() == c) {
                    temp = aChild;
                    break;
                }
            }
            cur = temp;
            if (temp == null)
                return false;
        }

        if (cur.getValue() == '$') {
            while (cur != root) {
                if (cur.getParent().getChildren().size() > 1) {
                    ArrayList<TrieNode> siblings = cur.getParent().getChildren();
                    siblings.remove(cur);
                    return true;
                }
                cur = cur.getParent();
            }
        }
        return true;
    }

    @Override
    public String allStrings() {
        return allStringsHelper(root).toString().replace("$", " ").trim();
    }

    private StringBuilder allStringsHelper(TrieNode node) {
        StringBuilder sb = new StringBuilder();

        int numElem =0;
        for (TrieNode aNode : node.getChildren()) {
            if (numElem > 0) {
                Stack<Character> stack = new Stack<>();
                TrieNode cur = node;
                while (!cur.equals(root)) {
                    stack.push(cur.getValue());
                    cur = cur.getParent();
                }

                while(stack.size() > 0)
                    sb.append(stack.pop());
            }

            sb.append(aNode.getValue());
            sb.append(allStringsHelper(aNode));
            numElem++;
        }
        return sb;
    }

    @Override
    public String prefixMatches(String prefix) {

        char[] prefixArr = prefix.toCharArray();
        TrieNode cur = root;
        for (int i=0; i < prefixArr.length; i++) {
            char c = prefixArr[i];
            cur = cur.getChildren().stream().filter(e -> c == e.getValue()).findAny().orElse(null);

            if (cur == null)
                return null;
        }
        return prefix+allStringsHelper(cur).toString().replace("$", " ").trim();
    }

    protected class TrieNode {
        private ArrayList<TrieNode> childTrieNodes;
        private TrieNode parent;
        private char value;

        public TrieNode(char value) {
            childTrieNodes = new ArrayList<>();
            this.value = value;
        }

        public TrieNode(char value, TrieNode parent) {
            childTrieNodes = new ArrayList<>();
            this.parent = parent;
            this.value = value;
        }

        public ArrayList<TrieNode> getChildren() { return childTrieNodes; }
        public TrieNode getParent() { return parent; }
        public char getValue() { return value; }
    }
}
