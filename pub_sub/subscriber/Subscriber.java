package design.pub_sub.subscriber;

import design.pub_sub.PubSubManager;
import design.pub_sub.publisher.Topic;

public class Subscriber implements ISubscriber {
	int subscriber_id;
	PubSubManager manager = PubSubManager.getInstance();
	public Subscriber(int id) {
		this.subscriber_id = id;
	}
	@Override
	public void printMessage(String msg) {
		System.out.println("Received message on subsriber "+subscriber_id+" msg="+msg);
	}

	@Override
	public void subscribe(Topic topic) {
		manager.createSubscription(topic, this);
	}
	public void deleteSubscribe(Topic topic) {
		manager.deleteSubscription(topic, this);
	}
}
