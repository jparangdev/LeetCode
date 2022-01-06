package medium;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class CarPooling {

	@Test
	public void test() {
		int[][] input1 = new int[][] {{2,1,5},{3,3,7}};
		int capacity = 4;

		assertThat(carPooling(input1, 4)).isFalse();
		assertThat(carPooling(input1, 5)).isTrue();
	}


	public boolean carPooling(int[][] trips, int capacity) {
		int max = 0;
		for (int i = 0; i < trips.length; i++) {
			int seatNum = getMinSeats(trips, trips[i][2]);
			max = Math.max(max,seatNum);
		}
		return capacity >= max;
	}

	public int getMinSeats(int[][] trips, int distance) {
		return Arrays.stream(trips)
			.filter((int[] t) ->(t[1] <= distance && t[2] > distance))
			.mapToInt((int[] t) -> t[0])
			.sum();
	}


}
