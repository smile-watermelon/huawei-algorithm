package com.guagua.medium.string;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.xml.internal.ws.api.message.MessageWritable;

import javax.swing.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author guagua
 * @date 2022/10/21 14:05
 * @describe HJ66 配置文件恢复
 * <p>
 * 描述
 * 有6条配置命令，它们执行的结果分别是：
 * <p>
 * 命   令	执   行
 * reset	reset what
 * reset board	board fault
 * board add	where to add
 * board delete	no board at all
 * reboot backplane	impossible
 * backplane abort	install first
 * he he	unknown command
 * 注意：he he不是命令。
 * <p>
 * 为了简化输入，方便用户，以“最短唯一匹配原则”匹配（注：需从首字母开始进行匹配）：
 * <p>
 * 1、若只输入一字串，则只匹配一个关键字的命令行。例如输入：r，根据该规则，匹配命令reset，执行结果为：reset what；输入：res，根据该规则，匹配命令reset，执行结果为：reset what；
 * 2、若只输入一字串，但匹配命令有两个关键字，则匹配失败。例如输入：reb，可以找到命令reboot backpalne，但是该命令有两个关键词，所有匹配失败，执行结果为：unknown command
 * <p>
 * 3、若输入两字串，则先匹配第一关键字，如果有匹配，继续匹配第二关键字，如果仍不唯一，匹配失败。
 * 例如输入：r b，找到匹配命令reset board 和 reboot backplane，执行结果为：unknown command。
 * 例如输入：b a，无法确定是命令board add还是backplane abort，匹配失败。
 * 4、若输入两字串，则先匹配第一关键字，如果有匹配，继续匹配第二关键字，如果唯一，匹配成功。例如输入：bo a，确定是命令board add，匹配成功。
 * 5、若输入两字串，第一关键字匹配成功，则匹配第二关键字，若无匹配，失败。例如输入：b addr，无法匹配到相应的命令，所以执行结果为：unknow command。
 * 6、若匹配失败，打印“unknown command”
 * <p>
 * 注意：有多组输入。
 * 数据范围：数据组数：1\le t\le 800\1≤t≤800 ，字符串长度1\le s\le 20\1≤s≤20
 * 进阶：时间复杂度：O(n)\O(n) ，空间复杂度：O(n)\O(n)
 * 输入描述：
 * 多行字符串，每行字符串一条命令
 * <p>
 * 输出描述：
 * 执行结果，每条命令输出一行
 * <p>
 * 示例1
 * 输入：
 * reset
 * reset board
 * board add
 * board delet
 * reboot backplane
 * backplane abort
 * <p>
 * 输出：
 * reset what
 * board fault
 * where to add
 * no board at all
 * impossible
 * install first
 */
public class ProfileRecoveryHJ66 {

    static HashMap<String, String> map = new HashMap<>(6);
    static {
        map.put("reset", "reset what");
        map.put("reset board", "board fault");
        map.put("board add", "where to add");
        map.put("board delete", "no board at all");
        map.put("reboot backplane", "impossible");
        map.put("backplane abort", "install first");
    }


    public static void main(String[] args) {
//        boolean matches2 = "board delete".matches("^" + "board delet" + ".*");
//        System.out.println(matches2);

        m1();

    }

    public static void calculate() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String cmd = sc.nextLine();
            String[] cmdArr = cmd.split(" ");
            if (cmdArr.length == 1) {
                if ("reset".contains(cmd)) {
                    System.out.println(map.get("reset"));
                } else {
                    System.out.println("unknown command");
                }
            } else {
                String result = "unknown command";
                int count = 0;
                for (String key : map.keySet()) {
                    if (key.equals(cmd)) {
                        result = map.get(key);
                        break;
                    } else {
                        String[] keyArr = key.split(" ");
                        if (keyArr.length > 1 && keyArr[0].indexOf(cmdArr[0]) == 0 && keyArr[1].indexOf(cmdArr[1]) == 0) {
                            result = map.get(key);
                            count++;
                        }
                    }
                }
                System.out.println(count > 1 ? "unknown command" : result);
            }
        }
    }

    /**
     * ToDo 提交未通过
     */
    private static void m1() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String cmd = scanner.nextLine();
            String[] cmds = cmd.split(" ");

            int key0Count = 0;
            int key1Count = 0;
            String result = "";
            if (map.containsKey(cmd)) {
                result = map.get(cmd);
                System.out.println(result);
                continue;
            }

            for (Map.Entry<String, String> entry : map.entrySet()) {
                String realKey = entry.getKey();
                String realCmd = entry.getValue();
                String[] key = realKey.split(" ");
                boolean matches = key[0].matches("^" + cmds[0] + ".*");

                if (cmds.length == 1) {
                    if (key.length > 1) {
                        continue;
                    }
                    if (matches) {
                        if (key0Count > 1) {
                            System.out.println("unknown command");
                            break;
                        }
                        key0Count++;
                        result = realCmd;
                        break;
                    }
                }
                if (cmds.length == 2) {
                    if (key.length == 1) {
                        continue;
                    }
                    boolean matches1 = key[1].matches("^" + cmds[1] + ".*");
                    if (matches1 && matches) {
                        result = realCmd;
                        key1Count++;
                    }
                }
            }
            if (key1Count > 1) {
                System.out.println("unknown command");
            } else if (cmds.length ==1 && key0Count ==0){
                System.out.println("unknown command");
            }else {
                System.out.println(result);
            }
        }
    }
}
