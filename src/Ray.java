public class Ray {

    private Vector3 origin,direction;

    public Ray(Vector3 origin, Vector3 direction){
        this.origin = origin;
        this.direction  = direction;
    }

    public Vector3 pointAtTime(double t){
        return origin.add(direction.mul(t));
    }

    //Getters and Setters
    public Vector3 getOrigin() {
        return origin;
    }

    public void setOrigin(Vector3 origin) {
        this.origin = origin;
    }

    public Vector3 getDirection() {
        return direction;
    }

    public void setDirection(Vector3 direction) {
        this.direction = direction;
    }
}
