package com.jackshenorion.thinkinjava.sample.pdf;

import org.apache.pdfbox.io.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;

/**
 * Created by jack on 7/06/2017.
 */
public class PdfboxSample {

    private static void convertTifftoPdf() {
        ImageInputStream imageStream = null;
        try {
            byte[] tiffImage = IOUtils.toByteArray(ClassLoader.getSystemResource("multipage.tiff").openStream()); //"2014040352.jpg"
            InputStream inputStream = new ByteArrayInputStream(tiffImage);
            imageStream = ImageIO.createImageInputStream(inputStream);
            Iterator<ImageReader> imageReaders = ImageIO.getImageReaders(imageStream);
            ImageReader reader = imageReaders.next();
            reader.setInput(imageStream);
            int pages = reader.getNumImages(true);
            PDDocument document = new PDDocument();
            for (int i = 0; i < pages; i ++) {
                BufferedImage bi = reader.read(0);
                PDPage blankPage = new PDPage();
                PDImageXObject image = LosslessFactory.createFromImage(document, bi);

                PDPageContentStream contentStream = new PDPageContentStream(document, blankPage);
                contentStream.drawImage(image, 6, 6);
                contentStream.close();
                document.addPage( blankPage );
            }
            document.save("test.pdf");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                imageStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        convertTifftoPdf();
    }


}
