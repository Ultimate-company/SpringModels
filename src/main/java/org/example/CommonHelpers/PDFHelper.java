package org.example.CommonHelpers;

import org.example.Models.CommunicationModels.CentralModels.GoogleCred;
import org.example.FactoryHelpers.ProfileImageReplacedElementFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;

public class PDFHelper {
    private static String htmlToXhtml(String html) {
        Document document = Jsoup.parse(html);
        document.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
        return document.html();
    }

    public static byte[] convertPurchaseOrderHtmlToPdf(GoogleCred googleCred, String filePath, String html) throws IOException {
        FirebaseHelper firebaseHelper = new FirebaseHelper(googleCred);
        byte[] imageBytes = firebaseHelper.downloadFileAsBytesFromFirebase(filePath);

        String xhtml = htmlToXhtml(html);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ITextRenderer iTextRenderer = new ITextRenderer();
        iTextRenderer.getSharedContext().setReplacedElementFactory(new ProfileImageReplacedElementFactory(
                iTextRenderer.getSharedContext().getReplacedElementFactory(),
                imageBytes,
                "profile_picture"));
        iTextRenderer.setDocumentFromString(xhtml);
        iTextRenderer.layout();
        iTextRenderer.createPDF(os);
        return os.toByteArray();
    }
}






