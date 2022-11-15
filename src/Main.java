import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
    System.out.println(repeat("rep", 3));
    int[] num2 = new int[]{1, 2, 3, 4, 5, 6};
    System.out.println(difference(num2));
    int[] num3 = new int[]{1, 2, 3, 4, 5, 6, 7};
    System.out.println(average(num3));
    num2 = cumulative(num2);
    System.out.println(Arrays.toString(num2));
    System.out.println(getDecimalPlaces("10.0875"));
    System.out.println(fibonacci(12));
    System.out.println(index("a0010"));
    System.out.println(strangePair("go", "og"));
    System.out.println(isPref("automobile", "auto-"));
    System.out.println(isSuf("automobile", "-mobile"));
    System.out.println(boxSeq(5));
    }

    public static String repeat(String s, int x) {
        int length = s.length();
        String s1 = "";
        int y = x;
        int n = 0;
        while (n < (length)) {
            y = x;
            while (y > 0) {
                y--;
                s1 = s1 + s.charAt(n);
            }
            n++;
        }
        return s1;
    }
    public static int difference(int[] mass){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int j : mass) {
            if (j > max) {
                max = j;
            }
        }
        for (int j : mass) {
            if (j < min) {
                min = j;
            }
        }
        return max-min;
    }
    public static boolean average(int[] mass){
        int sum = 0;
        for (int j : mass) {
            sum += j;
        }
        return ((sum % mass.length) == 0);
    }
    public static int[] cumulative(int[] mass){
        int sum = 0;
        int[] mass2 = new int[mass.length];
        for (int i = 0; i < mass.length; i++){
            sum += mass[i];
            mass2[i] += sum;
        }
        return mass2;
    }
    public static int getDecimalPlaces(String s){
        int digits = 0;
        for (int i = 0; i < s.length()-1; i++){
            if (s.charAt(i) == '.')
                while (i < s.length()){
                    digits++;
                    i++;
                }
        }
        return digits-1;
    }
    public static int fibonacci(int x){
        int[] dig = new int[x+1];
        dig[0] = 1;
        dig[1] = 1;
        for (int i = 0; i < (dig.length-2); i++){
            dig[i+2] = dig[i+1]+dig[i];
        }
        return dig[x];
    }
    public static boolean index(String n){
        int i = 0;
        int length = n.length();
        if (length != 5)
            return false;
        while (i < (length)){
            int j = (n.charAt(i));
            if ((j < 48) || (j > 57)){
                return false;
            }
            i++;
        }
        return true;
    }
    static public boolean strangePair(String x, String y){
        if ((x.length() == 0) && (y.length() == 0))
            return true;
        if ((x.length() == 0) || (y.length() == 0))
            return false;
        return Objects.equals(x.charAt(x.length() - 1), y.charAt(0));
    }
    static public boolean isPref(String x, String y){
        int L = y.length() - 1;
        int i = 0;
        int j = 0;
        if((y.charAt((y.length())-1)) == '-'){
            while(i < L){
                if (x.charAt(j) == y.charAt(i)) {
                    i++;
                    j++;
                }
                else return false;
            }
        }
        else return false;
        return true;
    }
    static public boolean isSuf(String x, String y){
        return x.endsWith(y.substring(1, (y.length())));
    }
    static public int boxSeq(int i){
        if (i == 0)
            return 0;
        else if(i%2==0)
            return boxSeq(i - 1) - 1;
        else return boxSeq(i - 1) + 3;
        }
}