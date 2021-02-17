package textmanipulator.controllers;

import textmanipulator.services.ConnectorApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TextManipulatorConnectorController {

    @Autowired
    private ConnectorApplicationService connectorApplicationService;

    //keeping this for testing purposes
    @PostMapping("/textmanipulatorconnector/inputfilename/{inputfilename}/outputfilename/{outputfilename}/action/{action}")
    public ResponseEntity<Object> runTextManipulationAction(@PathVariable("inputfilename") String inputFileName,
                                                            @PathVariable("outputfilename") String outputFileName,
                                                            @PathVariable("action") String action) {

        return connectorApplicationService.execute(inputFileName, outputFileName, action);
    }
}
