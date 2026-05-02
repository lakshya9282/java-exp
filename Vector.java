
class Vector {

    double x, y, z;

    // Constructor
    Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Method to add two vectors
    Vector add(Vector v) {
        return new Vector(
                this.x + v.x,
                this.y + v.y,
                this.z + v.z
        );
    }

    // Method to subtract two vectors
    Vector subtract(Vector v) {
        return new Vector(
                this.x - v.x,
                this.y - v.y,
                this.z - v.z
        );
    }

    // Method to calculate dot product
    double dotProduct(Vector v) {
        return this.x * v.x
                + this.y * v.y
                + this.z * v.z;
    }

    // Display vector
    void display() {
        System.out.println("(" + x + ", " + y + ", " + z + ")");
    }
}
