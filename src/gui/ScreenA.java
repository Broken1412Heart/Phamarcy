public class ScreenA {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

    public static void main(String[] args) {
        // Tạo và hiển thị giao diện
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ScreenMainOfManager();
            }
        });
    
}
