import static java.lang.Math.*;

public class Rectangle {
    public Point Center; // Center coordinates
    public float Width; // Rectangle's width
    public float Height; // Rectangle's height

    public Rectangle(float Width, float Height) { // Constructor which initializes width and height and takes coordinates from the start
        this.Center = new Point(Width / 2, Height / 2);
        this.Width = Width;
        this.Height = Height;
    }

    public Rectangle(Point Center, float Width, float Height) { // Constructor which initializes center coords, width and height
        this.Center = Center;
        this.Width = Width;
        this.Height = Height;
    }

    public Rectangle(float X, float Y, float Width, float Height) { // Constructor which initializes center coords from 2 splitted vars, width and height
        this.Center = new Point(X, Y);
        this.Width = Width;
        this.Height = Height;
    }

    public float getSegment() { // Return a segment of the rectangle
        return Width * Height;
    }
}
