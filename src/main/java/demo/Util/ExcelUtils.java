package demo.Util;

import demo.dto.Information;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by: zhangbingbing
 * @date 2018/7/5
 **/
public class ExcelUtils {

    // 去读Excel的方法readExcel，该方法的入口参数为一个File对象
    public static List<Information> readExcel(String path) {
        try {
            File file = new File(path);
            // 创建输入流，读取Excel
            InputStream is = new FileInputStream(file.getAbsolutePath());
            // jxl提供的Workbook类
            Workbook wb = Workbook.getWorkbook(is);
            // Excel的页签数量
            int sheet_size = wb.getNumberOfSheets();
            for (int index = 0; index < sheet_size; index++) {
                List<Information> outerList = new ArrayList<Information>();
                // 每个页签创建一个Sheet对象
                Sheet sheet = wb.getSheet(index);
                // sheet.getRows()返回该页的总行数
                for (int i = 1; i < sheet.getRows(); i++) {
                    List innerList = new ArrayList();
                    // sheet.getColumns()返回该页的总列数
                    Information info = new Information();
                    for (int j = 0; j < sheet.getColumns(); j++) {
                        String cellinfo = sheet.getCell(j, i).getContents();
                        if (cellinfo.isEmpty()) {
                            continue;
                        }
                        switch (j){
                            case 0: info.setName(cellinfo);
                            break;
                            case 1: info.setTelphone(cellinfo);
                            break;
                            case 2: info.setKuandaiNo(cellinfo);
                            break;
                            case 3: info.setAddress(cellinfo);
                            break;
                            case 4: info.setKDAddr(cellinfo);
                            break;
                            case 5: info.setBegainDate(cellinfo);
                            break;
                            case 6: info.setEndDate(cellinfo);
                            break;
                            default:info.setRemark(cellinfo);
                        }
                    }
                    outerList.add(info);
                }
                return outerList;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public List<Information> getInfo(List list){
//    }
    public static void main(String[] args) {
        String patt = "E:/kuandai.xls";

        String tel = "123";
        List<Information> list = readExcel(patt);
        List<Information> result = new ArrayList<Information>();
        for(Information temp : list){
            if(temp.getTelphone().equals(tel)){
                result.add(temp);
            }
        }
        System.out.println(result);
        System.out.println(list);
    }
}
