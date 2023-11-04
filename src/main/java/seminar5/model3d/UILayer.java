package seminar5.model3d;

public interface UILayer {

    void openProject(String fileName);
    void showProjectSettings();
    void saveProject();
    void printAllModels();
    void printAllTextures();
    void renderAll();
    void renderModel(int i);

    void addModel(Model3D model);

    void removeModel(int i);

    void addTexture(Texture texture);

    void removeTexture(int i);
}
