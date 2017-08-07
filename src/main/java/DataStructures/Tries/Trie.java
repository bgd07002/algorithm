package DataStructures.Tries;

import java.util.ArrayList;
import java.util.List;

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
        return allStringsHelper(root).toString();
    }

    private StringBuilder allStringsHelper(TrieNode node) {
        StringBuilder sb = new StringBuilder();
        for (TrieNode aNode : node.getChildren()) {
            sb.append(aNode.getValue());
            sb.append(allStringsHelper(aNode));
        }

        return sb;
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




















    /*
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
    */


}
