package InterviewProblems.ElementsOfProgrammingInterviews;

import java.util.ArrayList;

public class Recursion {

    /**
     * 16.3 Generate all permutations
     */
    public ArrayList<ArrayList<Integer>> generateAllPermutations(int[] arr) {

        ArrayList<ArrayList<Integer>> permutationList = new ArrayList<>();
        ArrayList<Integer> initialList = new ArrayList<>();
        initialList.add(arr[0]);
        permutationList.add(initialList);

        int arrEntry = 1;
        return generateAllPermutationsHelper(arr, permutationList, arrEntry);
    }

    private ArrayList<ArrayList<Integer>> generateAllPermutationsHelper(int[] arr, ArrayList<ArrayList<Integer>> permutationList, int entry) {

        if (entry >= arr.length)
            return permutationList;

        ArrayList<ArrayList<Integer>> copyOfList = (ArrayList<ArrayList<Integer>>)permutationList.clone();//ew ArrayList<>(permutationList);
        permutationList = new ArrayList<>();
        for (int position =0; position <= copyOfList.get(0).size(); position++ ) {
            for (int listNumber =0; listNumber < copyOfList.size(); listNumber++) {
                permutationList.add((ArrayList<Integer>) copyOfList.get(listNumber).clone());
                permutationList.get(permutationList.size()-1).add(position,arr[entry]);
            }
        }
        return generateAllPermutationsHelper(arr,permutationList, ++entry);
    }

    /**
     * 16.4 Generate power set of a set
     */


    /**
     * 16.9 Implement a Sudoku Solver
     */
    public boolean isSudokuValid(int[][] sudoku) {
        final int SUDOKU_LENGTH = 9;

        //Check dimension first
        if (sudoku.length != SUDOKU_LENGTH || sudoku[0].length != SUDOKU_LENGTH)
            return false;

        //Strategy: Check if numbers are in [1-9] and empty as 0
        //Check each row
        //Check each column
        //Check each square

        for (int i=0; i < sudoku.length; i++) {
            boolean[] rowMarker = new boolean[10];
            boolean[] columnMarker = new boolean[10];
            for (int j = 0; j < sudoku[i].length; j++) {
                //Check if numbers are in [1-9] and empty as 0
                if (sudoku[i][j] > 9 || sudoku[i][j] < 0)
                    return false;

                //Checking each row
                if (rowMarker[sudoku[i][j]] && sudoku[i][j]!=0)
                    return false;

                rowMarker[sudoku[i][j]]=true;

                //Checking each column
                if (columnMarker[sudoku[j][i]] && sudoku[j][i]!=0)
                    return false;

                columnMarker[sudoku[j][i]]=true;
            }
        }

        //Finally, checking each subsquare
        for (int i=0; i< 3; i++)
            for (int j=0; j<3; j++) {
                boolean isSubsquareViolates = checkSubSquare (sudoku, i, j);
                if (!isSubsquareViolates)
                    return false;
            }

        return true;
    }

    private boolean checkSubSquare(int[][] sudoku, int row, int column) {
        int rowAdjuster =3*row;
        int columnAdjuster = 3*column;
        boolean[] subSquareMarker = new boolean[10];

        for (int i=0; i< 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (subSquareMarker[sudoku[rowAdjuster+i][columnAdjuster+j]] && sudoku[rowAdjuster+i][columnAdjuster+j]!=0)
                    return false;

                subSquareMarker[sudoku[rowAdjuster+i][columnAdjuster+j]]=true;
            }
        }
        return true;
    }
}
