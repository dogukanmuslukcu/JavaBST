public class Main {

    public static void main(String[] args) {
        System.out.println("hello world");
        int[][] a = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(i==j)
                {
                    a[i][j]=i+1;
                }else if(i>j)
                {
                    a[i][j]=j+1;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                 System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}
