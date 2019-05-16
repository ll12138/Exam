package com.oxy.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;

/**
 * excel工具
 */

/**
 * @Description 将workbook写入response
 */
public class ExcelUtils {

	/**
	 * @Description 将Excel写入response
	 * @param workbook
	 * @param response
	 * @param docName
	 *            文件名
	 * @throws IOException
	 */
	public static void excelToResponse(Workbook workbook, HttpServletResponse response, String docName)
			throws IOException {
		response.setContentType("application/msword;charset=UTF-8");
		docName = URLEncoder.encode(docName, "UTF-8");
		response.addHeader("Content-Disposition", "attachment;filename=" + docName);
		OutputStream out = response.getOutputStream();
		workbook.write(out);
	}
	
	/**
	 * @Description excel公式求和SUM(B4:B100)
	 * @param row 合计行
	 * @param sumCell 合计行求和的列表
	 * @param start 求和起点的行B4--4
	 * @param end  结束行B100--100
	 * @param style 
	 */
	public static void getSumCell(XSSFRow row, int sumCell, int start,int end, XSSFCellStyle style) {
		// 获取列名(A B C D...)
		String colString = CellReference.convertNumToColString(sumCell);
		// 求和公式SUM(B4:B100)
		String sumstring = "SUM(" + colString + start+":" + colString + (end) + ")";
		row.getCell(sumCell).setCellFormula(sumstring);
		if(style!=null){
			row.getCell(sumCell).setCellStyle(style);
		}
	}

}
