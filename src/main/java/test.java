public class test {
    public static void main(String[] args) {
        int x=2 ; String ms;
        switch (x) {
            case 1: ms = "January"; System.out.print(ms + " ");
            case 2: x++; ms = "February"; System.out.print(ms + " ");
            case 3: x++; ms = "March"; System.out.print(ms + " ");
            case 4: ms = "April"; System.out.print(ms + " ");
            case 5: ms = "May"; System.out.print(ms + " ");
                break;
            case 6: ms = "June"; System.out.print(ms + " ");
            default: ms = "Invalid month"; System.out.print(ms + " ");
        }
        System.out.println(x);
    }
}