package InterviewProblems.CrackingCodingInterviews;

import DataStructures.Trees.BinarySearchTrees;
import DataStructures.Trees.BinaryTreeNode;
import DataStructures.Trees.IBinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class TreesAndGraphs<T extends Comparable<T>> {

    /**
     * 4.1 Route between nodes: Given a directed graph, design an algorithm to find out whether there is a
     * route between two nodes.
     */


    /**
     * 4.2 Minimal Tree: Given a sorted (increasing) array with unique integer elements, write an algorithm to create binary search
     * tree with minimal height.
     */
    public IBinarySearchTree<Integer> bstFromSortedArray(int[] sortedArray) {

        IBinarySearchTree<Integer> bst = new BinarySearchTrees<>();
        if (sortedArray.length < 1)
            return bst;

        bstFromSortedArrayHelper(bst, sortedArray, 0, sortedArray.length-1);
        return bst;
    }

    private void bstFromSortedArrayHelper(IBinarySearchTree<Integer> bst, int[] sortedArray, int start, int finish) {
        int mid = (start+finish)/2;
        bst.addElement(sortedArray[mid]);

        if (start <= mid-1)
            bstFromSortedArrayHelper(bst, sortedArray, start, mid-1);

        if (mid+1 <= finish)
            bstFromSortedArrayHelper(bst, sortedArray, mid+1, finish);
    }

    /**
     * 4.3 List of depths: Given a binary tree, design an algorithm which creates a linked list of all nodes at each depth
     * (if you have tree with depth D, you will have D linked lists)
     */
    public LinkedHashMap<Integer, LinkedList<BinaryTreeNode<T>>> listAtDepth(BinarySearchTrees<T> bst) {
        LinkedHashMap<Integer, LinkedList<BinaryTreeNode<T>>> listOfDepths = new LinkedHashMap<>();
        listAtDepthHelper(listOfDepths, bst.getRoot(), 0);
        return listOfDepths;
    }

    private void listAtDepthHelper(LinkedHashMap<Integer, LinkedList<BinaryTreeNode<T>>> listOfDepths, BinaryTreeNode<T> node, int level) {
        LinkedList<BinaryTreeNode<T>> nodeList = listOfDepths.get(level);
        if (nodeList == null)
            nodeList = new LinkedList<>();
        nodeList.add(node);
        listOfDepths.put(level, nodeList);

        if (node.getLeftChild() != null)
            listAtDepthHelper(listOfDepths, node.getLeftChild(), level+1);

        if (node.getRightChild() != null)
            listAtDepthHelper(listOfDepths, node.getRightChild(), level+1);
    }

    /**
     * 4.4 Check balanced: Implement a function to check binary tree is balanced. Balanced tree is defined to be tree
     * such that heights of two subtrees of any node never differ by more than one.
     */
    public boolean checkBalanced(BinarySearchTrees<T> inputTree) {
        return checkBalancedHelper(inputTree, inputTree.getRoot());
    }

    private boolean checkBalancedHelper(BinarySearchTrees<T> inputTree, BinaryTreeNode<T> node) {
        if (node == null)
            return true;

        if (Math.abs(inputTree.computeHeight(node.getRightChild())-
                inputTree.computeHeight(node.getLeftChild())) > 1)
            return false;
        else {
            return checkBalancedHelper(inputTree, node.getLeftChild()) &&
                    checkBalancedHelper(inputTree, node.getRightChild());
        }
    }

    /**
     * 4.5 BST Validation: Implement a function to check if a binary tree is a binary search tree
     */
    public boolean validateBST(BinarySearchTrees<T> inputTree) {
        if (inputTree.getSize() < 2)
            return true;

        return validateBSTHelper(inputTree, inputTree.getRoot());
    }

    private boolean validateBSTHelper(BinarySearchTrees<T> inputTree, BinaryTreeNode<T> subRoot) {
        if (subRoot.getRightChild() != null) {
            if (subRoot.getData().compareTo(subRoot.getRightChild().getData()) <= 0)
                validateBSTHelper(inputTree, subRoot.getRightChild());
            else
                return false;
        }

        if (subRoot.getLeftChild() != null) {
            if (subRoot.getData().compareTo(subRoot.getLeftChild().getData()) >= 0)
                validateBSTHelper(inputTree, subRoot.getLeftChild());
            else
                return false;
        }
        return true;
    }

    /**
     * 4.6 Successor: Write an algorithm to find the next node (in-order successor) of a given node in BST.
     * You may assume each node is linked to its parent.
     */
    public T findSuccessor(BinaryTreeNode<T> node) {
        if (node.getRightChild() != null)
            //Bug
            return node.getRightChild().getData();
        else {
            BinaryTreeNode<T> cur = node;
            while (cur.getParentNode().getLeftChild() != cur) {
                cur = cur.getParentNode();
                if (cur.getParentNode() == null)
                    return null;
            }
            return cur.getParentNode().getData();
        }
    }

    /**
     * 4.7 Build Order: Given list of projects and list of dependencies (pair of projects, where second
     * project is depend on first project). All project dependencies must be built before project. Find a
     * build order that will allow the projects to be build.
     *
     * Input:
     *      Projects: a, b, c, d, e, f
     *      Dependencies: (a,d), (f,b), (b,d), (f,a), (d,c)
     * Output: f, e, a, b, d, c
     */
    //Graph DFS

    /**
     * 4.8 First common ancestor: Design an algorithm and write code to find the first common ancestor ow two nodes
     * in a binary tree.
     */
    public T firstCommonAncestor(BinarySearchTrees<T> bst, BinaryTreeNode<T> node1, BinaryTreeNode<T> node2) {
        BinaryTreeNode<T> cur1 = node1;
        BinaryTreeNode<T> cur2;

        while (!cur1.equals(bst.getRoot())) {
            cur2 = node2;
            while (!cur2.equals(bst.getRoot())) {
                if (cur1.equals(cur2)) {
                    return cur1.getData();
                }
                cur2 = cur2.getParentNode();
            }
            cur1 = cur1.getParentNode();
        }
        return bst.getRoot().getData();
    }

    /**
     * 4.9 BST Sequences: BST was created by traversing through an array from left to right and inserting
     * each element. Given a BST with distinct elements, print all possible arrays that could have led to
     * this tree.
     * Input:
     *    2
     *   / \
     *  1   3
     *
     *  Output: {2,1,3} and {2,3,1}
     */
    public ArrayList<ArrayList<Integer>> bstSequences(BinarySearchTrees<Integer> bst) {

        ArrayList<ArrayList<Integer>> listSeq = new ArrayList<>();
        if (bst.getSize() > 0) {
            ArrayList<Integer> aList = new ArrayList<>();
            aList.add(bst.getRoot().getData());
            listSeq.add(aList);
        }
        return bstSequencesHelper(listSeq, bst.getRoot());
    }

    private ArrayList<ArrayList<Integer>> bstSequencesHelper(ArrayList<ArrayList<Integer>> listSeq,
                                                             BinaryTreeNode<Integer> curNode) {

        ArrayList<ArrayList<Integer>> newListSeq = new ArrayList<>(listSeq);

        for (ArrayList<Integer> aList : listSeq) {
            if (curNode.getLeftChild() != null && curNode.getRightChild() != null) {
                ArrayList<Integer> newList = new ArrayList<>(aList);
                aList.add(curNode.getLeftChild().getData());
                aList.add(curNode.getRightChild().getData());

                newList.add(curNode.getRightChild().getData());
                newList.add(curNode.getLeftChild().getData());

                newListSeq.add(newList);
                newListSeq = bstSequencesHelper(newListSeq, curNode.getLeftChild());
                newListSeq = bstSequencesHelper(newListSeq, curNode.getRightChild());
            } else if (curNode.getLeftChild() != null) {
                aList.add(curNode.getLeftChild().getData());
                newListSeq = bstSequencesHelper(newListSeq, curNode.getLeftChild());
            } else if (curNode.getRightChild() != null) {
                aList.add(curNode.getRightChild().getData());
                newListSeq = bstSequencesHelper(newListSeq, curNode.getRightChild());
            }
        }
        return newListSeq;
    }

    /**
     * 4.10 Check Subtree: T1 and T2 are two very large binary trees, with T1, much bigger than T2. Create an
     * algorithm to determine if T2 is a subtree of T1.
     */
    public boolean checkSubtree(BinarySearchTrees<T> t1, BinarySearchTrees<T> t2) {
        BinaryTreeNode<T> cur = t1.getRoot();
        BinaryTreeNode<T> rootT1T2 = findRootT2(cur, t2.getRoot());
        if (rootT1T2 == null)
            return false;

        return checkSubtreeHelper(rootT1T2, t2.getRoot());
    }

    private boolean checkSubtreeHelper(BinaryTreeNode<T> curT1, BinaryTreeNode<T> curT2) {
        if (curT1 == null && curT2 == null)
            return true;

        if ((curT1 != null && curT2 == null) ||
                (curT1 == null && curT2 != null) ||
                !curT1.getData().equals(curT2.getData()))
            return false;

        return checkSubtreeHelper(curT1.getLeftChild(), curT2.getLeftChild()) &&
                checkSubtreeHelper(curT1.getRightChild(), curT2.getRightChild());
    }

    private BinaryTreeNode<T> findRootT2(BinaryTreeNode<T> cur, BinaryTreeNode<T> rootT2) {

        if (cur == null)
            return null;

        int compare = cur.getData().compareTo(rootT2.getData());
        if (compare < 0)
            return findRootT2(cur.getRightChild(), rootT2);
        else if (compare > 0)
            return findRootT2(cur.getLeftChild(), rootT2);
        else
            return cur;
    }

    /**
     * 4.11 Random Node: You are implementing a binary tree class. In addition to find, delete, insert, you
     * implement getRandomNode() which returns a random node from tree
     *
     * 4.12 Paths with Sum: Given a binary tree with integer values (positive or negative). Design an algorithm
     * to count the number of paths that sum to a given value. Path doesn't need to start from root or a leaf but
     * it must go downwards.
     */
}
