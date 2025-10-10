class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        String result = "0";
        int m = num1.length();
        int n = num2.length();

        for (int i = n - 1; i >= 0; i--) {
            int digit2 = num2.charAt(i) - '0';
            StringBuilder current = new StringBuilder();
            
            for (int k = 0; k < n - 1 - i; k++) {
                current.append('0');
            }

            int carry = 0;
            for (int j = m - 1; j >= 0; j--) {
                int digit1 = num1.charAt(j) - '0';
                int product = digit1 * digit2 + carry;
                current.append(product % 10);
                carry = product / 10;
            }

            if (carry > 0) {
                current.append(carry);
            }

            result = addStrings(result, current.reverse().toString());
        }

        return result;
    }

    private String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) sum += num1.charAt(i--) - '0';
            if (j >= 0) sum += num2.charAt(j--) - '0';

            sb.append(sum % 10);
            carry = sum / 10;
        }

        return sb.reverse().toString();
    }
}
