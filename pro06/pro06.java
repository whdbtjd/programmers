
package problem;

import java.util.Arrays;
import java.util.HashMap;

public class pro06 {

	public static void main(String args[]) {

		System.out.println(Arrays.toString(solution(new int[] {2,1,2,6,2,4,3,3}, 5)));
	}

	static int[] solution(int stage[], int N) {

		int failcnt[] = new int[N]; // 현재 해당 스테이지를 도전중인 유저의 수를 저장할 배열
		double user = stage.length; // 해당 스테이지까지 실패한 유저를 제외한 남은 유저의 수 
		double percent[] = new double[N]; // 실패율을 저장할 배열

		for (int j = 0; j < N; j++) {
			for (int i = 0; i < stage.length; i++) {
				if (stage[i] > N) { // 모든 스테이지를 통과한 경우
					continue;
				} else if (stage[i] == j + 1) { // j+1번 스테이지를 플레이 중인 경우
					failcnt[j]++;

				}
			}
			
			
			if (failcnt[j] == 0) { // 해당 스테이지를 모두 통과한 경우 
				percent[j] = 0; 
			} else {               // 통과하지 못한 유저가 있는경우 실패율 계산 후 변동된 유저수 계산
				percent[j] = failcnt[j] / user;
				user -= failcnt[j];
			}
		}
        
		// 스테이지, 실패율 쌍으로 해시맵 생성
		HashMap<Integer, Double> maps = new HashMap<>();
		for (int i = 0; i < percent.length; i++) {
			maps.put(i + 1, percent[i]);
		}
        
		// 실패율을 기준으로 내림차순 정렬 후 리턴
		return maps.entrySet().stream().sorted((x, y) -> Double.compare(y.getValue(), x.getValue()))
				.mapToInt(HashMap.Entry::getKey).toArray();

	}
}
