package be.pxl.ja.decorator;

public class DecoratingMyChristmasTree {

	public static void main(String[] args) {
		ChristmasTree myChristmasTree = new StarsDecorator(new LightsDecorator(new BigChristmasTree()));
		myChristmasTree.decorate();
	}

}
