package problem;

import java.util.Arrays;
import java.util.Collections;

public class pro06 {

	public static void main(String args[]) {

		System.out.println(Arrays.toString(solution(new int[] { 2, 1, 2, 6, 2, 4, 3, 3 }, 5)));
	}

	static double[] solution(int stage[], int N) {

		int failcnt[] = new int[N];
		double user = stage.length;
		double percent[] = new double[N];

		for (int i = 0; i < N; i++) {
			failcnt[i] = (int) Arrays.stream(stage).filter(x -> x == i).count();
			if (failcnt[i] == 0) {
				percent[i] = 0;
			} else {
				percent[i] = failcnt[i] / user;
			}
			user -= failcnt[i];
		}

		percent = Arrays.stream(percent).boxed().sorted(Collections.reverseOrder()).mapToDouble(Double::doubleValue)
				.toArray();

		return percent;

	}
}
