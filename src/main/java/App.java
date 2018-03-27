

import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import java.awt.image.BufferedImage;
import java.io.*;

import java.util.Scanner;


public class App {
    public static final String NAME_PAGE ="src/main/resources/shtrih-code.png";


    public static void main(String[] args) throws IOException {
        Code code = new Code(new Code39Bean());
        PdfFile pdfFile;
        File file = new File(NAME_PAGE);
        System.out.println(file.getAbsolutePath());

        try (OutputStream out = new FileOutputStream(file)) {
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(
                    out, "image/x-png", code.getDPI(), BufferedImage.TYPE_BYTE_BINARY, false, 0);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите число для создания штрих кода: ");
            String strNumber = scanner.next();
            code.getBean().generateBarcode(canvas, strNumber);
            canvas.finish();
            pdfFile = PdfFile.getInstance();
            pdfFile.addImg(NAME_PAGE);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
