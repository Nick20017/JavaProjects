public class CameraMove {
    private int count = 0; // Number of pictures taken with camera

    public void move(Rectangle screen, Rectangle camera, int direction) {
        if(camera.Center.Y < camera.Height / 2) // if camera touches bottom of the screen, then return method
            return;

        if (direction > 0) { // if positive movement direction (move right)
            while (camera.Center.X < screen.Width - camera.Width / 2) { // works until camera touches rect's right side
                count++; // add 1 to number of pictures taken with camera
                camera.Center.X += camera.Width; // Move camera one step right equals to its width to take a brand new pic
            }
        } else if (direction < 0) { // if negative movement direction (move left)
            while (camera.Center.X > camera.Width / 2) { // works until camera touches rect's left side
                count++; // add 1 to number of pictures taken with camera
                camera.Center.X -= camera.Width; // Move camera one step left equals to its width to take a brand new pic
            }
        } else // if direction is equal to 0, then camera isn't moving and simply return method
            return;

        camera.Center.Y -= camera.Height; // After all linear movement done, move camera one step down
        move(screen, camera, direction * -1); // Recursion call to change direction
    }

    public int getCount() {
        return count;
    }

    public void printCount() {
        System.out.println("Count: " + count);
    }
}
