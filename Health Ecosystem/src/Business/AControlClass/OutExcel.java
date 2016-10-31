/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.AControlClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.scene.control.Cell;
 
  
import javax.swing.JOptionPane;  
import javax.swing.JTable;  
import javax.swing.table.DefaultTableModel;  
  
import jxl.CellType;  
import jxl.LabelCell;  
import jxl.NumberCell;  
import jxl.Sheet;  
import jxl.Workbook;  
import jxl.read.biff.BiffException; 

/**
 *
 * @author Cassiopeia
 */
public class OutExcel {

    public boolean readExcel(File file, DefaultTableModel tableModel, JTable jTable) {
        Workbook rwb = null;

        Object[] object = new Object[jTable.getColumnCount()];
        try {

            FileInputStream is = new FileInputStream(file);
            //创建一个workbook类读取excel文件  
            rwb = Workbook.getWorkbook(is);
//          得到第i个工作薄  
            Sheet st = rwb.getSheet(0);//这里有两种方法获取sheet表,1为名字，而为下标，从0开始  
//          //得到st的列数  
//          System.out.println("列"+ st.getColumns());  
//          //得到st的行数  
//          System.out.println("行"+ st.getRows());  
            if (st.getRows() > 2) {
                for (int t = tableModel.getRowCount() - 1; t >= 0; t--) {
                    tableModel.removeRow(t);
                }
                //行循环  
                for (int i = 1; i < st.getRows(); i++) {
                    //列循环  
                    for (int j = 0; j < st.getColumns(); j++) {
                        //      得到第j列第i行的数据  
                        jxl.Cell c00 = st.getCell(j, i);
                        if (c00.getType() == CellType.LABEL) {
                            LabelCell labelc00 = (LabelCell) c00;
                            object[j] = labelc00.getString();
                            //jTable.setValueAt(labelc00.getString(), i-1, j);  
                        } else if (c00.getType() == CellType.NUMBER) {
                            Double numd;
                            int numi;
                            NumberCell numc10 = (NumberCell) c00;
                            numd = new Double(numc10.getValue());
                            numi = numd.intValue();
                            object[j] = numi;
//                          jTable.setValueAt(numi, i-1, j);  
                        }

                    }
                    tableModel.addRow(object);
                }
            } else {
                for (int i = 1; i < st.getRows(); i++) {
                    //列循环  
                    for (int j = 0; j < st.getColumns(); j++) {
                        //      得到第j列第i行的数据  
                        jxl.Cell c00 = st.getCell(j, i);
                        if (c00.getType() == CellType.LABEL) {
                            LabelCell labelc00 = (LabelCell) c00;
                            object[j] = labelc00.getString();
                            //jTable.setValueAt(labelc00.getString(), i-1, j);  
                        } else if (c00.getType() == CellType.NUMBER) {
                            Double numd;
                            int numi;
                            NumberCell numc10 = (NumberCell) c00;
                            numd = new Double(numc10.getValue());
                            numi = numd.intValue();
                            object[j] = numi;
//                          jTable.setValueAt(numi, i-1, j);  
                        }

                    }
                    tableModel.addRow(object);
                }
            }
            JOptionPane.showMessageDialog(null, "导入" + file.getName() + "成功", "成功", JOptionPane.INFORMATION_MESSAGE);

        } catch (FileNotFoundException e) {

            System.out.println("文件" + file.getName() + "没有找到");

            return false;

        } catch (BiffException e) {

            System.out.println("文件格式不正确");

            return false;

        } catch (IOException e) {

            System.out.println("文件读写失败");

            return false;

        } finally {
//          关闭  
            rwb.close();
        }
        return true;
    }

}
