public class Codec {

    public String serialize(TreeNode root) {
        var builder = new StringBuilder();
        serialize(root, builder);
        return builder.toString();
    }

    public TreeNode deserialize(String data) {
        var index = new AtomicInteger();
        var tokens = data.split(",");
        return deserialize(tokens, index);
    }

    private static void serialize(TreeNode root, StringBuilder builder) {

        if (root == null) {
            builder.append("null")
                .append(",");
            return;
        }

        builder.append(root.val)
            .append(",");

        serialize(root.left, builder);
        serialize(root.right, builder);
    }

    private static TreeNode deserialize(String[] tokens, AtomicInteger index) {

        if (index.get() >= tokens.length || tokens[index.get()].equals("null")) {
            index.incrementAndGet();
            return null;
        }

        var value = Integer.parseInt(tokens[index.getAndIncrement()]);
        var root = new TreeNode(value);

        root.left = deserialize(tokens, index);
        root.right= deserialize(tokens, index);

        return root;
    }
}