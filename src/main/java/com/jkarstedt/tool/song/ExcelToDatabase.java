package com.jkarstedt.tool.song;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;

public class ExcelToDatabase {
    // public static final String SAMPLE_XLSX_FILE_PATH = "/Users/jens/Documents/IdeaProjects14/SongImporter/src/main/resources/songs.xlsx";
    public static final String SAMPLE_XLSX_FILE_PATH = "songs.xlsx";

    public static void main(String[] args) {



    }

    public static void runExporter(String fileName, MyRepository repository) {
        Workbook workbook = null;
        try {

            BufferedInputStream in = new BufferedInputStream(Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName));
            File tempFile = File.createTempFile("poi", "xls");
            tempFile.deleteOnExit();
            FileOutputStream out = new FileOutputStream(tempFile);
            IOUtils.copy(in, out);

            workbook = new XSSFWorkbook(new FileInputStream(tempFile));
            Sheet sheet = workbook.getSheet("Volx");
            Iterator<Row> rowIterator = sheet.rowIterator();
            DataFormatter dataFormatter = new DataFormatter();
            int rowcounter = 0;
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                if (rowcounter >=9 && rowcounter <992) {
                    Song song = new Song(dataFormatter.formatCellValue(row.getCell(1)), dataFormatter.formatCellValue(row.getCell(0)), dataFormatter.formatCellValue(row.getCell(5)), dataFormatter.formatCellValue(row.getCell(2)), dataFormatter.formatCellValue(row.getCell(3)), dataFormatter.formatCellValue(row.getCell(4)), dataFormatter.formatCellValue(row.getCell(6)), dataFormatter.formatCellValue(row.getCell(7)), dataFormatter.formatCellValue(row.getCell(11)), dataFormatter.formatCellValue(row.getCell(12)), dataFormatter.formatCellValue(row.getCell(13)));
                    repository.save(song);
                    System.out.println(song);
                }
                rowcounter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
    }
}
