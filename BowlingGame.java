import java.util.Scanner;

public class Bowling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] scores = new int[11][4];

        for (int i = 0; i < scores.length; i++) {
            if (i < scores.length - 1) {
                System.out.printf("请输入第%d，第1次打倒的个数：", i + 1);
                scores[i][0] = sc.nextInt();
                if (scores[i][0] < 10 || i == 9) {
                    System.out.printf("请输入第%d，第2次打倒的个数", i + 1);
                    scores[i][1] = sc.nextInt();
                }
            } else if (scores[i - 1][0] + scores[i - 1][1] >= 10) {
                System.out.printf("请输入第%d，第%d次打倒的个数", i, 3);
                scores[i][0] = scores[i][2] = sc.nextInt();
            }
        }

        for (int i = 0; i < scores.length-1; i++) {
            if (scores[i][0] == 10 && i != 9) {
                if (scores[i + 1][0] == 10 && i < 8){
                    scores[i][2] = scores[i][0] + scores[i + 1][0]  + scores[i + 2][0];
                }else if (scores[i + 1][0] != 10 || i == 8){
                    scores[i][2] = scores[i][0]  + scores[i + 1][0]  + scores[i + 1][1];
                }
            }else{
                if (scores[i][0] + scores[i][1] == 10 && i < 9){
                    scores[i][2] = scores[i][0] + scores[i][1] + scores[i + 1][0];
                }else{
                    scores[i][2] = scores[i][0] + scores[i][1];
                }
            }
        }

        scores[0][3] = scores[0][2];
        for(int i = 1; i < scores.length;i++ ){
            scores[i][3]=scores[i][2] + scores[i - 1][3];
        }

        for(int i = 0 ; i < scores.length; i++){
            for(int j = 0 ; j < scores[i].length; j++){
                System.out.print(scores[i][j] + "\t");
            }
            System.out.println("\t第" + (i + 1) +"轮\n");
        }
    }
}
