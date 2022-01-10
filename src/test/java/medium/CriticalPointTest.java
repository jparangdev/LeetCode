package medium;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class CriticalPointTest {

	@Test
	void CriticalPointTest() {
		List<Integer> list = Arrays.asList(1,3,2,2,3,2,2,2,7);
		ListNode head = make(0,list);
		int[] result = new int[]{3,3};

		CriticalPoint point = new CriticalPoint();
		int[] answer = point.nodesBetweenCriticalPoints(head);

		assertThat(answer).containsExactly(result);
	}

	public ListNode make(int i, List<Integer> list) {
		if(i < list.size()) {
			return new ListNode(list.get(i), make(i+1,list));
		}
		return null;
	}

}