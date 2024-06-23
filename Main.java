import java.util.*;

class Main {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to TIC-TAC-TOE !!!!!!");
        int x_win_count = 0;
        int o_win_count = 0;
        int num;

        while (true) {
            System.out.println("Starting new Game.....");
            char ch[][] = new char[3][3];

            for (int i = 0; i < 3; i++)
                Arrays.fill(ch[i], ' ');

            boolean visited[][] = new boolean[3][3];
            boolean current_chance = true;
            int count = 0;

            while (true) {
                char current = (current_chance) ? 'X' : 'O';
                System.out.println("Enter the row and col to enter " + current);
                int row = sc.nextInt();
                int col = sc.nextInt();

                if (visited[row][col]) {
                    System.out.println("OOPS that place is already occupied by " + ch[row][col]);
                    System.out.println("Please enter other row and column");

                    row = sc.nextInt();
                    col = sc.nextInt();
                }

                visited[row][col] = true;
                ch[row][col] = current;
                count += 1;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        System.out.print(ch[i][j] + "     ");
                    }
                    System.out.println();
                }

                Result result = getMessage(ch, current);

                if (result.win) {
                    System.out.println(result.message);
                    if (current == 'X') {
                        x_win_count++;
                    } else {
                        o_win_count++;
                    }

                    System.out.println("Current scores are..  X : " + x_win_count + "   O : " + o_win_count);
                    break;
                } else if (count == 9) {
                    System.out.println("Oops Close Call But its a DRAW..!!!");
                    System.out.println("Current scores are..  X : " + x_win_count + "   O : " + o_win_count);
                    break;
                } else {
                    System.out.println(result.message);
                }

                current_chance = !current_chance;

            }

            System.out.println("Press 1 to continuee \n Press 2 to Exit Game");
            num = sc.nextInt();

            if (num == 2) {
                return;
            }

        }

    }

    private static Result getMessage(char[][] ch, char curr_ch) {

        Result res = new Result();

        if ((ch[0][0] == curr_ch && ch[0][1] == curr_ch && ch[0][2] == curr_ch) ||
                (ch[1][0] == curr_ch && ch[1][1] == curr_ch && ch[1][2] == curr_ch)
                || (ch[2][0] == curr_ch && ch[2][1] == curr_ch && ch[2][2] == curr_ch)
                || (ch[0][0] == curr_ch && ch[1][0] == curr_ch && ch[2][0] == curr_ch)
                || (ch[0][1] == curr_ch && ch[1][1] == curr_ch && ch[2][1] == curr_ch) ||
                (ch[0][2] == curr_ch && ch[1][2] == curr_ch && ch[2][2] == curr_ch)
                || (ch[0][0] == curr_ch && ch[1][1] == curr_ch && ch[2][2] == curr_ch)
                || (ch[2][0] == curr_ch && ch[1][1] == curr_ch && ch[0][2] == curr_ch)) {

            res.message = "Hurrayy !! Seems " + curr_ch + " won this match";
            res.win = true;
            return res;
        }

        res.message = "Continue.. Still no one wins";
        res.win = false;
        return res;
    }
}

class Result {
    String message = "";
    boolean win = false;
}