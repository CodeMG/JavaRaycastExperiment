public class Sphere implements Hittable {
    Vector3 center;
    double radius;

    public Sphere(Vector3 center, double radius){
        this.center = center;
        this.radius = radius;
    }

    public Hit hit(Ray r, double t_min,double t_max){
        Hit hit = new Hit();
        Vector3 oc = r.getOrigin().sub(center);
        double a = Vector3.dot(r.getDirection(),r.getDirection());
        double b = Vector3.dot(oc,r.getDirection());
        double c = Vector3.dot(oc,oc) - radius*radius;
        double discriminant = b * b - a * c;
        if(discriminant > 0){
            double temp = (-b - Math.sqrt(discriminant))/a;
            if(temp < t_max && temp > t_min){
                hit.t = temp;
                hit.point = r.pointAtTime(temp);
                hit.normal = (hit.point.sub(center)).div(radius);
                return hit;
            }
            temp = (-b + Math.sqrt(discriminant))/a;
            if(temp < t_max && temp > t_min){
                hit.t = temp;
                hit.point = r.pointAtTime(temp);
                hit.normal = (hit.point.sub(center)).div(radius);
                return hit;
            }
        }
        return null;

    }

}
