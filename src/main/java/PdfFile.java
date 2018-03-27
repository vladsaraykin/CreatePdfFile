import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.*;

public class PdfFile {
    private Document document;
    private PdfWriter writer;
    private Image image;

    private PdfFile() {
        final String PATH_DIR = "target/template.pdf";
        try {
            document = new Document(PageSize.A4, 50, 50, 50, 50);
            File file = new File("target/template.pdf");
            file.getParentFile().mkdirs();
            writer = PdfWriter.getInstance(document,
                    new FileOutputStream("target/template.pdf"));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static PdfFile getInstance() {
        return new PdfFile();
    }

    public void addImg(String imgName) {
        try {
            image = Image.getInstance(imgName);
            document.open();
            document.add(image);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            document.close();
        }
    }
}
