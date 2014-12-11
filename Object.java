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
		double disx = (x - x2);
		double disy = (y - y2);
		
		byte signx = 1;
		byte signy = 1;
		if (disx < 0) {
			signx = -1;
		} if (disy < 0) {
			signy = -1;
		}
		
		double fx = signx * G * (Math.pow(10, G10)) * ((mass * mass2) / (Math.pow(disx, 2)));
		double fy = signy * G * (Math.pow(10, G10)) * ((mass * mass2) / (Math.pow(disy, 2)));
 		double ax = fx / mass;
 		double ay = fy / mass;
 		
 		
 		
 		xd += ax;
 		yd += ay;
		
		double angle = Math.atan(disy/disx);
		
		//double xc = Math.cos(angle) * a;
		//double yc = Math.sin(angle) * a;		
		
		
	}
	
}
