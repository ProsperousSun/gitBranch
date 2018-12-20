package sumrize.SocketLearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemIn {
    public static void main(String[] args) throws IOException {
        //System.in的用法和原理
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        String message;
        while (true) {
            message = re.readLine();
            System.out.println(message);
        }
    }
}
/**
 * System.in的类型可以归结为节点流、字节流、输入流；
 * InputStreamReader这个对象是处理流，字符流，输入流；
 * BufferedReader的类型是缓冲处理流、字符流、输入流。
 *
 *   类 InputStreamReader是字节流通向字符流的桥梁：它使用指定的 charset 读取字节并将其解码为字符。它使用的字符集可以由名称指定或显式给定，或者可以接受平台默认的字符集。如：GBK 
 *   每次调用 InputStreamReader 中的一个 read() 方法都会导致从底层输入流读取一个或多个字节。要启用从字节到字符的有效转换，可以提前从底层流读取更多的字节，使其超过满足当前读取操作所需的字节。 为了达到最高效率，可要考虑在 BufferedReader 内包装 InputStreamReader。例如：  BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
 *
 * System.in是个字节流
 *
 * InputStreamReader是个字符流和字节流之间的转换中介
 *
 * BufferedReader是个字符流
 * 整体意思就是用InputStreamReader这个中介把System.in这个字节流转换成字符流BufferedReader
 * 这样输入的时候就可以不是一个一个字节读，而是一个一个字符读，再加上是个Buffer，效率会高很多。
 * InputStream is = System.in;//键盘输入流
 * InputStreamReader isr = new InputStreamReader(is);//字节流转换为字符流
 * BufferedReader bufr = new BufferedReader(isr);//把字符流添加到缓冲流
 *
 * 用户通过reader对象的readLine方法来进行读取。
 * ---------------------
 */
