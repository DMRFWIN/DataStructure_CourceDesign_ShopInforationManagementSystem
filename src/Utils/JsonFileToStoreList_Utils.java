package Utils;

import Bean.Store;
import List.Store_List;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import javax.swing.*;
import java.io.*;
import java.util.Iterator;

public class JsonFileToStoreList_Utils {


    public static Store_List JsonFileToStoreList() {
        Store_List store_list = new Store_List();

        String json = ReadFile("/home/dmrf/文档/DataStructure/CourseDesign/StoreInformation.json");

        Gson gson = new Gson();
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(json);  //将json字符串转换成JsonElement
        JsonArray jsonArray = jsonElement.getAsJsonArray();  //将JsonElement转换成JsonArray
        Iterator it = jsonArray.iterator();  //Iterator处理

        int i = 1;
        while (it.hasNext()) {  //循环
            jsonElement = (JsonElement) it.next(); //提取JsonElement
            json = jsonElement.toString();  //JsonElement转换成String
            Store bean = gson.fromJson(json, Store.class); //String转化成JavaBean
           // bean.setId(String.valueOf(Integer.valueOf(bean.getId())-6));
            store_list.Insert_Store(i, bean);
            i++;
            //System.out.println("i：" + i);
        }
        System.out.println("i：" + i);
        return store_list;

    }


    //读文件，返回字符串
    public static String ReadFile(String path) {
        File file = new File(path);
        BufferedReader reader = null;
        String laststr = "";
        try {
            //System.out.println("以行为单位读取文件内容，一次读一整行：");
            //reader = new BufferedReader(new FileReader(file),"GBK");
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "gbk"));
            String tempString = null;
            //一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                //显示行号
                laststr = laststr + tempString;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return laststr;
    }
}


