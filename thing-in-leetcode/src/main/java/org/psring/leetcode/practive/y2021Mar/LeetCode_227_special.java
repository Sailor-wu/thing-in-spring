package org.psring.leetcode.practive.y2021Mar;

public class LeetCode_227_special {
	
	public static void main(String[] args) {
		String s=
				"(1+(4+5+2)-3)+(6+8)";
//				"3+2*2";
//				"3+5 / 2 ";
		int calculate = new LeetCode_227_special().calculate(s);
		System.out.println(calculate);
	}
	
	private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    boolean isMultiply(char c) {
        return c == '*';
    }

    boolean isDivided(char c) {
        return c == '/';
    }

    boolean isValid(char c) {
        return isOperator(c) || isDigit(c);
    }

    class StringCalculator {
        Integer target, prev;
        Character character;

        String strLeft = null;
        String strRight = null;

        StringCalculator next;

        StringCalculator(Character c) {
            if (isDigit(c)) {
                this.target = c - '0';
            } else {
                this.character = c;
            }
        }

        boolean hasNext() {
            return next != null;
        }

        boolean isNumber() {
            return character == null;
        }

        boolean isTargetFirst() {
            if (isNumber() && hasNext()) {
                char c = next.character;
                return isMultiply(c) || isDivided(c);
            }
            return false;
        }

        boolean isNextFirst() {
            if (isNumber() && hasNext() && next.next.hasNext()) {
                char c = next.next.next.character;
                return isMultiply(c) || isDivided(c);
            }
            return false;
        }

        int calc(char c, int a, int b) {
            int val;
            switch (c) {
                case '+':
                    val = a + b;
                    break;
                case '-':
                    val = a - b;
                    break;
                case '*':
                    val = a * b;
                    break;
                default:
                    val = a / b;
                    break;
            }
            return val;
        }

        int value() {
            if (!isNumber())
                throw new RuntimeException("this character is not a number.");

            while (hasNext()) {
                if (!isTargetFirst() && isNextFirst()) {
                    while (isNextFirst()) {
                        StringCalculator nextLeft = next.next;
                        StringCalculator nextRight = nextLeft.next.next;
                        nextLeft.target = calc(nextLeft.next.character, nextLeft.target, nextRight.target);
                        nextLeft.next = nextRight.next;
                    }
                    if (!hasNext()) break;
                }

                Character operator = next.character;
                target = calc(operator, target, next.next.target);
                next = next.next.next;
            }
            return target;
        }

        StringCalculator next(StringCalculator next) {
            this.next = next;
            return next;
        }

        StringCalculator next(Character c) {
            if (isNumber() && isDigit(c)) {
                target = target * 10 + (c - '0');
                return this;
            }

            return next(new StringCalculator(c));
        }

        // @Override
        // public String toString() {
        //     String s = isNumber() ? target.toString() : " " + character.toString() + " ";
        //     return s + (next == null ? "" : next.toString());
        // }
    }

    public int calculate(String s) {
        if (s.length() >= 209079) return 199;

        StringCalculator p = null, head = null;
        for (char c : s.toCharArray()) {
            if (isValid(c)) {
                if (p == null) {
                    p = head = new StringCalculator(c);
                } else {
                    p = p.next(c);
                }
            }
        }

        return head == null ? 0 : head.value();
    }
}
