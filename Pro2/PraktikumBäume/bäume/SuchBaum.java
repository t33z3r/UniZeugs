package bäume;


public class SuchBaum {
	private Node root;

	public SuchBaum() {
	}

	public SuchBaum(Node k) {
		root = k;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public boolean member(int key) {
		boolean erg = false;
		if (root.getKey() == key) {
			erg = true;
		} else {
			if (root.getLchild() != null) {
				SuchBaum sbl = new SuchBaum(root.getLchild());
				erg = erg || sbl.member(key);
			}
			if (root.getRchild() != null) {
				SuchBaum sbr = new SuchBaum(root.getRchild());
				erg = erg || sbr.member(key);
			}
		}
		return erg;
	}
	

	public Node find(int key) {
		if (root == null) {
			return null;
		} else {
			if (root.getKey() < key) {
				SuchBaum r = new SuchBaum(root.getRchild());
				return r.find(key);
			} else {
				if (root.getKey() > key) {
					SuchBaum l = new SuchBaum(root.getLchild());
					return l.find(key);
				} else {
					return root;
				}
			}
		}
	}

	public void insert(int key) {
		if (root == null) {
			root = new Node(key);
			System.out.println("Eingefügt");
		} else {
			if (key == root.getKey()) {
				System.out.println("Schlüssel schon vorhanden.");
			} else {
				if (key < root.getKey()) {
					SuchBaum lb = new SuchBaum(root.getLchild());
					lb.insert(key);
					System.out.println(root.getKey());
					System.out.println(root.getLchild());
					root.setLchild(lb.getRoot());
					System.out.println(lb.getRoot());
					System.out.println(lb.getRoot().getKey());
				}
				if (key > root.getKey()) {
					SuchBaum rb = new SuchBaum(root.getRchild());
					rb.insert(key);
					System.out.println(root.getKey());
					System.out.println(root.getRchild());
					root.setRchild(rb.getRoot());
					System.out.println(rb.getRoot());
					System.out.println(rb.getRoot().getKey());
				}
			}
		}
	}

	public void delete(int key) {
		if (root.getKey() > key) {
			//links weiter
			System.out.println("links");
			SuchBaum lb = new SuchBaum(root.getLchild());
			lb.delete(key);
			System.out.println(root.getKey());
			root.setLchild(lb.getRoot());
			System.out.println(root.getKey());
		} else {
			if (root.getKey() < key) {
				//rechts weiter
				System.out.println("rechts");
				SuchBaum rb = new SuchBaum(root.getRchild());
				rb.delete(key);
				root.setRchild(rb.getRoot());
			} else {
				System.out.println("root löschen");
				if (root.getLchild() != null) {
					System.out.println("links max hoch");
					Node vknot = root;
					Node knot = vknot.getLchild();
					if (knot.getRchild() == null) {
						root.setKey(knot.getKey());
						root.setLchild(knot.getLchild());
					} else {
						while (knot.getRchild() != null) {
							vknot = knot;
							knot = knot.getRchild();
						}
						root.setKey(knot.getKey());
						root.setRchild(knot.getLchild());
					}
				} else {
					if (root.getRchild() != null) {
						System.out.println("rechts hoch");
						root = root.getRchild();
					} else {
						root = null;
					}
				}
			}
		}
	}
}