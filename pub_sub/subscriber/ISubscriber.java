package design.pub_sub.subscriber;

import design.pub_sub.publisher.Topic;

public interface ISubscriber {
	public void printMessage(String msg);
	public void subscribe(Topic topic);
}
