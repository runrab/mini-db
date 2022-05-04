
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.json.JSONUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Crud {
    public static void main(String[] args) {
        //判断文件是否存在
//        if (FileUtil.isFile("src/main/resources/db.json")) {
//            System.out.println();
//        }

        String result = FileUtil.readString("db.json", CharsetUtil.charset("UTF-8"));
         // 第一个参数就是json字符串，第二个就是json对应的javabean
        Result mini = JSONUtil.toBean(result, Result.class);

//        System.out.println(mini.getVersion());

//        System.out.println(mini.getDb().get("string").get("name"));

        String op=null;
        /**
         * ====type== op   ==
         * string   get key    set key value
         *
         * hash     hget key k
         * */

//        while (op=="exit"){
//            Scanner sc=new Scanner(System.in);
//            op = sc.nextLine();
////            mini.getDb().get("string").get("name");
//            System.out.println(mini.getDb().get("string").get(op));
//        }

        Scanner sc=new Scanner(System.in);
        boolean flag=true;
        while (flag){
            System.out.printf("mini-db:>");
//            op = sc.next();
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
//            System.out.println(sc.next());
//            System.out.println(sc.next());
            if ("exit".equals(op1)){
                sc.close();
                // 将数据回写到json文件或者 定时 或者按照数量写到json中
                flag=false;
                FileUtil.writeUtf8String(JSONUtil.toJsonStr(mini), "db.json");
            }

            if ("get".equals(op1)){
                System.out.println(mini.getDb().get("string").get(op2));

            }

            if ("set".equals(op1)){
                Map map =mini.getDb().get("string");
//                map.remove(op2);
                map.put(op2,op3);
                Map<String, Map> db = new HashMap<>();
                db.put("string",map);
                mini.setDb(db);
                System.out.println("OK");
//                System.out.println(mini.getDb().get("string").get(op2));
                // 可设置多少次重写文件中
//                FileUtil.writeUtf8String(JSONUtil.toJsonStr(mini),"db.json");
            }

//            System.out.println(mini.getDb().get("string").get(op));

        }


        //加载db到jsonObject

        //增删改查


    }
}
