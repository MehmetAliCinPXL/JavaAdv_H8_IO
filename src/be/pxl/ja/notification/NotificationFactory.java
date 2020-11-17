package be.pxl.ja.notification;

public class NotificationFactory {

	public Notification createNotification(Preference preference) {
		switch (preference) {
			case SMS:
				return new SMSNotification();
			case EMAIL:
				return new EmailNotification();
			default:
				return null;
		}
	}

}
