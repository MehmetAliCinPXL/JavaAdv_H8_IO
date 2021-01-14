package be.pxl.ja.decorator;

public class StarsDecorator extends ChristmasTreeDecorator {

	public StarsDecorator(ChristmasTree christmasTree) {
		super(christmasTree);
	}

	@Override
	public void decorate() {
		super.decorate();
		System.out.println("added a lot of stars");
	}
}
