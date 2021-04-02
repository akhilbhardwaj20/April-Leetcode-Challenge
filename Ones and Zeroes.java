//tc- O(n*m*length)
// sc- O(n*m)
class Solution {

    int[][][] dp = null;

    public int findMaxForm(String[] strs, int m, int n) {

        dp = new int[m + 1][n + 1][strs.length];

        int[][] strFreq = new int[strs.length][2];
        int i = 0;
        for (String str : strs) {
            strFreq[i] = freqCount(str);
            i++;
        }

        return helper(strs, m, n, 0, strFreq);

    }


    private int helper(String[] strs, int m, int n, int index, int[][] strFreq) {
        if (index >= strs.length || (m + n) <= 0) {
            return 0;
        }
        if (dp[m][n][index] > 0) {
            return dp[m][n][index];
        }

        int countElIfCurrInc = 0;
        int countElIfCurrExc = 0;

        int zeroFreq = strFreq[index][0];
        int oneFreq = strFreq[index][1];


        if (m >= zeroFreq && n >= oneFreq) {
            countElIfCurrInc = 1 + helper(strs, m - zeroFreq, n - oneFreq, index + 1, strFreq);
        }
        countElIfCurrExc = helper(strs, m, n, index + 1, strFreq);

        dp[m][n][index] = Math.max(countElIfCurrInc, countElIfCurrExc);

        return dp[m][n][index];


    }


    private int[] freqCount(String str) {
        int[] freq = new int[2];
        for (char a : str.toCharArray()) {
            if (a == '0') {
                freq[0]++;
            } else {
                freq[1]++;
            }
        }
        return freq;
    }
}
