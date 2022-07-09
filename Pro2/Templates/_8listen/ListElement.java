package _8listen;

public class ListElement {
	
	public Object data = null;
	public ListElement next = null;
	
	public ListElement(Object data) {
		this.data = data;
	}
	
	public ListElement(Object data, ListElement next) {
		this.data = data;
		this.next = next;
	}

}
