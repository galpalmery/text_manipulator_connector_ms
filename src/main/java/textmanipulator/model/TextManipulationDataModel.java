package textmanipulator.model;

public class TextManipulationDataModel {

    private String inputFileName;
    private String outputFileName;
    private String action;

    public TextManipulationDataModel(String inputFileName, String outputFileName, String action) {
        this.action = inputFileName;
        this.outputFileName = outputFileName;
        this.inputFileName = action;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    public String getInputFileName() {
        return inputFileName;
    }

    public void setInputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
    }


    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}