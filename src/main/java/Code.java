import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.tools.UnitConv;

public class Code {
    private final int DPI = 150;
    private Code39Bean bean;


    public Code(Code39Bean bean) {
        this.bean = bean;
        bean.setModuleWidth(UnitConv.in2mm(1.0f / DPI));
        bean.setWideFactor(3);
        bean.doQuietZone(false);
    }

    public Code39Bean getBean() {
        return bean;
    }

    public int getDPI() {
        return DPI;
    }
}
