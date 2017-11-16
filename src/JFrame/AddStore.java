package JFrame;

import Bean.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddStore extends JFrame {

    private JLabel l_usr;

    private JLabel l_who;


    private JLabel l_name;//商铺名称
    private JLabel l_cre;//商铺信誉值

    private JTextField t_name;
    private JTextField t_cre;


    private JButton ok;

    public AddStore(String username) throws HeadlessException {
        super();
        setTitle("新增商铺");
        //setSize(1000, 800);
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
        l_usr = new JLabel("当前用户： " + username);

        l_usr.setBounds(140, 0, 120, 40);


        l_who = new JLabel("当前角色：管理员");
        l_who.setBounds(290, 0, 200, 40);


        l_name = new JLabel("商铺名称：");
        l_name.setBounds(200, 80, 80, 30);

        t_name = new JTextField();
        t_name.setBounds(280, 80, 100, 30);


        l_cre = new JLabel("商铺信誉值：");
        l_cre.setBounds(200, 120, 80, 30);

        t_cre = new JTextField();
        t_cre.setBounds(280, 120, 100, 30);


        ok = new JButton("确定");
        ok.setBounds(270, 200, 60, 30);

        add(l_usr);
        add(l_who);

        add(l_name);
        add(t_name);

        add(l_cre);
        add(t_cre);

        add(ok);

        SetListener();

        setSize(600, 550);
        setVisible(true);
    }


    private void SetListener() {
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = t_name.getText().trim();
                String cre = t_cre.getText().trim();

                if (name.equals("") || cre.equals("")) {
                    JOptionPane.showMessageDialog(null, "店铺名称和店铺信誉值不可为空！");
                } else {
                    Store store = new Store();
                    store.setName(name);
                    store.setCre(cre);
                    store.setNext_Store(null);
                    store.setId(null);
                    try {
                        HomeJFrame.SaveChange(store);
                        GoHomeJFrame();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }

            }
        });
    }

    private void GoHomeJFrame() {

        HomeJFrame homeJFrame = new HomeJFrame("dmrf");
        this.setVisible(false);

    }
}
