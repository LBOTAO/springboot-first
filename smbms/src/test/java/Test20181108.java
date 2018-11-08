import org.junit.Test;

/**
 * author：  刘涛
 *
 * @create 2018-11-08 10:09
 */
public class Test20181108 {
    public static void main(String[] args) {
       String str="8,11,13,14,37,";
        String[] split = str.split(",");
        for (String item:split){
            System.out.print(item.toString());
        }
    }
}
