package corejava.test;

public class Test {

    public static void main(String[] args) {

        String a = "1hA2";

        int sum = a.chars()
                .filter(x -> Character.isDigit(x))       // no cast needed, isDigit takes int too
                .map(x -> x - 48)                        // '1'-'0'=1, '2'-'0'=2
                .sum();
        System.out.println(sum);

    }
}
