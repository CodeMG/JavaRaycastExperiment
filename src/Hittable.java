public interface Hittable {
    Hit hit(Ray r, double t_min,double t_max);
}
