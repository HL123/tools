import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @classname FileSize
 * @escription 获取指定目录下的文件和文件夹，并输出文件大小
 * @author huanglei
 * @date 2022/3/29 3:44 下午
 * @version 1.0
 */
public class FileSize {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        String path = "/Users/huanglei/Downloads";
        getFile(path);
        long end = System.currentTimeMillis();
        System.out.println("total time: " + (end - start) + "ms");
    }

    private static void getFile(String path) throws IOException {
        File file = new File(path);
        File[] array = file.listFiles();

        List<String> list = new ArrayList<String>();

        for (int i = 0; i < (array != null ? array.length : 0); i++){
            long size = FileUtils.sizeOf(array[i]);
            String size2Show = FileUtils.byteCountToDisplaySize(size);
            String result = null;

            if(array[i].isFile()){
                result = "File name: " + array[i].getName() + "  size:" + size2Show;
            }else if(array[i].isDirectory()){
                result = "Directory name: " + array[i].getName() + "  size:" + size2Show;
            }

            list.add(result);
            System.out.println(result);
            FileUtils.writeLines(new File("/Users/huanglei/Desktop/filelist.txt"), list, "\n", false);
        }

    }

}
