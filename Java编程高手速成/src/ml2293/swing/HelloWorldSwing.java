package ml2293.swing;

/*
 * 一个简单的swing窗体程序
 */
import javax.swing.*;

public class HelloWorldSwing {

    /**
     * 创建GUI并显示。从线程安全方面考虑，从javax.swing.SwingUtilities.invokeLater中创建线程启动窗口。
     */
    private static void createAndShowGUI() {
        //创建窗体
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //增加一个“你好，世界！”的标签
        JLabel label = new JLabel("你好，世界！");
        frame.getContentPane().add(label);

        //显示窗体.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //创建线程启动窗口
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
