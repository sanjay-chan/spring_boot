import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HtmlToPdfConverter {

    public static void main(String[] args) throws IOException {
        String htmlFilePath = "E:/eg.html";
        String pdfFilePath = "E:/output.pdf";

        File htmlFile = new File(htmlFilePath);
        File pdfFile = new File(pdfFilePath);

        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        // Load HTML into BufferedImage (example)
        BufferedImage bufferedImage = ImageIO.read(htmlFile);

        // Create PDImageXObject from BufferedImage
        PDImageXObject pdImageXObject = LosslessFactory.createFromImage(document, bufferedImage);

        // Add PDImageXObject to PDF
        contentStream.drawImage(pdImageXObject, 0, 0);

        contentStream.close();

        // Save PDF
        document.save(pdfFile);
        document.close();
    }
}
