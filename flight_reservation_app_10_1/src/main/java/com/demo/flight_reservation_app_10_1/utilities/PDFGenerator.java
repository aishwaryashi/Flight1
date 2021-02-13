package com.demo.flight_reservation_app_10_1.utilities;

import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

import com.demo.flight_reservation_app_10_1.entity.Reservation;
import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


@Component
public class PDFGenerator {
	 public void generateItinerary(Reservation reservation, String filePath) {
	
	try {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();
        document.add(generateTable(reservation));
        document.close();
    } catch ( Exception e) {
        e.printStackTrace();
    }
	
}
	 
public PdfPTable generateTable(Reservation reservation) {
	PdfPTable table = new PdfPTable(2);
	PdfPCell cell;
	
	cell = new PdfPCell(new Phrase("FLIGHT RESERVATION"));
	cell.setColspan(2);
	table.addCell(cell);
	
	
	cell = new PdfPCell(new Phrase("Flight Details"));
    cell.setColspan(2);
    table.addCell(cell);
	
    table.addCell("Departure City");
    table.addCell(reservation.getFlight().getDepartureCity());
    table.addCell("Arrival City");
    table.addCell(reservation.getFlight().getArrivalCity());
    table.addCell("Flight Number");
    table.addCell(reservation.getFlight().getFlightNumber());
    table.addCell("Departure Time");
    table.addCell(reservation.getFlight().getEstimatedDepartureTime().toString());
    
    cell= new PdfPCell(new Phrase("Passenger Details"));
    cell.setColspan(2);
    table.addCell(cell);
    
    
    table.addCell("First Name");
    table.addCell(reservation.getPassenger().getFirstName());
    table.addCell("Last Name");
    table.addCell(reservation.getPassenger().getLastName());
    table.addCell("Email");
    table.addCell(reservation.getPassenger().getEmail());
    table.addCell("Phone");
    table.addCell(reservation.getPassenger().getPhone());
    
	return table;
	}
private static void addMetaData(Document document) {
    document.addTitle("My first PDF");
    document.addSubject("Using iText");
    document.addKeywords("Java, PDF, iText");
    document.addAuthor("Lars Vogel");
    document.addCreator("Lars Vogel");
}  

}
