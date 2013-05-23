package com.app.inv.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.app.inv.mapper.TranMapper;
import com.app.inv.model.OrderList;
import com.app.inv.model.Tran;
import com.app.inv.model.TranList;
import com.app.inv.model.TranOrder;

public class TranService implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 455224890463372687L;
	
	@Inject
	private transient TranMapper tranMapper;
	
	public TranList loadTran(String startDate, String endDate){
		
		List<Tran> tranList = tranMapper.loadTransaction(startDate, endDate);
		
		for(Tran tran:tranList){
			OrderList orderList = new OrderList(tranMapper.loadTransactionOrder(tran.getCodeTransaction()));
			tran.setOrderList(orderList);
		}
		
		return new TranList(tranList);
	}
	
	public void printTran(TranList tranList){
		String fileName = "D:\\Magnum Opus\\test.xls";
	    Workbook wb = new HSSFWorkbook();
	    int rowCounter = 0;
	    int colLength;
	    
	    
        
            
        String[] col = {"Time", "Transaction Number", "Dine in", "Item Ordered", "Price", "Total Amount"};
        Sheet sheet = wb.createSheet("test");
        Row row = sheet.createRow(rowCounter++);
        colLength = col.length;
        for(int i = 0; i < col.length; i++){
            Cell cell = row.createCell(i, Cell.CELL_TYPE_STRING);
            cell.setCellValue(col[i]);
        }
        
        for(Tran tran:tranList.getTranList()){
            row = sheet.createRow(rowCounter++);
            Cell cell = row.createCell(0, Cell.CELL_TYPE_STRING);
            cell.setCellValue(tran.getTimeStamp().toString());
            CellStyle cs = cell.getCellStyle();
            
            Cell cell1 = row.createCell(1, Cell.CELL_TYPE_NUMERIC);
            cell1.setCellValue(tran.getCodeTransaction());
            Cell cell2 = row.createCell(2, Cell.CELL_TYPE_STRING);
            if(tran.getIndDineIn()){
                cell2.setCellValue("Yes");
            } else {
                cell2.setCellValue("No");
            }
            int rowOrder = rowCounter;
            Row innerRow = row;
            boolean status = false;
            for(TranOrder tranOrder:tran.getOrderList().getTranOrderList()){
            	if(status){
            		innerRow = sheet.createRow(rowOrder++);
            	}
            	Cell cell3 = innerRow.createCell(3, Cell.CELL_TYPE_STRING);
                cell3.setCellValue(tranOrder.getMenuItemName());
                Cell cell4 = innerRow.createCell(4, Cell.CELL_TYPE_NUMERIC);
                cell4.setCellValue(tranOrder.getMenuItemPrice());
                status = true;
            }
            
            
            Cell cell5 = row.createCell(5, Cell.CELL_TYPE_NUMERIC);
            cell5.setCellValue(tran.getTotalAmount());
            rowCounter = rowOrder;
        }
        
        FileOutputStream out = null;
        try {
			out = new FileOutputStream(fileName);
			wb.write(out);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        	   
	}
	
}
