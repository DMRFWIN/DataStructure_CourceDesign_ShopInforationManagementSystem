package JFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import Bean.Store;
import List.Merchanidse_List;

public class StoreInformationJFrame extends JFrame {

    private boolean flag = false;

    // 默认表格模型
    private DefaultTableModel model = null;
    private JTable table = null;

    private JButton edit = null;
    private JButton delete = null;
    private JButton add = null;


    private JPopupMenu jpm;
    private JMenuItem Browse;
    private JMenuItem Delele;

    private JTextField t_id;
    private JTextField t_name;
    private JTextField t_cre;


    private JLabel l_id;
    private JLabel l_name;
    private JLabel l_cre;


    private Merchanidse_List merchanidse_list;

    private Store m_store;

    public StoreInformationJFrame(Merchanidse_List merchanidse_list, Store store) throws HeadlessException {
        super();
        if (store == null) {
            System.out.println("store为空！");
            return;
        } else {
            m_store = store;
        }

        setTitle("商铺信息管理");
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


        l_id = new JLabel("店铺编号：  ");
        t_id = new JTextField(store.getId());
        t_id.setEditable(false);


        l_name = new JLabel("店铺名称：  ");
        t_name = new JTextField(store.getName());
        t_name.setEditable(false);


        l_cre = new JLabel("店铺信誉值：  ");
        t_cre = new JTextField(store.getCre());
        t_cre.setEditable(false);


        l_id.setBounds(20, 0, 80, 40);
        t_id.setBounds(100, 0, 40, 40);
        l_name.setBounds(140, 0, 80, 40);
        t_name.setBounds(220, 0, 200, 40);
        l_cre.setBounds(420, 0, 100, 40);
        t_cre.setBounds(500, 0, 40, 40);


        edit = new JButton("修改");
        edit.setBounds(600, 0, 80, 40);

        delete = new JButton("删除");
        delete.setBounds(700, 0, 80, 40);


        add = new JButton("添加商品");
        add.setBounds(800, 0, 150, 40);


        add(l_name);
        add(l_id);
        add(l_cre);
        add(t_name);
        add(t_cre);
        add(t_id);
        add(edit);
        add(delete);
        add(add);


        String[][] datas = {};
        String[] titles = {"编号", "商品名称", "价格", "销量"};
        model = new DefaultTableModel(datas, titles);
        table = new JTable(model);
        table.setRowHeight(20);
        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(0, 40, 1000, 800);

        add(jScrollPane);


        for (int i = 0; i < 100; i++) {
            model.addRow(new String[]{String.valueOf(i), "机械键盘", "100", "20"});
        }

        SetListener();


        setSize(1000, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);


    }

    private void SetListener() {
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!flag) {
                    t_cre.setEditable(true);
                    t_name.setEditable(true);
                    edit.setText("确定");
                    flag = true;
                } else {

                    String new_name = t_name.getText().trim();
                    String new_cre = t_cre.getText().trim();
                    if (!new_cre.equals("") && !new_name.equals("")) {
                        t_cre.setEditable(false);
                        t_name.setEditable(false);
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

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int r = table.getSelectedRow();
                int c = table.getSelectedColumn();
                //得到选中的单元格的值，表格中都是字符串
                Object value = table.getValueAt(r, c);
                String info = r + "行" + c + "列值 : " + value.toString();
                JOptionPane.showMessageDialog(null, info);
            }
        });


        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    HomeJFrame.DeleleStore(m_store.getId());
                    GoHomeFrame();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

    }


    private void GoHomeFrame() {
        new HomeJFrame("dmrf");
        this.setVisible(false);
    }

}
