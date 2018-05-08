package com.leetcode.easy;

import java.util.Stack;

public class ValidParantheses {

	public static void main(String[] args) {
		ValidParantheses para = new ValidParantheses();
		System.out.println(para.isValid("()"));
	}
	public boolean isValid(String s) {
		boolean isValid = true;
		Stack<Character> stack = new Stack<>();
		for(int i = 0 ; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(ch == '(' ||ch == '{' || ch == '[') {
				stack.push(ch);
			} else if(ch == ')' ||ch == '}' || ch == ']') {
				 if(stack.isEmpty()) {
	                    return false;
	             }
				char top = stack.pop();
				if(ch == ')' && top !='(') {
					return false;
				}else if(ch == '}' && top !='{') {
					return false;
				}else if(ch == ']' && top !='[') {
					return false;
				}
			}
		}
		if(!stack.isEmpty())
			return false;
		return isValid;
	}
}
