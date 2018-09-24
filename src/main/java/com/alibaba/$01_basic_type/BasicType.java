package com.alibaba.$01_basic_type;

/**
 * 有哪些基础数据类型
 * Created by Administrator on 2018/9/22.
 */
public class BasicType {


    /**
     * Java语言提供了八种基本类型。六种数字类型（四个整数型，两个浮点型），一种字符类型，还有一种布尔型。
     */

    /**
     * byte 数据类型是8位、有符号的，以二进制补码表示的整数；
     * 最小值是 -128（-2^7）；
     * 最大值是 127（2^7-1）；
     * 默认值是 0；
     * byte 类型用在大型数组中节约空间，主要代替整数，因为 byte 变量占用的空间只有 int 类型的四分之一；
     * <p>
     * 字节是byte
     * 位是bit
     * 1 byte = 8 bit
     * <p>
     * 补码：简单地说,补码就是反码加1.
     * 主要原因：1、使用补码，可以将符号位和其它位统一处理；同时，减法也可按加法来处理。另外，两个用补 码表示的数相加时，如果最高位（符号位）有进位，则进位被舍弃。 2、补码与原码的转换过程几乎是相同的。
     */
    protected static byte aByte;

    /**
     * short 数据类型是 16 位、有符号的以二进制补码表示的整数
     * 最小值是 -32768（-2^15）；
     * 最大值是 32767（2^15 - 1）；
     * Short 数据类型也可以像 byte 那样节省空间。一个short变量是int型变量所占空间的二分之一；
     * 默认值是 0；
     * 例子：short s = 1000，short r = -20000。
     */
    protected static short aShort;

    /**
     * int 数据类型是32位、有符号的以二进制补码表示的整数；
     * 最小值是 -2,147,483,648（-2^31）；
     * 最大值是 2,147,483,647（2^31 - 1）；
     * 一般地整型变量默认为 int 类型；
     * 默认值是 0 ；
     * 例子：int a = 100000, int b = -200000。
     */
    protected static int anInt;
    /**
     * long 数据类型是 64 位、有符号的以二进制补码表示的整数；
     * 最小值是 -9,223,372,036,854,775,808（-2^63）；
     * 最大值是 9,223,372,036,854,775,807（2^63 -1）；
     * 这种类型主要使用在需要比较大整数的系统上；
     * 默认值是 0L；
     * 例子： long a = 100000L，Long b = -200000L。
     * "L"理论上不分大小写，但是若写成"l"容易与数字"1"混淆，不容易分辩。所以最好大写。
     */
    protected static long aLong;

    /**
     * float 数据类型是单精度、32位、符合IEEE 754标准的浮点数；
     * float 在储存大型浮点数组的时候可节省内存空间；
     * 默认值是 0.0f；
     * 浮点数不能用来表示精确的值，如货币；
     * 例子：float f1 = 234.5f。
     */
    protected static float aFloat;

    /**
     * double 数据类型是双精度、64 位、符合IEEE 754标准的浮点数；
     * 浮点数的默认类型为double类型；
     * double类型同样不能表示精确的值，如货币；
     * 默认值是 0.0d；
     * 例子：double d1 = 123.4。
     */
    protected static double aDouble;

    /**
     * boolean数据类型表示一位的信息；
     * 只有两个取值：true 和 false；
     * 这种类型只作为一种标志来记录 true/false 情况；
     * 默认值是 false；
     * 例子：boolean one = true。
     */
    protected static boolean aBoolean;

    /**
     * char类型是一个单一的 16 位 Unicode 字符；
     * 最小值是 \u0000（即为0）；
     * 最大值是 \uffff（即为65,535）；
     * char 数据类型可以储存任何字符；
     * 例子：char letter = 'A';。
     */
    protected static char aChar;


    public static void main(String[] args) {

        // byte
        System.out.println("基本类型：byte 二进制位数：" + Byte.SIZE);
        System.out.println("包装类：java.lang.Byte");
        System.out.println("最小值：Byte.MIN_VALUE=" + Byte.MIN_VALUE);
        System.out.println("最大值：Byte.MAX_VALUE=" + Byte.MAX_VALUE);
        System.out.println();

        // short
        System.out.println("基本类型：short 二进制位数：" + Short.SIZE);
        System.out.println("包装类：java.lang.Short");
        System.out.println("最小值：Short.MIN_VALUE=" + Short.MIN_VALUE);
        System.out.println("最大值：Short.MAX_VALUE=" + Short.MAX_VALUE);
        System.out.println();

        // int
        System.out.println("基本类型：int 二进制位数：" + Integer.SIZE);
        System.out.println("包装类：java.lang.Integer");
        System.out.println("最小值：Integer.MIN_VALUE=" + Integer.MIN_VALUE);
        System.out.println("最大值：Integer.MAX_VALUE=" + Integer.MAX_VALUE);
        System.out.println();

        // long
        System.out.println("基本类型：long 二进制位数：" + Long.SIZE);
        System.out.println("包装类：java.lang.Long");
        System.out.println("最小值：Long.MIN_VALUE=" + Long.MIN_VALUE);
        System.out.println("最大值：Long.MAX_VALUE=" + Long.MAX_VALUE);
        System.out.println();

        // float
        System.out.println("基本类型：float 二进制位数：" + Float.SIZE);
        System.out.println("包装类：java.lang.Float");
        System.out.println("最小值：Float.MIN_VALUE=" + Float.MIN_VALUE);
        System.out.println("最大值：Float.MAX_VALUE=" + Float.MAX_VALUE);
        System.out.println();

        // double
        System.out.println("基本类型：double 二进制位数：" + Double.SIZE);
        System.out.println("包装类：java.lang.Double");
        System.out.println("最小值：Double.MIN_VALUE=" + Double.MIN_VALUE);
        System.out.println("最大值：Double.MAX_VALUE=" + Double.MAX_VALUE);
        System.out.println();

        // char
        System.out.println("基本类型：char 二进制位数：" + Character.SIZE);
        System.out.println("包装类：java.lang.Character");
        // 以数值形式而不是字符形式将Character.MIN_VALUE输出到控制台
        System.out.println("最小值：Character.MIN_VALUE="
                + (int) Character.MIN_VALUE);
        // 以数值形式而不是字符形式将Character.MAX_VALUE输出到控制台
        System.out.println("最大值：Character.MAX_VALUE="
                + (int) Character.MAX_VALUE);

    }

}
