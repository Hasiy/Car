package car;

/**
 * Created by zhuxiaoyao on 2017/6/28.
 */
import java.security.MessageDigest;
public class MakeMD5 {
    public final static String password(String str){
        // 用来将字节转换成 16 进制表示的字符
        char hexDiagiArr[]={'0','1','2','3','4','5','6','7','8','9','0','a','b','c','d','e','f'};
        MessageDigest digest=null;
        try{
            digest=MessageDigest.getInstance("MD5");     //创建MD5算法摘要
            digest.update(str.getBytes());                 //更新摘要
            byte mdBytes[]=digest.digest();                 //加密，并返回字节数组
            //新建字符数组，长度为myBytes字节数组的2倍，用于保存加密后的值
            char newCArr[]=new char[mdBytes.length*2];
            int k=0;
            for(int i=0;i<mdBytes.length;i++){
                byte byte0=mdBytes[i];
                newCArr[k++]=hexDiagiArr[byte0>>>4&0x0f]; //取字节中高 4 位的数字转换,>>>为逻辑右移，将符号位一起右移
                newCArr[k++]=hexDiagiArr[byte0&0x0f];     //取字节中低 4 位的数字转换
                //针对字符0-9的，0-9的ascii码值为0x30，0x31，0x32 0x33 ...0x39，
                //因此与0x0f按位与后只保留个位上的书即0x0，0x1，。。。0x9
                //  0000 1010
                //& 0000 1111
                //  0000 1010
            }
            return String.valueOf(newCArr);   //将转换后的字符转换为字符串
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
/*  todo String password=request.getParameter("pwd2"); password=MakeMD5.password(password); */