package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1063 {

    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        Piece king = new Piece(s.charAt(0), s.charAt(1) - '0');
        s = st.nextToken();
        Piece stone = new Piece(s.charAt(0), s.charAt(1) - '0');
        n = Integer.parseInt(st.nextToken());

        while (n-- > 0) {
            Piece tmpKing = new Piece(king.column, king.row);
            Piece tmpStone = new Piece(stone.column, stone.row);

            String commands = br.readLine();

            if (!tmpKing.canMove(commands)) {
                continue;
            }
            tmpKing.move(commands);

            if (!tmpKing.samePosition(tmpStone)) {
                king = tmpKing;
                continue;
            }

            if (!tmpStone.canMove(commands)) {
                continue;
            }
            king = tmpKing;
            tmpStone.move(commands);
            stone = tmpStone;
        }

        System.out.println(king.position());
        System.out.println(stone.position());
    }

    static class Piece {
        char column;
        int row;

        public Piece(char column, int row) {
            this.column = column;
            this.row = row;
        }

        String position() {
            return column + String.valueOf(row);
        }

        void move(String commands) {
            for (int i = 0; i < commands.length(); i++) {
                move(commands.charAt(i));
            }
        }

        void move(char command) {
            if (command == 'T') {
                row++;
            } else if (command == 'B') {
                row--;
            } else if (command == 'L') {
                column--;
            } else if (command == 'R') {
                column++;
            }
        }

        boolean canMove(String commands) {
            for (int i = 0; i < commands.length(); i++) {
                if (!canMove(commands.charAt(i))) {
                    return false;
                }
            }
            return true;
        }

        boolean canMove(char command) {
            return (command == 'T' && row + 1 <= 8) ||
                (command == 'B' && 1 <= row - 1) ||
                (command == 'L' && 'A' <= column - 1) ||
                (command == 'R' && column + 1 <= 'H');
        }

        public boolean samePosition(Piece stone) {
            return column == stone.column && row == stone.row;
        }
    }
}
