import java.util.Stack;

public class BrowserModel {
	private BrowserView view;
	private int lnNum;
	private Stack<Integer> fwd, back;
	
	public BrowserModel(BrowserView view) {
		this.view = view;
		home();
	}
	
	public void back() {
		if(hasBack()) {
			fwd.push(lnNum);
			lnNum = back.pop();
			view.update(lnNum);
		}
	}
	
	public void forward() {
		back.push(fwd.pop());
	}
	
	public void home() {
		followLink(0);
		back.clear();
	}
	
	public void followLink(int n) {
		view.update(n);
		back.push(lnNum);
		lnNum = n;
		fwd.clear();
	}
	
	public boolean hasBack() {
		return !(back.isEmpty() );
	}
	
	public boolean hasForward() {
		return !(fwd.isEmpty() );
	}
	
}
