package JFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInJFrame extends JFrame {

    JTextField tf_username;
    JPasswordField tf_password;


    public LogInJFrame() throws HeadlessException {
        super();
        setTitle("登录");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = getToolkit(); // 获得Toolkit对象
        Dimension dimension = toolkit.getScreenSize(); // 获得Dimension对象
        int screenHeight = dimension.height; // 获得屏幕的高度
        int screenWidth = dimension.width; // 获得屏幕的宽度
        int frm_Height = this.getHeight(); // 获得窗体的高度
        int frm_width = this.getWidth(); // 获得窗体的宽度
        setLocation((screenWidth - frm_width) / 2,
                (screenHeight - frm_Height) / 2); // 使用窗体居中显示

        getContentPane().setLayout(null);


        final JLabel l_username = new JLabel();
        l_username.setText("请输入用户名：");
        l_username.setBounds(175, 50, 100, 25);
        getContentPane().add(l_username);


        tf_username = new JTextField();
        tf_username.setBounds(275, 50, 150, 25);
        getContentPane().add(tf_username);


        final JLabel l_password = new JLabel();
        l_password.setText("请输入密码：");
        l_password.setBounds(175, 150, 100, 25);
        getContentPane().add(l_password);


        tf_password = new JPasswordField();
        tf_password.setBounds(275, 150, 150, 25);
        getContentPane().add(tf_password);


        final JButton bt_login = new JButton();
        bt_login.setText("登录");
        bt_login.setBounds(250, 250, 100, 25);
        getContentPane().add(bt_login);


        bt_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tf_username.getText().trim();
                String passworld = tf_password.getText().trim();
                if (username.equals("DMRF") && passworld.equals("161630213")) {
                    //JOptionPane.showMessageDialog(null, "登录成功！");
                    GoHomeFRame();

                } else {

                    JOptionPane.showMessageDialog(null, "账号密码错误！");

                }
            }
        });
    }


    private void GoHomeFRame() {
        this.setVisible(false);
        HomeJFrame homeJFrame = new HomeJFrame("DMRF");
        homeJFrame.setVisible(true);
    }
}

