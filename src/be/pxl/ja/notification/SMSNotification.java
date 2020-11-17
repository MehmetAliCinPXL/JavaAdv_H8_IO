package be.pxl.ja.notification;

public class SMSNotification implements Notification {

	@Override
	public void notify(User user) {
		System.out.println("Sending SMS to " + user.getPhone());
	}
}
