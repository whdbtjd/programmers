
public class pro05 {

	public static void main(String args[]) {
		// 예시 행렬
		int ar1[][] = { { 1, 4 }, { 3, 2 }, { 4, 1 } };
		int ar2[][] = { { 3, 3 }, { 1, 3 } };
		solution(ar1, ar2);
	}

	static int[][] solution(int ary1[][], int ary2[][]) {
		// 행렬곱셈의 결과를 저장할 이차원 배열 생성
		int ans[][] = new int[ary1.length][ary2[0].length];
        
		// 행렬 곱셈 구현부
		for (int i = 0; i < ary1.length; i++) {
			for (int j = 0; j < ary2[0].length; j++) {
				for (int x = 0; x < ary2.length; x++) {
					ans[i][j] += ary1[i][x] * ary2[x][j];
				}
			}
		}

		return ans;

	}

}
