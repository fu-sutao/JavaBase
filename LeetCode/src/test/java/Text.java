import org.junit.Test;

public class Text {
    @Test
    public void Fanzhuan(){
        //给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
//
// 示例 1:
//
// 输入: 123
//输出: 321
//
//
// 示例 2:
//
// 输入: -123
//输出: -321
//
//
// 示例 3:
//
// 输入: 120
//输出: 21
//
//
// 注意:
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
// Related Topics 数学
// 👍 2187 👎 0
        int x = 1534236469;
        int res ;
        if(x<0){
            String a = String.valueOf(x);
            StringBuilder temp = new StringBuilder(a.substring(1,a.length()));

            temp = temp.reverse();
            String b ="-"+ temp;
            try{
                int a1 = Integer.valueOf(b);
                res = a1;
            }catch(Exception e){
                //
                res =0;
            }


        }else {

            StringBuilder temp = new StringBuilder(String.valueOf(x));

            temp = temp.reverse();

            try{
                int a1 = Integer.valueOf(temp.toString());
                res = a1;
            }catch(Exception e){
                //
                res =0;
            }
        }
        System.out.println(res);

    }
    @Test
    public void A(){
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Math.pow(2,31));
    }
    @Test
    public void B(){
        int num ;
        

        
    }


}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    