public class TestDemo {
    public static void main(String arg[]) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (Integer i = 0; i < 100; i++) {
                    System.out.println(i);
                }
            }
        }).start();

        for (Integer i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}
