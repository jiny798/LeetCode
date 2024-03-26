import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();


		int[][] dp = new int[str2.length() + 1][str1.length() + 1];

		for (int j = 0; j < str1.length()+1; j++) {
			dp[0][j] = j;

		}
		for (int i = 0; i < str2.length()+1; i++) {
			dp[i][0] = i;

		}

		for(int i = 1 ; i < dp.length ; i++ ) {
			for (int j = 1 ; j < dp[0].length; j++ ){
				if(str1.charAt(j-1) == str2.charAt(i-1)){
					dp[i][j] = dp[i-1][j-1];

				}else{
					int min = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
					dp[i][j] = min+1;

				}
			}
		}

		System.out.println(dp[str2.length()][str1.length()]);
		// 0 0 a b c
		// 0 0 1 2 3
		// a 1
		// b 2

	}

}