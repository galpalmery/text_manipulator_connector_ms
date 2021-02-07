# text_manipulator_connector_ms
this microservice has a listener to the same queue in RabbitMQ as text_manipulator_messaging_ms and once a message arrives it will send a REST to the text_manipulator_persistence_ms via Feign client

for more information please also read this: https://github.com/galpalmery/text_manipulator_messaging_ms/blob/master/README.md
