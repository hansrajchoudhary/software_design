package design.pub_sub.publisher;

import design.pub_sub.PubSubManager;

public class Publisher implements IPublisher{

	@Override
	public void publishMessage(Topic topic, String message) {
		PubSubManager.getInstance().publish(topic, message);
	}

}
