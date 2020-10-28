import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloClassLoader extends ClassLoader {
    private static final String HELLO_CLASS_FILE = "./Hello.xlass";
    private static final String HELLO_CLASS_NAME = "Hello";
    private static final String HELLO_CLASS_METHOD = "hello";

    public static void main(String[] args) {
        try {
            // new HelloClassLoader().findClass("Hello").newInstance(); 
            // 获取自定义加载类Hello
            Class helloClass = new HelloClassLoader().findClass(HELLO_CLASS_NAME);
            // 反射获取hello方法
            Method helloMethod = helloClass.getMethod(HELLO_CLASS_METHOD);
            // 执行hello方法，输出：Hello, classLoader!
            helloMethod.invoke(helloClass.newInstance());
        } catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        } 
    }

    @Override
    public Class findClass(String name) {
        byte[] b = new byte[0];
        try {
            b = getContent(name);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return defineClass(name, b, 0, b.length);
    }

    private byte[] getContent(String fileName) throws FileNotFoundException {
        System.out.println(fileName);
        File file = new File(fileName);
        FileInputStream inputStream = new FileInputStream(file);
        byte[] buffer;
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        int nextValue = 0;
        try {
            while ( (nextValue = inputStream.read()) != -1 ) {
                byteStream.write(255 - nextValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        buffer = byteStream.toByteArray();
        return buffer;
    }
}
