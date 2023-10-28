package seminar2.buildermethod;

public class DocCreationEngine {
    public void generateDocument(DocBuilder builder){
        builder.createDocument();
        builder.createText();
        builder.createImages();
    }
}
