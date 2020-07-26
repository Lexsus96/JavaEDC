package part1.lesson01.task03;

public class Sex {
    private String s;
    public static final String MAN = "MAN";
    public static final String WOMAN = "WOMAN";
    public Sex(boolean sex) {
        if (sex) {
            this.s = MAN;
        } else {
            this.s = WOMAN;
        }
    }

    public String getS() {
        return s;
    }
}
