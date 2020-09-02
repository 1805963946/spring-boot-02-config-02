public class Node {
    public static void main(String arg[]) {
        Node d = new Node("d");
        Node e = new Node("e");
        Node a = new Node("a");
        Node r = new Node("r");
        Node b = new Node("b");
        d.left = e;
        d.right = a;
        a.right = r;
        System.out.println(d.toJson());
    }
    Object obj;
    Node left;
    Node right;

    public Node(Object obj) {
        this.obj = obj;
    }

    public String toJson() {
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        sb.append("\"value\":").append("\"" + this.obj + "\"");
        if (this.left != null) {
            sb.append(",\"left\":" + left.toJson());
        }
        if (this.right != null) {
            sb.append(",").append("\"right\":").append(right.toJson());
        }
        sb.append("}");
        return sb.toString();
    }
}
