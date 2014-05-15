package algorithm.s2w3;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseballElimination {

    private int[]   w;       // wins
    private int[]   l;       // losses
    private int[]   r;       // remaining
    private int[][] g;       // ramaining games between team i and team j
    private int     n;       // number of total teams
    private String[] names;  // team name

    /**
     * create a baseball division from given filename in format specified below
     *                   w[i]       l[i]        r[i]                  g[i][j]
     * i  team           wins       loss        left          Atl    Phi   NY   Mon
     * 0  Atlanta        83         71          8              -      1    6     1
     * 1  Philadelphia   80         79          3              1      -    0     2
     * 2  New York       78         78          6              6      0    -     0
     * 3  Montreal       77         82          3              1      2    0     -
     * @param filename
     */
    public BaseballElimination(String filename) {
        Scanner scanner = null;
        try {
            // count the total number fo teams
            scanner = new Scanner(new File(filename));
            int lines = 0;
            while(scanner.hasNextLine() && scanner.nextLine() != null) lines++;
            scanner.close();

            // allocate the memory for the datastructure
            w = new int[lines];
            l = new int[lines];
            r = new int[lines];
            g = new int[lines][lines];
            n = lines;
            names = new String[lines];

            // populate the data
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            StringBuilder patternBuilder = new StringBuilder();
            patternBuilder.append("(");
            patternBuilder.append("([a-zA-Z0-9_]+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)");
            for(int i=0; i<n; i++) {
                patternBuilder.append("\\s+(\\d+)");
            }
            patternBuilder.append(")");
            Pattern pattern = Pattern.compile(patternBuilder.toString());
            String line;
            int index = 0;
            while((line = reader.readLine()) != null) {
                Matcher result = pattern.matcher(line);
                if(!result.matches() || result.groupCount() < 5) {
                    throw new RuntimeException("Data format of the file is not right.");
                }
                names[index] = result.group(2);
                w[index] = Integer.valueOf(result.group(3));
                l[index] = Integer.valueOf(result.group(4));
                r[index] = Integer.valueOf(result.group(5));

                for(int i=1; i<=n; i++) {
                    g[index][i-1] = Integer.valueOf(result.group(i+5));
                }
                index++;
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read the data file.");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    /**
     * @return number of teams
     */
    public int numberOfTeam() {
        return n;
    }

    /**
     * @return all teams
     */
    public Iterable<String> teams() {
        return Arrays.asList(names);
    }

    /**
     * @param team
     * @return number of wins for given team
     */
    public int wins(String team) {
        return w[getIndexByTeamName(team)];
    }

    /**
     * @param team
     * @return number of losses for given team
     */
    public int losses(String team) {
        return l[getIndexByTeamName(team)];
    }

    /**
     * @param team
     * @return number of remaining games for given team
     */
    public int remaining(String team) {
        return r[getIndexByTeamName(team)];
    }

    /**
     * @param team1
     * @param team2
     * @return number of remaining games between team1 and team2
     */
    public int against(String team1, String team2) {
        return g[getIndexByTeamName(team1)][getIndexByTeamName(team2)];
    }

    /**
     * @param name
     * @return is given team eliminated
     */
    public boolean isEliminated(String name) {
        return false;
    }

    /**
     * @param team
     * @return subset R of teams that eliminates given team;
     *         null if not eliminated.
     */
    public Iterable<String> certificateOfElimination(String team) {
        return null;
    }

    /**
     * @param name
     * @return team index by name
     */
    private int getIndexByTeamName(String name) {
        int index = -1;
        for(int i=0; i<n; i++) {
            if(names[i].equalsIgnoreCase(name)) {
                index = i;
                break;
            }
        }
        if(index != -1) {
            return index;
        } else {
            throw new IllegalArgumentException(String.format("Team %s is not found.", name));
        }
    }
}
