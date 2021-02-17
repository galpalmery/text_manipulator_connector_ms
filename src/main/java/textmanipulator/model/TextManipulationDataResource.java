package textmanipulator.model;

public class TextManipulationDataResource {

    private TextManipulationDataModel textManipulationDataModel;

    public TextManipulationDataResource(TextManipulationDataModel textManipulationDataModel) {
        this.textManipulationDataModel = textManipulationDataModel;
    }

    public TextManipulationDataModel getTextManipulationDataModel() {
        return textManipulationDataModel;
    }

    public void setTextManipulationDataModel(TextManipulationDataModel textManipulationDataModel) {
        this.textManipulationDataModel = textManipulationDataModel;
    }
}
