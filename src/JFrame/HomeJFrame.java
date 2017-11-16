package JFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import List.Store_List;
import Bean.Store;
import List.Merchanidse_List;
import Utils.JsonFileToStoreList_Utils;
import Utils.StoreListToJsonFile_Utils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class HomeJFrame extends JFrame {

    // 默认表格模型
    private DefaultTableModel model = null;
    private JTable table = null;

    private JButton addBtn = null;

    private JPopupMenu jpm;
    private JMenuItem Browse;
    private JMenuItem Delele;

    private JLabel l_usr;

    private JLabel l_who;

    private static Store_List store_list;

    public HomeJFrame(String usrname) throws HeadlessException {
        super();
        setTitle("商家概览");
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

        l_usr = new JLabel("当前用户： " + usrname);

        l_usr.setBounds(0, 0, 120, 40);


        l_who = new JLabel("当前角色：管理员");
        l_who.setBounds(150, 0, 200, 40);

        addBtn = new JButton("添加店铺");
        addBtn.setBounds(880, 0, 100, 40);


        add(l_usr);
        add(l_who);
        add(addBtn, BorderLayout.NORTH);


        String[][] datas = {};
        String[] titles = {"编号", "店铺名", "信誉度"};
        model = new DefaultTableModel(datas, titles);
        table = new JTable(model);
        table.setRowHeight(20);
        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(0, 40, 1000, 760);
        add(jScrollPane);


        store_list = JsonFileToStoreList_Utils.JsonFileToStoreList();
        Store bean = store_list.getHead_store();


        while (true) {
            bean = bean.getNext_Store();
            if (bean == null) {
                break;
            } else {
                model.addRow(new String[]{bean.getId(), bean.getName(), bean.getCre()});
            }
        }


        addBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                GoAddStoreFrame();


            }
        });


        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);


                if (e.getClickCount() == 2) {

                }
                if (e.getButton() == MouseEvent.BUTTON3) {
                    //在table显示
                    jpm = new JPopupMenu();

                    //表格 的rowAtPoint方法返回坐标所在的行号，参数为坐标类型，
                    int i = table.rowAtPoint(e.getPoint());

                    Browse = new JMenuItem("查看详细信息");
                    Delele = new JMenuItem("删除店铺信息");
                    jpm.add(Browse);
                    jpm.add(Delele);

                    int x = e.getX();
                    int y = e.getY();

                    jpm.show(table, e.getX(), e.getY());


                    Browse.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int r = table.getSelectedRow();
                            int c = table.getSelectedColumn();
                            int d = table.getRowHeight();
                            //Object value = table.getValueAt(r, c);
                            String info = r + "行" + c + "列" + " " + d;

                            JOptionPane.showMessageDialog(null, info);

                        }
                    });

                    Delele.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String info = "x:" + x + " y:" + y;

                            JOptionPane.showMessageDialog(null, info);

                        }
                    });


                } else if (e.getButton() == MouseEvent.BUTTON1) {
                    int r = table.getSelectedRow();
                    int c = table.getSelectedColumn();
                    //得到选中的单元格的值，表格中都是字符串

                   /* Object value = table.getValueAt(r, c);
                    String info = r + "行" + c + "列值 : " + value.toString();

                    JOptionPane.showMessageDialog(null, info);*/

                    GoStoreInfoFRame(new Merchanidse_List(), r + 1);
                }

            }
        });


        setSize(1000, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);


    }

    private void GoAddStoreFrame() {
        AddStore addStore = new AddStore("dmrf");
        this.setVisible(false);
    }


    private void GoStoreInfoFRame(Merchanidse_List merchanidse_list, int r) {
        this.setVisible(false);
        StoreInformationJFrame storeInformationJFrame = new StoreInformationJFrame(merchanidse_list, store_list.get_Store(r));
        storeInformationJFrame.setVisible(true);
    }

    public static void SaveChange(Store store) throws IOException {
        store.setId(String.valueOf(store_list.getLength() + 1));
        store_list.Insert_Store(store_list.getLength() + 1, store);
        StoreListToJsonFile_Utils.StoreListToJsonFile(store_list);
        System.out.println("增加成功～");
    }

    public static void DeleleStore(String id) throws IOException {
        store_list.delete_Store(Integer.parseInt(id));
        StoreListToJsonFile_Utils.StoreListToJsonFile(store_list);

        store_list = JsonFileToStoreList_Utils.JsonFileToStoreList();
        Store bean = store_list.getHead_store();
        System.out.println("删除成功～");


    }


}

