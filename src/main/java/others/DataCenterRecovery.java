package others;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DataCenterRecovery {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        int numOfDataCenters = Integer.valueOf(line.trim());
        // data center indexed data availability map
        int[][] dataSet = new int[numOfDataCenters+1][299];

        int index = 1;
        for(int j=0; j<numOfDataCenters; j++) {
            line = reader.readLine();
            String[] strs = line.split(" ");
            for(int i=1; i<strs.length; i++) {
                dataSet[index][Integer.valueOf(strs[i])] = 1;
            }
            index++;
        }

        // populate data set availability map
        // loop through data set
        for(int i=1; i<=298; i++) {
            // loop through data centers
            int idx = -1;
            for(int j=1; j<=numOfDataCenters; j++) {
              if(dataSet[j][i] == 1) {
                  idx = j;
              }
            }

            // copy data
            if(idx != -1) {
                for(int j = 1; j<=numOfDataCenters; j++) {
                    if(dataSet[j][i] == 0) {
                        System.out.println(String.format("%d %d %d", i, idx, j));
                    }
                }
            }
        }

        System.out.println("done");
    }
}
