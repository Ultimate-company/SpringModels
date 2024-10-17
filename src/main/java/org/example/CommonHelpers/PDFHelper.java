package org.example.CommonHelpers;

import com.itextpdf.text.DocumentException;
import org.xhtmlrenderer.pdf.ITextRenderer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class PDFHelper {
    public static byte[] convertHtmlToPdf(String htmlContent) throws DocumentException, IOException{
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(htmlContent);
        renderer.layout();
        renderer.createPDF(os);
        return os.toByteArray();
    }
}
