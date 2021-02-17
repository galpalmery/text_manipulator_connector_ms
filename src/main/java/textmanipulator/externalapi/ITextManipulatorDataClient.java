package textmanipulator.externalapi;

import feign.Headers;
import feign.RequestLine;
import textmanipulator.model.TextManipulationDataModel;

public interface ITextManipulatorDataClient {
    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    void persistToDB(TextManipulationDataModel textManipulationDataModel);
}
