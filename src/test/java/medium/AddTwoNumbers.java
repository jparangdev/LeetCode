package medium;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.w3c.dom.NodeList;

public class AddTwoNumbers {

	@Test
	void AddTwoNumbers() {
		ListNode l1 = new ListNode(2,new ListNode(4, new ListNode(3)));
		ListNode l2= new ListNode(5,new ListNode(6, new ListNode(4)));

		addTwoNumbers(l1,l2);

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		BigInteger num1 = new BigInteger(nodeString(new StringBuilder(), l1));
		BigInteger num2 = new BigInteger(nodeString(new StringBuilder(), l2));

		BigInteger sum = num1.add(num2);
		StringBuilder sb = new StringBuilder(sum+"");
		String sumStr = sb.reverse().toString();

		ListNode node = createNode(sumStr, 0);
		return node;

	}

	public String nodeString(StringBuilder sb, ListNode node) {
		sb.append(node.val);
		if(node.next == null) {
			return sb.reverse().toString();
		} else {
			return nodeString(sb,node.next);
		}
	}

	public ListNode createNode(String text, int idx) {
		int val = Integer.parseInt(text.charAt(idx)+"");
		if(idx+1 == text.length()) {
			return new ListNode(val);
		} else {
			return new ListNode(val, createNode(text, idx+1));
		}
	}

	public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
