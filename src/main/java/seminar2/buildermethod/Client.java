package seminar2.buildermethod;

public class Client {
    public static void main(String args[]) {
        DocCreationEngine engine = new DocCreationEngine();
        PDFDocBuilder pdfDocBuilder = new PDFDocBuilder();
        engine.generateDocument(pdfDocBuilder);
        PDFDocument pdfDocument = (PDFDocument) pdfDocBuilder.getDocument();
        XMLDocBuilder xmlDocBuilder = new XMLDocBuilder();
        engine.generateDocument(xmlDocBuilder);
        XMLDocument xmlDocument = (XMLDocument) xmlDocBuilder.getDocument();
    }
}
