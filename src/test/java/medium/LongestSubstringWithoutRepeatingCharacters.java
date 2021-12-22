package medium;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class LongestSubstringWithoutRepeatingCharacters {

	@Test
	void test() {
		String test1 = "abcabcbb";
		String test2 = "bbbbb";
		String test3 = " ";

		assertThat(lengthOfLongestSubstring(test3)).isEqualTo(1);
	}

	public int lengthOfLongestSubstring(String s) {
		int result = 0;
		if(s.length() == 1) return 1;
		for (int i = 0; i < s.length()-1; i++) {
			for (int j = i+1; j <= s.length(); j++) {
				String sub = s.substring(i,j);
				if(sub.length() < result) continue;
				if(isRepeat(sub)) {
					result = Math.max(result, sub.length());
				} else {
					break;
				}
			}
		}
		return result;
	}

	public boolean isRepeat(String sub) {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < sub.length(); i++) {
			char c = sub.charAt(i);
			if(set.contains(c)) {
				return false;
			} else {
				set.add(c);
			}

		}
		return true;
	}


}
