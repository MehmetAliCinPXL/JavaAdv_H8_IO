package be.pxl.ja.decorator;

public abstract class ChristmasTreeDecorator implements ChristmasTree {
	private ChristmasTree christmasTree;

	public ChristmasTreeDecorator(ChristmasTree christmasTree) {
		this.christmasTree = christmasTree;
	}

	public void decorate() {
		christmasTree.decorate();
	}
}
