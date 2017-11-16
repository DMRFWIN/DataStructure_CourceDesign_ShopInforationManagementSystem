package JFrame;

import Bean.Merchanidse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import List.Merchanidse_List;

public class MerchanidseInfoJFrame extends JFrame {


    JLabel l_id;
    JLabel l_cre;
    JLabel l_name;
    JLabel l_price;

    JTextField t_id;
    JTextField t_name;
    JTextField t_cre;
    JTextField t_price;


    JButton edit;
    JButton delete;

    boolean flag=false;

    private Merchanidse_List merchanidse_list;


    public MerchanidseInfoJFrame(Merchanidse merchanidse) throws HeadlessException {
        super();
        setTitle("商品管理");

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


        l_id = new JLabel("商品编号：");
        l_id.setBounds(200, 20, 80, 30);

        t_id = new JTextField(merchanidse.getId());
        t_id.setBounds(280, 20, 120, 30);
        t_id.setEditable(false);

        add(l_id);
        add(t_id);


        l_name = new JLabel("商品名称：");
        l_name.setBounds(200, 120, 80, 30);

        t_name = new JTextField(merchanidse.getName());
        t_name.setBounds(280, 120, 120, 30);
        t_name.setEditable(false);

        add(l_name);
        add(t_name);


        l_price = new JLabel("商品价格：");
        l_price.setBounds(200, 220, 80, 30);

        t_price = new JTextField(String.valueOf(merchanidse.getPrice()));
        t_price.setBounds(280, 220, 120, 30);
        t_price.setEditable(false);

        add(l_price);
        add(t_price);

        l_cre = new JLabel("商品销量：");
        l_cre.setBounds(200, 320, 80, 30);

        t_cre = new JTextField(merchanidse.getSales());
        t_cre.setBounds(280, 320, 120, 30);
        t_cre.setEditable(false);


        add(l_cre);
        add(t_cre);


        edit = new JButton("修改商品信息");
        edit.setBounds(165, 420, 115, 30);
        add(edit);

        delete = new JButton("删除该商品");
        delete.setBounds(335, 420, 115, 30);
        add(delete);



        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!flag) {
                    t_cre.setEditable(true);
                    t_name.setEditable(true);
                    t_price.setEditable(true);
                    edit.setText("确定");
                    flag = true;
                } else {

                    String new_name = t_name.getText().trim();
                    String new_cre = t_cre.getText().trim();
                    String new_price = t_price.getText().trim();


                    if (!new_cre.equals("") && !new_name.equals("")) {
                        t_cre.setEditable(false);
                        t_name.setEditable(false);
                        t_price.setEditable(false);
                        edit.setText("修改");
                        flag = false;

                        /*
                        用这里得到的new_name和new_cre更新链表数据
                         */
                    } else {
                        System.out.println("空～");
                        JOptionPane.showMessageDialog(null, "店铺名称和店铺信誉值不可为空！");
                    }

                }

            }
        });



        setSize(600, 550);
        setVisible(true);

    }
}
