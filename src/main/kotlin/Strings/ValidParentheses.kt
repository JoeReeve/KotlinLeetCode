package Strings

import java.util.*

class ValidParentheses {

    class Solution {
        
        fun isValid(s: String): Boolean {
            if (s.length % 2 != 0) return false
            var stack = Stack<Char>()

            s.forEach { brace ->
                when(brace) {
                    '{', '[', '(' -> stack.push(brace)
                    '}' -> if(!stack.isEmpty() && stack.peek() == '{') stack.pop() else return false
                    ']' -> if(!stack.isEmpty() && stack.peek() == '[') stack.pop() else return false
                    ')' -> if(!stack.isEmpty() && stack.peek() == '(') stack.pop() else return false
                    else -> return false
                }
            }
            return stack.isEmpty()
        }
    }
}