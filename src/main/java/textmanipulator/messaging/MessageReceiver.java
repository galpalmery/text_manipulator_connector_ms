package textmanipulator.messaging;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import textmanipulator.externalapi.ITextManipulatorDataClient;
import textmanipulator.model.TextManipulationDataModel;
import org.springframework.beans.factory.annotation.Value;

import java.util.concurrent.CountDownLatch;

public class MessageReceiver {
	@Value("${url}")
	private String URL;

	private CountDownLatch latch = new CountDownLatch(1);

	public void receiveMessage(String message) {
		System.out.println("Received <" + message + ">");
		if (message.startsWith("Executing action:")) {
			parseMessageAndSendToFeignClient(message);
		}
		latch.countDown();
	}

	private void parseMessageAndSendToFeignClient(String message) {
		String action = message.substring(message.indexOf("action: ")+8,message.indexOf(","));
		String inputFileName = message.substring(message.indexOf("Input file: ")+12,message.indexOf(", Output"));
		String outputFileName = message.substring(message.indexOf("Output file: ")+13);
		System.out.println(action);
		System.out.println(inputFileName);
		System.out.println(outputFileName);

		sendToFeignClient(action, inputFileName, outputFileName);
	}

	private void sendToFeignClient(String action, String inputFileName, String outputFileName) {
		ITextManipulatorDataClient textManipulatorDataClient = Feign.builder()
				.client(new OkHttpClient())
				.encoder(new GsonEncoder())
				.decoder(new GsonDecoder())
				.logger(new Slf4jLogger(ITextManipulatorDataClient.class))
				.logLevel(Logger.Level.FULL)
				.target(ITextManipulatorDataClient.class, URL);

		TextManipulationDataModel textManipulationDataModel = new TextManipulationDataModel(inputFileName, outputFileName, action);
		textManipulatorDataClient.persistToDB(textManipulationDataModel);
	}

	public CountDownLatch getLatch() {
		return latch;
	}

}
