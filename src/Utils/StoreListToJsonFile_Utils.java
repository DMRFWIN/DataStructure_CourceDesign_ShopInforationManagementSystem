package Utils;

import Bean.Store;
import List.Store_List;
import com.google.gson.Gson;

import java.io.*;

public class StoreListToJsonFile_Utils {

    public static void StoreListToJsonFile(Store_List store_list) throws IOException {
        int i = 1;


        File file = new File("/home/dmrf/文档/DataStructure/CourseDesign/StoreInformation.json");

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "GBK"));

        Store s = store_list.getHead_store().getNext_Store();


        while (true) {

            if (s == null) {
                break;
            } else {


                Gson gson = new Gson();
                String str = gson.toJson(s);
                if (s.getId().equals("1")) {
                    str = "[" + str + ",";
                } else {
                    str = str + ",";
                }
                if ((s = s.getNext_Store()) == null) {
                    str = str + "]";
                }


                bw.write(str);
                bw.newLine();
            }
        }

        bw.flush();
        System.out.println("写入文件成功~");
    }

}
