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
    private enum sceneEnumName {START_PAGE, CITY, DOCKYARD}

    /**
     * Map storing scene names and enums equivalents
     */
    private HashMap<String, Enum> sceneNameMap;

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
    private HashMap<String, Enum> sceneNameMapGenerator(){
        HashMap<String, Enum> resultMap = new HashMap<>();
        resultMap.put("scenes/startPage.fxml", sceneEnumName.START_PAGE);
        resultMap.put("scenes/dockyard.fxml", sceneEnumName.DOCKYARD);
        resultMap.put("scenes/city.fxml", sceneEnumName.CITY);
        return resultMap;
    }
}
