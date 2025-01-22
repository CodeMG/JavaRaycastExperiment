public class Hit {
    public double t;
    public Vector3 point;
    public Vector3 normal;
    public Ray scatteredRay;

    public Hit(){

    }

    public Hit(double t,Vector3 point, Vector3 normal){
        this.t = t;
        this.point = point;
        this.normal = normal;
    }

    public Hit(double t,Vector3 point, Vector3 normal,Ray r){
        this.t = t;
        this.point = point;
        this.normal = normal;
        this.scatteredRay = r;
    }
}
