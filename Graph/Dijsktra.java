import java.util.ArrayList;
import java.util.Arrays;

public class Dijsktra {
    static int findMinIndex (ArrayList<int[]> q){
        int m = 10000000;
        int indexMin = 0;
        for (int i= 0; i < q.size(); i++){
            if (q.get(i)[2] < m){
                m = q.get(i)[2];
                indexMin = i;
            }
        }
        return indexMin;
    }

    static boolean validIndex(int r, int c, int lenRow, int lenCol){
        return r >= 0 && r < lenRow && c >= 0  && c < lenCol && r != c;
    }

    static boolean validate(int num){
        return num > 0;
    }

    static int dijsktra(int[][] g, int sr, int sc, int tr, int tc){
        int[] r = new int [] {1, 1, 1, 0, -1, -1, -1, 0};
        int[] c = new int [] {-1, 0, 1, 1, 1, 0, -1, -1};
        boolean visited[][] = new boolean[g.length][g[0].length];
        for (int i =0; i < g.length; i++){
            Arrays.fill(visited[i], false);
        }

        ArrayList<int[]> queue = new ArrayList<>();
        queue.add(new int [] {sr, sc, 0});

        while (queue != null){
            int j = findMinIndex(queue);
            int[] s = queue.get(j);

            if (s[0] == tr && s[1] == tc){
                return s[2];
            }
            visited[s[0]][s[1]] = true;
            queue.remove(j);

            for (int i= 0; i < 8; i ++){
                int testRow = r[i]+ s[0];
                int testCol = c[i] + s[1];

                if ( validIndex(testRow, testCol, g.length, g[0].length) && !visited[testRow][testCol] && validate(g[testRow][testCol])){
                    queue.add(new int[]{testRow, testCol, g[testRow][testCol]+ s[2]});
                }
            }
        }
        return 0;
    }
    public static void main(String args[])
    {
        int graph[][] = new int[][]{
                {1, 4, 3, 6},
                {2, 0, 6, 1},
                {1, 7, 0, 5},
                {0, 4, 2, 0}
        };
        System.out.println(dijsktra(graph, 0,0, 2,3));
    }
}