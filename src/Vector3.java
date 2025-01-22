public class Vector3 {

    public double x,y,z;

    public Vector3(double x,double y,double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3 add(Vector3 vec){
        Vector3 n = new Vector3(0,0,0);
        n.x = x + vec.getX();
        n.y = y + vec.getY();
        n.z = z + vec.getZ();
        return n;
    }

    public Vector3 sub(Vector3 vec){
        Vector3 n = new Vector3(0,0,0);
        n.x = x - vec.getX();
        n.y = y - vec.getY();
        n.z = z - vec.getZ();
        return n;
    }

    public Vector3 mul(Vector3 vec){
        Vector3 n = new Vector3(0,0,0);
        n.x = x * vec.getX();
        n.y = y * vec.getY();
        n.z = z * vec.getZ();
        return n;
    }

    public Vector3 mul(double t){
        Vector3 n = new Vector3(0,0,0);
        n.x = x *t;
        n.y = y *t;
        n.z = z *t;
        return n;
    }

    public Vector3 div(Vector3 vec){
        Vector3 n = new Vector3(0,0,0);
        n.x = x / vec.getX();
        n.y = y / vec.getY();
        n.z = z / vec.getZ();
        return n;
    }

    public Vector3 div(double t){
        Vector3 n = new Vector3(0,0,0);
        n.x = x /t;
        n.y = y /t;
        n.z = z /t;
        return n;
    }

    public double length(){
        return Math.sqrt(x*x + y*y + z*z);
    }

    public double squareLength(){
        return x*x + y*y + z*z;
    }

    public void normalize(){
        Vector3 n = div(length());
        x = n.x;
        y = n.y;
        z = n.z;
    }

    public Vector3 normalized(){
        Vector3 n = new Vector3(x,y,z);
        n.normalize();
        return n;
    }

    public static double dot(Vector3 a, Vector3 b){
        return a.x * b.x + a.y * b.y + a.z * b.z;
    }

    //GETTERS AND SETTERS
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
}
