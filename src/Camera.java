public class Camera {
    private Vector3 origin,lower_left_corner,horizontal,vertical;

    public Camera(){
        lower_left_corner = new Vector3(-2.0,-1.0,-1.0);
        horizontal = new Vector3(4.0,0.0,0.0);
        vertical = new Vector3(0.0,2.0,0.0);
        origin = new Vector3(0,0,0);
    }

    public Ray getRay(double u,double v){
        return new Ray(origin,lower_left_corner.add(horizontal.mul(u).add(vertical.mul(v))));

    }
}
