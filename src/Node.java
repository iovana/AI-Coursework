import java.util.ArrayList;

public class Node {
	int depth;
	Node parent, leftchild, rightchild, upchild, downchild;
	ArrayList<Node> children = new ArrayList<Node>();
	State nodestate;
	boolean discovered = false;
	
	
	public Node(Node parent, int depth, char direction) {
		this.depth = depth;
		this.parent = parent;
		nodestate = new State(parent.getState(), direction);
	}

	public int getDepth() {
		return depth;
	}
	public Node(State s) {
		depth = 0;
		parent = null;
		nodestate = new State(s.matrix, s.agentx, s.agenty);
	}

	public State getState() {
		return nodestate;
	}

	public ArrayList<Node> createChildren() {
		leftchild = new Node(this, depth + 1, 'L');
		rightchild = new Node(this, depth + 1, 'R');
		upchild = new Node(this, depth + 1, 'U');
		downchild = new Node(this, depth + 1, 'D');

		if (leftchild.getState().getMoved() == true) {
			children.add(leftchild);
		}
		if (rightchild.getState().getMoved() == true) {
			children.add(rightchild);
		}
		if (upchild.getState().getMoved() == true) {
			children.add(upchild);
		}
		if (downchild.getState().getMoved() == true) {
			children.add(downchild);
		}
		return children;
	}
}
