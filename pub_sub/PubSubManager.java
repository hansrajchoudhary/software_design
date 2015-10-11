package design.pub_sub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import design.pub_sub.publisher.Topic;
import design.pub_sub.subscriber.Subscriber;

public class PubSubManager {
	Map<Topic, List<Subscriber>> listOfSubscribers;
	private static PubSubManager instance = null;

	private PubSubManager() {
		initiallizeTopicsSubscribers();
	}

	public void initiallizeTopicsSubscribers() {
		listOfSubscribers = new HashMap<Topic, List<Subscriber>>();
		// initialize from db or persistance data store
		/** * **/
	}

	public void createSubscription(Topic topic, Subscriber subscriber) {
		if (listOfSubscribers.get(topic) == null)
			listOfSubscribers.put(topic, new ArrayList<Subscriber>());
		listOfSubscribers.get(topic).add(subscriber);
	}

	public static PubSubManager getInstance() {
		// TODO Auto-generated method stub
		if (instance == null) {
			synchronized (PubSubManager.class) {
				instance = new PubSubManager();
			}
		}

		return instance;
	}

	public void deleteSubscription(Topic topic, Subscriber subscriber) {
		if (listOfSubscribers.get(topic) == null)
			listOfSubscribers.put(topic, new ArrayList<Subscriber>());

		listOfSubscribers.get(topic).add(subscriber);
	}

	public void publish(Topic topic, String message) {
		for (Subscriber sub : listOfSubscribers.get(topic)) {
			sub.printMessage(message);
		}
	}
}
