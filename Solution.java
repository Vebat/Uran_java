public class Solution {

    public static void main( String args[])
    {
        dot one=new dot(48.069162,37.737908);
        dot two=new dot(48.124225,37.738502);
        Ingeodesictask solut=new Ingeodesictask();
        System.out.println(solut.getDistance(one,two))
        public class dot {
            public  double longitude;
            public  double latitude;
            public  dot(double lon,double lat){
                longitude=lon;
                latitude=lat;
            }
        }
       public class Ingeodesictask {
           private double diflongitudes;
           private double diflatitudes;
           private double rumb;
           public double distance;
           public double getDistance(dot dot1,dot dot2) {
               diflongitudes=Math.Abs(dot1.longitude-dot2.longitude);
               diflatitudes=Math.Abs(dot1.latitude-dot2.latitude);
               distance=Math.sqrt(Math.pow(diflongitudes, 2)+Math.pow(diflatitudes));
               distance=(Math.PI*distance/180)*6371;
               return distance;
           }
       }
    }
}
