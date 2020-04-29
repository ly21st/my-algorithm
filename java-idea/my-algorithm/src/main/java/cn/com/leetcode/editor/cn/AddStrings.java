package cn.com.leetcode.editor.cn;

public class AddStrings {
        public String addStrings(String num1, String num2) {
            int len1 = num1.length();
            int len2 = num2.length();
            char []arr;
            int t;
            if (len1 >= len2) {
                arr = num1.toCharArray();
                t = len1 - 1;
            } else {
                arr = num2.toCharArray();
                t = len2 - 1;
            }
            int j1 = len1 - 1;
            int j2 = len2 - 1;
            boolean addFlag = false;
            for (; j1 >= 0 && j2 >= 0; j1--, j2--) {
                char c1 = num1.charAt(j1);
                char c2 = num2.charAt(j2);
                int n;
                if (addFlag) {
                    n = c1 - '0' + c2 - '0' + 1;
                } else {
                    n = c1 - '0' + c2 - '0';
                }

                if (n > 9) {
                    arr[t--] = (char)(n - 10 + '0');
                    addFlag = true;
                }
                else {
                    arr[t--] = (char)(n + '0');
                    addFlag = false;
                }
            }
            StringBuffer str = new StringBuffer();
            if (t < 0 && addFlag) {
                return "1" + String.valueOf(arr);
            }
            return String.valueOf(arr);
        }
        public static void main(String[] args) {
            AddStrings s = new AddStrings();
            s.addStrings("9", "99");
        }
}
