package be.pxl.ja.factory;

public class EmailNotification implements Notification {

	@Override
	public void notify(User user) {
		System.out.println("Sending email to " + user.getEmail());
	}
}
