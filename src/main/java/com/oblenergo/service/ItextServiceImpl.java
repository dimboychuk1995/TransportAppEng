package com.oblenergo.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.oblenergo.model.Orders;

@Service
public class ItextServiceImpl implements ItextService {

	@Autowired
	SapServiceImpl sapServiceImpl;

	@Autowired
	ServletContext context;

	public Font getFont() {
		BaseFont baseFont = null;
		try {
			String path = context.getRealPath("/resources/ARIALUNI.TTF");

			baseFont = BaseFont.createFont(path, BaseFont.IDENTITY_H, true);
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
		document.setMargins(20, 50, 25, 2);

		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("c://check.pdf"));

			document.open();

			document.add(createTable(order));
			document.add(createTableOrder(order));
			document.close();
			writer.close();

		} catch (Exception e) {

		}
	}

	public PdfPTable createTable(Orders order) {
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
		cell.setBorderColor(BaseColor.WHITE);
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

		table.addCell(new Phrase(order.getCustomer(), getFont()));
		cell = new PdfPCell(new Phrase("Підстава : ", getFont()));
		table.addCell(cell);

		table.addCell(new Phrase("на підставі заказу №" + order.getId() + " від " + getLocalDay(), getFont()));

		cell = new PdfPCell(new Phrase("", getFont()));
		cell.setColspan(2);
		cell.setBorderColor(BaseColor.WHITE);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("", getFont()));
		cell.setColspan(2);
		cell.setBorderColor(BaseColor.WHITE);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("", getFont()));
		cell.setColspan(2);
		cell.setBorderColor(BaseColor.WHITE);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);
		return table;
	}

	public PdfPTable createTableOrder(Orders order) {
		// a table with three columns
		PdfPTable table = new PdfPTable(6);
		table.setWidthPercentage(100); // Width 100%
		// Set Column widths
		float[] columnWidths = { 5f, 2f, 2f, 2f, 2f, 2f };
		try {
			table.setWidths(columnWidths);
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		PdfPCell cell;
		cell = new PdfPCell(new Phrase("Найменування товару", getFont()));
		table.addCell(cell);
		table.addCell(new Phrase("Од.виміру", getFont()));
		table.addCell(new Phrase("Кількість", getFont()));
		table.addCell(new Phrase("Ціна", getFont()));
		table.addCell(new Phrase("Один. ціни", getFont()));
		table.addCell(new Phrase("Сума", getFont()));

		cell = new PdfPCell(new Phrase(order.getWorkType().getName(), getFont()));
		table.addCell(cell);
		table.addCell(new Phrase("шт.", getFont()));
		table.addCell(new Phrase("1", getFont()));
		table.addCell(new Phrase("" + order.getWorkType().getPrice_including_vat(), getFont()));
		table.addCell(new Phrase("грн.", getFont()));
		table.addCell(new Phrase("" + order.getWorkType().getPrice_including_vat(), getFont()));
		return table;
	}

	public String getLocalDay() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		dateFormat.format(date);
		return dateFormat.format(date);
	}

}
