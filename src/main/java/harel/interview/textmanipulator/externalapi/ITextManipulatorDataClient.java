package harel.interview.textmanipulator.externalapi;

import feign.Headers;
import feign.RequestLine;
import harel.interview.textmanipulator.model.TextManipulationDataModel;

public interface ITextManipulatorDataClient {
    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    void persistToDB(TextManipulationDataModel textManipulationDataModel);
}
