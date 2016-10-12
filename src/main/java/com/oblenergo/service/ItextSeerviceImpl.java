package com.oblenergo.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.oblenergo.model.Orders;

@Service
public class ItextSeerviceImpl implements ItextService {

	@Autowired
	SapServiceImpl sapServiceImpl;

	public static File fontFile = new File("D://temp//unicodeItext//ARIALUNI.TTF");

	public static Font getFont() {
		BaseFont baseFont = null;
		try {
			baseFont = BaseFont.createFont("D://temp//unicodeItext//ARIALUNI.TTF", BaseFont.IDENTITY_H, true);
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Font font = new Font(baseFont);
		return font;
	}

	@Override
	public void writeCheck(Orders order) {

		Document document = new Document();
		document.setMargins(15, 150, 25, 2);
		//
		// Font normalFont10 = FontFactory.getFont(FontFactory.HELVETICA, 10,
		// Font.NORMAL, new CMYKColor(0, 0, 0, 0));
		// Font boldFont10 = FontFactory.getFont(FontFactory.TIMES_BOLD, 10,
		// Font.BOLD, new CMYKColor(0, 0, 0, 0));
		// Font boldFont14 = FontFactory.getFont(FontFactory.TIMES_BOLD, 14,
		// Font.BOLD, new CMYKColor(0, 0, 0, 0));

		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("c://testCheck.pdf"));

			document.open();

			// PdfPTable table = new PdfPTable(2); // 3 columns.
			// table.setWidthPercentage(50); // Width 100%
			// table.setSpacingBefore(5f); // Space before table
			// table.setSpacingAfter(5f); // Space after table

			// Set Column widths
			// float[] columnWidths = { 1f, 1f };
			// table.setWidths(columnWidths);

			// PdfPCell cell1 = new PdfPCell(new Paragraph("Постачальник : ",
			// font));
			// cell1.setBorderColor(BaseColor.DARK_GRAY);
			// // cell1.setPaddingLeft(2);
			// cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			//
			// PdfPCell cell2 = new PdfPCell(new Paragraph("00131564"));
			// cell2.setBorderColor(BaseColor.DARK_GRAY);
			// // cell2.setPaddingLeft(2);
			// cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

			// PdfPCell cell3 = new PdfPCell(new Paragraph("TEST"));
			// // cell3.setBorderColor(BaseColor.RED);
			// cell3.setPaddingLeft(10);
			// cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			//
			// table.addCell(cell1);
			// table.addCell(cell2);
			// table.addCell(cell3);

			document.add(createTable(order));

			document.close();
			writer.close();
		} catch (Exception e) {

		}
	}

	public static PdfPTable createTable(Orders order) {
		// a table with three columns
		PdfPTable table = new PdfPTable(2);
		table.setWidthPercentage(100); // Width 100%
		// Set Column widths
		float[] columnWidths = { 2f, 5f, };
		try {
			table.setWidths(columnWidths);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		// the cell object
		PdfPCell cell;
		// we add a cell with colspan 3
		cell = new PdfPCell(new Phrase("РАХУНОК-ФАКТУРА №  від " + getLocalDay(), getFont()));
		cell.setColspan(2);
		table.addCell(cell);
		// now we add a cell with rowspan 2
		cell = new PdfPCell(new Phrase("Постачальник : ", getFont()));
		// cell.setRowspan(2);
		table.addCell(cell);
		// we add the four remaining cells with addCell()
		table.addCell("00131564");

		cell = new PdfPCell(new Phrase("Адреса : ", getFont()));
		table.addCell(cell);
		table.addCell(new Phrase("76014, м.Івано-Франківськ, вул.Індустріальна ,34.", getFont()));

		cell = new PdfPCell(new Phrase("ІПН : ", getFont()));
		table.addCell(cell);
		table.addCell("001315609158");

		cell = new PdfPCell(new Phrase("Р/рахунок : ", getFont()));
		table.addCell(cell);
		table.addCell(new Phrase("Філія - Івано.-Франк.ОУ АТ Ощадбанк 336503 26003301757", getFont()));

		cell = new PdfPCell(new Phrase("Платник : ", getFont()));
		table.addCell(cell);
		table.addCell(new Phrase("Філія - Івано.-Франк.ОУ АТ Ощадбанк 336503 26003301757", getFont()));
		return table;
	}

	public static String getLocalDay() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		dateFormat.format(date);
		return dateFormat.format(date);
	}

}
