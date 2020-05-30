public class Main {

    public static void main(String[] args) {
        var screen = new Rectangle(600f, 500f); // Screen object
        var camera = new Rectangle(new Point(20f, 580f),40f, 40f); // Camera object
        var cameraMove = new CameraMove(); // CameraMove object
        cameraMove.move(screen, camera, 1); // Call method move of CameraMove class
        cameraMove.printCount(); // Print number of pics taken with camera
    }
}
