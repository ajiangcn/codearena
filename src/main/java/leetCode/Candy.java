package leetCode;

public class Candy {

    public int candy(int[] ratings) {
        if(ratings == null) {
            return 0;
        }
        if(ratings.length == 1) {
            return 1;
        }
        int firstDecrease = 0;
        int[] assignments = new int[ratings.length];
        assignments[0]  =1;
        for(int i=1; i<ratings.length; i++) {
            if(ratings[i] < ratings[i-1]) {
                firstDecrease = i;
                assignments[i] = assignments[i-1]+1;
            } else if (ratings[i] == ratings[i-1]) {
                assignments[i] = assignments[i-1];
            } else if(ratings[i] > ratings[i-1]) {
                int num = assignments[i-1]-1;
                if(num >=1) {
                    assignments[i] = num;
                } else {
                    assignments[i] = 1;
                    // increase the assignment since the first decrease
                    for(int j=i-1; j>=firstDecrease; j--) {
                        assignments[j]++;
                    }
                }
            }
        }

        int sum = 0;
        for(int n: assignments) {
            sum += n;
        }
        return  sum;
    }

}
