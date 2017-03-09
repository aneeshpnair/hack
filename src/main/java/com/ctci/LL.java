package com.ctci;

class LL<D>{
	D data;
	LL<D> next;
	LL<D> prev;
	public D getData() {
		return data;
	}
	public void setData(D data) {
		this.data = data;
	}
	public LL<D> getNext() {
		return next;
	}
	public void setNext(LL<D> next) {
		this.next = next;
	}
	public LL<D> getPrev() {
		return prev;
	}
	public void setPrev(LL<D> prev) {
		this.prev = prev;
	}
	public LL(D data) {
		this.data = data;
	}
//	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		LL<D> current = this;
		while(true){
			sb.append(current.data);
			if(current.next != null){
				sb.append("->");
				current = current.next;
			}else{
				break;
			}
		}
		return sb.toString();
	}
	
//	public String toString() {
//		return data.toString();
//	}
}
	
	