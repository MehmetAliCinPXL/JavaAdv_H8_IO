package be.pxl.ja.notification;

public class EmailNotification implements Notification {

	@Override
	public void notify(User user) {
		System.out.println("Sending email to " + user.getEmail());
	}
}
