package 内存可见性;

/**
 * Created by robin on 19/1/10.
 */
public class VisibilityDemo extends Thread {

    volatile private boolean stop;

    @Override
    public void run() {
        int i = 0;
        System.out.println("执行循环");
        while (!isStop()) {
            i++;
        }
        System.out.println("执行完成, i=" + i);
    }


    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public static void main(String[] args) throws InterruptedException {
        VisibilityDemo demo = new VisibilityDemo();
        demo.start();

        Thread.sleep(1000);

        demo.setStop(true);
        System.out.println("程序执行完毕: " + demo.isStop());

    }


}
