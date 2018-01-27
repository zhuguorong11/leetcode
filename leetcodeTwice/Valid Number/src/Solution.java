/**
 * Validate if a given string is numeric.
 * 
 * Some examples: "0" => true " 0.1 " => true "abc" => false "1 a" => false
 * "2e10" => true Note: It is intended for the problem statement to be
 * ambiguous. You should gather all requirements up front before implementing
 * one.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isNumber(String s) {
		s = s.trim();
		int len = s.length();
		if (len == 0) {
			return false;
		}
		boolean num = false;// �Ƿ�Ϊ��
		boolean ex = false;// �Ƿ���exp
		boolean dot = false;// �Ƿ���.
		char[] strs = s.toCharArray();
		for (int i = 0; i < len; ++i) {
			if (strs[i] >= '0' && strs[i] <= '9') {
				num = true;
			} else if (strs[i] == 'e') {
				if (ex) {
					return false;// �����ܳ�������e
				}
				if (!num) {
					return false;// ���֮ǰû��������϶���
				}
				ex = true;
				dot = false;
				num = false;// ��Ϊe����϶�Ҫ��������
			} else if (strs[i] == '.') {
				if (dot) {
					return false;// ������������.
				}
				if (ex) {
					return false;// ���֮ǰ��exp����϶���
				}
				dot = true;
			} else if (strs[i] == '+' || strs[i] == '-') {//����������
				if (num || dot) {//����Ѿ����������ֻ���С���㣬�򲻿����ٳ�����������
					return false;
				}
			} else
				return false;
		}
		return num;
	}
}