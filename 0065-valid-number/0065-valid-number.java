class Solution {
    public boolean isNumber(String s) {

        boolean digit = false;
        boolean dot = false;
        boolean exponent = false;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            // Digit
            if (Character.isDigit(c)) {
                digit = true;
            }

            // Dot
            else if (c == '.') {

                // Dot cannot appear twice or after exponent
                if (dot || exponent) {
                    return false;
                }

                dot = true;
            }

            // e or E
            else if (c == 'e' || c == 'E') {

                // Must have a digit before e
                // and e can appear only once
                if (exponent || !digit) {
                    return false;
                }

                exponent = true;
                digit = false;  // Need digit after e
            }

            // Sign
            else if (c == '+' || c == '-') {

                // Sign is valid only at beginning
                // or immediately after e/E
                if (i != 0 &&
                    s.charAt(i - 1) != 'e' &&
                    s.charAt(i - 1) != 'E') {
                    return false;
                }
            }

            // Anything else
            else {
                return false;
            }
        }

        // Must have a digit at the end
        return digit;
    }
}