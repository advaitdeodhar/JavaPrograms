package LeetCode150;

class IntegerToRoman14 {

    int[] number;
    String[] roman;

    public IntegerToRoman14() {

        number = new int[13];
        roman = new String[13];

        int i = 0;
        number[i++] = 1000;
        number[i++] = 900;
        number[i++] = 500;
        number[i++] = 400;
        number[i++] = 100;
        number[i++] = 90;
        number[i++] = 50;
        number[i++] = 40;
        number[i++] = 10;
        number[i++] = 9;
        number[i++] = 5;
        number[i++] = 4;
        number[i++] = 1;

        i = 0;
        roman[i++] = "M";
        roman[i++] = "CM";
        roman[i++] = "D";
        roman[i++] = "CD";
        roman[i++] = "C";
        roman[i++] = "XC";
        roman[i++] = "L";
        roman[i++] = "XL";
        roman[i++] = "X";
        roman[i++] = "IX";
        roman[i++] = "V";
        roman[i++] = "IV";
        roman[i++] = "I";

    }
    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        int ref = 0;
        while ( num > 0 ) {

            if ( num >= number[ref]) {
                ans.append(roman[ref]);
                num -= number[ref];
            } else {
                ref++;
            }

        }

        return ans.toString();

    }

    public static void main(String[] args) {
        IntegerToRoman14 s = new IntegerToRoman14();

        System.out.println(s.intToRoman(3749));
    }

}
