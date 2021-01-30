package com.fst.excelParsing;
/**
 * @date 2019年8月25日 上午8:48:24 @author fst @Email 820913504@qq.com
 *  @purpose：
 *  	HSSF提供读写Microsoft Excel XLS格式档案的功能。
 *
 * 		XSSF提供读写Microsoft Excel OOXML XLSX格式档案的功能。
 *
 * 		HWPF提供读写Microsoft Word DOC格式档案的功能。
 *
 * 		HSLF提供读写Microsoft PowerPoint格式档案的功能。
 *
 * 		HDGF提供读Microsoft Visio格式档案的功能。
 *
 * 		HPBF提供读Microsoft Publisher格式档案的功能。
 *
 * 		HSMF提供读Microsoft Outlook格式档案的功能。
 */

import com.fst.wheel.excel.Chack;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class Main_c {
    public static void main(String [] args) throws Exception {
        //xls();
        //readExcel();
        //FileInputString1(new File("D:/IO/my.png"),8);
        String[][] a = readExcel(new File("D:/IO/aa.x"));
        System.out.println();
        //行   列
        System.out.println(a[2][4]);
    }
    //输入一个文件对象，和要取的文件对象的前numb个字节，如果文件不存在则抛出异常,
    //文件大小为零时也会返回null
    private static StringBuffer getFilebyte(File file, int numb) {

        if (file.exists()) {
            try (FileInputStream f = new FileInputStream(file)) {
                byte by[] = new byte[numb];
                StringBuffer temp = new StringBuffer();
                //第二次读取会从对一次读取的后面开始读
                if(f.read(by, 0, by.length)!=-1){
                    for (byte b : by) {
                        int a = b & 0xff;//转化为无符号类型

                        if (a < 16) {
                            temp.append("0").append(Integer.toHexString(a));
                        } else {
                            temp.append(Integer.toHexString(a));
                        }
                    }
                    return temp;
                }
                return null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public static void createxlsx() throws Exception {
        //如果文件格式是xlsx用这个方法在内存中创建工作簿
        Workbook wk = new XSSFWorkbook();
        FileOutputStream out = new FileOutputStream("D:\\用Poi作部分对不对薄.xlsx");
        //在工作簿上创建表
        Sheet sh =wk.createSheet("sheet1");//创建一个sheet页

        Row row=sh.createRow(0);//创建第一行
        //Cell cell= row.createCell(0);//创建第一行的第一个单元格
        //cell.setCellValue(1);				//为第一行第一个单元格塞值
        //row 行     column：列
        row.createCell(0).setCellValue(1);
        row.createCell(1).setCellValue(1.2);			//创建第一行第2个单元格并赋值
        row.createCell(2).setCellValue("这是一个字符串");//创建第一行第3个单元格并赋值
        row.createCell(3).setCellValue(true);			//创建第一行第4个单元格并赋值
        //对列填入序列的数据
        for (int i = 0; i < 100; i++ ){
            row = sh.createRow(i);
            row.createCell(0).setCellValue(i);
        }
        /* 对第一行填入序列值 */
        for (int i = 0; i < 20; i++){
            row.createCell(0);
            row.createCell(i).setCellValue(i);
        }
        wk.write(out);
        wk.close();
        out.close();
    }
    public static void createxls() throws Exception {
        Workbook wk = new HSSFWorkbook();//定义一个工作薄在内存中生成一个工作蒲
        //定义 在该路径中检查有没有文件，没有则在输出时创建
        FileOutputStream out= new FileOutputStream("D:\\用Poi搞出来的工作薄.xls");
        Sheet sh=wk.createSheet("第一个sheet页");//创建一个sheet页
        Row row=sh.createRow(0);//创建第一行
        Cell c = row.createCell(0);

        row.createCell(0).setCellValue(0);              //创建第一行第2个单元格并赋值
        row.createCell(1).setCellValue(1.2);			//创建第一行第2个单元格并赋值
        row.createCell(2).setCellValue("这是一个字符串");//创建第一行第3个单元格并赋值
        row.createCell(3).setCellValue(true);			//创建第一行第4个单元格并赋值
        System.out.println();


        wk.write(out);
        wk.close();
        out.close();
    }
    public static String[][] readExcel(File file) throws Exception {

        BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));

        return readExcel(in);
    }
    public static String[][] readExcel(InputStream ina) throws Exception {
        // 获取一个Excel
        Workbook wb = null;
//        File file = new File("D:/IO/aa.x");
//        in = new FileInputStream(file);
//        String s = getFilebyte(file,8).toString();
//        System.out.println(s);
        BufferedInputStream in = new BufferedInputStream(ina);
        //in.mark(1024*128);
        Chack chack = new Chack();
        String type = chack.getFileType(in);
        //in.reset();
        //BufferedOutputStream os = new BufferedOutputStream();

        //校验
        if(type.equals("xlsx")){
            wb = new XSSFWorkbook(in);
            //System.out.println("aa1");//xlsx
            //d0cf11e0a1b11ab1
        }else if(type.equals("xls")){
            wb = new HSSFWorkbook(in);//xls
            //System.out.println("xls");
        }else {
            return null;
        }
        // 获取第一个sheet
        //wb.get
        Sheet sheet = wb.getSheetAt(0);
        //System.out.println(sheet.getSheetName());
        Row row = sheet.getRow(0);
        // 获取最大列数  从左到右查找，返回不为空的列数目。
        //例如：035列有值，则返回3
        //int maxcell = row.getPhysicalNumberOfCells();
        //System.out.println(row.getLastCellNum());

        //获得最大列
        int maxcell = row.getLastCellNum();
        // 获取最大行数
        int maxrow = sheet.getPhysicalNumberOfRows();
        String[][] res = new String[maxrow][maxcell];
        for(int j=0;j<maxrow;j++){
            //获取第一行
            row = sheet.getRow(j);
            for(int i = 0; i < maxcell; i ++){
                Cell cell = row.getCell(i);
                String a1 = getDataValue(cell);
                res[j][i] = a1;
            }
        }
        return res;
    }
    /**	获取单个单元格数据
     * @param cell
     * @return
     * @author lizixiang ,2018-05-08
     */
    public static String getDataValue(Cell cell) {
        String cellValue = null;
        if (cell != null) {
            // 判断cell类型
            //System.out.print("类型weikong"+cell.getCellType());
            switch (cell.getCellType()) {
                //未知类型仅限内部使用
                case _NONE: {
                    cellValue = String.valueOf(cell.getNumericCellValue());
                    break;
                }
                //整数 小数 日期
                case NUMERIC: {
                    // 判断cell是否为日期格式
                    if (DateUtil.isCellDateFormatted(cell)) {
                        // 转换为日期格式YYYY-mm-dd
                        cellValue = String.valueOf(cell.getDateCellValue());
                    } else {
                        // 数字
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                //字符串
                case STRING: {
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                }
                //空单元格
                case BLANK:

                    break;
                    //布尔值
                case BOOLEAN:{
                    cellValue = String.valueOf(cell.getBooleanCellValue());
                    break;
                }
                //公式
                case FORMULA:{
                    cellValue = String.valueOf(cell.getCellFormula());
                    break;
                }
                case ERROR:

                    break;
                default:
                    System.out.print("类型weikong");
                    cellValue = "";
            }
        } else {

            cellValue = "";
        }
        return cellValue;
    }


}
