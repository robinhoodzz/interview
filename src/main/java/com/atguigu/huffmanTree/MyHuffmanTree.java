package com.atguigu.huffmanTree;

import java.util.*;

/**
 * 赫夫曼树代码实现:
 * 1. 统计字符数并排序
 * 2. 创建赫夫曼树
 * 3. 创建赫夫曼树编码表
 * 4. 编码
 * <p>
 * Created by robin on 18/12/20.
 */
public class MyHuffmanTree {

    // 用于临时存储路径
    static StringBuilder sb = new StringBuilder();
    // 用与存储赫夫曼编码
    static Map<Byte, String> huffCodeMap = new HashMap<>();

    public static void main(String[] args) {
        String str = "can you can a can as a can canner can a can.";
        byte[] oriBytes = str.getBytes();
        /** 进行赫夫曼编码 */
        byte[] pressedBytes = huffmanZip(oriBytes);

        /** 使用赫夫曼编码进行解码 */
        byte[] decodeBytes = decode(pressedBytes);

        System.out.println(Arrays.toString(oriBytes));
        System.out.println(Arrays.toString(decodeBytes));
        System.out.println(new String(decodeBytes));
    }

    /**
     * 使用指定的赫夫曼编码进行解码
     *
     * @param pressedBytes
     * @return
     */
    private static byte[] decode(byte[] pressedBytes) {
        StringBuilder sb = new StringBuilder();

        // 把byte数组转为一个二进制的字符串
        for (int i = 0; i < pressedBytes.length; i++) {
            byte b = pressedBytes[i];
            // 是否最后一个
            boolean flag = (i == pressedBytes.length - 1);
            sb.append(byteToBitStr(!flag, b));
        }

        // 把字符串按照指定的赫夫曼编码进行解码
        // 把赫夫曼编码的键值对进行调换
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffCodeMap.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }

        // 创建一个集合, 用于存byte
        List<Byte> list = new ArrayList<>();
        // 处理字符串
        for (int i = 0; i < sb.length(); ) {
            int count = 1;
            boolean flag = true;
            Byte aByte = null;

            // 截取出一个byte
            while (flag) {

                String key = sb.substring(i, i + count);
                aByte = map.get(key);
                if (aByte == null) {
                    count++;
                } else {
                    flag = false;
                }
            }
            list.add(aByte);
            i += count;
        }
        // 把集合转化为数组
        byte[] bytes = new byte[list.size()];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = list.get(i);
        }
        return bytes;
    }

    private static String byteToBitStr(boolean flag, byte bytes) {
        int tmp = bytes;
        if (flag)
            tmp |= 256;
        String str = Integer.toBinaryString(tmp);
        if (flag)
            return str.substring(str.length() - 8);
        else
            return str;
    }

    /**
     * 赫夫曼 压缩编码
     *
     * @param bytes
     * @return
     */
    private static byte[] huffmanZip(byte[] bytes) {
        /** 统计每一个byte出现的次数,并放入一个集合中 */
        List<HuffmanNode> nodeList = getNodes(bytes);
        /** 创建一颗赫夫曼树 */
        HuffmanNode tree = createHuffmanTree(nodeList);
        /** 创建一个赫夫曼编码表 */
        Map<Byte, String> huffCodeMap = getCodes(tree);
        /** 编码 */
        byte[] zipBytes = zip(bytes, huffCodeMap);

        return zipBytes;
    }

    /**
     * 进行赫夫曼编码
     *
     * @param bytes
     * @param huffCodeMap
     * @return
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffCodeMap) {

        StringBuilder sb = new StringBuilder();

        // 把需要压缩的byte数组处理成一个二进制字符串
        for (byte aByte : bytes) {
            sb.append(huffCodeMap.get(aByte));
        }

        // 定义长度
        int len;
        if (sb.length() % 8 == 0) {
            len = sb.length() / 8;
        } else {
            len = sb.length() / 8 + 1;
        }

        // 用于存储压缩后的byte
        byte[] by = new byte[len];
        // 记录新byte的位置
        int index = 0;
        for (int i = 0; i < sb.length(); i += 8) {
            String strByte;
            if (i + 8 > sb.length()) {
                strByte = sb.substring(i);
            } else {
                strByte = sb.substring(i, i + 8);
            }
            byte byt = (byte) Integer.parseInt(strByte, 2);
            by[index] = byt;
            index++;
        }
        return by;
    }

    /**
     * 根据赫夫曼树,获取赫夫曼编码
     *
     * @param tree
     * @return
     */
    private static Map<Byte, String> getCodes(HuffmanNode tree) {
        if (tree == null) return null;


        getCodes(tree.left, "0", sb);
        getCodes(tree.right, "1", sb);

        return huffCodeMap;
    }

    /**
     * @param node
     * @param code
     * @param sb
     */
    private static void getCodes(HuffmanNode node, String code, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append(code);

        if (node.data == null) {
            getCodes(node.left, "0", sb2);
            getCodes(node.right, "1", sb2);
        } else {
            huffCodeMap.put(node.data, sb2.toString());
        }
    }

    /**
     * 创建 赫夫曼树
     *
     * @param nodeList
     * @return
     */
    private static HuffmanNode createHuffmanTree(List<HuffmanNode> nodeList) {

        while (nodeList.size() > 1) {
            // 排序
            Collections.sort(nodeList);
            // 取出两个权值最低的二叉树
            HuffmanNode left = nodeList.get(nodeList.size() - 1);
            HuffmanNode right = nodeList.get(nodeList.size() - 2);
            // 创建一颗新的二叉树
            HuffmanNode parent = new HuffmanNode(null, left.weight + right.weight);
            // 把之前取出来的二叉树设置为新创建的二叉树子树
            parent.left = left;
            parent.right = right;
            // 把前面取出来的二叉树删除
            nodeList.remove(left);
            nodeList.remove(right);
            // 把新创建的二叉树放入集合中
            nodeList.add(parent);
        }
        return nodeList.get(0);
    }

    private static List<HuffmanNode> getNodes(byte[] bytes) {
        List<HuffmanNode> list = new ArrayList<>();
        /** 存储每一个byte出现了多少次 */
        Map<Byte, Integer> map = new HashMap<>();
        /** 统计每一个byte出现的次数 */
        for (byte byt : bytes) {
            Integer integer = map.get(byt);
            if (integer == null) {
                map.put(byt, 1);
            } else {
                map.put(byt, integer + 1);
            }
        }
        /** 把每一个键值对转为Node对象 */
        map.forEach((x, y) -> list.add(new HuffmanNode(x, y)));

        return list;
    }
}
