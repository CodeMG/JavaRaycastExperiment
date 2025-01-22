import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Raycaster {

    private int width,height,aliasingAmount;
    private boolean aliasing = true;
    private ArrayList<Hittable> hittables;

    public Raycaster(){
        width = 1000;
        height = 500;
        aliasingAmount = 50;
        hittables = new ArrayList<>();


    }

    public BufferedImage renderImage(){
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        hittables.add(new Sphere(new Vector3(0,0,-1),0.5));
        hittables.add(new Sphere(new Vector3(0.2,-0.2,-0.6),0.1));
        hittables.add(new Sphere(new Vector3(-0.2,-0.2,-0.6),0.1));
        hittables.add(new Sphere(new Vector3(2,0,-3),0.5));
        hittables.add(new Sphere(new Vector3(-2,0,-3),0.5));
        hittables.add(new Sphere(new Vector3(0,100.1,-10),100));
        //hittables.add(new Sphere(new Vector3(0,-100.1,-10),100));
        Camera cam = new Camera();
        Random random = new Random();
        for(int j = height-1; j>= 0;j--){
            if(j % 5 == 0){
                System.out.println("x: " + j);
            }
            for(int i = 0; i < width;i++){

                double u;
                double v;
                Vector3 color = new Vector3(0,0,0);
                if(aliasing){
                    color = new Vector3(0,0,0);
                    for(int s = 0; s < aliasingAmount;s++){
                        u = (double)(i + random.nextDouble()) / (double)width;
                        v = (double)(j + random.nextDouble()) / (double)height;
                        Ray r = cam.getRay(u,v);
                        color = color.add(color(r));
                    }
                    color = color.div(aliasingAmount);
                }
                else{
                    u = (double)(i ) / (double)width;
                    v = (double)(j) / (double)height;
                    Ray r = cam.getRay(u,v);
                    color = color(r);
                }
                color = new Vector3(Math.sqrt(color.x),Math.sqrt(color.y),Math.sqrt(color.z));
                int ir = (int)(255.99*color.x);
                int ig = (int)(255.99*color.y);
                int ib = (int)(255.99*color.z);
                /*
                if(ir > 255){
                    ir = 255;
                }
                if(ig > 255){
                    ig = 255;
                }
                if(ib > 255){
                    ib = 255;
                }
                if(ir < 0){
                    ir = 0;
                }
                if(ig < 0){
                    ig = 0;
                }
                if(ib < 0){
                    ib = 0;
                }
                */

                Color c = new Color(ir,ig,ib);
                image.setRGB(i,j,c.getRGB());
            }
        }
        return image;
    }

    private Vector3 color(Ray r){
        //double t = hit_sphere(new Vector3(0,0,1),0.5,r);
        Hit record = closestThingHit(r,0.001,Double.MAX_VALUE);
        if(record != null){
            //Vector3 N = r.pointAtTime(t).sub(new Vector3(0,0,-1)).normalized();
            Vector3 target = record.point.add(record.normal).add(random_in_unit_sphere());
            return color(new Ray(record.point,target.sub(record.point))).mul(0.5);
            //return new Vector3(record.normal.x+1,record.normal.y+1,record.normal.z+1).mul(0.5);
        }
        Vector3 unit = r.getDirection().normalized();
        double t = 0.5 * (unit.y + 1.0);
        return new Vector3(1.0,1.0,1.0).mul(1.0-t).add(new Vector3(0.5,0.7,1.0).mul(t));
        //return new Vector3(1,0,0);
    }

    private double hit_sphere(Vector3 center,double radius,Ray r){
        Vector3 oc = r.getOrigin().sub(center);
        double a = Vector3.dot(r.getDirection(),r.getDirection());
        double b = 2.0 * Vector3.dot(oc,r.getDirection());
        double c = Vector3.dot(oc,oc) - radius*radius;
        double discriminant = b * b - 4 * a * c;
        if(discriminant < 0){
            return -1.0;
        }
        else{
            return ((-1*b) - (Math.sqrt(discriminant) / (2.0*a)));
        }
    }

    private Hit closestThingHit(Ray r, double t_min,double t_max){
        Hit record = null;
        double closest_so_far = t_max;
        Hit temp_record = null;
        for(int i = 0; i < hittables.size();i++){
            temp_record = hittables.get(i).hit(r,t_min,closest_so_far);
            if(temp_record != null){
                closest_so_far = temp_record.t;
                record = temp_record;
            }
        }
        return record;
    }

    private Vector3 random_in_unit_sphere(){
        Vector3 p;
        Random random = new Random();
        do{
            p = new Vector3(random.nextDouble(),random.nextDouble(),random.nextDouble()).mul(2.0).sub(new Vector3(1,1,1));
        }while(p.squareLength() >= 1.0);
        return p;
    }

}
