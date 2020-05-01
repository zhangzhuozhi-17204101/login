package webadv.s99201105.p02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import org.apache.commons.codec.digest.DigestUtils;
public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
    	Scanner sc = new Scanner(System.in);
    		
    		try {
    			//创建文件输出流
    			//创建文件对象输出流
    			FileOutputStream fos = new FileOutputStream("d:/c.txt");
    			ObjectOutputStream oos = new ObjectOutputStream(fos);
    			//创建文件输入流
    			//创建文件对象输入流
    			FileInputStream fes = new FileInputStream("d:/c.txt");
    			ObjectInputStream ois = new ObjectInputStream(fes);
    			//创建普通对象
    			User user = new User("张三","8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92");
    			//实现序列化：序列化就是将内存中的Java对象已制定的二进制序列写入到特定的流中
    			oos.writeObject(user);
    			//实现反序列化
    			User user2 = (User) ois.readObject();
    			System.out.println(user2);
    			String name2 = user2.getName();
    			String password2 = user2.getPassword();
    			System.out.println(name2);
    			
    			System.out.println("请输入用户名:");
    			String name = sc.next();
    			System.out.println("请输入用户密码：");
    			String password = sha256hex(sc.next());
    			if(name.equals(user2.getName()) && password.equals(user2.getPassword())) {
    				System.out.println("登陆成功");
    			}else {
    				System.out.println("登陆失败！");
    			}
    			
    		} catch (FileNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}


  
    }
    public static String sha256hex(String input) {
        return DigestUtils.sha256Hex(input);
    }
}

