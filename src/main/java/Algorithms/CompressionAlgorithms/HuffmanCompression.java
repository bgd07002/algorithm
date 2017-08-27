package Algorithms.CompressionAlgorithms;

import DataStructures.HeapPriorityQueue.*;
import DataStructures.HeapPriorityQueue.Entry;
import DataStructures.Maps.*;
import DataStructures.Trees.BinaryTreeNode;
import Utility.CommonFunctions;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class HuffmanCompression {

    private IHeap<Integer, Object> pq;
    private ArrayList<String> plaintext;
    private HashMap<Character, String> encodingMap;

    public HuffmanCompression(String fileOrTxtInput) throws IOException {

        if (fileOrTxtInput.contains(".txt"))
            plaintext = CommonFunctions.loadDictionary(fileOrTxtInput, null);
        else {
            plaintext = new ArrayList<>();
            plaintext.add(fileOrTxtInput);
        }
        pq = new ArrayHeap<>();
        encodingMap = new HashMap<>();
        analyzeCharFrequency(plaintext);
        HuffmanTree ht = new HuffmanTree(pq);
        ht.generateHuffmanTreeMap();
        ht.buildEncodingMap();
    }

    public String encode() {
        StringBuilder sb = new StringBuilder();
        for (String s : plaintext) {
            for (char c : s.toCharArray())
                sb.append(encodingMap.get(c));
        }
        return sb.toString();
    }

    public String decode(String encoding) {
        StringBuilder decodedStr = new StringBuilder();

        String sTemp = "";
        for (char c: encoding.toCharArray()) {
            sTemp += Character.toString(c);
            for (char encodedChar : encodingMap.keySet())
                if (encodingMap.get(encodedChar).equals(sTemp)) {
                    decodedStr.append(encodedChar);
                    sTemp = "";
                }
        }
        return decodedStr.toString();
    }

    /**
     * Step 1: Analyze characters and build a min-heap for those
     */
    private void analyzeCharFrequency(ArrayList<String> textWords) {
        int[] charFrequency = new int[256];
        for (String s : textWords) {
            for (char c : s.toCharArray())
                charFrequency[(int)c]++;
        }

        for (int i =0; i< charFrequency.length; i++) {
            if (charFrequency[i] > 0) {
                pq.insert(new Entry<>(charFrequency[i], (char) i));
            }
        }
    }

    /**
     * Step 2: Generate Huffman tree as a bottom up approach
     */
    private class HuffmanTree {

        private IHeap<Integer, Object> heap;
        private HuffmanTreeNode root;
        private HuffmanTree(IHeap heap) {
            this.heap = heap;
        }

        /**
         * Remove two nodes and make them as child node.
         * Create a new node and insert it in PQ
         */
        private void generateHuffmanTreeMap() {

            while (heap.getSize() > 1) {
                Entry<Integer, Object> node1Entry = heap.extractMin();
                Entry<Integer, Object> node2Entry = heap.extractMin();

                HuffmanTreeNode node1 = null, node2 = null;
                if (node1Entry.getValue() instanceof Character)
                    node1 = new HuffmanTreeNode(node1Entry.getKey(), (char)node1Entry.getValue(), null, null);
                else if (node1Entry.getValue() instanceof HuffmanTreeNode)
                    node1 = (HuffmanTreeNode) node1Entry.getValue();

                if (node2Entry.getValue() instanceof Character)
                    node2 = new HuffmanTreeNode(node2Entry.getKey(), (char)node2Entry.getValue(), null, null);
                else if (node2Entry.getValue() instanceof HuffmanTreeNode)
                    node2 = (HuffmanTreeNode) node2Entry.getValue();

                //Character '\u001a' for internal node
                HuffmanTreeNode parent = new HuffmanTreeNode(node1.intValue + node2.intValue,'\u001a', node1, node2);
                pq.insert(new Entry<>(parent.intValue, parent));
            }
            if (pq.getMin().getValue() instanceof HuffmanTreeNode)
                root = (HuffmanTreeNode) pq.getMin().getValue();
            else //Tree consists of one element
                root = new HuffmanTreeNode(pq.getMin().getKey(), (char)pq.getMin().getValue(), null, null);
        }

        private void buildEncodingMap() {
            StringBuilder sb = new StringBuilder();
            buildEncodingMapHelper(root, sb);
        }

        private void buildEncodingMapHelper(HuffmanTreeNode node, StringBuilder sb) {
            if (node.leftNode != null) {
                if (node.intValue == root.intValue)
                    sb = new StringBuilder();
                StringBuilder sb1 = new StringBuilder(sb);
                buildEncodingMapHelper(node.leftNode, sb1.append("0"));
            }

            if (node.rightNode != null) {
                if (node.intValue == root.intValue)
                    sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder(sb);
                buildEncodingMapHelper(node.rightNode, sb2.append("1"));
            }

            if (node.leftNode == null && node.rightNode == null) {
                encodingMap.put(node.charValue, sb.toString());
            }
        }
    }

    private class HuffmanTreeNode {
        private HuffmanTreeNode rightNode;
        private HuffmanTreeNode leftNode;
        private int intValue;
        private char charValue;

        private HuffmanTreeNode(int intValue, char charValue, HuffmanTreeNode leftNode, HuffmanTreeNode rightNode) {
            this.charValue = charValue;
            this.intValue = intValue;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }
}
