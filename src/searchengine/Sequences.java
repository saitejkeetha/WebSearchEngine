package searchengine;
//This class provides editDistance
public class Sequences {

	public static int editDistance(String word1, String word2) {
		int len = word1.length();
		int len1 = word2.length();
	 
		// len1+1, len2+1, because finally return dp[len][len1]
		int[][] dp = new int[len + 1][len1 + 1];
	 
		for (int i = 0; i <= len; i++) {
			dp[i][0] = i;
		}
	 
		for (int j = 0; j <= len1; j++) {
			dp[0][j] = j;
		}
	 
		//iterate though, and check last char
		for (int i = 0; i < len; i++) {
			char c1 = word1.charAt(i);
			for (int j = 0; j < len1; j++) {
				char c2 = word2.charAt(j);
	 
				//if last two chars equal
				if (c1 == c2) {
					//update dp value for +1 length
					dp[i + 1][j + 1] = dp[i][j];
				} else {
					int replace = dp[i][j] + 1;
					int insert = dp[i][j + 1] + 1;
					int delete = dp[i + 1][j] + 1;
	 
					int min = replace > insert ? insert : replace;
					min = delete > min ? min : delete;
					dp[i + 1][j + 1] = min;
				}
			}
		}
	 
		return dp[len][len1];
	}
}
