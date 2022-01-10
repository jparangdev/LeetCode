package medium;

import java.util.ArrayList;
import java.util.List;

//No. 2058
public class CriticalPoint {
	public int[] nodesBetweenCriticalPoints(ListNode head) {
		List<Integer> resultList = new ArrayList<>();

		int i = 1;
		int min = Integer.MAX_VALUE;
		while(head.next != null) {
			if(isCriticalPoint(head)) {
				resultList.add(i);
				int size = resultList.size();
				if(size >= 2) {
					int diff = resultList.get(size-1) - resultList.get(size-2);
					min = Math.min(min, diff);
				}
			}
			i++;
			head = head.next;
		}

		int[] result = new int[]{-1,-1};


		if(resultList.size() >= 2 ) {
			int max = resultList.get(resultList.size()-1) - resultList.get(0);
			result[0] = min;
			result[1] = max;
		}

		return result;


	}


	public boolean isCriticalPoint(ListNode head) {
		ListNode prev = head;
		ListNode cur;
		ListNode next;

		if(prev.next != null) {
			cur = head.next;
			if(cur.next != null) {
				next = cur.next;

				if(cur.val > next.val && cur.val > prev.val) {
					return true;
				}
				if(cur.val < next.val && cur.val < prev.val) {
					return true;
				}
			}
		}
		return false;
	}



}
