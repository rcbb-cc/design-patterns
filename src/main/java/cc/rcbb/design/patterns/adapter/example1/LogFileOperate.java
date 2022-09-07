package cc.rcbb.design.patterns.adapter.example1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * LogFileOperate 实现对日志文件的操作
 * </p>
 *
 * @author rcbb.cc
 * @date 2022/9/7
 */
public class LogFileOperate implements LogFileOperateApi {
    /**
     * 日志文件的路径和文件名称，默认是当前项目的根下的AdapterLog.log
     */
    private String logFilePathName = "AdapterLog.log";

    /**
     * 构造方法，传入文件的路径和名称
     *
     * @param logFilePathName 文件的路径和名称
     */
    public LogFileOperate(String logFilePathName) {
        //先判断是否传入了文件的路径和名称，如果是，
        //就重新设置操作的日志文件的路径和名称
        if (logFilePathName != null && logFilePathName.trim().length() > 0) {
            this.logFilePathName = logFilePathName;
        }
    }

    @Override
    public List<LogModel> readLogFile() {
        List<LogModel> list = new ArrayList<>();
        ObjectInputStream oin = null;
        try {
            File f = new File(logFilePathName);
            if (f.exists()) {
                oin = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
                list = (List<LogModel>) oin.readObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (oin != null) {
                    oin.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public void writeLogFile(List<LogModel> list) {
        File f = new File(logFilePathName);
        ObjectOutputStream oout = null;
        try {
            oout = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
            oout.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
