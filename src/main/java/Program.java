/**
 * Created by me on 21.01.2019.
 */
public class Program {
    public static void main(String[] args) {
        long m = System.currentTimeMillis();
        TestTask task = new TestTask("0 5 10 0 11 14 13 4 11 8 8 7 1 4 12 11");
        task.doIt();
        System.out.println("Количество шагов = " + task.getCountStep());
        System.out.println("Длина цикла  = " + task.getLengthCycle());
        System.out.println((double) (System.currentTimeMillis() - m));
    }
}
