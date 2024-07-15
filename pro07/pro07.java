package problem;

import java.util.HashSet;

public class pro07 {
	public static void main(String args[]) {
		System.out.println(solution("LLLLLLLLLLLLLLLLLUUUUUURRRDDDDDDDDDD"));
	}

	static int solution(String dirs) {
		// 현재 좌표를 (5,5)로 설정
		int x = 5;
		int y = 5;

		char array[] = dirs.toCharArray();
		HashSet<String> set = new HashSet<>();
        
		// 배열 순회
		for (int i = 0; i < array.length; i++) {
			// 위 아래 이동
			if (x >= 0 && x <= 10) {
				if (array[i] == 'U') {
            
					if (y + 1 > 10) { // y좌표가 10을 벗어날 경우 10으로 고정
						y = 10;
					} else {
						set.add(x + "," + y + " " + x + "," + (++y)); // 현재 좌표의 출발점과 이동한 점 해시셋에 추가
						set.add(x + "," + y + " " + x + "," + (y-1));
					}

				} else if (array[i] == 'D') {

					if (y - 1 < 0) { // y좌표가 0을 벗어날 경우 0으로 고정
						y = 0;
					} else { 
						set.add(x + "," + y + " " + x + "," + (--y)); // 현재 좌표의 출발점과 이동한 점 해시셋에 추가
						set.add(x + "," + y + " " + x + "," + (y+1)); // 정답에는 방향성이 없으니 반대 방향도 추가
					}

				}
			}

			if (y >= 0 && y <= 10) {
				if (array[i] == 'L') {

					if (x - 1 < 0) { // x좌표가 0을 벗어날 경우 0으로 고정
						x = 0;

					} else {
						set.add(x + "," + y + " " + (--x) + "," + y);  // 현재 좌표의 출발점과 이동한 점 해시셋에 추가
						set.add(x + "," + y + " " + (x+1) + "," + y);
					}

				} else if (array[i] == 'R') {

					if (x + 1 > 10) { // x좌표가 10을 벗어날 경우 10으로 고정
						x = 10;
					} else {
						set.add(x + "," + y + " " + (++x) + "," + y); // 현재 좌표의 출발점과 이동한 점 해시셋에 추가
						set.add(x + "," + y + " " + (x-1) + "," + y);
					}

				}
			}
		}

		return set.size()/2;
	}
}
