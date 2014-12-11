package blackhole;

public class Object {

	double mass;
	double x;
	double y;
	double xd;
	double yd;
	double G = 6.673;
	int G10 = -11;
	
	public Object(double m, double x, double y) {
		mass = m;
		this.x = x;
		this.y = y;
	}
	
	public Object() {
		
	}
	
	public void update(Object obj) {
		
	}
	
	public void gravity(double mass2, double x2, double y2) {
              double dis = Math.sqrt(Math.pow(x - x2, 2) + Math.pow(y - y2, 2))
		double disx = (x - x2);
		double disy = (y - y2);
		
		byte signx = 1;
		byte signy = 1;
		if (disx < 0) {
			signx = -1;
		} if (disy < 0) {
			signy = -1;
		}
		
		double mdis = (G * Math.pow(10, G10) * mass) / (Math.pow(dis, 2)
 		
		double angle = Math.atan(disy/disx);
		
		double xc = Math.cos(angle) * mdis;
		double yc = Math.sin(angle) * mdis;		
		
		
	}
	
}