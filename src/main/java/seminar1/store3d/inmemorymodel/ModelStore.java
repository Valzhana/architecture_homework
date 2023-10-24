package seminar1.store3d.inmemorymodel;

import seminar1.store3d.modelelements.Camera;
import seminar1.store3d.modelelements.Flash;
import seminar1.store3d.modelelements.PoligonalModel;
import seminar1.store3d.modelelements.Scene;

import java.util.ArrayList;
import java.util.Collection;

public class ModelStore implements ModelChanger {
    ArrayList<PoligonalModel> Models = new ArrayList<>();
    ArrayList<Scene> Scenes = new ArrayList<>();
    ArrayList<Flash> Flashes = new ArrayList<>();
    ArrayList<Camera> Cameras = new ArrayList<>();

    private Collection<ModelChangedObserver> changeObservers = new ArrayList<>();

    /**
     * Нотифицирует о событии
     */
    @Override
    public void notifyChange() {
        for (ModelChangedObserver observer : changeObservers) {
            observer.applyUpdateModel();
        }
    }

    @Override
    public void registerModelChanger(ModelChangedObserver o) {
        changeObservers.add(o);
    }

    @Override
    public void removeModelChanger(ModelChangedObserver o) {
        changeObservers.remove(o);
    }
}
