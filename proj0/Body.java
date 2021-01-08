
public class Body {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static final double G = 6.67e-11;

    public Body(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Body(Body b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }
    public double calcDistance(Body b) {
        return Math.pow(Math.pow((this.xxPos - b.xxPos), 2) + Math.pow((this.yyPos - b.yyPos), 2),0.5);
    }

    public double calcForceExertedBy(Body b){
        double distance = calcDistance(b);
        double Force = G * this.mass * b.mass / Math.pow(distance, 2);
        return Force;
    }

    public double calcForceExertedByX(Body b){
        double Force = calcForceExertedBy(b);
        double distance = calcDistance(b);
        double Fx = Force * (b.xxPos - this.xxPos) / distance;
        return Fx;
    }

    public double calcForceExertedByY(Body b){
        double Force = calcForceExertedBy(b);
        double distance = calcDistance(b);
        double Fx = Force * (b.yyPos - this.yyPos) / distance;
        return Fx;
    }

    public double calcNetForceExertedByX(Body[] bodys){
        double Fnetx = 0;
        for (Body b : bodys){
            if (b != this){
                Fnetx += this.calcForceExertedByX(b);
            }
        }
        return Fnetx;
    }

    public double calcNetForceExertedByY(Body[] bodys){
        double Fnety = 0;
        for (Body b : bodys){
            if (b != this){
                Fnety += this.calcForceExertedByY(b);
            }
        }
        return Fnety;
    }

    public void update(double dt, double fX, double fY){
        double ax = fX / mass;
        double ay = fY / mass;

        xxVel = xxVel + ax * dt;
        yyVel = yyVel + ay * dt;
        xxPos = xxPos + xxVel * dt;
        yyPos = yyPos + yyVel * dt;
    }
}
