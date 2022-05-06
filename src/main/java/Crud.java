
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.json.JSONUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Crud {
    public static void main(String[] args) {
        //判断文件是否存在
//        if (FileUtil.isFile("/Users/work/github/mini-db/db.json")) {
//            System.out.println();
//        }
        //替换你文件的未知
        String dbPath = "/Users/work/github/mini-db/db.json";
        String result = FileUtil.readString(dbPath, CharsetUtil.charset("UTF-8"));
         // 第一个参数就是json字符串，第二个就是json对应的javabean
        Result mini = JSONUtil.toBean(result, Result.class);
        String op=null;
        Scanner sc=new Scanner(System.in);
        boolean flag=true;
        while (flag){
            System.out.printf("mini-db:>");
            String op1=sc.next();
            String op2=null;
            if (!"exit".equals(op1)){
                if (sc.hasNext()){
                    op2=sc.next();
                }
            }
            String op3=null;
            if ("set".equals(op1)){
                if (sc.hasNext()){
                    op3=sc.next();
                }
            }
            if ("exit".equals(op1)){
                sc.close();
                // 将数据回写到json文件或者 定时 或者按照数量写到json中
                flag=false;
                FileUtil.writeUtf8String(JSONUtil.toJsonStr(mini), dbPath);
            }

            if ("get".equals(op1)){
                System.out.println(mini.getDb().get("string").get(op2));

            }

            if ("set".equals(op1)){
                Map map =mini.getDb().get("string");
                map.put(op2,op3);
                // 日志
                String nowTime = DateUtil.format(new Date(), "yyyyMMddHHmmss");
                Map logMap =mini.getLog();
                logMap.put(nowTime,"{\"methods\":\"set\",\"status\":\"success\"}");

                Map<String, Map> db = new HashMap<>();
                db.put("string",map);
                mini.setDb(db);

                mini.setLog(logMap);
                System.out.println("OK");
                // 可设置多少次重写文件中
//                FileUtil.writeUtf8String(JSONUtil.toJsonStr(mini),dbPath);
            }
        }

    }
}
