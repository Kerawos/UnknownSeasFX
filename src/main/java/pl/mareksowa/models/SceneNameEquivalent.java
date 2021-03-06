package pl.mareksowa.models;

import java.util.HashMap;

/**
 * Class responsible for store precise scene names. To prevent 'typo' during writing scene changers. Better to store
 * scene names in enum type
 */
public class SceneNameEquivalent {

    /**
     * enums equivalents names
     */
    public enum sceneEnumName {START_PAGE, WORLD_MAP, CITY, DOCKYARD, MARKET, ARMORY, TAVERN, ENCOUNTER}

    /**
     * Map storing scene names and enums equivalents
     */
    private HashMap<Enum, String> sceneNameMap;

    /**
     * Constructor with loaded already generated map
     */
    public SceneNameEquivalent() {
        sceneNameMap = sceneNameMapGenerator();
    }

    /**
     * Map generator
     * @return predefined map
     */
    private HashMap<Enum, String> sceneNameMapGenerator(){
        HashMap<Enum, String> resultMap = new HashMap<>();
        resultMap.put(sceneEnumName.START_PAGE, "scenes/startPage.fxml");
        resultMap.put(sceneEnumName.WORLD_MAP, "scenes/map.fxml");
        resultMap.put(sceneEnumName.CITY, "scenes/city.fxml");
        resultMap.put(sceneEnumName.DOCKYARD, "scenes/dockyard.fxml");
        resultMap.put(sceneEnumName.MARKET, "scenes/market.fxml");
        resultMap.put(sceneEnumName.ARMORY, "scenes/armory.fxml");
        resultMap.put(sceneEnumName.TAVERN, "scenes/tavern.fxml");
        resultMap.put(sceneEnumName.ENCOUNTER, "scenes/encounter.fxml");

        return resultMap;
    }

    /**
     * Getter section
     */
    public HashMap<Enum, String> getSceneNameMap() {
        return sceneNameMap;
    }
}
