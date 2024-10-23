package com.paytm.risk.poc.lld.strategy;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipCompressionStrategy implements CompressionStrategy {
    @Override
    public void compressFile(String filePath) {
        try (FileOutputStream fos = new FileOutputStream(filePath + ".zip");
             ZipOutputStream zipOut = new ZipOutputStream(fos);
             FileInputStream fis = new FileInputStream(filePath)) {

            ZipEntry zipEntry = new ZipEntry(new File(filePath).getName());
            zipOut.putNextEntry(zipEntry);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) >= 0) {
                zipOut.write(buffer, 0, length);
            }
            System.out.println("File compressed using ZIP");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
