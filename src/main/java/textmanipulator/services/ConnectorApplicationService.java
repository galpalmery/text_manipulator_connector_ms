package textmanipulator.services;

import org.springframework.http.ResponseEntity;

public class ConnectorApplicationService {

    public ResponseEntity<Object> execute(String inputFileName, String outputFileName, String action)  {


        //send response 200 - OK
        return ResponseEntity.ok().build();
    }
}
