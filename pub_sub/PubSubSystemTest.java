package design.pub_sub;

import design.pub_sub.publisher.Publisher;
import design.pub_sub.publisher.Topic;
import design.pub_sub.subscriber.Subscriber;

public class PubSubSystemTest {
public static void main(String[] args) {
	Subscriber sub1 = new Subscriber(1);
	Subscriber sub2 = new Subscriber(2);
	
	sub1.subscribe(Topic.Topic1);
	sub2.subscribe(Topic.Topic1);
	sub2.subscribe(Topic.Topic2);
	
	Publisher pub1 = new Publisher();
	pub1.publishMessage(Topic.Topic1, " 1st message published on topic 1");
	pub1.publishMessage(Topic.Topic2, " 1st message published on topic 2");
	pub1.publishMessage(Topic.Topic2, " 2nd message published on topic 2");
}
}
