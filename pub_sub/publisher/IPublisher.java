package design.pub_sub.publisher;

public interface IPublisher {
	public void publishMessage(Topic topic, String message);
}
