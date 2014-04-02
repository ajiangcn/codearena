package others;

import java.util.Scanner;

public class ServerCapacity {

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        String serverCapacity = in.nextLine().trim();
        while(in.hasNextLine()) {
            String taskStr = in.nextLine().trim();
            int[] capacities = parseInput(serverCapacity);
            int[] tasks = parseInput(taskStr);

            // construct a capacity/task matrix
            // column is the server and row is the tasks
            int[][] matrix = new int[tasks.length+1][capacities.length+1];
            for(int i=1; i<=tasks.length; i++) {
                for(int j=1; j<=capacities.length; j++) {
                    if(tasks[i] > capacities[j]) {
                        // -1 indicate task i can not be assigned to server j
                        matrix[i][j] = -1;
                    } else {
                        // the remaining capacity if the task is assigned to this server
                        matrix[i][j] = capacities[j] - tasks[j];
                    }
                }
            }

            // this is a traditional task assignment problem
            // the strategy is to find the exact match
            // then assign the task, other wise find the smallest
            // gap
        }

    }

    private static int[] parseInput(String input) {
        int[] result = new int[8];
        String[] strs = input.split(" ");
        int idx = 0;
        for(String str: strs) {
            if(str.length() > 0) {
                result[idx++] = Integer.parseInt(str);
            }
        }
        return result;
    }
}
