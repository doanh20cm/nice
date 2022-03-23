package etc;

public class test2 {
    public static void main(String[] args) {
        // convert decimal to binary
        int n = 10;
        int binary = 0;
        int remainder;
        int i = 1;
        while (n != 0) {
            remainder = n % 2;
            n = n / 2;
            binary = binary + (remainder * i);
            i = i * 10;
        }
        System.out.println(binary);

    }
}
