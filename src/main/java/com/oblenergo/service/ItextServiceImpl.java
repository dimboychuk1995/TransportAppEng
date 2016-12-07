package com.oblenergo.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.oblenergo.model.Orders;

@Service
public class ItextServiceImpl implements ItextService {

  Logger LOGGER = Logger.getLogger(ItextServiceImpl.class);

  @Autowired
  SapServiceImpl sapServiceImpl;

  @Autowired
  ServletContext context;

  public Font getFont() {
    BaseFont baseFont = null;
    try {
      String path = context.getRealPath("/resources/ARIALUNI.TTF");
      baseFont = BaseFont.createFont(path, BaseFont.IDENTITY_H, true);
    } catch (DocumentException | IOException e) {

      LOGGER.error("Unable to get font for document " + e);
    }
    return new Font(baseFont);
  }

  @Override
  public byte[] writeCheck(Orders order) {

    byte[] pdf = null;
    Document document = new Document();
    document.setMargins(20, 50, 25, 2);

    try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

      PdfWriter writer = PdfWriter.getInstance(document, baos);
      document.open();
      document.add(createTable(order));

      Paragraph paragraph = new Paragraph();
      paragraph.setSpacingBefore(25);

      document.add(paragraph);
      document.add(createTableOrder(order));
      document.close();
      pdf = baos.toByteArray();
      writer.close();

    } catch (DocumentException | IOException e) {
      LOGGER.error("Unable to write data to document " + e);
    }
    return pdf;
  }

  public PdfPTable createTable(Orders order) throws DocumentException {
    // a table with three columns
    PdfPTable table = new PdfPTable(2);
    table.setWidthPercentage(100); // Width 100%
    // Set Column widths
    float[] columnWidths = { 2f, 5f };
    try {
      table.setWidths(columnWidths);
    } catch (DocumentException e) {
      LOGGER.error("Unable to write the table to document " + e);
      throw e;
    }

    PdfPCell cell;

    cell = new PdfPCell(new Phrase("РАХУНОК-ФАКТУРА №  від " + getLocalDay(), getFont()));
    cell.setColspan(2);
    cell.setBorderColor(BaseColor.WHITE);
    table.addCell(cell);

    cell = new PdfPCell(new Phrase("Постачальник : ", getFont()));

    table.addCell(cell);

    table.addCell("00131564");

    cell = new PdfPCell(new Phrase("Адреса : ", getFont()));
    table.addCell(cell);
    table.addCell(new Phrase("76014, м.Івано-Франківськ, вул.Індустріальна ,34.", getFont()));

    cell = new PdfPCell(new Phrase("ІПН : ", getFont()));
    table.addCell(cell);
    table.addCell("001315609158");

    cell = new PdfPCell(new Phrase("Р/рахунок : ", getFont()));
    table.addCell(cell);
    table.addCell(new Phrase("Філія - Івано.-Франк.ОУ АТ Ощадбанк 336503   26003301757", getFont()));

    cell = new PdfPCell(new Phrase("Платник : ", getFont()));
    table.addCell(cell);

    table.addCell(new Phrase(order.getCustomer(), getFont()));
    cell = new PdfPCell(new Phrase("Підстава : ", getFont()));
    table.addCell(cell);

    table.addCell(new Phrase("на підставі заказу №" + order.getId() + " від " + getLocalDay(), getFont()));

    return table;
  }

  public PdfPTable createTableOrder(Orders order) throws DocumentException {

    // a table with three columns
    PdfPTable table = new PdfPTable(6);
    table.setWidthPercentage(100); // Width 100%
    // Set Column widths
    float[] columnWidths = { 5f, 2f, 2f, 2f, 2f, 2f };
    try {
      table.setWidths(columnWidths);
    } catch (DocumentException e) {
      LOGGER.error("Unable to create the table " + e);
      throw e;
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
    table.addCell(new Phrase("" + order.getWorkType(), getFont()));
    table.addCell(new Phrase("грн.", getFont()));
    table.addCell(new Phrase("" + order.getWorkType(), getFont()));
    return table;
  }

  public String getLocalDay() {
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
    dateFormat.format(date);
    return dateFormat.format(date);
  }

}
