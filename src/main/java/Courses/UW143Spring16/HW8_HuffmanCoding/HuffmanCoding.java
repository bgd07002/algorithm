package Courses.UW143Spring16.HW8_HuffmanCoding;

import DataStructures.HeapPriorityQueue.*;
import DataStructures.Trees.BinaryTreeNode;
import Utility.CommonFunctions;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class HuffmanCoding {

    private IHeap<Integer, Character> pq;
    private BinaryTreeNode<Entry<Integer, Character>> huffmanRoot;
    private ArrayList<String> plaintextWords;
    private boolean foundEncodingChar;

    public HuffmanCoding(String fileOrTxtInput) throws IOException {
        pq = new ArrayHeap<>();
        if (fileOrTxtInput.contains(".txt"))
            plaintextWords = CommonFunctions.loadDictionary(fileOrTxtInput, null);
        else {
            plaintextWords = new ArrayList<>();
            plaintextWords.add(fileOrTxtInput);
        }
        analyzeCharFrequency(plaintextWords);
        HuffmanTree ht = new HuffmanTree(pq);
        huffmanRoot = ht.generateHuffmanTree();
    }

    private void analyzeCharFrequency(ArrayList<String> textWords) {
        int[] charFrequency = new int[256];
        for (String s : textWords) {
            for (char c : s.toCharArray())
                charFrequency[(int)c]++;
        }

        for (int i =0; i< charFrequency.length; i++) {
            if (charFrequency[i] > 0)
                pq.insert(new Entry<>(charFrequency[i], (char) i));
        }
        //Now add the character similar to EOF character
        pq.insert(new Entry<>(1, '\u001a'));
    }

    public String encode(String outputFileName) throws IOException {
        StringBuilder sbEncoded = new StringBuilder();
        for (String line : plaintextWords) {
            for (char c : line.toCharArray()) {
                foundEncodingChar = false;
                StringBuilder sb = getCharFromHuffmanTree(c, huffmanRoot, new StringBuilder());
                sbEncoded.append(sb);
            }
        }

        if (outputFileName != null) {
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
                writer.append(sbEncoded);
            }
        }

        return sbEncoded.toString();
    }

    private StringBuilder getCharFromHuffmanTree(char c, BinaryTreeNode<Entry<Integer, Character>> cur, StringBuilder sb) {

        if (cur.getLeftChild() == null && cur.getRightChild() == null) {
            if (cur.getData().getValue().charValue() == c) {
                foundEncodingChar = true;
                return sb;
            }
            else
                return sb.deleteCharAt(sb.length() - 1);
        }

        if (cur.getLeftChild() != null)
            sb = getCharFromHuffmanTree(c, cur.getLeftChild(), sb.append("0"));

        if (cur.getRightChild() != null)
            sb = getCharFromHuffmanTree(c, cur.getRightChild(), sb.append("1"));

        if (foundEncodingChar)
            return sb;

        return sb.deleteCharAt(sb.length() - 1);
    }

    /*if (!outputFileOrText.contains("0"))
        try (BufferedInputStream bufIn = new BufferedInputStream(new FileInputStream(outputFileOrText))) {}
    */

    public String decode(String outputFileOrText) throws IOException {
        StringBuilder sbPlaintext = new StringBuilder();
        String encodedText = outputFileOrText;

        if (!encodedText.matches("[01]+"))
            throw new IllegalArgumentException("Non-binary character on file or input contents");

        BinaryTreeNode<Entry<Integer, Character>> cur = huffmanRoot;
        for (char bit : encodedText.toCharArray()) {
            if (cur.getData().getValue().charValue() == '\u0000') {
                cur = (bit == '0') ? cur.getLeftChild() : cur.getRightChild();
            }

            if (cur.getData().getValue().charValue() != '\u0000') {
                sbPlaintext.append(cur.getData().getValue().charValue());
                cur = huffmanRoot;
            }
        }
        return sbPlaintext.toString();
    }

    private class HuffmanTree {

        private IHeap<Integer, Character> heap;
        private HuffmanTree(IHeap heap) {
            this.heap = heap;
        }

        /**
         * Remove two nodes and make them as child node.
         * Create a new node and insert it in PQ
         */
        private BinaryTreeNode<Entry<Integer, Character>> generateHuffmanTree() {
            LinkedList<BinaryTreeNode<Entry<Integer, Character>>> nodeList = new LinkedList<>();

            while (true) {
                Entry<Integer, Character> first = heap.extractMin();
                Entry<Integer, Character> second = heap.extractMin();
                //We label null character for the number only node
                int sum = first.getKey().intValue() + second.getKey().intValue();
                Entry<Integer, Character> parent = new Entry<>(new Integer(sum), '\u0000');
                heap.insert(parent);

                //Now set the references of the tree
                BinaryTreeNode<Entry<Integer, Character>> parentNode = new BinaryTreeNode<>(parent);
                BinaryTreeNode<Entry<Integer, Character>> leftNode = null;
                BinaryTreeNode<Entry<Integer, Character>> rightNode = null;

                for (BinaryTreeNode<Entry<Integer, Character>> node : nodeList) {
                    if (node.getData().equals(first))
                        leftNode = node;

                    if (node.getData().equals(second))
                        rightNode = node;
                }

                parentNode.setLeftChild((leftNode != null) ? leftNode : new BinaryTreeNode<>(second));
                parentNode.setRightChild((rightNode != null) ? rightNode : new BinaryTreeNode<>(first));
                nodeList.add(parentNode);

                if (heap.getSize() == 1)
                    return parentNode;
            }
        }
    }
}
