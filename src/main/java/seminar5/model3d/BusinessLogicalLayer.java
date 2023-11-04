package seminar5.model3d;

import java.util.Collection;

public interface BusinessLogicalLayer {

    Collection<Model3D> getAllModels();
    Collection<Texture> getAllTextures();

    void renderModel(Model3D model);
    void renderAllModels();

    void removeModel(Model3D model3D);

    void addModel(Model3D model);

    void addTexture(Texture texture);

    void removeTexture(Texture texture);
}



