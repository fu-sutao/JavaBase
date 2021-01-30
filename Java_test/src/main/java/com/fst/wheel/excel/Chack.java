package com.fst.wheel.excel;

import java.io.*;
import java.util.ArrayList;
//文件校验模块
//输入一个文件流，inputstrng，返回文件类型
public class Chack {

//    public static void main(String[] args) throws Exception {
//        File file = new File("D:/IO/aa.x");
//        InputStream ina = new FileInputStream(file);
//        BufferedInputStream in = new BufferedInputStream(ina);
//        System.out.println(getFileType(in));
//        System.out.println(getInbyte(in,8));
//
//    }

    //输入一个文件对象，和要取的文件对象的前numb个字节，如果文件不存在则抛出异常,
    //文件大小为零时也会返回null
    public static String getInbyte(File file,int numb){
        try {
            if (file.exists()&&file.isFile()){
                InputStream in = new FileInputStream(file);
                return getInbyte(in,0,numb);
            }
        }catch (Exception e){

        }
        return null;
    }
    public static String getInbyte(File file,int start, int numb){
        if (file.exists()&&file.isFile()){
            try {
                InputStream in = new FileInputStream(file);
                return getInbyte(in,start,numb);
            }catch (Exception e){

            }
        }
        return null;
    }
    public static String getInbyte(InputStream in,int numb){
        return getInbyte(in,0,numb);
    }
    //定义的方法中in流未关闭。
    public static String getInbyte(InputStream in, int start,int numb) {

        byte by[] = new byte[numb];
        StringBuffer temp = new StringBuffer();
        //第二次读取会从对一次读取的后面开始读
        //504b03040a0000000000874ee240000000000000
        //    03040a0000000000874ee240000000000000
        try {
            if(in.read(by, start, by.length)!=-1){
                for (int i=start;i<by.length;i++) {
                    byte b = by[i];
                    int a = b & 0xff;//转化为无符号类型
                    if (a < 16) {
                        temp.append("0").append(Integer.toHexString(a));
                    } else {
                        temp.append(Integer.toHexString(a));
                    }
                }
                return temp.toString();
            }
        }catch (Exception e){
            //System.out.println(e.getMessage());
        }
        return null;
    }
    //获取文件类型
    public static String getFileType(BufferedInputStream in){
        //缓存处理，保证调用完后指针指向输出流的头部
        in.mark(1024*1024);//128个字节以内标记有效

        ArrayList<Magic> arrayList = getmagic();
        ArrayList<Magic> arrayList1 = new ArrayList<>();//备用容器
        for(int j = 0;j<16;j+=2){
            String var = getInbyte(in,1);//in流的字节
            for(int i=0;i<arrayList.size();i++){//
                String var2 = arrayList.get(i).getNumber();//从魔数库中调取魔数
                int lan = var2.length();//获得魔术长度
                if(j+1<lan){
                    //小于这个长度可以可是截取字符串
                    if(var2.substring(j,j+2).equals(var)){//比较第一个字节
                        arrayList1.add(arrayList.get(i));//相同加入到备用容器中
                    }
                }
            }
            //魔数库遍历一遍后判断备用容器中的数量，符合条件返回对应类型
            if(arrayList.size()==1){
                try {
                    in.reset();
                }catch (Exception e){

                }
                return arrayList.get(0).getType();
            }else if(arrayList.size()==0){
                return null;
            }
            //不符合，进行第二轮处理
            //清空魔数库，将筛选后的魔数加入魔数库
            arrayList.clear();
            arrayList.addAll(arrayList1);
            //清空容器
            arrayList1.clear();

        }
        return null;
    }
    //魔数库
    private static ArrayList<Magic> getmagic(){
        ArrayList<Magic> arrayList = new ArrayList<Magic>();
        arrayList.add(new Magic("d0cf11e0a1","xls"));
        arrayList.add(new Magic("504b03040a","xlsx"));
        arrayList.add(new Magic("FFD8FF","JPEG"));
        arrayList.add(new Magic("89504E47","PNG"));
        arrayList.add(new Magic("47494638","GIF"));
        arrayList.add(new Magic("49492A00","TIFF"));
        arrayList.add(new Magic("41433130","dwg"));
        arrayList.add(new Magic("38425053","psd"));
        arrayList.add(new Magic("3C3F786D6C","XML"));
        arrayList.add(new Magic("68746D6C3E","HTML"));
        arrayList.add(new Magic("255044462D312E","PDF"));
        arrayList.add(new Magic("504B0304","ZIP"));
        arrayList.add(new Magic("52617221","RAR"));
        arrayList.add(new Magic("41564920","AVI"));
        arrayList.add(new Magic("CAFEBABE","CLASS"));
        return arrayList;
    }

}
class Magic{
    public Magic(String number,String type){
        this.number = number;
        this.type = type;
    }
    private String number;
    private String type;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
