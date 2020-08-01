public class week32_794 {
    class Solution {
        public boolean validTicTacToe(String[] board) {
            int xNum = 0, oNum = 0;
            char[][] boards = new char[3][3];
            for (int i = 0; i < 3; i++) {
                boards[i] = board[i].toCharArray();
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (boards[i][j] == 'X') {
                        xNum ++;
                    } else if (boards[i][j] == 'O') {
                        oNum ++;
                    }
                }
            }
            if (xNum == oNum + 1) {
                boolean res = check('O', boards);
                return !res;
            } else if (xNum == oNum) {
                boolean xRes = check('X', boards);
                return !xRes;
            } else {
                return false;
            }
        }
        
        private boolean check(char c, char[][] board) {
            for (int i = 0; i < 3; i++) {
                int row = 0;
                int col = 0;
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == c) {
                        row ++;
                    }
                    if (board[j][i] == c) {
                        col ++;
                    }
                }
                if (row == 3 || col == 3) {
                    return true;
                }
            }
            if ((board[0][0]==c&&board[1][1]==c&&board[2][2]==c) || (board[0][2]==c&&board[1][1]==c&&board[2][0]==c)) {
                return true;
            } else {
                return false;
            }
        }
    }
}