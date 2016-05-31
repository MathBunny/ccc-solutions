void Print(Node head) {
	if (head.next == null)
		return;
	System.out.println(head.data);
	Print(head.next);
}
